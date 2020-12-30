package br.com.exactaworks.desafio.config.security;

import br.com.exactaworks.desafio.exception.GenericException;
import br.com.exactaworks.desafio.repository.UserRepository;
import br.com.exactaworks.desafio.service.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class AuthenticationTokenFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UserRepository userRepository;
    private final Logger logger = Logger.getLogger("br.com.exactaworks.desafio.securty.AuthenticationTokenFilter");

    public AuthenticationTokenFilter(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        var token = getToken(request);
        var validToken = tokenService.isValidToken(token);
        if (validToken) {
            authenticateUser(token);
        }

        filterChain.doFilter(request, response);
    }

    private void authenticateUser(String token) {
        var user = this.userRepository.findUserById(getUserId(token)).orElseThrow(() -> new GenericException("User not found"));
        var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String getToken(HttpServletRequest request) {
        var token = request.getHeader("Authorization");

        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            logger.info("TOKEN NOT VALID: VERIFY TOKEN -> "+token);
            return null;
        }
        logger.info("VALID TOKEN: "+token.substring(7, token.length()));
        return token.substring(7, token.length());
    }

    private long getUserId(String token) {
        return Long.parseLong(this.tokenService.getTokenBodyString(token).getSubject());
    }
}
