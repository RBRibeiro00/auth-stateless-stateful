package br.com.rbribeiro.microservice.statelessauthapi.core.controller;

import br.com.rbribeiro.microservice.statelessauthapi.core.dto.AuthRequest;
import br.com.rbribeiro.microservice.statelessauthapi.core.dto.TokenDTO;
import br.com.rbribeiro.microservice.statelessauthapi.core.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    public TokenDTO login(@RequestBody AuthRequest request) {
        return authService.login(request);
    }

    @PostMapping("token/validate")
    public TokenDTO validateToken(@RequestHeader String accessToken) {
        return authService.validateToken(accessToken);
    }
}
