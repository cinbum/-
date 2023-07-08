<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../layout/header.jsp"%>
 

 <form method="POST" >

<div class="wTableFrm">
	<!-- 타이틀 -->
	<h2>명함등록</h2><!-- 명함 등록 -->
	
	<table class="table table-dark">
		<colgroup>
			<col style="width:16%" />
			<col style="width:34%" />
			<col style="width:16%" />
			<col style="" />
		</colgroup>
		<tr>
			<th>이름</th>
			<td class="left" colspan="3">
				<input type="text" id="ncrdNm" name="ncrdNm" maxlength="60" style="width:231px" />
			</td>
		</tr>
		<tr>
			<th>회사명 </th>
			<td class="left">
				<input type="text" id="cmpnyNm" name="cmpnyNm" value="" maxlength="60" />
			</td>
			<th>부서명 </th>
			<td class="left">
				<input type="text" id="deptNm" name="deptNm" value="" maxlength="60" />
			</td> 
		</tr>
		<tr>
			<th>직위 </th>
			<td class="left">
				<input type="text" id="ofcpsNm" name="ofcpsNm" value="" maxlength="60" />
			</td>
			<th>직급</th>
			<td class="left">
				<input type="text" id="clsfNm" name="clsfNm" value="" maxlength="60" />
			</td>
		</tr>
		<tr>
			<th>이메일주소</th>
			<td class="left" colspan="3">
				<input type="text" id="emailAdres" name="emailAdres" value="" maxlength="60" >
			</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td class="left" colspan="3">
				<input type="text" id="nationNo" name="nationNo" value="" maxlength="7" style="width:50px" /> -
				<input type="text" id="areaNo" name="areaNo" value="" maxlength="4" style="width:50px" /> -
				<input type="text" id="middleTelNo" name="middleTelNo" value="" maxlength="4" style="width:50px" /> -
				<input type="text" id="endTelNo" name="endTelNo" value="" maxlength="4" style="width:50px" />
			</td>
		</tr>
		<tr>
			<th>휴대폰 </th>
			<td class="left" colspan="3">
				<select id="mbtlNum" class="select" name="idntfcNo">
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="016">016</option>
					<option value="017">017</option>
					<option value="018">018</option>
					<option value="019">019</option>
				</select>  	   	    
				<input type="text"  id="middleMbtlNum" name="middleMbtlNum" value="" maxlength="5" style="width:50px" /> -
				<input type="text" id="endMbtlNum" name="endMbtlNum"  value="" maxlength="5" style="width:50px" />
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td class="left" colspan="3">
				<input type="hidden" name="zipCode" value="" />
				<input type="hidden" name="v_zipCode" value="" />
				
				<input type="text" id="adres" name="adres" style="width:250px; margin-bottom:2px" />
				<input type="text" name="detailAdres" value="" maxlength="80" />
			</td>
		</tr>
		<tr>
			<th>외부사용자여부 </th>
			<td class="left">
				외부사용자 : <input type="radio" name="extrlUserAt" class="radio2" value="Y">&nbsp;
	     		내부사용자 : <input type="radio" name="extrlUserAt" class="radio2" value="N">
			</td>
			<th>공개여부</th>
			<td class="left">
				공개 : <input type="radio" name="othbcAt" class="radio2" value="Y">&nbsp;
		     	비공개 : <input type="radio" name="othbcAt" class="radio2" value="N"><br />
			</td>
		</tr>
		<tr>
			<th>비고</th>
			<td class="left" colspan="3">
				 <input id="remark" type="text" name="remark" value="" maxlength="90" />
			</td>
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
	location.href="/namecard/list";
});
</script>

<%@ include file="../layout/footer.jsp"%>
