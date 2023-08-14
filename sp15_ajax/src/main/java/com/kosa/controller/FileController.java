package com.kosa.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FileController {

	@GetMapping("/fileUploadForm")
	public ModelAndView fileForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("fileForm"); // 뷰 이름 설정
		return modelAndView;
	}

	@PostMapping(value = "/fileUpload.do", produces = "application/json")
	public HashMap<String, Object> fileUpload(MultipartHttpServletRequest request) throws Exception {
		HashMap<String, Object> result = new HashMap<>();

		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		System.out.println(title);
		System.out.println(writer);

		MultipartFile file = request.getFile("file");

		if(file != null) {
			System.out.println("파라미터이름:"+file.getName());
			System.out.println("파일명:"+file.getOriginalFilename());
		    System.out.println("파일사이즈:"+file.getSize());
		    
		    String name = file.getName(); //필드 이름 얻기
			String fileName = file.getOriginalFilename(); //파일명 얻기
			String contentType = file.getContentType(); //컨텐츠 타입 얻기
					
			//업로드 파일명을 변경후 저장			
			String uploadedFileName = System.currentTimeMillis() 
					+ UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf("."));
		
		    String uploadPath = request.getSession().getServletContext().getRealPath("upload");
		
		    //지정한주소에 파일 저장	    
		    if(file.getSize() != 0) {
		    	File uploadDir = new File(uploadPath);
		    	if (!uploadDir.exists()) {
		    	    uploadDir.mkdir();
		    	}
		    	file.transferTo(new File(uploadPath+"/"+uploadedFileName));	    	
		    }   
		    
		    result.put("paramName", name);
		    result.put("fileName", fileName);
		    result.put("uploadedFileName", uploadedFileName);
		    result.put("fileSize", file.getSize());
		    result.put("contentType", contentType);
		}
		
		result.put("title", title);
		result.put("writer", writer);
		return result;
	}
}
