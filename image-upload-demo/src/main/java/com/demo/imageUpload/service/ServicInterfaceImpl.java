package com.demo.imageUpload.service;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.demo.imageUpload.entity.ImageDetails;
import com.demo.imageUpload.entity.Registration;
import com.demo.imageUpload.exception.FileNotFoundException;
import com.demo.imageUpload.repository.ImageDetailsRepository;
import com.demo.imageUpload.repository.RegistrationRepository;
import com.demo.imageUpload.util.ImageUtil;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ServicInterfaceImpl implements ServiceInterface {
@Autowired	
private RegistrationRepository registrationRepo;
@Autowired	
private ImageDetailsRepository imageDetailsRepo;
	@Override
	public Registration saveUser(Registration registration) {
//		if(registration.getName()==null||registration.getUserName()==null||registration.getPassword()==null)
//		throw new FileNotFoundException("Field should not be empty");
		Optional<Registration> findByUserName = registrationRepo.findByUserName(registration.getUserName());
		if(findByUserName.isPresent())
		{
			throw new FileNotFoundException("User name Already Exists!!.");
		}
		else
		return registrationRepo.save(registration);
	}

	@Override
	public String uploadImage(MultipartFile file) throws IOException {
			 if (file.isEmpty()) {
	                throw new FileNotFoundException("File is empty.");
	            }

	            if (file.getSize() > 3 * 1024 * 1024) {
	                throw new FileNotFoundException("File size exceeds the limit.");
	            }
	            else
	            {
	            	 String contentType = file.getContentType();
	                 if (!contentType.startsWith("image/") && !contentType.startsWith("application/pdf")) {
	                	 throw new FileNotFoundException("Extension Not Supported!!");
	                 }
	                 else {
			ImageDetails imageData =new ImageDetails();
			imageData.setFileName(file.getOriginalFilename());
			imageData.setContent(file.getContentType());
			imageData.setImage(ImageUtil.compressImage(file.getBytes()));
			imageData.setSize(String.valueOf(file.getSize()));
			imageData.setTime(LocalDateTime.now());
			ImageDetails save = imageDetailsRepo.save(imageData);
        if (save != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
    }
		}
		
		 return null;
	}

	@Override
	public List<ImageDetails> loginUser(Registration registration) {
		Optional<Registration> findByUserName = registrationRepo.findByUserName(registration.getUserName());
		if(findByUserName.isPresent())
		{
			if(findByUserName.get().getPassword().equals(registration.getPassword()))
			return imageDetailsRepo.findAll();
			else
				throw new FileNotFoundException("UserName or password is incorrect!!");
		     
		}
		else
			throw new FileNotFoundException("UserName or password is incorrect!!");
	}

	@Override
	public String deleteImage(long id) {
		imageDetailsRepo.deleteById(id);
		return "Deleted Succesfully";
	}

}


