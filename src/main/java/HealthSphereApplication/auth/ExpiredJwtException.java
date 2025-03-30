package HealthSphereApplication.auth;


import org.springframework.security.core.AuthenticationException;

public class ExpiredJwtException extends AuthenticationException {

    public ExpiredJwtException(String message) {
        super(message);
    }
}
