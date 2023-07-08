package spring.camp.mall.restaurant;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// @Service : 비즈니스 로직을 실행하는 서비스 클래스 선언
@Service
public class RestauRantImpl implements RestauRantService {
   
	// @Autowired : DAO 객체를 주입받을 때 사용
	@Autowired
	RestauRantDAO RestauRantDAO;
	
	@Override
	public String create(Map<String, Object> map){
		// 데이터베이스에 레코드 삽입결과를 affectRowCount에 받아옴.
		int affectRowCount = this.RestauRantDAO.insert(map);
		if(affectRowCount == 1) {
			return map.get("r_num").toString();  // ncrdId값이 리턴 값으로 옴.
		}
		return null;
	}
	

@Override
public Map<String, Object> detail(Map<String, Object> map){
	
	return this.RestauRantDAO.selectDetail(map);
}

@Override
public List list() {
	return this.RestauRantDAO.selectList();
	
}
 
@Override
public boolean edit(Map<String, Object> map) {
	int affectRowCount = this.RestauRantDAO.update(map);
	
	return affectRowCount == 1;  // 1이면, 즉 true면 return
}

@Override
public boolean delete(Map<String, Object> map) {
	int affectRowCount = this.RestauRantDAO.delete(map);
	
	return affectRowCount == 1;  // 1이면, 즉 true면 return 하나가 수정됬다는 의미.
}

@Override
public List<RestauRantVO> list(RestauRantDTO restaurantDTO) {
	// TODO Auto-generated method stub
	return this.RestauRantDAO.selectList(restaurantDTO);
}


@Override
public List<RestauRantVO> list(int offset, int limit) {
	// TODO Auto-generated method stub
	RowBounds rowBounds = new RowBounds(offset, limit);
	return this.RestauRantDAO.selectRowBoundList(rowBounds);
}

@Override
public Map<String, Object> listcnt(Map<String, Object> map) {
	return this.RestauRantDAO.selectListCnt(map);
}
}
