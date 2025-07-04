package com.example.demo.repository;

public interface EmailService {
    void sendPolicyPdf(String toEmail, byte[] pdfBytes, String fileName);
}
