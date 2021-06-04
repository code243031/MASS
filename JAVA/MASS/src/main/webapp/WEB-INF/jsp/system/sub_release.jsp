<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="org.json.*"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <title>MASS project | Release</title>           
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta http-equiv="Content-Script-Type" content="text/javascript">
        <meta http-equiv="Content-Style-Type" content="text/css">        
        <meta name="viewport" content="user-scalable=no, initial-scale=1.0">
        <meta name="title" content="프로젝트 MASS | 분석자료 모음">
        <meta name="description" content="의료사고 및 분쟁실태를 조사해 분석한 결과를 정리한 사이트입니다.">
        <meta property="og:url" content="https://prjmass.org">
        <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon">
        <link rel="icon" href="/img/favicon.ico" type="image/x-icon">

        <link href="/css/layout_sub_release.css" rel="stylesheet">
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

        <div id="content-wrap" wfd-id="0">
            <h2>릴리즈 정보</h2>
            <div id="main-content" wfd-id="299">
                <div class="release-note-notice">
                    <div class="release-note-x">
                        <ul>
                            <li>
                                <a href="#release1">Version 20210528.1_a</a>
                            </li>
                        </ul>
                        <div class="release-note-x-in">

                        </div>
                    </div>
                    <div class="release-note-information-x">
                        <div class="release-note-info-x-in">
                            <a name="#release1"><p style="font-size:3px;">(업로드일 2021.05.28)</p></a>
                            <h1 id="-version-20210528-1_a">● Version 20210528.1_a</h1>
                            <p>초반기에 제작된 알고리즘을 이용해 공공데이터를 기반으로 추출한 분석자료에 대한 데이터</p>
                            <h2 id="-">상세정보</h2>
                            <ul>
                            <li>지원자료:<ol>
                            <li>공공데이터 사이트 CSV</li>
                            <li>분석결과를 정리한 JSON파일</li>
                            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
                        <%String HArrayString = (String)request.getAttribute("HArray");
                        JSONArray HArray = new JSONArray(HArrayString);%>
	<table class="table table-striped">
		<tr  class="bg-info">
		    <th>장소</th>
		    <th>건수</th>
		    <th>건수</th>
		    
		</tr>
		<tbody id="HArrayTable">
		
		<%for (int i =0; i<HArray.length(); i++){
		JSONObject data = HArray.getJSONObject(i);
		   { %>
			<tr>
		    <th><%=data.getString("location")%></th>
		    <th><%=data.getString("count")%></th>
		    <th><%=data.getString("count")%></th>
			</tr>   
		<% }%>
		<%}%>
		</tbody>
	</table>
	
<%String SArrayString = (String)request.getAttribute("SArray");
JSONArray SArray = new JSONArray(SArrayString);%>
	<table class="table table-striped">
		<tr  class="bg-info">
		    <th>규모</th>
		    <th>건수</th>
		    
		</tr>
		<tbody id="SArrayTable">
		
		<%for (int i =0; i<SArray.length(); i++){
		JSONObject data = SArray.getJSONObject(i);
		   { %>
			<tr>
		    <th><%=data.getString("range")%></th>
		    <th><%=data.getString("count")%></th>
			</tr>   
		<% }%>
		<%}%>
		</tbody>
	</table>
                            </ol>
                            </li>
                            </ul>

                        </div>
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
                <div id="footer-info-text"style="float: center; width: 45%;">
                    <p>GitHub&nbsp; | https://github.com/code243031/MASS</p>
                    <p>Email&nbsp;&nbsp;&nbsp;&nbsp;| koy321@naver.com</p>
                    <p>Phone&nbsp;&nbsp;&nbsp;| 010-8878-4770</p>
                </div>
            </div>
    </body>
</html>