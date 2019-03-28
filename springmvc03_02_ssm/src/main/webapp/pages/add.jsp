<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加账户</title>
</head>
<body>
<h3>添加账户</h3>
    <form action="/account/save" method="post">
        <table>
            <tr>
                <th>用户ID</th>
                <td><input type="text" name="uid"></td>
            </tr>
            <tr>
                <th>余额</th>
                <td><input type="text" name="money"></td>
            </tr>
            <tr>
                <th colspan="2">
                    <input type="submit" value="添加账户">
                </th>
            </tr>
        </table>
    </form>
</body>
</html>
