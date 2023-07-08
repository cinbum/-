<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../layout/header.jsp"%>

  <h1>명함 상세</h1>
	<table class="table table-dark">
		<colgroup>
			<col style="width:16%" />
			<col style="width:34%" />
			<col style="width:16%" />
			<col style="" />
		</colgroup>
		<tr>
			<th>이름</th>
			<td class="left"colspan="3">${data.nm}</td>
		</tr>
		<tr>
			<th>회사명</th>
			<td class="left">${data.cmpny_nm}&nbsp;</td>
			<th>부서명</th> 
			<td class="left">${data.dept_nm}  &nbsp;</td>
		</tr>
		<tr>
			<th>직위</th>
			<td class="left">${data.ofcps_nm} &nbsp;</td>
			<th>직급</th>
			<td class="left">${data.clsf_nm}  &nbsp;</td>
		</tr>
		<tr>
			<th>이메일주소</th>
			<td class="left">${data.email_adres}  &nbsp;</td>
			<th>전화번호</th>
			<td class="left">${data.nation_no}-${data.area_no}-${data.middle_telno}-${data.end_telno}  &nbsp;</td>
		</tr>
		<tr>
			<th>휴대폰번호</th>
			<td class="left" colspan="3">${data.idntfc_no}-${data.middle_mbtlnum}-${data.end_mbtlnum}  &nbsp;</td>
		</tr>
		<tr>
			<th>주소</th>
			<td class="left" colspan="3">${data.adres} &nbsp; ${data.detail_adres}</td>
		</tr>
		<tr>
			<th>외부사용자여부</th>
			<td class="left" colspan="3">
				<c:choose>
			    	<c:when test="${data.extrl_user_at == 'Y'}">
			    		외부
			    	</c:when>
			    	<c:otherwise>
			    		내부
			    	</c:otherwise>
			    </c:choose>
			</td>
		</tr>
		<tr>
			<th>비고</th>
			<td class="left" colspan="3">${data.rm} &nbsp;</td>
		</tr>
	</table>
	
<div class="w-100 text-right">
		<div class="col-3 text-right float-right"> 
			<div class="input-group mb-3">
				<div class="input-group-prepend">
				
			<form action="/namecard/delete" method="post"> 
				   <input type="hidden" name="ncrdId" value="${data.ncrd_id}" />
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
	location.href="/namecard/update?ncrdId="+${ncrdId};
});
$('#btn_list').click(function(e){
	location.href="/namecard/list";
});
</script>
<%@ include file="../layout/footer.jsp"%>

