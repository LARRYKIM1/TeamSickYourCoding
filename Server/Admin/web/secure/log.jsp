<%--
  Created by IntelliJ IDEA.
  User: jidby
  Date: 2019-08-22
  Time: 오후 1:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.io.RandomAccessFile" %>
<%@ page import="service.loglist" %>
<%@ page import="java.util.List"%>
<%@ page import="java.io.FileNotFoundException" %>
<%@ page import="java.io.IOException" %>
<%@ page import="com.mysql.cj.jdbc.exceptions.NotUpdatable" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%

    String logPath = "/usr/local/tomcat9/logs/";
    String logSave = "";

    String getName = (String) session.getAttribute("filename");
    String fileName = logPath + getName;
    StringBuilder log = new StringBuilder();
    long startPoint = 0;
    long endPoint = 0;
    RandomAccessFile file = null;
    String str = "";
    int preEndPoint = 0;
    loglist ll = new loglist();
    List<String> filelist = ll.list();
    try {
        file = new RandomAccessFile(fileName, "r");
        endPoint = file.length();
        startPoint = preEndPoint > 0 ?
                preEndPoint : endPoint < 8000 ?
                0 : endPoint - 8000;
        file.seek(startPoint);

        while ((str = file.readLine()) != null) {
            String utf8 = new String(str.getBytes("ISO-8859-1"), "UTF-8");
            log.append(utf8);
            log.append("\n");
            endPoint = file.getFilePointer();
            file.seek(endPoint);
        }
    } catch (FileNotFoundException fnfe) {
        log.append("File does not exist.");
    } catch (IOException e) {
        log.append("Sorry. An error has occurred.");

    } finally {
        try {
            if(!(file==null)) file.close();
        } catch (NullPointerException e) {
            log.append("Sorry. An error has occurred.");
        } catch (IOException e){
            log.append("Sorry. An error has occurred.");
        }
    }
    logSave = log.toString();
%>
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
    <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet">

    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
        }
        body{
            font-family: 'Roboto Condensed', sans-serif;
        }
        #header {
            position: fixed;
            top: 80px;
            left: 150px;
            width: 100%;
            height: 15%;
        }
        #console {
            position: fixed;
            bottom: 0;
            width: 100%;
            height: 75%;
            background-color: black;
            color:white;
            font-size: 15px;
        }

    </style>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
    <a class="navbar-brand" href="main.jsp">Go To Main</a>
</nav>
<div id="header">
    <h1>Log By Date</h1>
    <form method="post" action="date.do">
        <table>
            <tr>
            <td><select id="fileName" name="file" class="browser-default custom-select custom-select-lg mb-3" style="margin-top: 10px">
                <%  for (String files : filelist) {  %>
                <option value="<%=files%>"><%=files%></option>
                <%  }   %>
            </select></td>
                <td>&nbsp</td>
                <td><button class="btn btn-info btn-block btn-elegant" type="submit" style="height:46px;width: 100px">GET</button></td>
            </tr>
        </table>
    </form>
    <br><br>
</div>
<textarea id="console">
    <%= logSave%>
</textarea>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/popper.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/mdb.min.js"></script>
</body>
</html>

