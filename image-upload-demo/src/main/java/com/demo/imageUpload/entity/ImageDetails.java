package com.demo.imageUpload.entity;
import java.time.LocalDateTime;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class ImageDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fileName;
	private String size;
	@Lob
	@Column(name = "imagedata",length=1000000000)
	private byte[] image;
	private LocalDateTime time;
	private String content;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "ImageDetails [id=" + id + ", fileName=" + fileName + ", size=" + size + ", image="
				+ Arrays.toString(image) + ", time=" + time + ", content=" + content + "]";
	}
	public ImageDetails(Long id, String fileName, String size, byte[] image, LocalDateTime time, String content) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.size = size;
		this.image = image;
		this.time = time;
		this.content = content;
	}
	public ImageDetails() {
		super();
		// TODO Auto-generated constructor stub
	}	
}
