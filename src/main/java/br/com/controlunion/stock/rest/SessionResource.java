package br.com.controlunion.stock.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlunion.stock.security.TokenAuthenticationSecurity;

@RestController
@CrossOrigin
@RequestMapping("/sessions")
public class SessionResource {

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET, produces = { "application/json" })
	public String getSession() {
		return "{\"userId\" : " + TokenAuthenticationSecurity.getAuthenticatedUser() + "}";
	}

}
