package br.com.exactaworks.desafio.service;

import br.com.exactaworks.desafio.entity.UserEntity;
import br.com.exactaworks.desafio.utils.Utils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private final String secret = "$2y$12$utSbXLKbBQU215yoFqMFKu6JQDQZoU2/jL2bkPyBPzZJNeoU2zIb2";

    public String createToken(Authentication authentication){

        return Jwts.builder()
                .setIssuer("API EXPENSE")
                .setSubject(((UserEntity) authentication.getPrincipal()).getId().toString())
                .setIssuedAt(Utils.dateGeneratorForToken())
                .setExpiration(Utils.dateExpirationForToken())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isValidToken(String token) {
        try {
            getParseClaims(token);
            return true;

        } catch (Exception exception) {
            return false;
        }
    }

    public Claims getTokenBodyString(String token) {
        return getParseClaims(token).getBody();
    }

    private Jws<Claims> getParseClaims(String token) {
        return Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
    }
}
