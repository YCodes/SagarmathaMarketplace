package com.sagarmatha.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagarmatha.domain.Category;
import com.sagarmatha.repository.CategoryRepository;
import com.sagarmatha.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public List<Category> viewAllCategory() {
		
		return categoryRepository.findAll();
	}

	@Override
	public Category findOne(Long Id) {
		
		return categoryRepository.findOne(Id);
	}

	
}
