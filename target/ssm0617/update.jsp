<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
<h1>update</h1>
<form action="update" method="post">
    <input type="hidden" value="typeid">
    类型:
    <c:forEach  items="${billss}" var="b">
        <input type="radio" name="typeid" ${b.bid==typeid?'checked':''} >${b.name}
    </c:forEach>
    <br>
    标题:<input type="text" name="title" value="${bills.title}"><br>
    日期:
    <fmt:formatDate name="billtime"  value="${bills.billtime}" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate>
    金额:<input type="text" name="price"  value=" ${bills.price}"><br>
    说明:<input type="text" name="details" value="${bills.details}"><br>
    <input type="submit" value="保存">
    <input type="hidden"  value="重置">
    <input type="hidden" value="返回">
</form>
</body>
</html>