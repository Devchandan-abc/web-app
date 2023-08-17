package com.demo.imageUpload.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.imageUpload.entity.ImageDetails;

public interface ImageDetailsRepository extends JpaRepository<ImageDetails, Long> {
	
	Optional<ImageDetails> findByFileName(String fileName);

}
