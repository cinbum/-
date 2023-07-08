package spring.camp.mall.common;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;


import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;




public class Uploader {
	
 private static final Logger logger =
LoggerFactory.getLogger(Uploader.class);

public static HttpHeaders getHttpHeaders(String fileName) throws
Exception {
	MediaType mediaType = MimeType.getMediaType(fileName);
	
	HttpHeaders httpHeaders = new HttpHeaders();
	
	// mime 타입 확인
	if(mediaType != null) {
		httpHeaders.setContentType(mediaType);
		return httpHeaders;
	}
	// UUID 제거
	fileName = fileName.substring(fileName.indexOf("_") + 1);
	
	// 다운로드 MIME 타입 설정
	httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	
	// 한글 인코딩처리
	httpHeaders.add("Content-Disposition", "attachment; filename=\"" + 
	new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
	
    return httpHeaders;
}

    public static Map<String, String> uploadFile(MultipartFile file, 
		         HttpServletRequest request) throws Exception {
	 
     // 파일명
	 String originalFileName = file.getOriginalFilename();
	 
	 // 파일데이터
	 byte[] fileData = file.getBytes();
	 
	 // 1. 파일명 중복 방지 처리
	 String uuidFileName = getUuidFileName(originalFileName);
	 
	 // 2. 파일 업로드 경로 설정
	 // 기본 경로로 추출 (이미지 or 일반파일)
	 String rootPath = getRootPath(originalFileName, request);
	 
	 // 날짜 경로 추출, 날짜 폴더 생성
	 String datePath = getDatePath(rootPath);
	 
	 // 3. 서버에 파일 저장
	 // 파일 객체 생성
	 File target = new File(rootPath + datePath, uuidFileName);
	 
	 // 파일 객체에 파일 데이터 복사	 
	 FileCopyUtils.copy(fileData, target);
	 
	 
	 Map<String, String> retMap = new HashMap<>();
	 retMap.put("filePathOrg", replaceSavedFilePath(datePath, uuidFileName));
	 
	 String thumbnailImgName = "";
	 
	 // 4. 이미지 파일인 경우 썸네일이미지 생성
	 if(MimeType.getMediaType(originalFileName) != null) {
		 uuidFileName = makeThumbnail(rootPath, datePath, uuidFileName);
		 thumbnailImgName = replaceSavedFilePath(datePath, uuidFileName);
	 }
	 retMap.put("filePathThumb", thumbnailImgName);
	 
	 
	 // 5. 파일 저장 경로 치환
	 return retMap;
 }
 
    
 public static String getRootPath(String fileName, HttpServletRequest request) {
	 
	 String rootPath = "/resources";
	 
	 // 파일 타입 확인
	 MediaType mediaType = MimeType.getMediaType(fileName);
	 
	 if (mediaType != null)
		 return // 이미지 파일 경로
	request.getSession().getServletContext().getRealPath(rootPath + "/images");
	 
	return // 일반 파일 경로
	request.getSession().getServletContext().getRealPath(rootPath + "/files");
 }
 
 
 // 저장 디렉토리 설정
 private static String getDatePath(String uploadPath) {
	 
	 Calendar calendar = Calendar.getInstance();
	 String yearPath = File.separator + calendar.get(Calendar.YEAR);
	 String monthPath = yearPath + File.separator + new 
	 DecimalFormat("00").format(calendar.get(Calendar.MONTH) + 1);
	 
	 makeDateDir(uploadPath, yearPath, monthPath);
	 
	 return monthPath;
 }
 
 // 저장 디렉토리 생성
 private static void makeDateDir(String uploadPath, String... paths)
 {
	 // 디렉토리 존재 여부 확인
	 if(new File(uploadPath + paths[paths.length - 1]).exists())
		 return;

	 for(String path : paths) {
		 File dirPath = new File(uploadPath + path);
		 if(!dirPath.exists())
			 dirPath.mkdirs();
	 }
 }
 
 // 파일 저장 경로 치환
 private static String replaceSavedFilePath(String datePath, String fileName) {
	 String savedFilePath = datePath + File.separator + fileName;
	 return savedFilePath.replace(File.separatorChar, '/');
 }
 
 // 파일명 중복방지 처리
 private static String getUuidFileName(String originalFileName) {
	 return UUID.randomUUID().toString() + "_" + originalFileName;
 }
 
 // 썸네일 이미지 생성
 private static String makeThumbnail(String uploadRootPath, String datePath, String fileName) throws
 Exception{
	 
	 // 원본이미지를 메모리상에 로딩
	 BufferedImage originalImg = ImageIO.read(new File(uploadRootPath + datePath, fileName));
	 
	 // 원본이미지를 축소
	 BufferedImage thumbnailImg = Scalr.resize(originalImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
	 
	 // 썸네일 파일명
	 String thumbnailImgName = "s_" + fileName;
	 
	 // 썸네일 업로드 경로
	 String fullPath = uploadRootPath + datePath + File.separator + thumbnailImgName;
	 
	 // 썸네일 파일 객체 생성
	 File newFile = new File(fullPath);
	 
	 // 썸네일 파일 확장자 추출
	 String formatName = MimeType.getFormatName(fileName);
	 
	 // 썸네일 파일 저장
	 ImageIO.write(thumbnailImg, formatName, newFile);
	 
	 return thumbnailImgName;
  }
}
