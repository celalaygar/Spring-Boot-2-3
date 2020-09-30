package com.example.demo.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

import org.apache.tika.Tika;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.AppConfiguration;
import com.example.demo.jwt.config.JwtTokenUtil;
import com.example.demo.repo.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileService {

	private final AppConfiguration app;
	//private final Logger logger;
	Tika tika;

	public String writeBase64StringToFile(String image) throws IOException {
		String fileName = generateUniqueName();
		File target = new File(app.getUploadPath() + "/" + fileName);
		OutputStream stream = new FileOutputStream(target);
		byte[] b = Base64.getDecoder().decode(image);

		stream.write(b);
		stream.close();
		return fileName;
	}

	public String generateUniqueName() {

		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public void deleteFile(String oldImage) {
		if (oldImage == null)
			return;
		try {
			Files.deleteIfExists(Paths.get(app.getUploadPath(), oldImage));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String detectType(String value) {
		byte[] b = Base64.getDecoder().decode(value);
		tika = new Tika();
		String fileType = tika.detect(b);
		return fileType;
	}
	public Boolean isValidFileType(String[] types, String value) {
		if(value ==null || value.isEmpty())
			return false;
		String fileType = detectType(value);
		for (String supportedType : types) {
			if(fileType.equalsIgnoreCase(supportedType))
				return true;
		}
//		if(fileType.equalsIgnoreCase("image/jpeg") || fileType.equalsIgnoreCase("image/png") )
//			return true;
		return false;
	}
}
