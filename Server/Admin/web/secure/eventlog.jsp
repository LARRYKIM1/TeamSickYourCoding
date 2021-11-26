<%@ page import="vo.AdminVO" %><%--
  Created by IntelliJ IDEA.
  User: jidby
  Date: 2019-08-22
  Time: 오후 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList"%>
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
<nav class="navbar navbar-dark bg-dark">
    <a class="navbar-brand" href="main.jsp">Go To Main</a>
</nav>
<div style="margin-left: 400px;margin-right: 400px;margin-top: 100px;">
    <h1>Server Event Logs</h1>
    <br>
    <%  ArrayList<AdminVO> list = (ArrayList<AdminVO>) session.getAttribute("vlist");
    if(!(list==null)){
        if(!list.isEmpty()) {  %>
            <table class="table">
                <thead class="black white-text">
                <tr>
                    <th scope="col">Event</th>
                    <th scope="col">Description</th>
                    <th scope="col">Time</th>
                </tr>
                </thead>
                <tbody>
                <%   for(int i=0; i<list.size(); i++){
                    AdminVO member = list.get(i);   %>

                <tr><th scope="row"><%=member.getType() %></th>
                    <td><%=member.getDes() %></td>
                    <td><%=member.getTime() %></td>
                </tr>
                </tbody>
        <%   }
        }else{
            out.print("<h3>로그가 없습니다.</h3>");
        }
        }
    else{
         out.print("<h3>오류가 발생했습니다.</h3>");
     }
        %>
    </table>
</div>
<div id="footer">싴유어콛잉 @ 소프트웨어 개발보안 시큐어코딩 해커톤
</div>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/popper.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/mdb.min.js"></script>
</body>

</html>
