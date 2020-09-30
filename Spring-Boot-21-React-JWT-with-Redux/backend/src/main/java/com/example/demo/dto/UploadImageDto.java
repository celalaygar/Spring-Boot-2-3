package com.example.demo.dto;

import java.util.Date;

import com.example.demo.model.annotation.FileType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadImageDto {

	//@FileType(types = {"image/png","image/jpeg"} )
	String image;
}
