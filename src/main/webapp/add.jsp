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
    <h1>add</h1>
    <form action="add" method="post">
    <input type="hidden" name="method" value="add">
        类型:
        <c:forEach  items="${tlist}" var="t">
         <input type="radio"  value="${t.bid}" name="name" ${t.bid==1?'checked':''}>${t.name}
        </c:forEach>
        <br>
        标题:<input type="text" name="title"><br>
        日期:<input type="text" name="billtime">
        金额:<input type="text" name="price"><br>
        说明:<input type="text" name="details"><br>
        <input type="submit" value="保存">
        <input type="button"  value="重置">
        <input type="button" value="返回" location.href="getbills">
    </form>
</body>
</html>