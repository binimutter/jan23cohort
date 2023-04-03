package com.example.images.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.images.models.Image;
import com.example.images.repositories.ImageRepo;

@Service
public class ImageServ {
//	private final ImageRepo imageRepo;
//	public ImageServ(ImageRepo imageRepo) {
//		this.imageRepo = imageRepo;
//	}
	@Autowired
    private ImageRepo imageRepo;
	
    // ==========================
    //         METHODS
    // ==========================
	
	public List<Image> allImages() {
		return imageRepo.findAll();
	}
	
	public Image createImage(Image i) {
		return imageRepo.save(i);
	}
}
