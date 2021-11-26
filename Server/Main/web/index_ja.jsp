<%--
  Created by IntelliJ IDEA.
  User: jidby
  Date: 2019-07-28
  Time: 오후 7:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>SickYourCoding</title>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.8/css/mdb.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="fullpage.css" />
    <link rel="stylesheet" type="text/css" href="examples.css" />

    <!--[if IE]>
    <script type="text/javascript">
        var console = { log: function() {} };
    </script>
    <![endif]-->

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript" src="fullpage.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Nanum+Gothic|Noto+Serif+KR&display=swap" rel="stylesheet">
    <script type="text/javascript">
        //using document ready...
        $(document).ready(function(){

            //initialising fullpage.js in the jQuery way
            $('#fullpage').fullpage({
                sectionsColor: ['#ffcdd2', '#fec401', '#2F9599', '#355C7D', '#FC913A'],
                navigation: true,
                slidesNavigation: true,
            });

            // calling fullpage.js methods using jQuery
            $('#moveSectionUp').click(function(e){
                e.preventDefault();
                $.fn.fullpage.moveSectionUp();
            });

            $('#moveSectionDown').click(function(e){
                e.preventDefault();
                $.fn.fullpage.moveSectionDown();
            });
        });
    </script>

    <style type="text/css">
        #actions{
            position:fixed;
            top: 73px;
            left: 30px;
            z-index: 99999;
        }
        #actions a{
            background: rgba(0,0,0,0.8);
            padding: 7px;
            margin: 2px;
            color: #ccc;
            display: inline-block;
        }
        #actions a:hover{
            color: #fff;
            background: #81A140;
        }
        .box{
            color: black;
            font-family: 'Nanum Gothic', sans-serif;
        }
        h1{
            font-family: 'Nanum Gothic', sans-serif;
            color: #3e2723;
            font-size: 50px;
            text-shadow: 1px 1px black;
        }
        h2{
            font-family: 'Nanum Gothic', sans-serif;
            color: whitesmoke;
            font-size: 50px;
            text-shadow: 1px 1px black;
        }
        h3{
            font-family: 'Nanum Gothic', sans-serif;
            color: #3e2723;
            font-size: 18px;
            margin-left: 20px;
        }
        h4{
            font-family: 'Nanum Gothic', sans-serif;
            color: whitesmoke;
            font-size: 18px;
            margin-left: 20px;
        }
        h5{
            font-family: 'Black Han Sans', sans-serif;
            color: whitesmoke;
            font-size: 50px;
        }
        #section3{
            background-image: url(imgs/bg4.jpg);
            background-repeat: no-repeat;
            background-position: center; ;
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
</head>
<body>

<div id="footer">싴유어콛잉 @ 소프트웨어 개발보안 시큐어코딩 해커톤
</div>
<div id="fullpage">
    <ul id="menu">
        <div align="center">
            <table style="overflow: hidden">
                <tr>
                    <td>
                        <a ><img src="SVG/cnn.png" width="69" height="69" style="cursor: pointer" onclick="window.location.href='index_cn.jsp';"></a>
                    </td>

                    <td style="width: 24px"></td>
                    <td>
                        <a ><img src="SVG/ru.png" width="72" height="72" style="cursor: pointer" onclick="window.location.href='index_ru.jsp';"></a>
                    </td>
                    <td style="width: 10px"></td>
                    <td>
                        <svg width="100" height="100"
                             xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                            <image xlink:href="SVG/ko.svg" height="100" width="100"style="cursor: pointer" onclick="window.location.href='index.jsp';"/>
                        </svg>
                    </td>
                    <td>
                        <svg width="100" height="100"
                             xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                            <image xlink:href="SVG/ja.svg" height="100" width="100"style="cursor: pointer" onclick="window.location.href='index_ja.jsp';"/>
                        </svg>
                    </td>
                    <td>
                        <svg width="100" height="100"
                             xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                            <image xlink:href="SVG/en.svg" height="100" width="100"style="cursor: pointer" onclick="window.location.href='index_en.jsp';"/>
                        </svg>
                    </td>
                    <td>
                        <svg width="100" height="100"
                             xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                            <image xlink:href="SVG/es.svg" height="100" width="100" style="cursor: pointer" onclick="window.location.href='index_es.jsp';"/>
                        </svg>
                    </td>

                    <td>
                        <svg width="100" height="100"
                             xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                            <image xlink:href="SVG/id.svg" height="100" width="100"style="cursor: pointer" onclick="window.location.href='index_id.jsp';"/>
                        </svg>
                    </td>

                    <td>
                        <svg width="100" height="100"
                             xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                            <image xlink:href="SVG/th.svg" height="100" width="100" style="cursor: pointer" onclick="window.location.href='index_th.jsp';"/>
                        </svg>
                    </td>
                    <td>
                        <svg width="100" height="100"
                             xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                            <image xlink:href="SVG/de.svg" height="100" width="100" style="cursor: pointer" onclick="window.location.href='index_de.jsp';"/>
                        </svg>
                    </td>
                    <td style="width: 10px"></td>
                    <td>
                        <a ><img src="SVG/it.png" width="72" height="72" onclick="window.location.href='index_it.jsp';"></a>
                    </td>
                    <td style="width: 20px"></td>
                    <td>
                        <a ><img src="SVG/fr.png" width="72" height="72" onclick="window.location.href='index_fr.jsp';" ></a>
                    </td>
                </tr>

                <tr>
                    <td>
                        <div class="box">&nbsp&nbsp&nbsp&nbsp汉语</div>
                    </td>
                    <td style="width: 8px"></td>

                    <td>
                        <div class="box">&nbsp&nbspРусский</div>
                    </td>

                    <td style="width: 10px"></td>
                    <td>
                        <div class="box">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp한국어</div>
                    </td>
                    <td>
                        <div class="box">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp日本語</div>
                    </td>
                    <td>
                        <div class="box">&nbsp&nbsp&nbsp&nbsp&nbsp&nbspEnglish</div>
                    </td>
                    <td>
                        <div class="box">&nbsp&nbsp&nbsp&nbsp&nbsp&nbspespañol</div>
                    </td>

                    <td>
                        <div class="box">&nbsp&nbsp&nbsp&nbsp&nbspIndonesia</div>
                    </td>

                    <td>
                        <div class="box">&nbsp&nbsp&nbsp&nbsp&nbspภาษาไทย</div>
                    </td>

                    <td>
                        <div class="box">&nbsp&nbsp&nbsp&nbsp&nbsp&nbspDeutsch</div>
                    </td>
                    <td style="width: 10px"></td>
                    <td>
                        <div class="box">&nbsp&nbspitaliano</div>
                    </td>
                    <td style="width: 20px"></td>
                    <td>
                        <div class="box">&nbsp&nbspfrançais</div>
                    </td>
                </tr>
            </table>
        </div>
    </ul>
    <div class="section">

        <div align="center" class="intro">

            <table style="margin-top: 100px">
                <tr>
                    <td>
                        <svg width="300" height="570"
                             xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                            <image xlink:href="SVG/s4.svg" width="100%" height="100%"/>
                        </svg>
                    </td>
                    <td style="width: 100px"></td>
                    <td>
                        <h1>海外観光客対象の位置に基づい<br>
                            観光情報ドスントゥサービス</h1>
                        <br>
                        <h3>*ドスントゥサービスとは？<br>ドスントゥは展覧会を解説してくれる人を意味します。<br>ドスントゥは観覧客に美術品を鑑賞することに先立ち展示作品の<br>詳細な説明を通じて観覧客の展示観覧の理解を助けます。 </h3>
                    </td>
                </tr>

            </table>
        </div>
    </div>
    <div class="section">
        <div align="center" class="intro">

            <table style="margin-top: 100px">
                <tr>
                    <td>
                        <svg width="300" height="570"
                             xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                            <image xlink:href="SVG/s4.svg" width="100%" height="100%"/>
                        </svg>
                    </td>
                    <td style="width: 100px"></td>
                    <td>
                        <h1>公共データAPIを利用して<br>
                            様々な観光情報を提供</h1>
                        <br>
                        <h3>韓国観光公社が提供するTour API3.0を使用して、<br>国内観光地や祭り、食品など様々な良質の観光情報を提供しています。 </h3>
                    </td>
                </tr>

            </table>
        </div>
    </div>
    <div class="section">
        <div align="center" class="intro">

            <table style="margin-top: 100px">
                <tr>
                    <td>
                        <svg width="300" height="570"
                             xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                            <image xlink:href="SVG/s4.svg" width="100%" height="100%"/>
                        </svg>
                    </td>
                    <td style="width: 100px"></td>
                    <td>
                        <h2>12個の様々な言語のサポートと<br>
                            Google TTS APIを活用した<br>ドスントゥサービス提供</h2>
                        <br>
                        <h4>12個の言語をサポートしていくつかの国の観光客が手軽に利用でき、<br>
                            Google Text-To-Speech APIを活用して、さまざまな言語の音声に変換して
                            <br>WaveNetの画期的な研究成果と <br>Googleの強力なニューラルネットワークを適用して、最高の音質を提供して、<br>
                            観光客に良質のドスントゥサービスを提供しています。</h4>
                    </td>
                </tr>

            </table>
        </div>
    </div>
    <div class="section">
        <div align="center" class="intro">

            <table style="margin-top: 100px">
                <tr>
                    <td>
                        <svg width="300" height="570"
                             xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                            <image xlink:href="SVG/s4.svg" width="100%" height="100%"/>
                        </svg>
                    </td>
                    <td style="width: 100px"></td>
                    <td>
                        <h2>さまざまな観光情報の<br>
                            ロケーションベースのナビゲーションサービス</h2>
                        <br>
                        <h4>Kakao APIを活用して、観光地、食べ物、祭りなど、様々な情報について<br>ユーザーの位置に基づいて、ルートサービスをサポートします。</h4>
                    </td>
                </tr>

            </table>
        </div>
    </div>
    <div class="section">
        <div align="center" class="intro">

            <table style="margin-top: 100px">
                <tr>
                    <td>
                        <svg width="300" height="570"
                             xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                            <image xlink:href="SVG/s4.svg" width="100%" height="100%"/>
                        </svg>
                    </td>
                    <td style="width: 100px"></td>
                    <td>
                        <h1>私がしたい観光情報の<br>
                            蒸し（お気に入り）サービス</h1>
                        <br>
                        <h3>蒸し（お気に入り）機能を提供して、ユーザーが行きたいところを<br>保存利便性を提供しています。</h3>
                    </td>
                </tr>

            </table>
        </div>
    </div>
    <div class="section" id="section3">
        <div class="mask flex-center rgba-black-strong">
            <h5>私たちは、韓国的な文化と祭りの世界にあなたを導くでしょう。<br>今ダウンロード。<br><br>
                <i class="fab fa-android fa-3x" onclick="alert('準備中です。')" style="cursor: pointer">&nbsp</i>
                <i class="fab fa-apple fa-3x" onclick="alert('準備中です。')" style="cursor: pointer">&nbsp</i>
                <i class="fab fa-windows fa-3x" onclick="alert('準備中です。')" style="cursor: pointer"></i>
            </h5>
            <br>


        </div>
    </div>
</div>


<script type="text/javascript" src="examples.js"></script>
</body>
</html>
