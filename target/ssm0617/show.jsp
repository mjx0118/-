<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div>
    <form action="getbills" method="post">
        类型
        <select name="name" >
            <option value="-1">请选择</option>
            <c:forEach items="${tbill}" var="t">
                <option value="${t.bid}"  ${t.bid==typid?'selected':""}>${t.name}</option>
            </c:forEach>
        </select>
        时间:从<input type="text" name="billtime" value="${billtime}">到 <input type="text"  name="lasttime" value="${lsttime}">
        <input type="submit" value="查询">
    </form>
    <a href="gettype">记账</a>
</div>
<div>
    <table border="1" cellspacing="0" width="70%">
        <tr>
            <td>标题</td>
            <td>记账时间</td>
            <td>类别</td>
            <td>金额</td>
            <td>说明</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${pi.list}" var="k" >
            <tr>
                <td>${k.title}</td>
                <td><fmt:formatDate value="${k.billtime}" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate></td>
                <td> ${k.billtype.name}</td>
                <td>${k.price}</td>
                <td>${k.details}</td>
                  <td>
                   <a href="delete?id=${k.id}">删除</a>
                    <a href="getypesupdate?id=${k.id}">修改</a>
                  </td>
        </c:forEach>
        <c:if test="${pi.list.size()!=0}">
        <tr>
            <td colspan="4">
                <a href="getbills?typeid=${typeid}&billtime=${billtime}&lasttime=${lsttime}">首页</a>
                <a href="getbills?index=${pi.prePage==0?1:pi.prePage}&typeid=${typeid}&billtime=${billtime}&lasttime=${lsttime}">上一页</a>
                <c:forEach begin="1" end="${pi.pages}" var="i">
                    <a  href="getbills?index=${i}&typeid=${typeid}&billtime=${billtime}&lasttime=${lsttime}">${i}</a>
                </c:forEach>
                <a href="getbills?index=${pi.nextPage==0?pi.pages:pi.nextPage}&typeid=${typeid}&billtime=${billtime}&lasttime=${lsttime}">下一页</a>
                <a href="getbills?index=${pi.pages}&typeid=${typeid}&billtime=${billtime}&lasttime=${lsttime}">尾页</a>
                共${pi.total}条
                每页显示
                ${pi.pageNum}/${pi.pages}</a>
            </td>
        </tr>
        </c:if>

        <c:if test="${pi.list.size()==0}">
        <tr>
            <td >
                抱歉,暂无数据
            </td>
        </tr>
        </c:if>
    </table>
</div>

</body>
</html>