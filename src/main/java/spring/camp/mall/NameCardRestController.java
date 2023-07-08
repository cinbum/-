package spring.camp.mall;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import spring.camp.mall.namecard.NameCardService;
import spring.camp.mall.namecard.NameCardVO;

// RestController : 선언한 클래스가 RestAPI서비스를 구현한 것
@RestController
@RequestMapping("/namecardapi")
public class NameCardRestController {
	private static final Logger logger = LoggerFactory.getLogger(NameCardRestController.class);

	@Autowired
	NameCardService namecardService;

	@RequestMapping(value="/detail/{idx}", method=RequestMethod.GET)
	@ApiOperation(value = "{idx}명함세부정보를 반환한다.", response = NameCardVO.class)
	public ResponseEntity<?> select(@PathVariable String idx) {
		try {
			Map<String, Object> map =  new HashMap<String, Object>();
			map.put("ncrdId", new String(idx));
 			Map<String, Object> detailMap = namecardService.detail(map);

			if (detailMap != null) {
				return new ResponseEntity<Map>(detailMap, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@RequestMapping(value="/lists", method=RequestMethod.GET)
	@ApiOperation(value = "명함정보 목록을 반환한다.", response = NameCardVO.class)
	public ResponseEntity<?> search(@ModelAttribute NameCardVO nameCardVO) {
		try {
			List<NameCardVO> list = namecardService.list();
			if (list != null && list.size() > 0) {
				return new ResponseEntity<List<NameCardVO>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

 	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
