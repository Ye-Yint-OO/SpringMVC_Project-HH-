package com.spring.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.PhotoBean;

import Repository.BookRepo;
import Repository.PhotoRepo;

@Controller

public class PhotoController {
	@GetMapping("/photo")
	public ModelAndView go() {
		PhotoBean photobean=new PhotoBean();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("photo");
		mv.addObject("Photo", photobean);
		return mv;
		
	}
	
	@PostMapping("/viewphoto")
	public String addAndRead(@ModelAttribute("Photo") PhotoBean bean,Model model) throws IOException, SQLException {
		byte[] photoByte=bean.getFile().getBytes();
		PhotoRepo repo=new PhotoRepo();
		int i=repo.addPhoto(photoByte);
		if(i>0) {
			System.out.println("Add photo success");
		}else {
			System.out.println("Add photo faile");
		}
		PhotoBean bean2=repo.viewPhoto();
		model.addAttribute("PhotoBean", bean2);
		return "viewphoto";
	}
}
