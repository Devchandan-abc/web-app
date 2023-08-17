package com.demo.imageUpload.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.demo.imageUpload.entity.ImageDetails;
import com.demo.imageUpload.entity.Registration;

public interface ServiceInterface {

	Registration saveUser(Registration registration);

	String uplaoadImage(MultipartFile file) throws IOException;

	List<ImageDetails> loginUser(Registration registration);

	String deleteImage(long id);


}
