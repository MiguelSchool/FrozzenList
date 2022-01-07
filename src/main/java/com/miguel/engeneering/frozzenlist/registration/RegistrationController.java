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
    @GetMapping(path="/confirm")
    public String confirm(@RequestParam("token") String token){
        System.out.println(token);
        return registrationService.confirmToken(token);
    }
}
