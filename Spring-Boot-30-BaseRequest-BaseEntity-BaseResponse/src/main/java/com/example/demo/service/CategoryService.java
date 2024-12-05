package com.example.demo.service;

import com.example.demo.base.BaseResponse;
import com.example.demo.model.Category;
import com.example.demo.model.Code;
import com.example.demo.repo.CategoryRepository;
import com.example.demo.repo.CodeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CodeRepository codeRepository;

    public CategoryService(CategoryRepository categoryRepository, CodeRepository codeRepository) {
        this.categoryRepository = categoryRepository;
        this.codeRepository = codeRepository;
    }

    public BaseResponse<Category> saveCategory(Category category) throws Exception {
        Optional<Code> opt = codeRepository.findById(1L);
        if(!opt.isPresent()){

            BaseResponse<Category> response = new BaseResponse<>(
                    false,
                    "notFoundCode",
                    HttpStatus.NOT_FOUND,
                    null);
            return response;
        }
        Code code = opt.get();
        category.setCategoryCode(code.getNextCode());

        code.setCode(code.getNextCode());
        code.setNextCode(code.getNextCode() + 1);
        codeRepository.save(code);
        category.setCategoryCodeName(category.getCategoryCode() + " - " + category.getCategoryName());
        Category savedCategory = categoryRepository.save(category);

        BaseResponse<Category> response = new BaseResponse<>(
                true,
                HttpStatus.CREATED,
                List.of(savedCategory));

        return response;
    }

    public BaseResponse<List<Category>> getAllCategories() {
        BaseResponse<List<Category>> response = new BaseResponse<>(
                true,
                HttpStatus.OK,
                List.of(categoryRepository.findAll()));
        return response;
    }

    public BaseResponse<Category> getCategoryById(Long id) {
        Optional<Category> opt = categoryRepository.findById(id);
        if(!opt.isPresent()){
            BaseResponse<Category> response = new BaseResponse<>(
                    false,
                    "notFoundCategory",
                    HttpStatus.NOT_FOUND,
                    null);
            return response;
        }
        BaseResponse<Category> response = new BaseResponse<>(
            true,
            HttpStatus.OK,
            List.of(opt.get()));
        return response;
    }

    public BaseResponse<Code> saveCode(Code code) {
        code =  codeRepository.save(code);
        BaseResponse<Code> response = new BaseResponse<>(
                true,
                HttpStatus.CREATED,
                List.of(code));
        return response;
    }

    public BaseResponse<List<Code>> getAllCodes() {
        BaseResponse<List<Code>> response = new BaseResponse<>(
                true,
                HttpStatus.OK,
                List.of(codeRepository.findAll()));
        return response;
    }

    public BaseResponse<Code> getCodeById(Long id) {
          codeRepository.findById(id);
        Optional<Code> opt = codeRepository.findById(id);
        if(!opt.isPresent()){
            BaseResponse<Code> response = new BaseResponse<>(
                    false,
                    "notFoundCode",
                    HttpStatus.NOT_FOUND,
                    null);
            return response;
        }
        BaseResponse<Code> response = new BaseResponse<>(
                true,
                HttpStatus.OK,
                List.of(opt.get()));
        return response;
    }
}

