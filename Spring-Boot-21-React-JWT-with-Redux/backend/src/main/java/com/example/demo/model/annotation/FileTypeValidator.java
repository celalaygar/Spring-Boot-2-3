package com.example.demo.model.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.file.FileService;
import com.example.demo.model.User;

public class FileTypeValidator  implements ConstraintValidator<FileType, String>{

	@Autowired
	FileService fileService;
	
	String [] types;
	@Override
	public void initialize(FileType constraintAnnotation) {
		this.types = constraintAnnotation.types();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return fileService.isValidFileType(this.types, value);
//		String fileType = fileService.detectType(value);
//		if(fileType.equalsIgnoreCase("image/jpeg") || fileType.equalsIgnoreCase("image/png") )
//			return true;
//		return false;
	}

}
