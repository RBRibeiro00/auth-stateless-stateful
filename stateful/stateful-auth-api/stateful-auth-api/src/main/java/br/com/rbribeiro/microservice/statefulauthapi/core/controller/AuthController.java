package br.com.rbribeiro.microservice.statefulauthapi.core.controller;

import br.com.rbribeiro.microservice.statefulauthapi.core.dto.AuthRequest;
import br.com.rbribeiro.microservice.statefulauthapi.core.dto.AuthUserResponse;
import br.com.rbribeiro.microservice.statefulauthapi.core.dto.TokenDTO;
import br.com.rbribeiro.microservice.statefulauthapi.core.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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

    @PostMapping("/logout")
    public HashMap<String, Object> logout(@RequestHeader String accessToken) {
        authService.logout(accessToken);
        var response = new HashMap<String, Object>();
        var ok = HttpStatus.OK;
        response.put("status", ok.name());
        response.put("code", ok.value());
        return response;
    }

    @GetMapping("user")
    public AuthUserResponse getAuthenticatedUser(@RequestHeader String accessToken) {
        return authService.getAuthenticatedUser(accessToken);
    }
}
