package com.sagarmatha.service;

import org.springframework.stereotype.Service;

import com.sagarmatha.domain.Category;

@Service
public interface CategoryService {

	public void addCategory(Category category);
}
