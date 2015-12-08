package com.forum.app.component;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.forum.app.entity.User;
import com.forum.app.service.CrudService;
import com.forum.app.service.QueryParameters;

/**
 * CustomAuthenticationProvider class
 * 
 * @author dzigar
 *
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private CrudService crudService;

	private User user;

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = (String) authentication.getCredentials();

		try {
			user = (User) crudService.findUniqueByNamedQuery(User.BY_USERNAME,
					QueryParameters.with("username", username).parameters());
		} catch (Exception e) {
			LOGGER.error(e.getLocalizedMessage());
		}

		if (user == null) {
			throw new BadCredentialsException("User not found");
		}
		if (!new BCryptPasswordEncoder().matches(password, user.getPassword())) {
			throw new BadCredentialsException("Wrong password");
		}

		List<GrantedAuthority> roles = user.getRoles();

		return new UsernamePasswordAuthenticationToken(username, password, roles);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}
}
