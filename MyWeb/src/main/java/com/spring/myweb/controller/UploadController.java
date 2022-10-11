package com.spring.myweb.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.myweb.command.MultiUploadVO;
import com.spring.myweb.command.UploadVO;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/fileupload")
public class UploadController {
	
	@GetMapping("/upload")
	public void form() {
	}
	
	@PostMapping("/upload_ok")
	public String upload(@RequestParam("file") MultipartFile file) { //하나의 파일만 받을때는 매개변수 타입 MultipartFile 선언
		String fileRealName = file.getOriginalFilename(); //파일 원본명
		long size = file.getSize(); //파일 사이즈
		
		System.out.println("파일명: " + fileRealName);
		System.out.println("사이즈: " + size);
		
		//DB에는 파일 경로를 저장, 실제 파일은 서버 컴퓨터의 로컬 경로에 저장하는 방식.
		String uploadFolder = "C:\\test\\upload"; //폴더 경로
		String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length()); //확장자
		
		/*
        파일 업로드 시 파일명이 동일한 파일이 이미 존재할 수도 있고,
        사용자가 업로드하는 파일명이 영어 이외의 언어로 되어있을 수 있습니다.
        타 언어를 지원하지 않는 환경에서는 정상 동작이 되지 않습니다. (리눅스)
        고유한 랜덤 문자를 통해 DB와 서버에 저장할 파일명을 새롭게 만들어 줍니다.
        */
		
		//실제 파일 저장 메소드(fileWriter 작업을 손쉽게 한방에 처리해 줍니다.)
		try {
			UUID uuid = UUID.randomUUID(); //고유한 랜덤 문자 UUID
			System.out.println(uuid.toString());
			String[] uuids = uuid.toString().split("-"); //분할을 하기위해 split메소드 사용 
			//split : 특정 문자를 기준으로 문자열을 나누어 배열로 저장하는 메소드
			System.out.println("생성된 고유 문자열: " + uuids[0]);
			System.out.println("확장자명: " + fileExtension);
			
			File folder = new File(uploadFolder);
			if(!folder.exists()) { //exists() 존재여부 파악 메소드
				folder.mkdirs(); //폴더가 존재하지 않는다면 생성해라.
				//mkdir : 마지막 경로만 만들어주고 앞에 있는 경로들은 완성이 되어 있어야한다
				//mkdirs : 처음부터 끝까지 경로를 자동으로 만들어준다.
			}
			
			folder = new File(uploadFolder + "\\" + uuids[0] + fileExtension);			
			
			file.transferTo(folder);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return "fileupload/upload_ok";
	}
	
	@PostMapping("/upload_ok2")
	public String upload2(MultipartHttpServletRequest files) { //여러개의 파일을 매개변수로 받을때는 매개변수 타입 MultipartHttpServletRequest 선언
		//서버에서 저장할 파일 경로
		String uploadFolder = "C:/test/upload";
		
		List<MultipartFile> list = files.getFiles("files");
		/*
		for(int i = 0; i < list.size(); i++) {
			String fileRealName = list.get(i).getOriginalFilename();
			long size = list.get(i).getSize();
			System.out.println("파일명: " + fileRealName);
			System.out.println("사이즈: " + size);
			
			File saveFile = new File(uploadFolder + "/" + fileRealName);
			try {
				list.get(i).transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		*/
		for(MultipartFile m : list) {
			
			try {
				String fileRealName = m.getOriginalFilename();
				long size = m.getSize();
				System.out.println("파일명: " + fileRealName);
				System.out.println("사이즈: " + size);
				
				File saveFile = new File(uploadFolder + "/" + fileRealName);
				
				m.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "fileupload/upload_ok";
	}
	
	@PostMapping("/upload_ok3")
	public String upload3(@RequestParam("file") List<MultipartFile> list) {
		
		String uploadFolder = "C:/test/upload";
		
		for(MultipartFile m : list) {
			
			try {
				String fileRealName = m.getOriginalFilename();
				long size = m.getSize();
				System.out.println("파일명: " + fileRealName);
				System.out.println("사이즈: " + size);
				
				File saveFile = new File(uploadFolder + "/" + fileRealName);
				
				m.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "fileupload/upload_ok";
	}
	
	@PostMapping("/upload_ok4")
	public String upload4(MultiUploadVO vo) {
		String uploadFolder = "C:/test/upload";
		System.out.println(vo);
		List<UploadVO> list = vo.getList();
		
		for(UploadVO uvo : list) {
			String fileName = uvo.getName();
			String realName = uvo.getFile().getOriginalFilename();
			String fileExtension = realName.substring(realName.lastIndexOf("."), realName.length());
			File saveFile = new File(uploadFolder + "/" + fileName + fileExtension);
			try {
				uvo.getFile().transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "fileupload/upload_ok";
	}
	
}
