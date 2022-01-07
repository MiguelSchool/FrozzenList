package com.miguel.engeneering.frozzenlist.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;
    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return this.registrationService.register(request);
    }
    @GetMapping(path="/registration/confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }
}
