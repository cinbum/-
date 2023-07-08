<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../layout/header.jsp"%>
 

 <form method="POST" enctype="multipart/form-data">

<div class="wTableFrm">
	<!-- 타이틀 -->
	<h2>맛집등록</h2><!-- 명함 등록 -->
	
	<table class="table table-dark">
		<colgroup>
			<col style="width:13%" />
			<col style="width:33%" />
			<col style="width:12%" />
			<col style="" />
		</colgroup>
		<tr>
			<th>맛집이름</th>
			<td class="left">
				<input type="text" id="rName" name="rName" maxlength="60" style="width:231px" />
			</td>
			<th>업종</th>
			<td class="left">
			<select id="rType" name="rType" style="width:150px">
			<option value="" >선택</option>
            <option value="양식" >양식</option>
            <option value="한식">한식</option>
            <option value="중식" >중식</option>
            <option value="일식">일식</option>
            <option value="기타">기타</option>  
            </select>
			</td>
		</tr>
		<tr>
			<th>추천메뉴</th>
			<td class="left">
				<input type="text" id="rMenu" name="rMenu" value="" maxlength="60" />
			</td>
			<th>가격</th>
			<td class="left">
				<input type="text" id="rPric" name="rPric" value="" maxlength="60" />
			</td>
		</tr>
		
		<tr>
			<th>추천메뉴2</th>
			<td class="left">
				<input type="text" id="rMenu2" name="rMenu2" value="" maxlength="60" />
			</td>
			<th>가격</th>
			<td class="left">
				<input type="text" id="rPric2" name="rPric2" value="" maxlength="60" />
			</td>
		</tr>
		
		<tr>
			<th>전화번호</th>
			<td class="left">
				<input type="text" id="rPhone" name="rPhone" value="" maxlength="60" >
			</td>
			<th>주소 </th>
			<td class="left">
				<input type="text" id="rAddr" name="rAddr" value="" maxlength="60" style="width:200px;" />
				<input type="text" id="rAddr2" name="rAddr2" value="" maxlength="60" style="width:200px;" />
			</td> 
		</tr>
		<tr>
			<th>방문날짜</th>
			<td class="left">
				<input type="date" id="rVisit" name="rVisit" value="2018-01-01" max ="2023-01-01" maxlength="60"/> 
			</td>
			<th>평점</th>
			<td class="left">
			<select id="rGrade" name="rGrade" style="width:150px">
			<option value="" >선택</option>
            <option value="5" >5점</option>
            <option value="4">4점</option>
            <option value="3" >3점</option>
            <option value="2">2점</option>
            <option value="1">1점</option>  
            </select>
			</td>
		</tr>
		
		<tr>
			<th>비고</th>
			<td class="left">
				<textarea  id="rNote" name="rNote" maxlength="90" style="width:300px; height:200px;"> </textarea>
			</td>
		</tr>
		<tr>
		<th>첨부파일 </th>
		<td class="left" colspan="1">
		<div class = "input-group mb-3">
		<div class = "w-100 mb-3"><input type="file" name = "files">
		</div>
		  </div>
		</tr>
	</table>
	
	<!-- 하단 버튼 -->
	<div class="btn">
		<input class="btn btn-primary" type="submit" value="확인" />
		<input id="btn_list" class="btn btn-warning" type="button" value="목록" />
	</div>
</div>

</form>
<script>
 document.getElementById('rVisit').value = new
 Date().toISOString().substring(0,10);
 
var msg = "${msg}";
if (msg === "success") {
	swal({
		  title: "Good job!",
		  text: "입력완료",
		  icon: "success",
		  button: "OK",
		});
	 
} else if (msg == "error") {
	swal({
		  title: "",
		  text: "입력실패",
		  icon: "error",
		  button: "OK",
		});
	 
}

$('#btn_list').click(function(e){
	location.href="/restaurant/list";
});
</script>

<%@ include file="../layout/footer.jsp"%>
