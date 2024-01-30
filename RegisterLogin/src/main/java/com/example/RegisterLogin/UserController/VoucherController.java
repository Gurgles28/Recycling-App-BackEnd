package com.example.RegisterLogin.UserController;

import com.example.RegisterLogin.Entity.User;
import com.example.RegisterLogin.Service.UserService;
import io.micrometer.common.lang.Nullable;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.util.Matrix;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/voucher")
public class VoucherController {

    private final TemplateEngine templateEngine;
    private final UserService userService;

    @Autowired
    public VoucherController(TemplateEngine templateEngine, UserService userService) {
        this.templateEngine = templateEngine;
        this.userService = userService;
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadVoucher(@RequestParam String email) {
        User user = userService.getUserByEmail(email);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        String firstName = user.getFirst_name();
        String lastName = user.getLast_name();
        String address = user.getAddress();

        BigDecimal rewardPoints = user.getPoints();
        LocalDate expirationDate = LocalDate.now().plusDays(30);

        String voucherCode = generateVoucherCode();

        byte[] pdfContent = generateVoucher(email, firstName, lastName, address, expirationDate, voucherCode);

        return voucherResponseEntity(pdfContent);
    }

    private byte[] generateVoucher(String email, String firstName, String lastName,
                                   String address, LocalDate expirationDate, String voucherCode) {
        try (PDDocument document = new PDDocument()) {

            PDPage page = new PDPage(new PDRectangle(320, 170));
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.setNonStrokingColor(230, 230, 230);
            contentStream.addRect(0, 0, page.getMediaBox().getWidth(), page.getMediaBox().getHeight());
            contentStream.fill();

            contentStream.setStrokingColor(255, 50, 50);
            contentStream.setLineWidth(10);

            float width = page.getMediaBox().getWidth();
            float height = page.getMediaBox().getHeight();

            contentStream.addRect(0, 0, width, height);
            contentStream.closePath();
            contentStream.stroke();

            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.setNonStrokingColor(0, 0, 0);

            float centerX = width / 2;
            float centerY = height - 15;

            float titleHeight = 40;
            float infoStartY = height - 30 - titleHeight;

            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.setNonStrokingColor(0, 0, 0);
            contentStream.setTextMatrix(Matrix.getTranslateInstance(centerX - 75, centerY - titleHeight / 2));
            contentStream.showText("Voucher Type #" + voucherCode);
            contentStream.endText();

            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 8);
            contentStream.setNonStrokingColor(0, 0, 0);

            contentStream.beginText();
            contentStream.newLineAtOffset(10, infoStartY);

            contentStream.showText("Email: " + email);
            contentStream.newLineAtOffset(0, -12);

            contentStream.showText("Name: " + firstName + " " + lastName);
            contentStream.newLineAtOffset(0, -12);

            contentStream.showText("Address: " + address);
            contentStream.newLineAtOffset(0, -12);

            contentStream.setTextMatrix(Matrix.getTranslateInstance(width - 125, infoStartY));
            contentStream.showText("Reward Points: ");
            contentStream.showText("2000");

            contentStream.newLineAtOffset(0, -12);

            contentStream.showText("Redemption Date: " + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            contentStream.newLineAtOffset(0, -12);

            contentStream.showText("Expiration Date: " + expirationDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            contentStream.newLineAtOffset(0, -12);

            float bottomCenterX = width / 2;
            float bottomCenterY = 30;

            contentStream.setTextMatrix(Matrix.getTranslateInstance(bottomCenterX - 128, bottomCenterY));

            contentStream.showText("Your voucher can be redeemed inside MSG-System headquarters");
            contentStream.setNonStrokingColor(0, 0, 0);

            contentStream.endText();

            contentStream.close();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            document.save(baos);
            document.close();

            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private int CODE_LENGTH = 8;

    private String generateVoucherCode() {
        SecureRandom random = new SecureRandom();
        StringBuilder voucherCode = new StringBuilder();

        for (int i = 0; i < CODE_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            voucherCode.append(CHARACTERS.charAt(randomIndex));
        }

        return voucherCode.toString();
    }

    private ResponseEntity<byte[]> voucherResponseEntity(byte[] pdfContent) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "voucher.pdf");

        return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
    }
}
