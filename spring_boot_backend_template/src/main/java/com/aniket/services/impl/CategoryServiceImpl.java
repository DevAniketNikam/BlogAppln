package com.aniket.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aniket.daos.CategoryRepo;
import com.aniket.dtos.CategoryDTO;
import com.aniket.entities.Category;
import com.aniket.exceptions.ResourceNotFoundException;
import com.aniket.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDto) {
		Category cat= this.modelMapper.map(categoryDto, Category.class);
		Category addedCat = this.categoryRepo.save(cat);
		return this.modelMapper.map(addedCat, CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO categorydDto, Integer categoryId) {
		// TODO Auto-generated method stub
		
		Category cat= this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		
		cat.setCategoryTitle(categorydDto.getCategoryTitle());
		cat.setCategoryDescription(categorydDto.getCategoryDescription());
		
		Category updateCat= this.categoryRepo.save(cat);
		
		return this.modelMapper.map(updateCat, CategoryDTO.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		
		Category cat= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", categoryId));
		// TODO Auto-generated method stub
		this.categoryRepo.delete(cat);

	}

	@Override
	public CategoryDTO getCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", categoryId));
		
		//return cat= if we put like it is type missmatch error
		return this.modelMapper.map(cat, CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> getCategories() {
		// TODO Auto-generated method stub
		List<Category> categories= this.categoryRepo.findAll();
		
		List<CategoryDTO> catDtos = categories.stream().map((cat)-> this.modelMapper.map(cat, CategoryDTO.class)).collect(Collectors.toList());
		return catDtos;
	}

}
