package com.vinay.project.uber.uberApp.handlers;

import com.vinay.project.uber.uberApp.entities.User;
import com.vinay.project.uber.uberApp.security.JWTService;
import com.vinay.project.uber.uberApp.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final UserService userService;
    private final JWTService jwtService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;

        DefaultOAuth2User oAuth2User = (DefaultOAuth2User) token.getPrincipal();

        String email = oAuth2User.getAttribute("email");

        User user = userService.getUserByEmail(email);

        if (user == null) {
            User newUser = User.builder()
                    .name(oAuth2User.getAttribute("name"))
                    .email(email)
                    .build();

            user = userService.save(newUser);
        }

        String accessToken = jwtService.generateAccessKey(user);
        String refreshToken = jwtService.generateRefreshKey(user);

        Cookie cookie = new Cookie("token",refreshToken);
        cookie.setSecure(false); //for dev set to false, for prod it should be true;
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        String frontEndUrl = "http://localhost:8080/home.html?token="+accessToken;

//        getRedirectStrategy().sendRedirect(request, response, frontEndUrl);

        response.sendRedirect(frontEndUrl);
    }
}
