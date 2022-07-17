<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>sound page</title>
	<meta charset="utf-8">
</head>
    <!-- CSS -->
    <link href="/resources/css/mail.css" rel="stylesheet" type="text/css">
    <link href="/resources/css/common.css" rel="stylesheet" type="text/css">
<body>
    <!-- header -->
    <jsp:include page="./include/header.jsp" flush="true">
        <jsp:param name="active" value="1"/>
    </jsp:include>
    <!--// header -->

    <div>
        sound.jsp
        <br/>
        <input type="button" value="getSound" onclick="getSText()">
    </div>
    <div>

    </div>

    <script src="/resources/js/jquery-3.6.0.js"></script>
    <script src="/resources/js/sound.js"></script>
</body>
</html>