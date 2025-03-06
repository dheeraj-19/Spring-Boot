package com.email.email.service.impl;

import org.springframework.stereotype.Service;

import com.email.email.model.Confirmation;
import com.email.email.model.User;
import com.email.email.repository.ConfirmationRepository;
import com.email.email.repository.UserRepository;
import com.email.email.service.EmailService;
import com.email.email.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ConfirmationRepository confirmationRepository;
    private final EmailService emailService;

    @Override
    public User saveUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        user.setEnabled(false);
        userRepository.save(user);

        Confirmation confirmation = new Confirmation(user);
        confirmationRepository.save(confirmation);

        String emailType = user.getEmailType();

        switch (emailType) {
            case "simple":
                emailService.sendEmailSimple(user.getName(), user.getEmail(), confirmation.getToken());
                break;

            case "withAttachments":
                emailService.sendEmailWithAttachments(user.getName(), user.getEmail(), confirmation.getToken());
                break;

            case "withEmbeddedImages":
                emailService.sendEmailWithEmbeddedImages(user.getName(), user.getEmail(), confirmation.getToken());
                break;

            case "html":
                emailService.sendEmailHTML(user.getName(), user.getEmail(), confirmation.getToken());
                break;

            case "htmlWithImages":
                emailService.sendEmailHTMLWithEmbeddedFiles(user.getName(), user.getEmail(), confirmation.getToken());
                break;

            default:
                break;
        }

        return user;
    }

    @Override
    public Boolean verifyToken(String token) {

        Confirmation confirmation = confirmationRepository.findByToken(token);
        User user = userRepository.findByEmailIgnoreCase(confirmation.getUser().getEmail());
        user.setEnabled(true);
        userRepository.save(user);

        return Boolean.TRUE;
    }

}
