<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
	<div class="container">
	  <h2>포지션별 선수 페이지</h2>
	              
	  <table class="table table-dark table-hover">
	    <thead>
	      <tr>
	        <th>포지션</th>
	        <th>롯데</th>
	        <th>NC</th>
	        <th>두산</th>
	      </tr>
	    </thead>
	    <tbody>
	    	<c:forEach var="dto" items="${dtos}">
			    <tr>
			        <td>${dto.position}</td>
			        <td>${dto.lotte}</td>
			        <td>${dto.nc}</td>
			        <td>${dto.doosan}</td>
				</tr>
	     	</c:forEach>

	    </tbody>
	  </table>
	</div>
</body>
</html>