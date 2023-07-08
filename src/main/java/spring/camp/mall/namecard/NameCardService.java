package spring.camp.mall.namecard;

import java.util.List;
import java.util.Map;

public interface NameCardService {
	// 생성
	String create(Map<String, Object> map);
    // 선택
	List list();
	// 상세정보
	Map<String, Object> detail(Map<String, Object> map);
	// 수정
	boolean edit(Map<String, Object> map);
	// 식제
	boolean delete(Map<String, Object> map);
	


	
}
