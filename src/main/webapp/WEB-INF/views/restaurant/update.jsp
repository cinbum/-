 <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
<form method="POST" enctype="multipart/form-data">

<input type="hidden" name="rNum" value="${data.r_num}">
	
	<h2>맛집수정</h2>
	
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
				<input type="text" id="rName" name="rName" maxlength="60" style="width:231px" value="${data.r_name}"/>
			</td>
			<th>업종</th>
			<td class="left">
			<select id="rType" name="rType" style="width:150px">
			<option value="">선택</option>
			<option value="양식"
			  <c:if test = "${data.r_type == '양식'}">selected</c:if>>양식</option>
            <option value="한식"
              <c:if test = "${data.r_type == '한식'}">selected</c:if>>한식</option>
            <option value="중식" 
              <c:if test = "${data.r_type == '중식'}">selected</c:if>>중식</option>
            <option value="일식"
               <c:if test = "${data.r_type == '일식'}">selected</c:if>>일식</option>
            <option value="기타" 
               <c:if test = "${data.r_type == '기타'}">selected</c:if>>기타</option>
            </select>
        
			</td>
		</tr> 
		<tr>	
			<th>추천메뉴</th>
			<td class="left">
				<input type="text" id="rMenu" name="rMenu" maxlength="60" value="${data.r_menu}"/>
			</td>
			<th>가격</th>
			<td class="left">
				<input type="text" id="rPric" name="rPric" maxlength="60" value="${data.r_pric}"/>
			</td>
		</tr>
		
		<tr>	
			<th>추천메뉴2</th>
			<td class="left">
				<input type="text" id="rMenu2" name="rMenu2" maxlength="60" value="${data.r_menu2}"/>
			</td>
			<th>가격</th>
			<td class="left">
				<input type="text" id="rPric2" name="rPric2" maxlength="60" value="${data.r_pric2}"/>
			</td>
		</tr>
		
		<tr>	
			<th>전화번호</th>
			<td class="left">
				<input type="text" id="rPhone" name="rPhone" maxlength="60" value="${data.r_phone}"/>
			</td>
			<th>주소</th>
			<td class="left">
				<input id="rAddr" type="text" name="rAddr" maxlength="60" value="${data.r_addr}" style="width:200px;">
				<input id="rAddr2" type="text" name="rAddr2" maxlength="60" value="${data.r_addr2}" style="width:200px;">
			</td>
		</tr>
		
		<tr>
			<tr>
			<th>방문날짜</th>
			<td class="left">
				<input type="date" id="rVisit" name="rVisit" value="${data.r_visit}" max ="2023-01-01" maxlength="60"/> 
			</td>
			<th>평점</th>
			<td class="left">
			  <select id="rGrade" name="rGrade" style="width:150px">
			<option value="">선택</option>
			<option value="5"
			  <c:if test = "${data.r_grade == '5'}">selected</c:if>>5점</option>
            <option value="4"
              <c:if test = "${data.r_grade == '4'}">selected</c:if>>4점</option>
            <option value="3" 
              <c:if test = "${data.r_grade == '3'}">selected</c:if>>3점</option>
            <option value="2"
               <c:if test = "${data.r_grade == '2'}">selected</c:if>>2점</option>
            <option value="1" 
               <c:if test = "${data.r_grade == '1'}">selected</c:if>>1점</option>
            </select>
			</td>
		</tr>
		<tr>
			<th>비고</th>
			<td class="left">
				<textarea id="rNote" name="rNote" 
				maxlength="90" style="width:300px;height:200px;">${data.r_note}</textarea>
			</td>
		</tr>
		
		<tr>
		<th>첨부파일 </th>
		<td class="left" colspan="1">
		<div class = "input-group mb-3">
		<div class = "w-100 mb-3">
		<input type="file" name = "files">
		</div>
		  </div>
		</tr>
	</table>
	
	<!-- 하단 버튼 -->
	<div class="btn">
		<input class="btn btn-primary" type="submit" value="확인" />
		<a href="/restaurant/list"><input class="btn btn-info" type="button" value="목록" /></a>
	</div>

</form>  	    
<%@ include file="../layout/footer.jsp"%>