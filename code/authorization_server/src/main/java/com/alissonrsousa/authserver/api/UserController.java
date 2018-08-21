package com.alissonrsousa.authserver.api;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class UserController {
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        return principal;
    }

}
