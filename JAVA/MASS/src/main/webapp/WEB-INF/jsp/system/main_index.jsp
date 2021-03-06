<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <title>MASS project | Home</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta http-equiv="Content-Script-Type" content="text/javascript">
        <meta http-equiv="Content-Style-Type" content="text/css">        
        <meta name="viewport" content="user-scalable=no, initial-scale=1.0">
        <meta name="title" content="프로젝트 MASS">
        <meta name="description" content="의료사고 및 분쟁실태를 조사해 분석한 결과를 정리한 사이트입니다.">
        <meta property="og:url" content="https://prjmass.org">
        <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon">
        <link rel="icon" href="/img/favicon.ico" type="image/x-icon">

        <link href="/css/layout_main.css" rel="stylesheet">
        <link href="/css/stntax.css" rel="stylesheet">
    </head>

    <body>
        <div id="header">
            <a href="/mass"><img src="/img/banner.png" alt="banner", width="300" style="margin-top=20px;"></a>
            <nav id="topMenu">
                <ul>
                    <li><a class="menuLink" href="/mass">Home</a></li>
                    <li><a class="menuLink" href="/mass/aboutus">About us</a></li>
                    <li><a class="menuLink" href="/mass/sub">Analysis information</a></li>
                    <li><a class="menuLink" href="/mass/sub2">Release</a></li>
                    <li><a class="menuLink" href="https://blog.naver.com/koy321" target="_blank">Blog</a></li>
                </ul>
            </nav>
        </div>

        <div id="wrap">
            <div id="container" class="main-content">
                <div id="img-slide" class="slide">
                    <div class="slideshow-container">
                        <div class="mySlides fade">
                            <img src="/img/main/img_scroll1.png" alt="img1", width="100%">
                            <div class="text">
                                <h2>Project Mass에 오신걸 환영합니다</h2>
                                <a>의료사고 사례로 나온 데이터를 분석하여 대한민국 의료산업의 실태를 알리고자 개설된 사이트입니다.</a>
                            </div>
                        </div>
                        <div class="mySlides fade">
                            <img src="/img/main/img_scroll2.png" alt="img2", width="100%">
                            <div class="text">
                                <h2>사이트를 개설한 이유</h2>
                                <a>심심치 않게 발생하는 의료사고로 인해 사람들이 의료산업에 대한 불신이 커지고 있습니다.</a><br>
                                <a>공개된 사례들과 한국의 의료서비스가 어떤 상황인지 알리고 경각심을 가지게 하고 싶었습니다.</a>
                            </div>
                        </div>
                        <div class="mySlides fade">
                            <img src="/img/main/img_scroll3.png" alt="img3", width="100%">
                            <div class="text">
                                <h2>제공되는 서비스</h2>
                                <a>연도별 데이터 다운로드 링크 제공, 정보 분석 및 분석 결과 도출을 제공합니다.</a>
                            </div>
                        </div>
                        <div class="mySlides fade">
                            <img src="/img/main/img_scroll4.png" alt="img4", width="100%">
                            <div class="text">
                                <h2>발전 방향과 프로젝트 비전</h2>
                                <a>연도별로 제공되는 데이터들이 갱신될 때 마다 업데이트하겠습니다.</a><br>
                                <a>추가로 제공되는 정보들을 발빠르게 찾아내어 연구하겠습니다.</a>
                            </div>
                        </div>
                        <div class="mySlides fade">
                            <img src="/img/main/img_scroll5.png" alt="img5", width="100%">
                            <div class="text">
                                <h2>프로젝트 참여자 모집</h2>
                                <a>Project Mass는 능력있는 개발자 여러분들을 기다립니다.</a>
                            </div>
                        </div>
                    </div>
                    <br>
                    <div style="text-align:center">
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                        <span class="dot"></span>
                    </div>
                    <br>
                </div>
                <hr>
                <div id="main-content-bottom">
                    <div id="main-content-obj-prop">
                        <img src="/img/main_prop.png" width="95%">
                    </div>
                    <div id="main-content-obj-list">
                        <h2>홍보 영상</h2>
                        <iframe width="560" height="315" src="https://www.youtube.com/embed/k7BP1m9NRC4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                    </div>
                    <hr>
                    <div id="main-content-obj-list">
                        <h2>최근 릴리즈 데이터</h2>
                        <ol>    
                            <li style="padding-left: 10px; background: url('/ilos/images/main/ul_dot.png') no-repeat 0 49%;" wfd-id="106">
                                <em style="font-weight: normal;">
                                    <a class="site-link" href="sub_release.html">
                                        e-강의동 - 전자출결시스템 간 출석 연계 안내(출결기록 확인)
                                    </a>
                                </em>
                                <span class="date" wfd-id="107">2021.05.22</span>
                            </li>
                        </ol>
                    </div>
                    <hr>
                    <div id="main-content-obj-list">
                        <h2>Special Thanks</h2>
                        <ul>
                            <li>선문대학교 컴퓨터공학부 김정동 교수님</li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>

        <div id="footer">
            <h3>project MASS</h3>
            <div id="footer-wrapper">
                <div id="footer-info-icons" style="float: left; width: 35px;">
                    <span>
                        <svg version="1.1" fill="#000000" height="24" id="svg_icons_footer" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 20 20" enable-background="new 0 0 20 20" xml:space="preserve">
                            <path d="M10.015,9.949c0,0-0.01,0-0.015,0H9.985c-1.191,0-2.24-0.303-2.861,0.268c-0.371,0.342-0.527,0.754-0.527,1.197
                            c0,1.852,1.483,2.08,3.389,2.08h0.029c1.905,0,3.389-0.229,3.389-2.08c0-0.443-0.156-0.856-0.527-1.197
                            C12.255,9.646,11.206,9.949,10.015,9.949z M8.393,12.48c-0.363,0-0.656-0.408-0.656-0.91c0-0.502,0.293-0.908,0.656-0.908
                            c0.363,0,0.657,0.406,0.657,0.908C9.051,12.072,8.757,12.48,8.393,12.48z M11.606,12.48c-0.363,0-0.657-0.408-0.657-0.91
                            c0-0.502,0.294-0.908,0.657-0.908c0.362,0,0.656,0.406,0.656,0.908C12.263,12.072,11.969,12.48,11.606,12.48z M10,0.4
                            c-5.302,0-9.6,4.298-9.6,9.6s4.298,9.6,9.6,9.6s9.6-4.298,9.6-9.6S15.302,0.4,10,0.4z M10.876,13.939c-0.172,0-0.514,0-0.876,0.002
                            c-0.362-0.002-0.704-0.002-0.876-0.002c-0.76,0-3.772-0.059-3.772-3.689c0-0.834,0.286-1.445,0.755-1.955
                            c-0.074-0.184-0.078-1.232,0.32-2.236c0,0,0.916,0.1,2.301,1.051C9.017,7.029,9.509,6.988,10,6.988s0.982,0.041,1.273,0.121
                            c1.385-0.951,2.301-1.051,2.301-1.051c0.398,1.004,0.395,2.053,0.32,2.236c0.469,0.51,0.755,1.121,0.755,1.955
                            C14.648,13.881,11.636,13.939,10.876,13.939z"/>
                        </svg>
                    </span><br>
                    <span>
                        <svg version="1.1" fill="#000000" height="24" id="Email" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 20 20" style="enable-background:new 0 0 20 20;" xml:space="preserve">
                            <path d="M14.608,12.172c0,0.84,0.239,1.175,0.864,1.175c1.393,0,2.28-1.775,2.28-4.727c0-4.512-3.288-6.672-7.393-6.672
                            c-4.223,0-8.064,2.832-8.064,8.184c0,5.112,3.36,7.896,8.52,7.896c1.752,0,2.928-0.192,4.727-0.792l0.386,1.607
                            c-1.776,0.577-3.674,0.744-5.137,0.744c-6.768,0-10.393-3.72-10.393-9.456c0-5.784,4.201-9.72,9.985-9.72
                            c6.024,0,9.215,3.6,9.215,8.016c0,3.744-1.175,6.6-4.871,6.6c-1.681,0-2.784-0.672-2.928-2.161
                            c-0.432,1.656-1.584,2.161-3.145,2.161c-2.088,0-3.84-1.609-3.84-4.848c0-3.264,1.537-5.28,4.297-5.28
                            c1.464,0,2.376,0.576,2.782,1.488l0.697-1.272h2.016v7.057H14.608z M11.657,9.004c0-1.319-0.985-1.872-1.801-1.872
                            c-0.888,0-1.871,0.719-1.871,2.832c0,1.68,0.744,2.616,1.871,2.616c0.792,0,1.801-0.504,1.801-1.896V9.004z"/>
                        </svg>
                    </span><br>
                    <span>
                        <svg version="1.1" fill="#000000" height="24" id="Phone" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 20 20" style="enable-background:new 0 0 20 20;" xml:space="preserve">
                            <path d="M11.229,11.229c-1.583,1.582-3.417,3.096-4.142,2.371c-1.037-1.037-1.677-1.941-3.965-0.102
                            c-2.287,1.838-0.53,3.064,0.475,4.068c1.16,1.16,5.484,0.062,9.758-4.211c4.273-4.274,5.368-8.598,4.207-9.758
                            c-1.005-1.006-2.225-2.762-4.063-0.475c-1.839,2.287-0.936,2.927,0.103,3.965C14.324,7.812,12.811,9.646,11.229,11.229z"/>
                        </svg>
                    </span>
                </div>
                <div id="footer-info-text" style="float: center; width: 45%;">
                    <p>GitHub&nbsp; | https://github.com/code243031/MASS</p>
                    <p>Email&nbsp;&nbsp;&nbsp;&nbsp;| koy321@naver.com</p>
                    <p>Phone&nbsp;&nbsp;&nbsp;| 010-8878-4770</p>
                </div>
            </div>
        </div>
        <script src="../js/img_slide.js"></script>
    </body>
</html>