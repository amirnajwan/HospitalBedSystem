package com.Group4.HospitalBedSystem.controller.satisfaction;

import com.Group4.HospitalBedSystem.entity.satification.*;
import com.Group4.HospitalBedSystem.service.satisfaction.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping ("/api/v1/categories")
    public ResponseEntity<?> getAllCategories() {return categoryService.getCategories();}

    @PostMapping ("/api/v1/addCategory")
    public ResponseEntity<?> addCategories(@RequestBody CategoryEntity categoryEntity) {return categoryService.saveCategory(categoryEntity);}

    @PutMapping("/api/v1/updateCategory/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable int id, @RequestBody CategoryEntity categoryEntity) {
        categoryEntity.setId(id); // Ensure the entity has the correct ID
        return categoryService.updateCategories(categoryEntity);
    }
    @DeleteMapping ("/api/v1/deleteCategory/{id}")
    public ResponseEntity<?> deleteCategories(@PathVariable int id){
        return categoryService.deleteCategory(id);
    }

}
