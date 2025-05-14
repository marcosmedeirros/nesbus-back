package br.marcos.nesbusapi.infra.security;

import br.marcos.nesbusapi.service.AutenticacaoService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AutenticacaiFilter extends OncePerRequestFilter {
    private final br.marcos.nesbusapi.infra.security.TokenServiceJWT tokenServiceJWT;
    private final AutenticacaoService autenticacaoService;

    public AutenticacaiFilter(br.marcos.nesbusapi.infra.security.TokenServiceJWT tokenServiceJWT, AutenticacaoService autenticacaoService) {
        this.tokenServiceJWT = tokenServiceJWT;
        this.autenticacaoService = autenticacaoService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println("Filtro para atenticacao e autorizacao");
        String token = recuperartoken(request);
        System.out.println("Token aqui: " + token);

        //se nao existir token na requisicao o SecurityConfig deve bloquear
        if(token != null){
            String subject = this.tokenServiceJWT.getSubect(token);
            System.out.println("Login da req. " + subject);

            UserDetails userDetails = this.autenticacaoService.loadUserByUsername(subject);
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request, response);
    }

    private String recuperartoken(HttpServletRequest request){

        String token = request.getHeader("Authorization");
        if(token != null){
            return token.replace("Bearer", "").trim();
        }

        return null;

    }
}
