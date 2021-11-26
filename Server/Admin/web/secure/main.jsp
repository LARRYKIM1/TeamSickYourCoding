<%--
  Created by IntelliJ IDEA.
  User: jidby
  Date: 2019-08-23
  Time: 오전 12:15
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
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/mdb.min.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Noto+Serif+KR|Ubuntu&display=swap" rel="stylesheet">
</head>
<style>

    body{
        background-color: aliceblue;
        font-family: 'Ubuntu', sans-serif;
    }
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

<main class="pt-4">
    <div class="container">
        <h1 class="font-weight-bold mt-4 mb-8 text-center" style="font-size: 80px">SickYourCoding Admin Page</h1>
        <br><br>
        <section class="text-center">
            <div class="row wow fadeIn">
                <div class="col-lg-4 col-md-12 mb-4">
                    <div class="view overlay rounded z-depth-2 mb-4 flex-center" onclick="location.href='log.jsp'" style="cursor: pointer;height: 330px;background-color: #2A363B">
                        <i class="fas fa-trademark fa-10x amber-text"></i>
                    </div>
                    <h4 class="mb-3 font-weight-bold dark-grey-text">
                        <strong>Tomcat Logs</strong>
                    </h4>
                    <br><br>
                </div>

                <div class="col-lg-4 col-md-12 mb-4">
                    <div class="view overlay rounded z-depth-2 mb-4 flex-center" onclick="location.href='event.do'" style="cursor: pointer;height: 330px;background-color: #2A363B">
                        <i class="fas fa-info-circle fa-10x amber-text"></i>
                    </div>
                    <h4 class="mb-3 font-weight-bold dark-grey-text">
                        <strong>Server Event Logs</strong>
                    </h4>
                    <br><br>
                </div>

                <div class="col-lg-4 col-md-12 mb-4 amber-text">
                    <div class="view overlay rounded z-depth-2 mb-4 flex-center" onclick="location.href='error.do'" style="cursor: pointer;height: 330px;background-color: #2A363B">
                        <i class="fas fa-exclamation-triangle fa-10x"></i>
                    </div>
                    <h4 class="mb-3 font-weight-bold dark-grey-text">
                        <strong>Server Error Logs</strong>
                    </h4>
                    <br><br>
                </div>

            </div><br><br><br><br><br>
        </section>
    </div>
</main>
<div id="footer">싴유어콛잉 @ 소프트웨어 개발보안 시큐어코딩 해커톤
</div>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/popper.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/mdb.min.js"></script>
</body>

</html>
