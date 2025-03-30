package HealthSphereApplication.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

// Enum to define application roles
public enum Role {
    ROLE_ADMIN,
    ROLE_DOCTOR,
    ROLE_PATIENT;

    // Method to convert roles into GrantedAuthority objects
    public static final Collection<? extends GrantedAuthority> USER = Arrays.stream(Role.values())
            .map(role -> new SimpleGrantedAuthority(role.name()))
            .collect(Collectors.toList());
}
