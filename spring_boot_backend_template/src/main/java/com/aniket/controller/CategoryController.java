package com.aniket.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aniket.dtos.ApiResponse;
import com.aniket.dtos.CategoryDTO;
import com.aniket.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@Autowired 
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDto){
		CategoryDTO createCategory =  this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDTO>(createCategory, HttpStatus.CREATED);
				
				
	}
	
	
	//update
	
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO catDto, @PathVariable Integer catId){
		CategoryDTO updatedCategory =  this.categoryService.updateCategory(catDto, catId);
		return new ResponseEntity<CategoryDTO>(updatedCategory, HttpStatus.OK);
				
				
	} 
	
	//delete
	
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
		this.categoryService.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category is deleted successfully!!", true), HttpStatus.OK);
				
				
	}
	
	
	//get
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDTO> getCategory(@PathVariable Integer catId){
		CategoryDTO categoryDto = this.categoryService.getCategory(catId);
		
		return new ResponseEntity<CategoryDTO>(categoryDto, HttpStatus.OK);
	}
	
	//get All
	@GetMapping("/")
	public ResponseEntity<List<CategoryDTO>> getCategories(){
		List<CategoryDTO> categories = this.categoryService.getCategories();
		return ResponseEntity.ok(categories);
	}
	

}
