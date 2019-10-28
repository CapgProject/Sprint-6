package com.cg.otm.OnlineTestManagementRestful.model;

import java.io.Serializable;

/**
 * Author: Swanand Pande
 * Description: Return the JWT Token
 */
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}
