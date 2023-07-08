<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>Spring Camp</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<link rel="stylesheet" href="/webjars/bootstrap/4.6.0/css/bootstrap.min.css">
	<script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
	<script src="/webjars/popper.js/2.5.4/umd/popper.min.js"></script>
	<script src="/webjars/bootstrap/4.6.0/js/bootstrap.bundle.min.js"></script>
	<script src="/webjars/sweetalert/2.1.2/dist/sweetalert.min.js"></script>	
	<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script>	
	<link rel="stylesheet" href="<c:url value="/resources/css/common.css" />">
</head>
<body>

<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap col-md-12 p-0 shadow">
	<a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="/main">Spring Camp</a>
	<button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse" data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
	  <span class="navbar-toggler-icon"></span>
	</button>
	<input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
	
	<c:if test="${not empty login}">
		<ul class="navbar-nav px-3">
		  <li class="nav-item text-white text-nowrap">${login.memberId}</li>
		</ul>
	</c:if> 
	<ul class="navbar-nav px-3">
	  <li class="nav-item text-nowrap">
	    <a class="nav-link" href="/logout">Sign out</a>
	  </li>
	</ul>
</nav>
<% 
	String nowPageURL = request.getRequestURI().toString();
%>
<div class="container-fluid">
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="sidebar-sticky pt-3">
      <%
      	// out.println(nowPageURL);
      %>

        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link <%=(nowPageURL.indexOf("WEB-INF/views/main") > 0)?"active":""%>" href="/main">
              <span data-feather="home"></span>
              Dashboard <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link <%=(nowPageURL.indexOf("WEB-INF/views/namecard") > 0)?"active":""%>" href="/namecard/list">
              <span data-feather="users"></span>
              명함리스트
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link <%=(nowPageURL.indexOf("WEB-INF/views/namecard") > 0)?"active":""%>" href="/namecard/create">
              <span data-feather="users"></span>
              명함등록
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link <%=(nowPageURL.indexOf("WEB-INF/views/restaurant") > 0)?"active":""%>" href="/restaurant/list">
              <span data-feather="gift"></span>
              맛집리스트
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link <%=(nowPageURL.indexOf("WEB-INF/views/restaurant") > 0)?"active":""%>" href="/restaurant/create">
              <span data-feather="gift"></span>
              맛집등록
            </a>
          </li>
          
           <li class="nav-item">
            <a class="nav-link <%=(nowPageURL.indexOf("WEB-INF/views/restaurant") > 0)?"active":""%>" href="/restaurant/newlist">
              <span data-feather="gift"></span>
              맛집 최신 목록
            </a>
          </li>
        </ul>
      </div>
    </nav>

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
    <div class="col-md-12 ml-sm-auto col-lg-12 px-md-12">

