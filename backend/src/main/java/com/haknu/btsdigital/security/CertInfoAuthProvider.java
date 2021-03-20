package com.haknu.btsdigital.security;

import com.haknu.btsdigital.domain.User;
import com.haknu.btsdigital.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Slf4j
@Component
public class CertInfoAuthProvider implements AuthenticationProvider {

    private final UserService userService;

    public CertInfoAuthProvider(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String login = authentication.getName();
        BigInteger serialNumber = (BigInteger) authentication.getCredentials();

        UserDetails user = userService.loadUserByUsername(login);
        if (user == null)
            throw new BadCredentialsException("User not found " + login);

        User systemUser = (User) user;
        if (serialNumber.compareTo(systemUser.getAuthenticationData().getActiveSerialNumber()) != 0)
            throw new BadCredentialsException("SerialNumber is not correct " + serialNumber);

        log.debug(">>> Authenticated with {} and {}", login, serialNumber);
        return new UsernamePasswordAuthenticationToken(systemUser, systemUser.getAuthenticationData(), systemUser.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication == ProxiedCertificateInfoAuthentication.class;
    }
}
