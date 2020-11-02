package com.devsuperior.hroauth.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = 4397777940027385529L;
	
	private Long id;
	private String name;
	private String email;
	private String password;
	
	private Set<Role> roles = new HashSet<>();

}
