<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>    

	<div class="container">
	  <h2>팀 등록 페이지</h2>
	  <br/>
	  <form action="/teamAdd" method="post" class="was-validated">
	    <div class="form-group">
	      <label for="uname">팀 이름</label>
	      <input type="text" class="form-control" id="teamName" placeholder="Enter park name" name="teamName" required>
	      <div class="valid-feedback">Valid.</div>
	      <div class="invalid-feedback">Please fill out this field.</div>
	    </div>
	    
	    <br/>
	    
	 	<p>구장 선택</p>
	    <select name="ballparkId" class="custom-select mb-3" required>
			<option selected>구장 선택</option>
			<c:forEach var="ballpark" items="${parks}">
				<option value="${ballpark.id}">${ballpark.parkName}</option>
			</c:forEach>
	    </select>
	    <button type="submit" class="btn btn-primary">등록하기</button>
	  </form>
	</div>

</body>
</html>