package spring.camp.mall;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.camp.mall.common.Pagination;
import spring.camp.mall.common.Uploader;
import spring.camp.mall.namecard.NameCardService;
import spring.camp.mall.namecard.NameCardVO;
import spring.camp.mall.restaurant.RestauRantDTO;
import spring.camp.mall.restaurant.RestauRantService;
import spring.camp.mall.restaurant.RestauRantVO;


@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
  @Autowired
  NameCardService namecardService;
  
  @Autowired
  RestauRantService restaurantService;
  
  
  @RequestMapping(value="/main", method = RequestMethod.GET)
  public ModelAndView main() {
	return new ModelAndView("main");
 }

  // @RequestMapping 어노테이션을 이용해서 /namecard/create.jsp 페이지 호출
  @RequestMapping(value = "/namecard/create", method = RequestMethod.GET)
  public ModelAndView create() {
	  return new ModelAndView("namecard/create");
  }

 
  // @RequestMapping 어노테이션을 이용해서 /namecard/create를 Post 방법으로 호출
  // Post method로 전달된 값을 가져와야 함 => 전달된 값을 받아오기 위한 RedirectAttributes 객체 사용
  @RequestMapping(value = "/namecard/create", method = RequestMethod.POST)
  public ModelAndView createPost(@RequestParam Map<String, Object> map,     // <ncrdNm, 홍길동> 이런 식으로 옴.  <CompNm, 전주대학교>
		  RedirectAttributes redirectAttributes) {
	  ModelAndView mav = new ModelAndView();
	  
	  // 전달된 값을 DB에 저장하고 레코드에 삽입결과를 namecardResult값으로 할당.
	  String namecardId = this.namecardService.create(map);
	  // String nameCardResult = this.namecardService.create(map);
	  
	  
	  // 만약에 namecrdId 값이 null이라면 "error"를 출력
	  // 그렇지 않다면 "success"를 출력
	  
	  if(namecardId == null) {
		  // addFlashAttribute() : 리다이렉트 직전에 플래시메모리에 저장하는 메소드 (리다이렉트가 F5키 누르는 거)
		  //                       저장된 메세지는 리다이렉트 완료 후 소멸 
		  redirectAttributes.addFlashAttribute("msg","error");  
		  mav.setViewName("redirect:/namecard/create"); // 현재 화면에서 리다이렉트 시켜라.
	  }
	  else {
		  redirectAttributes.addFlashAttribute("msg","success");
		  mav.setViewName("redirect:/namecard/detail?ncrdId=" + namecardId);
		  // mav.setViewName("redirect:/namecard/list");
	  }
	  return mav;
	  
  }
  
  // client가 요청하는 경로 /namecard/detail?ncrdId=1 과 같이 요청.
  @RequestMapping(value = "/namecard/detail", method = RequestMethod.GET)
  public ModelAndView detail(@RequestParam Map<String, Object> map) {
	 
	  // 레코드에 ncrdId값이 1인(map) 레코드 정보를 가져오기 
	  // service 호출하여 결과를 리턴
	  Map<String, Object> detailMap = this.namecardService.detail(map);
	  
	  String namecardId = map.get("ncrdId").toString();
	  
	  ModelAndView mav = new ModelAndView();
	  
	  mav.addObject("data",detailMap);    // 짝을 이뤄서 데이터 통째로 넘김  
	  mav.addObject("ncrdId",namecardId); // ncrdid만 넘김
	  mav.addObject("namecard/detail");  
	  // mav.setViewName("namecard/detail");
	  return mav;
  }
  
  // @RequestMapping 어노테이션을 이용해서 /namecard/list를 입력하면 /view/list.jsp 페이지를 호출.
  @RequestMapping(value = "namecard/list")
  public ModelAndView list() {
	  ModelAndView mav = new ModelAndView();
	  // 서비스에 list메소드를 호출.
	  // 데이터베이스의 명함 정보를 namecardVO에 리턴(리스트형)
	  List<NameCardVO> namecardVO = namecardService.list(); 
	  
	  // 명함 정보를 View에 전달
	  mav.addObject("data",namecardVO);
	  
	  
	  mav.setViewName("namecard/list");
	  return mav;
  }
  
  // 상세페이지에서 수정화면을 요청했을때(아직 데이터가 수정되지 않았음)
  @RequestMapping(value="namecard/update", method=RequestMethod.GET)
  public ModelAndView update(@RequestParam Map<String, Object> map) {
	  ModelAndView mav = new ModelAndView();
	  
	  // 레코드에 ncrdId값이 1인(map) 레코드 정보를 가져오기 
	  // service 호출하여 결과를 리턴
	  Map<String, Object> detailMap = this.namecardService.detail(map);
	  String namecardId = map.get("ncrdId").toString();
	 
	  
	  mav.addObject("data",detailMap);    // 짝을 이뤄서 데이터 통째로 넘김  
	  mav.addObject("ncrdId",namecardId); // ncrdid만 넘김
	  mav.addObject("namecard/update");  
	  // mav.setViewName("namecard/update");
	  
	  return mav;
  }
  
  
  // update.jsp페이지에 입력된 데이터로 값을 변경/
  // RedirectAttributes객체는 사용자가 입력한 값을 받아옴.
  @RequestMapping(value = "namecard/update", method = RequestMethod.POST)
  public ModelAndView updatePost(@RequestParam Map<String, Object> map,
		  RedirectAttributes redirectAttributes) {
	   ModelAndView mav = new ModelAndView();
	   
	   //사용자가 입력한 데이터를 서비스에 전달하고 그 결과를 리턴(수정 프로세스 시작과 끝)
	   boolean isUpdateSuccess = this.namecardService.edit(map);
	   if(isUpdateSuccess) {
		   redirectAttributes.addFlashAttribute("msg","success");
		   String ncrdId = map.get("ncrdId").toString();
		   mav.setViewName("redirect:/namecard/detail?ncrdId=" +ncrdId);
	   }
	   else {
		   redirectAttributes.addFlashAttribute("msg","error");
		   mav = this.update(map);
	   }
	   
	   return mav;
  }
  
  // 삭제 프로세스
  @RequestMapping(value = "namecard/delete", method = RequestMethod.POST)
  public ModelAndView delete(@RequestParam Map<String, Object> map,
		  RedirectAttributes redirectAttributes) {
	   ModelAndView mav = new ModelAndView();
	   
	   //사용자가 입력한 데이터를 서비스에 전달하고 그 결과를 리턴(수정 프로세스 시작과 끝)
	   boolean isDeleteSuccess = this.namecardService.delete(map);
	   if(isDeleteSuccess) {
		   redirectAttributes.addFlashAttribute("msg","success");
		   String ncrdId = map.get("ncrdId").toString();
		   mav.setViewName("redirect:/namecard/list");
	   }
	   else {
		   String ncrdId = map.get("ncrdId").toString();
		   redirectAttributes.addFlashAttribute("msg","error");
		   mav.setViewName("redirect:/namecard/detail?ncrdId =" + ncrdId);
	   }
	   
	   return mav;
  }
  
  @RequestMapping(value = "/restaurant/create", method = RequestMethod.GET)
  public ModelAndView restcreate() {

 	  return new ModelAndView("restaurant/create");
  }
  
  @RequestMapping(value = "/restaurant/create", method = RequestMethod.POST,
		  produces="text/plain;charset=UTF-8")
  public ModelAndView restcreatePost(
		  @RequestParam Map<String, Object> map,    
 		  RedirectAttributes redirectAttributes,
 		  MultipartHttpServletRequest mtfRequest) throws Exception{
 	    ModelAndView mav = new ModelAndView();
 	    
 	    MultipartFile files = mtfRequest.getFile("files");
 	      String fileName = files.getOriginalFilename();
 	      
 	      if(files.getSize() >= 1) {
 	    	  Map<String, String> retfilePath = Uploader.uploadFile(files, mtfRequest);
 	    	  
 	    	  map.put("fileName", fileName);
 	    	  map.put("filePath", retfilePath.get("filePathOrg"));
 	      }
 	
 	  String restaurantId = this.restaurantService.create(map);
 	
 	  if(restaurantId == null) {
 		  redirectAttributes.addFlashAttribute("msg","error");  
 		  mav.setViewName("redirect:/restaurant/create"); // 현재 화면에서 리다이렉트 시켜라.
 	  }
 	  else {
 		  redirectAttributes.addFlashAttribute("msg","success");
 		  mav.setViewName("redirect:/restaurant/detail?rNum=" + restaurantId);
 	  }
 	  return mav;
 	  
  }

 @RequestMapping(value = "restaurant/list")
 public ModelAndView restlist(RestauRantDTO restaurantDTO,
		 @RequestParam  Map<String, Object> map,
		 @RequestParam(required = false, defaultValue = "1") int page,
		 @RequestParam(required = false, defaultValue = "1") int range) 
		 throws Exception {
	 
	 // 페이지 처리
	 Pagination pagination = new Pagination();
	 
	 restaurantDTO.setRecordCountPerpage((page-1)*pagination.getListSize());
	 restaurantDTO.setFirstIndex(pagination.getListSize());
	 
	 if(map.containsKey("searchCnd"))
		 restaurantDTO.setSearchCnd(map.get("searchCnd").toString());
	 
	 List<RestauRantVO> restaurantVO = restaurantService.list(restaurantDTO);
	 
	 Map<String, Object> listcntMap = restaurantService.listcnt(map);
	 
	 int listCnt = Integer.parseInt(listcntMap.get("list_cnt").toString());
	 
	 pagination.pageInfo(page, range, listCnt);
	 
	  ModelAndView mav = new ModelAndView();
	
	  mav.addObject("data",restaurantVO);
	  mav.addObject("info",listcntMap);
	  mav.addObject("listNum", (listCnt) +1);
	  mav.addObject("listNum",(listCnt - (pagination.getPage() - 1) 
			  * pagination.getListSize()) + 1);
	  mav.addObject("pagination",pagination);
	  mav.addObject("searchCnd",map.get("searchCnd"));
	  if(map.containsKey("searchWrd")) {
		  mav.addObject("searchWrd",map.get("searchWrd"));
			 
	  }
		 
		 
		 
	  
	  mav.setViewName("restaurant/list");
	  return mav;
 }
 
 @RequestMapping(value = "restaurant/list", method = RequestMethod.POST)
 public ModelAndView restlistSearch(RestauRantDTO restaurantDTO,
		 @RequestParam Map<String, Object> map) {
	 if(map.containsKey("searchCnd"))
		 restaurantDTO.setSearchCnd(map.get("searchCnd").toString());
	 
	 List<RestauRantVO> restaurantVO = restaurantService.list(restaurantDTO); 
	  ModelAndView mav = new ModelAndView();
	mav.addObject("data", restaurantVO);
	mav.addObject("searchCnd", map.get("searchCnd"));
	if(map.containsKey("searchWrd")) {
		mav.addObject("searchWrd", map.get("searchWrd"));
	}
	  
	  
	  mav.setViewName("restaurant/list");
	  return mav;
 }
 
 @RequestMapping(value = "restaurant/newlist", method = RequestMethod.GET)
 public ModelAndView listRowBounds(RestauRantDTO restaurantDTO,
		     @RequestParam Map<String, Object> map) {
	 int offset = 0;
	 int limit = 10;
	  ModelAndView mav = new ModelAndView();
	
	  List<RestauRantVO> restaurantVO = restaurantService.list(offset, limit); 
	                      
	  // 명함 정보를 View에 전달
	  mav.addObject("data",restaurantVO);
	  
	  
	  mav.setViewName("restaurant/newlist");
	  return mav;
 }
 @RequestMapping(value = "/restaurant/detail", method = RequestMethod.GET)
 public ModelAndView restdetail(@RequestParam Map<String, Object> map) {
	 
	  Map<String, Object> detailMap = this.restaurantService.detail(map);
	  
	  String restaurantId = map.get("rNum").toString();
	  
	  ModelAndView mav = new ModelAndView();
	  
	  mav.addObject("data",detailMap);   
	  mav.addObject("rNum",restaurantId); 
	  mav.addObject("restaurant/detail");  
	  return mav;
}
 
 @RequestMapping(value="restaurant/update", method=RequestMethod.GET)
 public ModelAndView restupdate(@RequestParam Map<String, Object> map) {
	  ModelAndView mav = new ModelAndView();
	  
	  Map<String, Object> detailMap = this.restaurantService.detail(map);
	  String restaurantId = map.get("rNum").toString();
	 
	  
	  mav.addObject("data",detailMap);   
	  mav.addObject("rNum",restaurantId); 
	  mav.addObject("restaurant/update");  
	
	  
	  return mav;
 }
 
 
 @RequestMapping(value = "restaurant/update", method = RequestMethod.POST,
		 produces = "text/plain;charset=UTF-8")
 public ModelAndView restupdatePost(
		 @RequestParam Map<String, Object> map,
		 RedirectAttributes redirectAttributes,
		  HttpServletRequest request,
		  MultipartHttpServletRequest mtfRequest) throws Exception {
	   ModelAndView mav = new ModelAndView();
	   
	 	   
	 	      MultipartFile files = mtfRequest.getFile("files");
	 	      String fileName = files.getOriginalFilename();
	 	      
	 	      if(files.getSize() >= 1) {
	 	    	  Map<String, String> retfilePath = Uploader.uploadFile(files, request);
	 	    	  
	 	    	  map.put("fileName", fileName);
	 	    	  map.put("filePath", retfilePath.get("filePathOrg"));
	 	      }
	 	 
	   boolean isUpdateSuccess = this.restaurantService.edit(map);
	   if(isUpdateSuccess) {
		   redirectAttributes.addFlashAttribute("msg","success");
		   String rNum = map.get("rNum").toString();
		   mav.setViewName("redirect:/restaurant/detail?rNum=" +rNum);
	   }
	   else {
		   redirectAttributes.addFlashAttribute("msg","error");
		   mav = this.update(map);
	   }
	   
	   return mav;
 }

@RequestMapping(value = "restaurant/delete", method = RequestMethod.POST)
public ModelAndView restdelete(@RequestParam Map<String, Object> map,
		  RedirectAttributes redirectAttributes) {
	   ModelAndView mav = new ModelAndView();
	   boolean isDeleteSuccess = this.restaurantService.delete(map);
	   if(isDeleteSuccess) {
		   redirectAttributes.addFlashAttribute("msg","success");
		   String restaurantId = map.get("rNum").toString();
		   mav.setViewName("redirect:/restaurant/list");
	   }
	   else {
		   String rNum = map.get("rNum").toString();
		   redirectAttributes.addFlashAttribute("msg","error");
		   mav.setViewName("redirect:/restaurant/detail?rNum =" + rNum);
	   }
	   
	   return mav;
}

}








