<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>    

	<div class="container">
	  <h2>팀 등록 페이지</h2>
	  <br/>
	  <form action="/playerAdd" method="post" class="was-validated">
	    <div class="form-group">
	      <label for="uname">선수 이름</label>
	      <input type="text" class="form-control" id="playerName" placeholder="Enter park name" name="playerName" required>
	      <div class="valid-feedback">Valid.</div>
	      <div class="invalid-feedback">Please fill out this field.</div>
	    </div>
	    <div class="form-group">
	      <label for="uname">포지션</label>
	      <input type="text" class="form-control" id="position" placeholder="Enter park name" name="position" required>
	      <div class="valid-feedback">Valid.</div>
	      <div class="invalid-feedback">Please fill out this field.</div>
	    </div>
	    
	    <br/>
	    
	 	<p>팀 선택</p>
	    <select name="teamId" class="custom-select mb-3" required>
			<option selected>팀 선택</option>
			<c:forEach var="team" items="${teams}">
				<option value="${team.id}">${team.teamName}</option>
			</c:forEach>
	    </select>
	    <button type="submit" class="btn btn-primary">등록하기</button>
	  </form>
	</div>

</body>
</html>