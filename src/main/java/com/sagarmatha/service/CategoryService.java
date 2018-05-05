package com.sagarmatha.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sagarmatha.domain.Category;

@Service
public interface CategoryService {

	public void addCategory(Category category);

	public List<Category> viewAllCategory();
}
