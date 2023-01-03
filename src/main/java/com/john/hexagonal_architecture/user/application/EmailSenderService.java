package com.john.hexagonal_architecture.user.application;

import com.john.hexagonal_architecture.user.domain.Email;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@AllArgsConstructor

public class EmailSenderService {

    private final JavaMailSender mailSender;

    public void sendEmailWithAttachment(Email email) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("gualterosjohn40@gmail.com");
        mimeMessageHelper.setTo(email.getTo());
        mimeMessageHelper.setText(email.getBody());
        mimeMessageHelper.setSubject(email.getSubject());

        FileSystemResource fileSystem = new FileSystemResource(new File(email.getAttachment()));

        mimeMessageHelper.addAttachment(fileSystem.getFilename(),fileSystem);

        mailSender.send(mimeMessage);
    }
}