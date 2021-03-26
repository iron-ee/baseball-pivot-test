<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>    

	<div class="container">
	  <h2>야구장 등록 페이지</h2>
	  <br/>
	  <form action="/ballparkAdd" method="post" class="was-validated">
	    <div class="form-group">
	      <label for="uname">구장 이름</label>
	      <input type="text" class="form-control" id="parkName" placeholder="Enter park name" name="parkName" required>
	      <div class="valid-feedback">Valid.</div>
	      <div class="invalid-feedback">Please fill out this field.</div>
	    </div>

	    <button type="submit" class="btn btn-primary">등록하기</button>
	  </form>
	</div>

</body>
</html>