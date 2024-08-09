package com.Group4.HospitalBedSystem.service.satisfaction;

//import package dto, entity, repository and service.general.SuccessAndDataResponse
import com.Group4.HospitalBedSystem.dto.response.satisfication.*;
import com.Group4.HospitalBedSystem.entity.UserEntity;
import com.Group4.HospitalBedSystem.entity.satification.*;
import com.Group4.HospitalBedSystem.repository.satisfaction.*;
import com.Group4.HospitalBedSystem.service.satisfaction.*;
import com.Group4.HospitalBedSystem.service.general.SuccessAndDataResponse;
import com.Group4.HospitalBedSystem.entity.generator.*;
//import all springframework
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import java.util
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MeasurementService measurementService;


    public ResponseEntity<?> getCategories(){
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        if(categoryEntities!=null){
            result.setSuccess(true);
            result.setMessage("Categories list found");
            List<CategoryResponse> categoryResponseList = new ArrayList<>();
            for(CategoryEntity category: categoryEntities)
            {
                categoryResponseList.add(mapCategoryEntityToCategoryDetail(category));
            }
            result.setData(categoryResponseList);
            return ResponseEntity.ok(result);
        }else{
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }//end if else statement
    }//end getCategories()

    // Post methods
    public ResponseEntity<?> saveCategory(CategoryEntity categoryEntity){
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            if (categoryEntity != null) {
                if (categoryRepository.save(categoryEntity) != null) {
                    result.setSuccess(true);
                    result.setMessage("Added new a category");
                    result.setData(categoryEntity);
                } else {
                    result.setMessage("Failed to add a category");
                }
                System.out.println("test");
                result.setData(categoryEntity);
                return ResponseEntity.ok(result);
            } else {
                result.setMessage("Failed to add a category");
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
        } catch (Exception e) {
            result.setMessage("Failed to add a category : " + e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }//end saveCategory

    public CategoryResponse mapCategoryEntityToCategoryDetail (CategoryEntity categoryEntity){
        CategoryResponse data = new CategoryResponse();
        data.setId(categoryEntity.getId());
        data.setName(categoryEntity.getName());

        List<MeasurementResponse> measurementResponseList = categoryEntity.getMeasurements().stream()
                .map(measurementService::mapMeasurementEntityToMeasurementDetail)
                .collect(Collectors.toList());

        data.setMeasurements(measurementResponseList);
        return data;
    }//end mapCategoryEntityToCategoryDetail

    public ResponseEntity<?> updateCategories(CategoryEntity categoryEntity) {
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            CategoryEntity existCategory = categoryRepository.findById(categoryEntity.getId()).orElse(null);
            if (existCategory != null) {
                existCategory.setName(categoryEntity.getName());
                categoryRepository.save(existCategory); // Save the updated category
                result.setSuccess(true);
                result.setMessage("Successfully updated the category");
                result.setData(existCategory);
            } else {
                result.setSuccess(false);
                result.setMessage("Category not found");
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("An error occurred: " + e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> deleteCategory(int categoryId) {
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            categoryRepository.deleteById(categoryId);
            result.setMessage("Deleted a category with id : " + categoryId);
            result.setSuccess(true);
        } catch (Exception e) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(result);
    }//end deleteCategory



//    //public List<CategoryEntity> getAllCategories() {
//        return categoryRepository.findAll();
//    }
//
//    public CategoryEntity getCategoryById(Long id) {
//        return categoryRepository.findById(id).orElse(null);
//    }
//
//    public CategoryEntity saveCategory(CategoryEntity category) {
//        return categoryRepository.save(category);
//    }
//
//    public void deleteCategory(Long id) {
//        categoryRepository.deleteById(id);
//    }
}
