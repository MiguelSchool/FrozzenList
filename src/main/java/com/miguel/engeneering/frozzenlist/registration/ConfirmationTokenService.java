package com.miguel.engeneering.frozzenlist.registration;
import com.miguel.engeneering.frozzenlist.repositories.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return this.confirmationTokenRepository.findByConfigurationToken(token);
    }

    public void setConfirmedAt(String token) {
      ConfirmationToken confirmationToken =
              this.confirmationTokenRepository.findByConfigurationToken(token)
                      .orElseThrow(()-> new IllegalStateException("this token not found"));
      confirmationToken.setConfirmedAt(LocalDateTime.now());
    }
}
