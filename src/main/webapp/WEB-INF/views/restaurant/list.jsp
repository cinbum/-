<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h1>맛집 목록</h1>
<div class="w-100 text-right">
    <div class="col-6 text-right float-right">
      <form action="/restaurant/list" method = "post" >  
      <div class="input-group mb-3">
        <div class="input-group-prepend">
          <select id="searchCnd" name="searchCnd">
            <option value="" >선택</option>
            <option value="1" ${searchCnd == "1" ? "selected" : ""} >가게이름</option>
            <option value="2" ${searchCnd == "2" ? "selected" : ""} >업종</option>
            <option value="3" ${searchCnd == "3" ? "selected" : ""} >평점</option> 
          </select>  
          <input type="text" placeholder="검색" name="searchWrd" value="${searchWrd}" class="form-control col-8" />  
          <input type="submit" value="검색" class="btn btn-xs btn-info" />  
          
          
          <input id="btn_create" class="btn btn-primary" type="button" value="생성" />
          <c:choose>
              <c:when test="${not empty searchCnd}">
            <input id="btn_list" class="btn btn-warning" type="button" value="목록" />
              </c:when> 
          </c:choose>    
        </div>
      </div> 
      </form> 
        
    </div>
</div>
<table class="table table-dark text-center w-100">  
  <thead>  
    <tr>  
    <th>번호</th>  
    <th>가게이름</th>   
    <th>업종</th>  
    <th>주소</th> 
    <th>전화번호</th> 
    <th>평점</th>
    <th>방문날짜</th>    
    </tr>  
  </thead>  
  <tbody>  
  <c:forEach var="row" items="${data}">  
    <tr>  
      <td>${row.rNum}</td>   
      <td><a href="/restaurant/detail?rNum=${row.rNum}">${row.rName}</a></td>
      <td>${row.rType}</td>   
      <td>${row.rAddr} ${row.rAddr2}</td>   
      <td>${row.rPhone}</td>  
      <td>${row.rGrade}점</td>
      <td>${row.rVisit}
     </td>   
    </tr>  
    
  </c:forEach>  
  </tbody>  
</table>

<!-- pagination{s} -->
<div class="w-100 text-center">
  <div id="paginationBox" >
    <ul class="pagination">
      <c:if test="${pagination.prev}">
        <li class="page-item"><a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Previous</a></li>
      </c:if>
        
      <c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
        <li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> "><a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')"> ${idx} </a></li>
      </c:forEach>
        
      <c:if test="${pagination.next}">
        <li class="page-item"><a class="page-link" href="#" onClick="fn_next('${pagination.range}', '${pagination.range}', '${pagination.rangeSize}')" >Next</a></li>
      </c:if>
    </ul>
  </div>
</div>
<!-- pagination{e} -->
<script>
var msg = "${msg}";
if (msg === "success") {
  swal({
      title: "Good job!",
      text: "정상적으로 처리되었습니다.",
      icon: "success",
      button: "OK",
    });
   
} else if (msg == "error") {
  swal({
      title: "Request error",
      text: "",
      icon: "error",
      button: "OK",
    });
   
}

$('#btn_create').click(function(e){
  location.href="/restaurant/create";
});
$('#btn_list').click(function(e){
  location.href="/restaurant/list";
});

  //이전 버튼 이벤트
  function fn_prev(page, range, rangeSize) {
    var page = ((range - 2) * rangeSize) + 1;
    var range = range - 1;
    var url = "${pageContext.request.contextPath}/restaurant/list";
    url = url + "?page=" + page;
    url = url + "&range=" + range;
    <c:choose>
         <c:when test="${not empty searchCnd}">
        url = url + "&searchCnd=${searchCnd}”;
        url = url + "&searchWrd="+encodeURIComponent("${searchWrd}") ;
         </c:when> 
    </c:choose>    
    location.href = url;
  }
  //페이지 번호 클릭
  function fn_pagination(page, range, rangeSize, searchType, keyword) {
    var url = "${pageContext.request.contextPath}/restaurant/list";
    url = url + "?page=" + page;
    url = url + "&range=" + range;
    <c:choose>
         <c:when test="${not empty searchCnd}">
        url = url + "&searchCnd=${searchCnd}”;
        url = url + "&searchWrd="+encodeURIComponent("${searchWrd}") ;
        </c:when> 
    </c:choose>  
    location.href = url;  
  }
  //다음 버튼 이벤트
  function fn_next(page, range, rangeSize) {
    var page = parseInt((range * rangeSize)) + 1;
    var range = parseInt(range) + 1;
    
    var url = "${pageContext.request.contextPath}/restaurant/list";
    url = url + "?page=" + page;
    url = url + "&range=" + range;
    <c:choose>
         <c:when test="${not empty searchCnd}">
        url = url + "&searchCnd=${searchCnd}”;
        url = url + "&searchWrd="+encodeURIComponent("${searchWrd}") ;
         </c:when> 
    </c:choose>  
    location.href = url;
  }
</script>


<%@ include file="../layout/footer.jsp"%>
