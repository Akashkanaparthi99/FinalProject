package com.freelance.controller;

import com.freelance.model.Category;
import com.freelance.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author - Akash
 * @date - 17-05-2022
 * @project - E-Freelance-Website
 */
@RestController
@RequestMapping("/freelance-api")
public class CategoryController {
    private ICategoryService categoryService;
    @Autowired
    public void setCategoryService(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     *
     * @param category
     * @return Response entity message
     */
    @PostMapping("/category")
    ResponseEntity<String> addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
        return ResponseEntity.ok("Added");
    }

    /**
     *
     * @param category
     * @return updates the category and returns response entity message
     */
    @PutMapping("/category")
    ResponseEntity<String> updateCategory(@RequestBody Category category){
        categoryService.updateCategory(category);
        return ResponseEntity.ok("Updated");
    }

    /**
     *
     * @param categoryId
     * @return deletes the category and returns the response entity message
     */
    @DeleteMapping("/category/category-id/{categoryId}")
    ResponseEntity<String> deleteCategory(@PathVariable("categoryId") int categoryId){
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Deleted");
    }

    /**
     *
     * @param categoryId
     * @return category entity by id
     */
    @GetMapping("/category/get-by-id/{categoryId}")
    ResponseEntity<Category> getById(@PathVariable("categoryId") int categoryId){
        return ResponseEntity.ok(categoryService.getById(categoryId));
    }
}
