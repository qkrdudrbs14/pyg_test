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

	<meta name="_csrf" content="${_csrf.token}" />
    <meta name="_csrf_header" content="${_csrf.headerName}" />

    <!-- CSS -->
    <link href="/resources/css/main.css" rel="stylesheet" type="text/css">
    <link href="/resources/css/common.css" rel="stylesheet" type="text/css">

</head>
<body>
    <!-- header -->
    <jsp:include page="./include/header.jsp" flush="true">
        <jsp:param name="active" value="1"/>
    </jsp:include>
    <!--// header -->

    <div>
        <p>main.jsp</p>
         <p>이미지 업로드 테스트</p>
    </div>
    <div>
        <form id="uploadForm" enctype="multipart/form-data">
            <input type="file" id="fileInput" />
        </form>
        <input type="button" value="file upload" id="fileuploadBtn"/>
    </div>



	<script src="/resources/js/core.min.js"></script>
    <script src="/resources/js/sha256.min.js"></script>
    <script src="/resources/js/jquery-3.6.0.js"></script>
    <script src="/resources/js/common.js"></script>
    <script src="/resources/js/main.js"></script>

    <script type="text/javascript">
        const token = $("meta[name='_csrf']").attr("content");
        const header = $("meta[name='_csrf_header']").attr("content");
    </script>
</body>
</html>