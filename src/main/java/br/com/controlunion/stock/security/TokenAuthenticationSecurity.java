package br.com.controlunion.stock.security;

import java.io.UnsupportedEncodingException;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.controlunion.stock.exception.UnauthorizedException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class TokenAuthenticationSecurity {
	
	// EXPIRATION_TIME = 10 dias
	//static final long EXPIRATION_TIME = 860_000_000;
	static final String SECRET = "P0rtsD1vis1@n#2017-cL";
	//static final String SECRET = "secret";
	static final String TOKEN_PREFIX = "Bearer ";
	static final String HEADER_STRING = "Authorization";

	static Authentication getAuthentication(HttpServletRequest request) throws UnauthorizedException {
		String token = request.getHeader("Authorization");
		
		if (token != null) {
			
			String tk = token.replace(TOKEN_PREFIX, "");
			
			try {
				Algorithm algorithm = Algorithm.HMAC256(SECRET);
				JWTVerifier verifier = JWT.require(algorithm).build();
				DecodedJWT jwt = verifier.verify(tk);
				String user = jwt.getSubject();
				if (user == null) {
					throw new UnauthorizedException("Invalid Token"); 
				}
				return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
			} catch (IllegalArgumentException e) {
				throw new UnauthorizedException("Invalid Token");
			} catch (UnsupportedEncodingException e) {
				throw new UnauthorizedException("Invalid Token");
			} catch (JWTVerificationException e) {
				throw new UnauthorizedException("Invalid Token");
			}
		}
		return null;
	}
	
	public static int getAuthenticatedUser() {
		String userId = SecurityContextHolder.getContext().getAuthentication().getName();
		return Integer.parseInt(userId);
	}
}
