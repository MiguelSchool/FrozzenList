package com.miguel.engeneering.frozzenlist.registration;

import com.miguel.engeneering.frozzenlist.models.User;
import com.miguel.engeneering.frozzenlist.services.serviceImplementations.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final UserServiceImpl userService;
    private final ConfirmationTokenService confirmationTokenService;


    public String register(RegistrationRequest request) {
        boolean isValid = emailValidator.test(request.getEmail());
        if (!isValid) {
            throw new IllegalStateException("email is not valid!");
        }
        return this.userService.signUpUser(
                new User(
                        request.getEmail(),
                        request.getPassword()
                ));
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService.getToken(token)
                .orElseThrow(()->
                        new IllegalStateException("Token not found"));
        if(confirmationToken.getConfirmedAt() != null){
            throw new IllegalStateException("email already confirmed");
        }
        LocalDateTime expiredAt = confirmationToken.getExpiresAt();
        if(expiredAt.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("token expired");
        }
        confirmationTokenService.setConfirmedAt(token);
        userService.enableUser(confirmationToken.getUser().getEmail());
        return "confirmed";
    }
}
