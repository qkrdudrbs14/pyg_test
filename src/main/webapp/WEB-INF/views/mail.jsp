<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mail page</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="description" content="Solar Monitoring - DaeYeon C&amp;I">
	<meta name="author" content="The Develovers">
	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">

    <!-- CSS -->
    <link href="/resources/css/mail.css" rel="stylesheet" type="text/css">
    <link href="/resources/css/common.css" rel="stylesheet" type="text/css">

</head>
<body>
    <!-- header -->
    <jsp:include page="./include/header.jsp" flush="true">
        <jsp:param name="active" value="1"/>
    </jsp:include>
    <!--// header -->

    <div>
        <p>mail.jsp</p>
         <p>메일 보내기 테스트</p>
         <input type="button" value="mail send" id="mailSendBtn"/>
    </div>
    <div>

    </div>



	<script src="/resources/js/core.min.js"></script>
    <script src="/resources/js/jquery-3.6.0.js"></script>
    <script src="/resources/js/common.js"></script>
    <script src="/resources/js/mail.js"></script>
</body>
</html>