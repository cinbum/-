package spring.camp.mall.namecard;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//DAO(Data Access Object)

// @Repository : 선언된 클래스는 DAO 메소드를 실행하는 것으로 이에 발생하는 예외처리(exception)까지 담당
@Repository
public class NameCardDAO {
	
	// @Autowired : 속성, setter, 생성자에서 사용하는 어노테이션
	//              의존 객체의 데이터타입에 필요한 Bean을 찾아서 주입
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	// SqlSessionTemplate은 SqlSession 객체를 구현한 MyBatis 스프링 연동의 핵심으로 데이터베이스 처리
	// SqlSession : 스프링의 트랜젝션에 의해 세션을 자동으로 실행, commit, rollback
	
	// 데이터 삽입 메소드
	public int insert(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("namecard.insertNcrdItem",map);    // 입력되면 1값 리턴.
	}
	// 데이터 읽기 메소드
	public List<NameCardVO> selectList(){
		return this.sqlSessionTemplate.selectList("namecard.list");
	}
	// 데이터 상세 정보 메소드
	public Map<String, Object> selectDetail(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("namecard.selectNcrdItem", map);
	}
	// 데이터 수정 메소드
	public int update(Map<String, Object>map) {
		
		return this.sqlSessionTemplate.update("namecard.update", map);
	}
	// 데이터 삭제 메소드
	public int delete(Map<String, Object> map) {
		
		return this.sqlSessionTemplate.delete("namecard.delete", map);
	}

	

}
