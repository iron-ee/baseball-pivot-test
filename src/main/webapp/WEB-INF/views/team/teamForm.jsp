<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
	<div class="container">
	  <h2>팀 목록 페이지</h2>
	              
	  <table class="table table-dark table-hover">
	    <thead>
	      <tr>
	        <th>No</th>
	        <th>팀</th>
	        <th>구장</th>
	        <th> </th>
	      </tr>
	    </thead>
	    <tbody>
	    	<c:forEach var="team" items="${teams}">
			    <tr id="team-${team.id}">
			        <td>${team.id}</td>
			        <td>${team.teamName}</td>
			        <td>${team.ballpark.parkName}</td>
			        <td><button onClick="deleteById(${team.id})" class="btn btn-danger">삭제</button></td>
				</tr>
	     	</c:forEach>

	    </tbody>
	  </table>
	</div>
</body>

<script>
	function deleteById(id){
		console.log(id);		
		$.ajax({
			type:"DELETE",
			url:"/team/"+id,
			dataType:"JSON"	
		}).done((res)=>{
			console.log(res);
	 		if(res.statusCode === 1){		
				$("#team-"+id).remove();
			}else{ 
				alert("삭제에 실패하였습니다.");
			}	 
		});		
	}
</script>

</html>