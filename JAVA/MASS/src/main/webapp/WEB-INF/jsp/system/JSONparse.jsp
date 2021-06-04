<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<style>
    th{ 
        color:#fff;
            }
</style>


<table class="table table-striped">
    <tr  class="bg-info">
        <th>Name</th>
        <th>Position</th>
        <th>Salary</th>
        <th>Start_date</th>
        <th>Office</th>
        <th>Extn</th>
    </tr>
    <tbody id="myTable">
        
    </tbody>
</table>

<script>
	var jArray = [
		{"name":"name1","position":"position1","salary":"salary1","start_date":"start_date1","office":"office1","extn":"extn1"},
		{"name":"name2","position":"position2","salary":"salary2","start_date":"start_date2","office":"office2","extn":"extn2"},
		{"name":"name3","position":"position3","salary":"salary3","start_date":"start_date3","office":"office3","extn":"extn3"},
		{"name":"name4","position":"position4","salary":"salary4","start_date":"start_date4","office":"office4","extn":"extn4"},
		{"name":"name5","position":"position5","salary":"salary5","start_date":"start_date5","office":"office5","extn":"extn5"},
		{"name":"name6","position":"position6","salary":"salary6","start_date":"start_date6","office":"office6","extn":"extn6"}
		]

	buildTable(jArray)

	function buildTable(data){
		var table = document.getElementById('myTable')

		for (var i = 0; i < data.length; i++){
			var row = `<tr>
							<td>${data[i].name}</td>
							<td>${data[i].position}</td>
							<td>${data[i].salary}</td>
							<td>${data[i].start_date}</td>
							<td>${data[i].office}</td>
							<td>${data[i].extn}</td>
					  </tr>`
			table.innerHTML += row
		}
	}

</script>

 