package com.freelance.service;

import com.freelance.model.Category;
import com.freelance.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author - Akash
 * @date - 16-05-2022
 */
@Service
public class CategoryServiceImpl implements ICategoryService{
    private ICategoryRepository categoryRepository;
    @Autowired
    public void setCategoryRepository(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     *
     * @param category
     */
    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    /**
     *
     * @param category
     */
    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    /**
     *
     * @param categoryId
     */
    @Override
    public void deleteCategory(int categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    /**
     *
     * @param categoryId
     * @return single category object
     */
    @Override
    public Category getById(int categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    /**
     *
     * @return list of all category's
     */
    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
