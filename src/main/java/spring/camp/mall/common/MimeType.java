package spring.camp.mall.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

public class MimeType {

private static Map<String, MediaType> mimeTypeMap;

static {
	mimeTypeMap = new HashMap<String, MediaType>();
	mimeTypeMap.put("JPG", MediaType.IMAGE_JPEG);
	mimeTypeMap.put("GIF", MediaType.IMAGE_GIF);
	mimeTypeMap.put("PNG", MediaType.IMAGE_PNG);
}

// 파일 타입
static MediaType getMediaType(String fileName) {
	String formatName = getFormatName(fileName);
	return mimeTypeMap.get(formatName);
}

// 파일 확장자 추출

static String getFormatName(String fileName) {
	return fileName.substring(fileName.lastIndexOf(".") + 1).toUpperCase();
}

}
