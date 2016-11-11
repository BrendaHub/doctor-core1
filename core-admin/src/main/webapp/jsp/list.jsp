<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String _path = request.getContextPath();
	String _port = request.getServerPort() == 80 || request.getServerPort() == 443
			? ""
			: ":" + request.getServerPort();
	String _basePath = request.getScheme() + "://" + request.getServerName() + _port + _path;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table table-striped">
    	 <thead>
            <tr>

                <th></th>
                <th>编号</th>
                <th>姓名</th>
                <th>年龄</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${contactList}" var="contact">
            	<tr>
                 <td></td>
                 <td>${contact.id}</td>
                 <td>${contact.name}</td>
                 <td>${contact.age}</td>
            	</tr>
            </c:forEach>
        </tbody>
    </table>
<script>
</script>
</body>
</html>