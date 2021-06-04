<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="org.json.*"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<%String HArrayString = (String)request.getAttribute("HArray");
JSONArray HArray = new JSONArray(HArrayString);%>
	<table class="table table-striped">
		<tr  class="bg-info">
		    <th>장소</th>
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
	
