package com.miguel.engeneering.frozzenlist.repositories;

import com.miguel.engeneering.frozzenlist.registration.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
    Optional<ConfirmationToken> findByConfigurationToken(String token);
}
