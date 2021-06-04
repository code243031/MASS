<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="org.json.*"%>

<!DOCTYPE html>
<html lang="ko">
    <head>
        <title>MASS project | 상세정보</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta http-equiv="Content-Script-Type" content="text/javascript">
        <meta http-equiv="Content-Style-Type" content="text/css">        
        <meta name="viewport" content="user-scalable=no, initial-scale=1.0">
        <meta name="title" content="프로젝트 MASS | 상세정보">
        <meta name="description" content="의료사고 및 분쟁실태를 조사해 분석한 결과를 정리한 사이트입니다.">
        <meta property="og:url" content="https://prjmass.org">
        <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon">
        <link rel="icon" href="/img/favicon.ico" type="image/x-icon">
        
        <link href="/css/layout_sub_page.css" rel="stylesheet">
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
            <h1 style="margin: 25px;">상세 분석정보 조회</h1>
            <div id="sidebar" wfd-id="298">
                <h3>조회정보 입력</h3>
                <label for="customize.sort" class="form-text">정렬기준</label>
                <select class="form-control" id="customize.sort" name="customize.sort">
                    <option value="select" selected="">(선택)</option>
                    <option value="dangerous">위험도 기준</option>
                    <option value="Number-of-beds">병상규모 기준</option>
                    <option value="Intentionality">고의성 기준</option>
                    <option value="occurrence-frequency">발생빈도 기준</option>
                </select>
                <br>
                <hr>
                <i>검색 조건 설명</i>
                <ul>
                    <li>
                        위험도
                        <p> - 의료사고로 발생한 사고의 위험정도를 나타냅니다.</p>
                    </li>

                    <li>
                        병상규모
                        <p> - 병원이 가지는 환자수용능력을 나타냅니다.</p>
                    </li>
                    <li>
                        고의성
                        <p> - 버러지</p>
                    </li>
                    <li>
                        발생빈도
                        <p> - 한 병원 내에서 발생한 의료사고의 빈도를 나타냅니다.</p>
                    </li>
                <ul>
            </div>
            <div id="wrapper" wfd-id="299">
                <div id="nav" wfd-id="299">
                    <label for="calender">작성 날짜:&nbsp;</label>
                    <input id="calender" type="date" name="day-update-length-start"></input>
                    <label for="calender">&nbsp;~&nbsp;</label>
                    <input id="calender2" type="date" name="day-update-length-end"></input>
                    <label for="department">진료과명:&nbsp;</label>
                    <select class="form-control" id="department"name="department-name">
                        <option value="select-all" selected="">모두</option>
                        <option value="select1">산부인과</option>
                        <option value="select2">피부과</option>
                        <option value="select3">안과</option>
                        <option value="select4">이비인후과</option>
                        <option value="select5">정신과</option>
                        <option value="select6">마취통증의학과</option>
                        <option value="select7">가정의학과</option>
                        <option value="select8">응급의학과</option>
                        <option value="select9">재활의학과</option>
                        <option value="select10">영상의학과</option>
                        <option value="select11">방사선종양학과</option>
                        <option value="select12">핵의학과</option>
                        <option value="select13">진단검사의학과</option>
                        <option value="select14">병리과</option>
                        <option value="select15">의공학과</option>
                        <option value="select16">한방과</option>
                        <option value="select17">대장항문</option>
                        <option value="select18">성형외과</option>
                        <option value="select19">신경외과</option>
                        <option value="select20">외과</option>
                        <option value="select21">정형외과</option>
                        <option value="select22">흉부외과</option>
                        <option value="select23">감염내과</option>
                        <option value="select24">내분비내과</option>
                        <option value="select25">류마티스내과</option>
                        <option value="select26">순환기내과</option>
                        <option value="select27">신장내과</option>
                        <option value="select28">알레르기내과</option>
                        <option value="select29">혈액종양내과</option>
                        <option value="select30">호흡기내과</option>
                        <option value="select31">치과</option>
                    </select>
                    <button id="search">검색</button>
                </div>
                <div id="main-content" wfd-id="299">
                    data table
                    <details>
                        <summary>데이터 분석</summary>
                        
                        <!-- 테이블 미완. 도큐먼트 인계받은 후 마저 완성할 것 -->
                        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
                        <%String HArrayString = (String)request.getAttribute("HArray");
                        JSONArray HArray = new JSONArray(HArrayString);%>
	<table class="table table-striped">
		<tr  class="bg-info">
		    <th>종류</th>
		    <th>건수</th>
		</tr>
		<tbody id="HArrayTable">
		
		<%for (int i =0; i<HArray.length(); i++){
		JSONObject data = HArray.getJSONObject(i);
		   { %>
			<tr>
		    <th><%=data.getString("location")%></th>
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
		    <th>범위</th>
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
	<%String OAGArrayString = (String)request.getAttribute("OAGArray");
                        JSONArray OAGArray = new JSONArray(OAGArrayString);%>
	<table class="table table-striped">
		<tr  class="bg-info">
		    <th>location</th>
		    <th>event</th>
		    <th>hospital</th>
		    <th>patient</th>
		    <th>appraisal</th>
		    <th>adjustment</th>
		    
		</tr>
		<tbody id="OAGArrayTable">
		
		<%for (int i =0; i<OAGArray.length(); i++){
		JSONObject data = OAGArray.getJSONObject(i);
		   { %>
			<tr>
		    <th><%=data.getString("location")%></th>
		    <th><%=data.getString("event")%></th>
		    <th><%=data.getString("hospital")%></th>
		    <th><%=data.getString("patient")%></th>
		    <th><%=data.getString("appraisal")%></th>
		    <th><%=data.getString("adjustment")%></th>
			</tr>   
		<% }%>
		<%}%>
		</tbody>
	</table>
	<%String OrthopedicsArrayString = (String)request.getAttribute("OrthopedicsArray");
                        JSONArray OrthopedicsArray = new JSONArray(OrthopedicsArrayString);%>
	<table class="table table-striped">
		<tr  class="bg-info">
		    <th>location</th>
		    <th>event</th>
		    <th>hospital</th>
		    <th>patient</th>
		    <th>appraisal</th>
		    <th>adjustment</th>
		    
		</tr>
		<tbody id="OrthopedicsArrayTable">
		
		<%for (int i =0; i<OrthopedicsArray.length(); i++){
		JSONObject data = OrthopedicsArray.getJSONObject(i);
		   { %>
			<tr>
		    <th><%=data.getString("location")%></th>
		    <th><%=data.getString("event")%></th>
		    <th><%=data.getString("hospital")%></th>
		    <th><%=data.getString("patient")%></th>
		    <th><%=data.getString("appraisal")%></th>
		    <th><%=data.getString("adjustment")%></th>
			</tr>   
		<% }%>
		<%}%>
		</tbody>
	</table>
	<%String neurosurgeryArrayString = (String)request.getAttribute("neurosurgeryArray");
                        JSONArray neurosurgeryArray = new JSONArray(neurosurgeryArrayString);%>
	<table class="table table-striped">
		<tr  class="bg-info">
		    <th>location</th>
		    <th>event</th>
		    <th>hospital</th>
		    <th>patient</th>
		    <th>appraisal</th>
		    <th>adjustment</th>
		    
		</tr>
		<tbody id="neurosurgeryArrayTable">
		
		<%for (int i =0; i<neurosurgeryArray.length(); i++){
		JSONObject data = neurosurgeryArray.getJSONObject(i);
		   { %>
			<tr>
		    <th><%=data.getString("location")%></th>
		    <th><%=data.getString("event")%></th>
		    <th><%=data.getString("hospital")%></th>
		    <th><%=data.getString("patient")%></th>
		    <th><%=data.getString("appraisal")%></th>
		    <th><%=data.getString("adjustment")%></th>
			</tr>   
		<% }%>
		<%}%>
		</tbody>
	</table>
	<%String GastroenterologyArrayString = (String)request.getAttribute("GastroenterologyArray");
                        JSONArray GastroenterologyArray = new JSONArray(GastroenterologyArrayString);%>
	<table class="table table-striped">
		<tr  class="bg-info">
		    <th>location</th>
		    <th>event</th>
		    <th>hospital</th>
		    <th>patient</th>
		    <th>appraisal</th>
		    <th>adjustment</th>
		    
		</tr>
		<tbody id="GastroenterologyArrayTable">
		
		<%for (int i =0; i<GastroenterologyArray.length(); i++){
		JSONObject data = GastroenterologyArray.getJSONObject(i);
		   { %>
			<tr>
		    <th><%=data.getString("location")%></th>
		    <th><%=data.getString("event")%></th>
		    <th><%=data.getString("hospital")%></th>
		    <th><%=data.getString("patient")%></th>
		    <th><%=data.getString("appraisal")%></th>
		    <th><%=data.getString("adjustment")%></th>
			</tr>   
		<% }%>
		<%}%>
		</tbody>
	</table>
	<%String respiratoryArrayString = (String)request.getAttribute("respiratoryArray");
                        JSONArray respiratoryArray = new JSONArray(respiratoryArrayString);%>
	<table class="table table-striped">
		<tr  class="bg-info">
		    <th>location</th>
		    <th>event</th>
		    <th>hospital</th>
		    <th>patient</th>
		    <th>appraisal</th>
		    <th>adjustment</th>
		    
		</tr>
		<tbody id="respiratoryArrayTable">
		
		<%for (int i =0; i<respiratoryArray.length(); i++){
		JSONObject data = respiratoryArray.getJSONObject(i);
		   { %>
			<tr>
		    <th><%=data.getString("location")%></th>
		    <th><%=data.getString("event")%></th>
		    <th><%=data.getString("hospital")%></th>
		    <th><%=data.getString("patient")%></th>
		    <th><%=data.getString("appraisal")%></th>
		    <th><%=data.getString("adjustment")%></th>
			</tr>   
		<% }%>
		<%}%>
		</tbody>
	</table>
	<%String medicineArrayString = (String)request.getAttribute("medicineArray");
                        JSONArray medicineArray = new JSONArray(medicineArrayString);%>
	<table class="table table-striped">
		<tr  class="bg-info">
		    <th>location</th>
		    <th>event</th>
		    <th>hospital</th>
		    <th>patient</th>
		    <th>appraisal</th>
		    <th>adjustment</th>
		    
		</tr>
		<tbody id="medicineArrayTable">
		
		<%for (int i =0; i<medicineArray.length(); i++){
		JSONObject data = medicineArray.getJSONObject(i);
		   { %>
			<tr>
		    <th><%=data.getString("location")%></th>
		    <th><%=data.getString("event")%></th>
		    <th><%=data.getString("hospital")%></th>
		    <th><%=data.getString("patient")%></th>
		    <th><%=data.getString("appraisal")%></th>
		    <th><%=data.getString("adjustment")%></th>
			</tr>   
		<% }%>
		<%}%>
		</tbody>
	</table>
	<%String OphthalmologyArrayString = (String)request.getAttribute("OphthalmologyArray");
                        JSONArray OphthalmologyArray = new JSONArray(OphthalmologyArrayString);%>
	<table class="table table-striped">
		<tr  class="bg-info">
		    <th>location</th>
		    <th>event</th>
		    <th>hospital</th>
		    <th>patient</th>
		    <th>appraisal</th>
		    <th>adjustment</th>
		    
		</tr>
		<tbody id="OphthalmologyArrayTable">
		
		<%for (int i =0; i<OphthalmologyArray.length(); i++){
		JSONObject data = OphthalmologyArray.getJSONObject(i);
		   { %>
			<tr>
		    <th><%=data.getString("location")%></th>
		    <th><%=data.getString("event")%></th>
		    <th><%=data.getString("hospital")%></th>
		    <th><%=data.getString("patient")%></th>
		    <th><%=data.getString("appraisal")%></th>
		    <th><%=data.getString("adjustment")%></th>
			</tr>   
		<% }%>
		<%}%>
		</tbody>
	</table>
	<%String ThoracicArrayString = (String)request.getAttribute("ThoracicArray");
                        JSONArray ThoracicArray = new JSONArray(ThoracicArrayString);%>
	<table class="table table-striped">
		<tr  class="bg-info">
		    <th>location</th>
		    <th>event</th>
		    <th>hospital</th>
		    <th>patient</th>
		    <th>appraisal</th>
		    <th>adjustment</th>
		    
		</tr>
		<tbody id="ThoracicArrayTable">
		
		<%for (int i =0; i<ThoracicArray.length(); i++){
		JSONObject data = ThoracicArray.getJSONObject(i);
		   { %>
			<tr>
		    <th><%=data.getString("location")%></th>
		    <th><%=data.getString("event")%></th>
		    <th><%=data.getString("hospital")%></th>
		    <th><%=data.getString("patient")%></th>
		    <th><%=data.getString("appraisal")%></th>
		    <th><%=data.getString("adjustment")%></th>
			</tr>   
		<% }%>
		<%}%>
		</tbody>
	</table>
	<%String OtorhinolaryngologyArrayString = (String)request.getAttribute("OtorhinolaryngologyArray");
                        JSONArray OtorhinolaryngologyArray = new JSONArray(OtorhinolaryngologyArrayString);%>
	<table class="table table-striped">
		<tr  class="bg-info">
		    <th>location</th>
		    <th>event</th>
		    <th>hospital</th>
		    <th>patient</th>
		    <th>appraisal</th>
		    <th>adjustment</th>
		    
		</tr>
		<tbody id="OtorhinolaryngologyArrayTable">
		
		<%for (int i =0; i<OtorhinolaryngologyArray.length(); i++){
		JSONObject data = OtorhinolaryngologyArray.getJSONObject(i);
		   { %>
			<tr>
		    <th><%=data.getString("location")%></th>
		    <th><%=data.getString("event")%></th>
		    <th><%=data.getString("hospital")%></th>
		    <th><%=data.getString("patient")%></th>
		    <th><%=data.getString("appraisal")%></th>
		    <th><%=data.getString("adjustment")%></th>
			</tr>   
		<% }%>
		<%}%>
		</tbody>
	</table>
	<%String OAGstatArrayString = (String)request.getAttribute("OAGstatArray");
                        JSONArray OAGstatArray = new JSONArray(OAGstatArrayString);%>
	<table class="table table-striped">
		<tr  class="bg-info">
		    <th>location</th>
		    <th>Dead</th>
		    <th>syndrome</th>
		    <th>paralysis</th>
		    <th>obstacle</th>
		    <th>delay</th>
		    <th>revision</th>
		    <th>etc</th>
		    <th>money</th>
		    
		</tr>
		<tbody id="OAGstatArrayTable">
		
		<%for (int i =0; i<OAGstatArray.length(); i++){
		JSONObject data = OAGstatArray.getJSONObject(i);
		   { %>
			<tr>
		    <th><%=data.getString("location")%></th>
		    <th><%=data.getString("Dead")%></th>
		    <th><%=data.getString("syndrome")%></th>
		    <th><%=data.getString("paralysis")%></th>
		    <th><%=data.getString("obstacle")%></th>
		    <th><%=data.getString("delay")%></th>
		    <th><%=data.getString("revision")%></th>
		    <th><%=data.getString("etc")%></th>
		    <th><%=data.getString("money")%></th>
			</tr>   
		<% }%>
		<%}%>
		</tbody>
	</table>
	<%String OrthopedicsstatInfoArrayString = (String)request.getAttribute("OrthopedicsstatInfoArray");
                        JSONArray OrthopedicsstatInfoArray = new JSONArray(OrthopedicsstatInfoArrayString);%>
	<table class="table table-striped">
		<tr  class="bg-info">
		    <th>location</th>
		    <th>Dead</th>
		    <th>syndrome</th>
		    <th>paralysis</th>
		    <th>obstacle</th>
		    <th>delay</th>
		    <th>revision</th>
		    <th>etc</th>
		    <th>money</th>
		    
		</tr>
		<tbody id="OrthopedicsstatInfoArrayTable">
		
		<%for (int i =0; i<OrthopedicsstatInfoArray.length(); i++){
		JSONObject data = OrthopedicsstatInfoArray.getJSONObject(i);
		   { %>
			<tr>
		    <th><%=data.getString("location")%></th>
		    <th><%=data.getString("Dead")%></th>
		    <th><%=data.getString("syndrome")%></th>
		    <th><%=data.getString("paralysis")%></th>
		    <th><%=data.getString("obstacle")%></th>
		    <th><%=data.getString("delay")%></th>
		    <th><%=data.getString("revision")%></th>
		    <th><%=data.getString("etc")%></th>
		    <th><%=data.getString("money")%></th>
			</tr>   
		<% }%>
		<%}%>
		</tbody>
	</table>
	<%String GastroenterologystatArrayString = (String)request.getAttribute("GastroenterologystatArray");
                        JSONArray GastroenterologystatArray = new JSONArray(GastroenterologystatArrayString);%>
	<table class="table table-striped">
		<tr  class="bg-info">
		    <th>location</th>
		    <th>Dead</th>
		    <th>syndrome</th>
		    <th>paralysis</th>
		    <th>obstacle</th>
		    <th>delay</th>
		    <th>revision</th>
		    <th>etc</th>
		    <th>money</th>
		    
		</tr>
		<tbody id="GastroenterologystatArrayTable">
		
		<%for (int i =0; i<GastroenterologystatArray.length(); i++){
		JSONObject data = GastroenterologystatArray.getJSONObject(i);
		   { %>
			<tr>
		    <th><%=data.getString("location")%></th>
		    <th><%=data.getString("Dead")%></th>
		    <th><%=data.getString("syndrome")%></th>
		    <th><%=data.getString("paralysis")%></th>
		    <th><%=data.getString("obstacle")%></th>
		    <th><%=data.getString("delay")%></th>
		    <th><%=data.getString("revision")%></th>
		    <th><%=data.getString("etc")%></th>
		    <th><%=data.getString("money")%></th>
			</tr>   
		<% }%>
		<%}%>
		</tbody>
	</table>
	<%String respiratorystatArrayString = (String)request.getAttribute("respiratorystatArray");
                        JSONArray respiratorystatArray = new JSONArray(respiratorystatArrayString);%>
	<table class="table table-striped">
		<tr  class="bg-info">
		    <th>location</th>
		    <th>Dead</th>
		    <th>syndrome</th>
		    <th>paralysis</th>
		    <th>obstacle</th>
		    <th>delay</th>
		    <th>revision</th>
		    <th>etc</th>
		    <th>money</th>
		    
		</tr>
		<tbody id="respiratorystatArrayTable">
		
		<%for (int i =0; i<respiratorystatArray.length(); i++){
		JSONObject data = respiratorystatArray.getJSONObject(i);
		   { %>
			<tr>
		    <th><%=data.getString("location")%></th>
		    <th><%=data.getString("Dead")%></th>
		    <th><%=data.getString("syndrome")%></th>
		    <th><%=data.getString("paralysis")%></th>
		    <th><%=data.getString("obstacle")%></th>
		    <th><%=data.getString("delay")%></th>
		    <th><%=data.getString("revision")%></th>
		    <th><%=data.getString("etc")%></th>
		    <th><%=data.getString("money")%></th>
			</tr>   
		<% }%>
		<%}%>
		</tbody>
	</table>
	<%String medicinestatArrayString = (String)request.getAttribute("medicinestatArray");
                        JSONArray medicinestatArray = new JSONArray(medicinestatArrayString);%>
	<table class="table table-striped">
		<tr  class="bg-info">
		    <th>location</th>
		    <th>Dead</th>
		    <th>syndrome</th>
		    <th>paralysis</th>
		    <th>obstacle</th>
		    <th>delay</th>
		    <th>revision</th>
		    <th>etc</th>
		    <th>money</th>
		    
		</tr>
		<tbody id="medicinestatArrayTable">
		
		<%for (int i =0; i<medicinestatArray.length(); i++){
		JSONObject data = medicinestatArray.getJSONObject(i);
		   { %>
			<tr>
		    <th><%=data.getString("location")%></th>
		    <th><%=data.getString("Dead")%></th>
		    <th><%=data.getString("syndrome")%></th>
		    <th><%=data.getString("paralysis")%></th>
		    <th><%=data.getString("obstacle")%></th>
		    <th><%=data.getString("delay")%></th>
		    <th><%=data.getString("revision")%></th>
		    <th><%=data.getString("etc")%></th>
		    <th><%=data.getString("money")%></th>
			</tr>   
		<% }%>
		<%}%>
		</tbody>
	</table>
	<%String OphthalmologystatArrayString = (String)request.getAttribute("OphthalmologystatArray");
                        JSONArray OphthalmologystatArray = new JSONArray(OphthalmologystatArrayString);%>
	<table class="table table-striped">
		<tr  class="bg-info">
		    <th>location</th>
		    <th>Dead</th>
		    <th>syndrome</th>
		    <th>paralysis</th>
		    <th>obstacle</th>
		    <th>delay</th>
		    <th>revision</th>
		    <th>etc</th>
		    <th>money</th>
		    
		</tr>
		<tbody id="OphthalmologystatArrayTable">
		
		<%for (int i =0; i<OphthalmologystatArray.length(); i++){
		JSONObject data = OphthalmologystatArray.getJSONObject(i);
		   { %>
			<tr>
		    <th><%=data.getString("location")%></th>
		    <th><%=data.getString("Dead")%></th>
		    <th><%=data.getString("syndrome")%></th>
		    <th><%=data.getString("paralysis")%></th>
		    <th><%=data.getString("obstacle")%></th>
		    <th><%=data.getString("delay")%></th>
		    <th><%=data.getString("revision")%></th>
		    <th><%=data.getString("etc")%></th>
		    <th><%=data.getString("money")%></th>
			</tr>   
		<% }%>
		<%}%>
		</tbody>
	</table>
	<%String ThoracicstatArrayString = (String)request.getAttribute("ThoracicstatArray");
                        JSONArray ThoracicstatArray = new JSONArray(ThoracicstatArrayString);%>
	<table class="table table-striped">
		<tr  class="bg-info">
		    <th>location</th>
		    <th>Dead</th>
		    <th>syndrome</th>
		    <th>paralysis</th>
		    <th>obstacle</th>
		    <th>delay</th>
		    <th>revision</th>
		    <th>etc</th>
		    <th>money</th>
		    
		</tr>
		<tbody id="ThoracicstatArrayTable">
		
		<%for (int i =0; i<ThoracicstatArray.length(); i++){
		JSONObject data = ThoracicstatArray.getJSONObject(i);
		   { %>
			<tr>
		    <th><%=data.getString("location")%></th>
		    <th><%=data.getString("Dead")%></th>
		    <th><%=data.getString("syndrome")%></th>
		    <th><%=data.getString("paralysis")%></th>
		    <th><%=data.getString("obstacle")%></th>
		    <th><%=data.getString("delay")%></th>
		    <th><%=data.getString("revision")%></th>
		    <th><%=data.getString("etc")%></th>
		    <th><%=data.getString("money")%></th>
			</tr>   
		<% }%>
		<%}%>
		</tbody>
	</table>
	<%String OtorhinolaryngologystatArrayString = (String)request.getAttribute("OtorhinolaryngologystatArray");
                        JSONArray OtorhinolaryngologystatArray = new JSONArray(OtorhinolaryngologystatArrayString);%>
	<table class="table table-striped">
		<tr  class="bg-info">
		    <th>location</th>
		    <th>Dead</th>
		    <th>syndrome</th>
		    <th>paralysis</th>
		    <th>obstacle</th>
		    <th>delay</th>
		    <th>revision</th>
		    <th>etc</th>
		    <th>money</th>
		    
		</tr>
		<tbody id="OtorhinolaryngologystatArrayTable">
		
		<%for (int i =0; i<OtorhinolaryngologystatArray.length(); i++){
		JSONObject data = OtorhinolaryngologystatArray.getJSONObject(i);
		   { %>
			<tr>
		    <th><%=data.getString("location")%></th>
		    <th><%=data.getString("Dead")%></th>
		    <th><%=data.getString("syndrome")%></th>
		    <th><%=data.getString("paralysis")%></th>
		    <th><%=data.getString("obstacle")%></th>
		    <th><%=data.getString("delay")%></th>
		    <th><%=data.getString("revision")%></th>
		    <th><%=data.getString("etc")%></th>
		    <th><%=data.getString("money")%></th>
			</tr>   
		<% }%>
		<%}%>
		</tbody>
	</table>
	<%String DentiststatArrayString = (String)request.getAttribute("DentiststatArray");
                        JSONArray DentiststatArray = new JSONArray(DentiststatArrayString);%>
	<table class="table table-striped">
		<tr  class="bg-info">
		    <th>location</th>
		    <th>Dead</th>
		    <th>syndrome</th>
		    <th>paralysis</th>
		    <th>obstacle</th>
		    <th>delay</th>
		    <th>revision</th>
		    <th>etc</th>
		    <th>money</th>
		    
		</tr>
		<tbody id="DentiststatArrayTable">
		
		<%for (int i =0; i<DentiststatArray.length(); i++){
		JSONObject data = DentiststatArray.getJSONObject(i);
		   { %>
			<tr>
		    <th><%=data.getString("location")%></th>
		    <th><%=data.getString("Dead")%></th>
		    <th><%=data.getString("syndrome")%></th>
		    <th><%=data.getString("paralysis")%></th>
		    <th><%=data.getString("obstacle")%></th>
		    <th><%=data.getString("delay")%></th>
		    <th><%=data.getString("revision")%></th>
		    <th><%=data.getString("etc")%></th>
		    <th><%=data.getString("money")%></th>
			</tr>   
		<% }%>
		<%}%>
		</tbody>
	</table>
	
	

                    </details>
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