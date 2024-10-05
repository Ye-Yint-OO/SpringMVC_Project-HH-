package com.spring.model;

import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class PhotoBean {
	private int id;
	private MultipartFile file;
	private byte[] photoBytes;
	
	public String getBase64() {
		if(photoBytes!=null) {
			return Base64.getEncoder().encodeToString(photoBytes);
		}
		return null;
	}
}
