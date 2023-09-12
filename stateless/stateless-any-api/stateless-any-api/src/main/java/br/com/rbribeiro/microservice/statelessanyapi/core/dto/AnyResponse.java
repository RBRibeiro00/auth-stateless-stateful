package br.com.rbribeiro.microservice.statelessanyapi.core.dto;

public record AnyResponse(String status, Integer code, AuthUserResponse authUser) {
}
