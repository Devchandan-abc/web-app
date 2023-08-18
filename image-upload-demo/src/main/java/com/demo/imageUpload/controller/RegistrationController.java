package com.demo.imageUpload.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.demo.imageUpload.entity.ImageDetails;
import com.demo.imageUpload.entity.Registration;
import com.demo.imageUpload.service.ServiceInterface;

import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
public class RegistrationController {
	@Autowired
	private ServiceInterface serviceInterface;
	@PostMapping("/save")
	public ResponseEntity<Registration> saveUser( @RequestBody Registration registration)
	{
		return new ResponseEntity<>(serviceInterface.saveUser(registration),HttpStatus.CREATED);
	}
	@PostMapping("/login")
	public ResponseEntity<List<ImageDetails>> loginUser(@RequestBody Registration registration)
	{
		return new ResponseEntity<>(serviceInterface.loginUser(registration),HttpStatus.CREATED);
	}
	

}
