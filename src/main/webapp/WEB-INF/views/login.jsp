<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>login page</title>
	<meta charset="utf-8">
</head>
<body>
	 <form method="post" id="frm" name="frm" class="form-horizontal">
                    <dl>
                        <dt>사용자 계정</dt>
                        <dd>
                            <ul>
                                <li>
                                    <label for="username" class="sr-only">Username</label>
                                    <input type="text" id="username" name="username" placeholder="username" />
                                    <span class="bg_i"><i class="fa fa-user fa-05x fa-lg"></i></span>
                                </li>
                                <li>
                                    <label for="password" class="sr-only">password</label>
                                    <input type="password" id="password" name="password" placeholder="password" />
                                    <span class="bg_i"><i class="fa fa-lock fa-05x fa-lg"></i></span>
                                </li>
                            </ul>
                        </dd>
                    </dl>
                    <div class="error_m"></div>
              		<input type="hidden"  name="${_csrf.parameterName}"  value="${_csrf.token}" />
                    <button type="button" class="btn_login" id="btnLogin" onclick="validation_activity();"><span>Login</span></button>
                </form>

    <script src="/resources/js/core.min.js"></script>
    <script src="/resources/js/sha256.min.js"></script>
    <script src="/resources/js/jquery-3.6.0.js"></script>
    <script src="/resources/js/login.js"></script>
</body>
</html>