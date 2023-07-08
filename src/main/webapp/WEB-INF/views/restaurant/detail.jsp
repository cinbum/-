<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../layout/header.jsp"%>
<% 
pageContext.setAttribute("CR", "\r");
pageContext.setAttribute("LF", "\n");
pageContext.setAttribute("CRLF", "\r\n");
pageContext.setAttribute("SP", "&nbsp;");
pageContext.setAttribute("BR", "</br>");
%>
<c:set var = "cmt" value = "${fn:replace(data.r_note, CRLF, BR)}"/>
<c:set var = "cmt" value = "${fn:replace(cmt,CR, BR)}"/>
<c:set var = "cmt" value = "${fn:replace(cmt,CR, BR)}"/>
<c:set var = "cmt" value = "${fn:replace(cmt,' ', SP)}"/>
  <h1>맛집 상세</h1>
	<table class="table table-dark">
		<colgroup>
			<col style="width:14%" />
			<col style="width:33%" />
			<col style="width:12%" />
			<col style="" />
		</colgroup>
		
		<tr>
			<th>맛집이름</th>
			<td class="left">${data.r_name} &nbsp;</td>
			<th>업종</th>
			<td class="left">${data.r_type}  &nbsp;</td>
		</tr>
		
		<tr>
			<th>추천메뉴</th> 
			<td class="left">${data.r_menu}  &nbsp;</td>
			<th>가격</th>
			<td class="left">${data.r_pric} &nbsp;</td>
		</tr>
		
		<tr>
			<th>추천메뉴2</th> 
			<td class="left">${data.r_menu2}  &nbsp;</td>
			<th>가격</th>
			<td class="left">${data.r_pric2} &nbsp;</td>
		</tr>
		
		<tr>
			<th>전화번호</th>
			<td class="left">${data.r_phone}  &nbsp;</td>
			<th>주소</th>
			<td class="left">${data.r_addr} ${data.r_addr2}</td>
		</tr>
		
		<tr>
			<th>방문날짜</th>
			<td class="left">${data.r_visit}
			</td>
			<th>평점</th>
			<td class="left">${data.r_grade}점  &nbsp;</td>
		</tr>
		
		<tr>
			<th>비고</th>
			<td class="left"><c:out value = "${cmt}" escapeXml = "false"/>
		</td>
		</tr>
		
	
		<tr>
		<td class = "left" colspan = "2">
		     <div class = "mb-3">
		        ${data.filename}
		        <img id = "happy" src = "<c:url value="/resources/images${data.filepath}" />" 
		        alt = "${data.filename}" style="width:300px; height:300px" onError="this.style.visibility='hidden'">
		        </div>
		          </td>
		          </tr>
	</table>
	
<div class="w-100 text-right">
		<div class="col-3 text-right float-right"> 
			<div class="input-group mb-3">
				<div class="input-group-prepend">
				
			<form action="/restaurant/delete" method="post"> 
				   <input type="hidden" name="rNum" value="${data.r_num}" />
   					<input type="submit" value="삭제" class="btn btn-danger  mr-1" /> 
			</form> 
			  
					<input id="btn_update" class="btn btn-success mr-1" type="button" value="수정" />
				    <input id="btn_list" class="btn btn-warning mr-1" type="button" value="목록" />	
				</div>
			</div>
		</div>
</div>

 
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


$('#btn_update').click(function(e){
	location.href="/restaurant/update?rNum="+${rNum};
});
$('#btn_list').click(function(e){
	location.href="/restaurant/list";
});
</script>
<%@ include file="../layout/footer.jsp"%>

