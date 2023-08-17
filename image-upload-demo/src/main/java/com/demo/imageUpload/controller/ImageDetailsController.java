package com.demo.imageUpload.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.demo.imageUpload.service.ServiceInterface;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ImageDetailsController {
	@Autowired
	private ServiceInterface serviceInterface;
	@PostMapping("/image")
	 public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) throws IOException
	 {
		 return new ResponseEntity<>(serviceInterface.uploadImage(file),HttpStatus.CREATED);
	 }

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteImage(@PathVariable("id") long id)
	{
		return new ResponseEntity<>(serviceInterface.deleteImage(id),HttpStatus.OK);
	}

	}
	 
