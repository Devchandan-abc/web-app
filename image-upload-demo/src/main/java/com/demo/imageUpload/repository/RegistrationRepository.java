package com.demo.imageUpload.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.imageUpload.entity.ImageDetails;
import com.demo.imageUpload.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
	
	Optional<Registration> findByUserName(String userName);


}
