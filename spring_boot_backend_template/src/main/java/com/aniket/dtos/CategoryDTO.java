package com.aniket.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class CategoryDTO {
	
	private Integer categoryId;
	
	@NotBlank
	@Size(min = 4, message = "min size of categoryTitle is 4 !")
	private String categoryTitle;
	
	@NotBlank
	@Size(min = 10, message = "min size of categoryDescription is 10 !")
	private String categoryDescription;
	
	
}
