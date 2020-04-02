<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	<title>Print Song Title</title>
</head> 
<body> 
	<c:forEach var="title" items="${titles}" varStatus="idx"> 
		${idx.index}은 ${title} <br /> 
	</c:forEach>
</body> 
</html>

