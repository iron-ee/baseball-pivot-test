<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
	<div class="container">
	  <h2>야구장 목록 페이지</h2>
	              
	  <table class="table table-dark table-hover">
	    <thead>
	      <tr>
	        <th>No</th>
	        <th>구장</th>
	        <th>팀</th>
	        <th> </th>
	      </tr>
	    </thead>
	    <tbody>
	    	<c:forEach var="ballpark" items="${ballparks}">
			    <tr id="park-${ballpark.id}">
			        <td>${ballpark.id}</td>
			        <td>${ballpark.parkName}</td>
			        <td>${ballpark.team.teamName}</td>
			        <td><button onClick="deleteById(${ballpark.id})" class="btn btn-danger">삭제</button></td>
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
			url:"/ballpark/"+id,
			dataType:"JSON"	
		}).done((res)=>{
			console.log(res);
	 		if(res.statusCode === 1){		
				$("#park-"+id).remove();
			}else{ 
				alert("삭제에 실패하였습니다.");
			}	 
		});
		
	}
</script>

</html>