<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
</head>
<body>
   <table>
       <tr>
           <th>账户ID</th>
           <th>用户ID</th>
           <th>余额</th>
       </tr>
       <c:if test="${not empty list}">
           <c:forEach var="a" items="${list}">
               <tr>
                   <td>${a.accountId}</td>
                   <td>${a.uid}</td>
                   <td>${a.money}</td>
               </tr>
           </c:forEach>
       </c:if>

       <tr>
           <td colspan="3">
               <%--
                   <a href="add.jsp">添加</a>
                   1. 相对路径
                   2. 不是相对于项目的目录（绝对目录），相对于当前访问路径。
                   3. 当前访问路径：
                      http://localhost:8080/account   相对于此目录
                      http://localhost:8080/account/add.jsp  最后的结果，不是我们要的。

                   <a href="/pages/add.jsp">添加</a>
                   1. “/” 开头绝对路径
                      http://localhost:8080/     斜杠就是这里的目录，相对于服务器的webapp
                   2. /pages/add.jsp
                     http://localhost:8080//pages/add.jsp
               --%>
               <a href="/pages/add.jsp">添加</a>
           </td>
       </tr>
   </table>
</body>
</html>
