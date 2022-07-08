<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>main page</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="description" content="Solar Monitoring - DaeYeon C&amp;I">
	<meta name="author" content="The Develovers">
	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">

	<!-- CSS -->
    <link href="/resources/css/cd.css" rel="stylesheet" type="text/css">
    <link href="/resources/css/common.css" rel="stylesheet" type="text/css">
    <link href="/resources/css/daterangepicker.css" rel="stylesheet" type="text/css">

</head>
<body>
    <!-- header -->
    <jsp:include page="./include/header.jsp" flush="true">
        <jsp:param name="active" value="2"/>
    </jsp:include>
    <!--// header -->

    <div>
        <p>cd.jsp</p>
        <p>달력 테스트</p>

        <input type="text" name="daterange" value="01/01/2018 - 01/15/2018" />

        <div id="reportrange" style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc; width: 100%">
            <i class="fa fa-calendar"></i>&nbsp;
            <span></span> <i class="fa fa-caret-down"></i>
        </div>

    </div>


	<script src="/resources/js/core.min.js"></script>
    <script src="/resources/js/sha256.min.js"></script>
    <script src="/resources/js/jquery-3.6.0.js"></script>
    <script src="/resources/js/moment.min.js"></script>
    <script src="/resources/js/daterangepicker.min.js"></script>
    <script src="/resources/js/common.js"></script>
    <script src="/resources/js/cd.js"></script>

</body>
</html>