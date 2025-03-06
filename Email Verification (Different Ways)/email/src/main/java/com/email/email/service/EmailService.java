package com.email.email.service;

public interface EmailService {
    void sendEmailSimple(String name, String to, String token);

    void sendEmailWithAttachments(String name, String to, String token);

    void sendEmailWithEmbeddedImages(String name, String to, String token);

    void sendEmailHTML(String name, String to, String token);

    void sendEmailHTMLWithEmbeddedFiles(String name, String to, String token);
}
