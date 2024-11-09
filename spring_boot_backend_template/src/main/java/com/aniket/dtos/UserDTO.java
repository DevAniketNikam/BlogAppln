package com.aniket.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class UserDTO {
	private int id;
	
	@NotEmpty
	@Size(min=2, message=" Username must be min 2 characters !!")
	private String name;
	
	@NotEmpty
	@Email(message="Email address is not valid !!")
	private String email;
	
	@NotEmpty
	@Size(min=3, max=4, message="Password must be min 3 and max 10 characters !!")
	private String password;
	
	@NotEmpty
	private String about;
	
}
