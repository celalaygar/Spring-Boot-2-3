package com.example.demo.api;
import com.example.demo.base.BaseRequest;
import com.example.demo.base.BaseResponse;
import com.example.demo.model.Category;
import com.example.demo.model.Code;
import com.example.demo.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse<Category>> createCategory(@RequestBody BaseRequest<Category> request) throws Exception {
        BaseResponse<Category> response = categoryService.saveCategory(request.getBody());
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<Category>>> getAllCategories() {
        BaseResponse<List<Category>> response = categoryService.getAllCategories();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<Category>> getCategoryById(@PathVariable Long id) {
        BaseResponse<Category> response = categoryService.getCategoryById(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PostMapping("/codes")
    public ResponseEntity<BaseResponse<Code>> createCode(@RequestBody BaseRequest<Code> request) {
        BaseResponse<Code> response = categoryService.saveCode(request.getBody());
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping("/codes")
    public ResponseEntity<BaseResponse<List<Code>>> getAllCodes() {
        BaseResponse<List<Code>> response = categoryService.getAllCodes();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping("/codes/{id}")
    public ResponseEntity<BaseResponse<Code>> getCodeById(@PathVariable Long id) {
        BaseResponse<Code> response =  categoryService.getCodeById(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }
}
