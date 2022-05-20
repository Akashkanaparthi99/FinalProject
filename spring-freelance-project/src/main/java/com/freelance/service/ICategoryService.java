package com.freelance.service;

import com.freelance.model.Category;

import java.util.List;

public interface ICategoryService{
    void addCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(int categoryId);

    Category getById(int categoryId);
    List<Category> getAll();
}
