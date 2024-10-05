package com.spring.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.UserBean;

import Repository.Img;

@Controller
public class TestController {
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String showTest() {
		return "redirect:index";
	}
	@GetMapping(value="/index")
	public String showIndex(Model m) {
		m.addAttribute("msg","Spring MVC");
		return "index";
	}
	@GetMapping(value="/showuserform")
	public ModelAndView showUser() {
		UserBean obj=new UserBean();
		obj.setGender("Male");
		return new ModelAndView("user","userObj",obj);
	}
	@ModelAttribute("frameworks")
	public List<String> addFrameworks(){
		List<String> frameworks=new ArrayList<String>();
		frameworks.add("Spring");
		frameworks.add("JPA");
		frameworks.add("Hibernate");
		return frameworks;
	}
	@ModelAttribute("numlist")
	public List<Integer> addNumbers(){
		List<Integer> number=new ArrayList<Integer>();
		number.add(1);
		number.add(2);
		number.add(3);
		return number;
	}
	@ModelAttribute("list")
	public Map<String,String> countryList(){
		Map<String,String> map=new HashMap<String,String>();
		map.put("US", "United States");
		map.put("JP", "Japan");
		map.put("Sg", "Singapore");
		return map;
	}
	@GetMapping("/upload")
	public String upload() {
		return "uploadimage";
	}
	@PostMapping(value="/addUser")
	public String addUser(@Validated @ModelAttribute("userObj")UserBean obj,BindingResult br,Model m ) {
	    if(br.hasErrors()) {
	    	
	      return "user";
	    }
	    
	    m.addAttribute("user",obj);
	    return "userview";
	  }
	@RequestMapping(value="/fileupload",method=RequestMethod.POST)
	public String uploadFile(@RequestParam("img") MultipartFile file,HttpServletRequest request) throws IOException {
		System.out.println("Name :"+file.getName());
		System.out.println("Org Name :"+file.getOriginalFilename());
		System.out.println("Byte : "+file.getBytes());
		//System.out.println("Input Stream :"+file.getInputStream());
		System.out.println("Size : "+file.getSize());
		System.out.println("Content Type "+file.getContentType());
		String path=request.getServletContext().getRealPath("/");
		System.out.println(path);
		return "";
	}
	@GetMapping("/img")
	 public String getImage( OutputStream outputStream,HttpServletRequest request) throws IOException, SQLException {
		 	Img img=new Img();
	        Blob blob = img.getimg(); // Fetch the blob from your database
	        if (blob != null) {
	            byte[] imageBytes = blob.getBytes(1, (int) blob.length());
	            outputStream.write(imageBytes);
	            //request.setAttribute("img", imageBytes);
	            System.out.println("hi");
	        }else {
	        	System.out.println("No data");
	        }
	        return "image";
	    }
	@RequestMapping(value="/hi",method=RequestMethod.GET)
	public String hi(OutputStream outputStream,HttpServletRequest request,HttpServletResponse response) throws SQLException {
		Img img=new Img();
        Blob blob = img.getimg(); // Fetch the blob from your database
        if (blob != null) {
            byte[] imageBytes = blob.getBytes(1, (int) blob.length());
//            try {
				//outputStream.write(imageBytes);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
           request.setAttribute("img", imageBytes);
            System.out.println("hi");
            response.setContentType("text/html");
            return "image";
        }else {
        	System.out.println("No data");
        }
		return "image";
	}
}
