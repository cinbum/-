<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h1>최신 목록</h1>
<div class="w-100 text-right">
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
      <td>${row.rAddr}</td>   
      <td>${row.rPhone}</td>  
      <td>${row.rGrade}</td>
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
</script>


<%@ include file="../layout/footer.jsp"%>