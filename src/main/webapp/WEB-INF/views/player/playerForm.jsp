<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
	<div class="container">
	  <h2>선수 목록 페이지</h2>
	              
	  <table class="table table-dark table-hover">
	    <thead>
	      <tr>
	        <th>No</th>
	        <th>선수 이름</th>
	        <th>포지션</th>
	        <th>팀</th>
	        <th> </th>
	      </tr>
	    </thead>
	    <tbody>
	    	<c:forEach var="player" items="${players}">
			    <tr id="player-${player.id}">
			        <td>${player.id}</td>
			        <td>${player.playerName}</td>
			        <td>${player.position}</td>
			        <td>${player.team.teamName}</td>
			        <td><button onClick="deleteById(${player.id})" class="btn btn-danger">삭제</button></td>
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
			url:"/player/"+id,
			dataType:"JSON"	
		}).done((res)=>{
			console.log(res);
	 		if(res.statusCode === 1){		
				$("#player-"+id).remove();
			}else{ 
				alert("삭제에 실패하였습니다.");
			}	 
		});		
	}
</script>

</html>