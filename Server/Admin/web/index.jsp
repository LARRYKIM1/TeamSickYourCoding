<%--
  Created by IntelliJ IDEA.
  User: jidby
  Date: 2019-08-21
  Time: 오후 6:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>SickYourCoding</title>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/mdb.min.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Noto+Serif+KR&display=swap" rel="stylesheet">
</head>
<style>
  #footer{
    font-family: 'Noto Serif KR', serif;
    position:fixed;
    height: 70px;
    display:block;
    width: 100%;
    background: #e90052;
    z-index:9;
    text-align:center;
    color: whitesmoke;
    padding: 18px 0 0 0;
    font-size: 18px;
  }
  #footer{
    bottom: 0;
  }
</style>
<body>

<div style="margin-left: 400px;margin-right: 400px;margin-top: 100px;">
  <form class="text-center border border-light p-5" action="login.do" method="post">
    <p class="h4 mb-4">SickYourCoding Admin Page</p>
    <p>Are you admin?</p>
    <p>
      <a href="http://52.231.70.45:8080" target="_blank">Go To Homepage</a>
    </p>
    <input type="email" name="email" class="form-control mb-4" placeholder="EMAIL">
    <input type="password" name="hi" class="form-control mb-4" placeholder="PASSWORD">
    <button class="btn btn-info btn-block btn-elegant" type="submit">LOGIN</button>
  </form>
</div>
<div id="footer">싴유어콛잉 @ 소프트웨어 개발보안 시큐어코딩 해커톤
</div>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/popper.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/mdb.min.js"></script>
</body>

</html>
