package com.instagram.mediaservice.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.instagram.mediaservice.model.ImageMetadata;
import com.instagram.mediaservice.payload.UploadFileResponse;
import com.instagram.mediaservice.service.ImageService;

import java.security.Principal;

@Slf4j
@RestController
public class ImageUploadApi {
	
	@Autowired
	private ImageService imageService;

	@PostMapping("/images")
	@PreAuthorize("hasRole('USER')")
	public UploadFileResponse uploadFile(@RequestParam("image") MultipartFile file,
			@AuthenticationPrincipal Principal principal) {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		log.info("received a request to upload file {} for user {}", filename, principal.getName());

		ImageMetadata metadata = imageService.upload(file, principal.getName());

		return new UploadFileResponse(metadata.getFilename(), metadata.getUri(), metadata.getFileType());
	}
}
