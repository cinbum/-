<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../layout/header.jsp"%>

<form method="POST">
<input type="hidden" name="ncrdId" value="${data.ncrdId} }">
	
	<h2>명함수정</h2>
	
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
				<input type="text" id="ncrdNm" name="ncrdNm" maxlength="60" style="width:231px" value="${data.nm}"/>
			</td>
		</tr>
		<tr>
			<th>회사명 </th>
			<td class="left">
				<input type="text" id="cmpnyNm" name="cmpnyNm" maxlength="60" value="${data.cmpny_nm}"/>
			</td>
			<th>부서명 </th>
			<td class="left">
				<input type="text" id="deptNm" name="deptNm" maxlength="60" value="${data.dept_nm}"/>
			</td>
		</tr>
		<tr>
			<th>직위 </th>
			<td class="left">
				<input type="text" id="ofcpsNm" name="ofcpsNm" maxlength="60" value="${data.ofcps_nm}"/>
			</td>
			<th>직급</th>
			<td class="left">
				<input type="text" id="clsfNm" name="clsfNm" maxlength="60" value="${data.clsf_nm}"/>
			</td>
		</tr>
		<tr>
			<th>이메일주소</th>
			<td class="left" colspan="3">
				<input id="emailAdres" type="text" name="emailAdres" maxlength="60" value="${data.email_adres}">
			</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td class="left" colspan="3">
				<input type="text" id="nationNo" name="nationNo" maxlength="7" style="width:50px" value="${data.nation_no}"/> -
				<input type="text" id="areaNo" name="areaNo" maxlength="4" style="width:50px"  value="${data.area_no}"/> -
				<input type="text" id="middleTelNo" name="middleTelNo" maxlength="4" style="width:50px"  value="${data.middle_telno}"/> -
				<input type="text" id="endTelNo" name="endTelNo" maxlength="4" style="width:50px"  value="${data.end_telno}"/>
			</td>
		</tr>
		<tr>
			<th>휴대폰 </th>
			<td class="left" colspan="3">
				<select id="mbtlNum" class="select" name="idntfcNo">
					<option value="010" ${data.idntfc_no == "010" ? "selected" : ""} >010</option>
					<option value="011" ${data.idntfc_no == "011" ? "selected" : ""} >011</option>
					<option value="016" ${data.idntfc_no == "016" ? "selected" : ""}>016</option>
					<option value="017" ${data.idntfc_no == "017" ? "selected" : ""}>017</option>
					<option value="018" ${data.idntfc_no == "018" ? "selected" : ""}>018</option>
					<option value="019" ${data.idntfc_no == "019" ? "selected" : ""}>019</option>
				</select>  	   	    
				<input type="text" id="middleMbtlNum" name="middleMbtlNum" maxlength="5" style="width:50px" value="${data.middle_mbtlnum}"/> -
				<input type="text" id="endMbtlNum" name="endMbtlNum" maxlength="5" style="width:50px" value="${data.end_mbtlnum}"/>
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td class="left" colspan="3"> 
				<input type="text" id="adres" name="adres" style="width:250px; margin-bottom:2px" value="${data.adres}"/>
				<input type="text" name="detailAdres" maxlength="150" value="${data.detail_adres}" />
			</td>
		</tr>
		<tr>
			<th>외부사용자여부 </th>
			<td class="left">
				외부사용자 : <input type="radio" name="extrlUserAt" class="radio2" value="Y"  ${data.extrl_user_at == "Y" ? "checked" : ""} >&nbsp;
	     		내부사용자 : <input type="radio" name="extrlUserAt" class="radio2" value="N"  ${data.extrl_user_at == "N" ? "checked" : ""} >
			</td>
			<th>공개여부</th>
			<td class="left">
				공개 : <input type="radio" name="othbcAt" class="radio2" value="Y" ${data.othbc_at == "Y"  ? "checked" : ""}>&nbsp;
		     	비공개 : <input type="radio" name="othbcAt" class="radio2" value="N" ${data.othbc_at == "N" ? "checked" : ""}><br />
		     	
			</td>
		</tr>
		<tr>
			<th>비고</th>
			<td class="left" colspan="3">
				 <input type="text" id="remark" name="remark" maxlength="90" value="${data.rm}" />
			</td>
		</tr>
	</table>
	
	<!-- 하단 버튼 -->
	<div class="btn">
		<input class="btn btn-primary" type="submit" value="확인" />
		<a href="/namecard/list"><input class="btn btn-info" type="button" value="목록" /></a>
	</div>

</form>  
  
			    
<%@ include file="../layout/footer.jsp"%>