<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <h3>封装请求数据到对象关联的对象、对象关联的集合对象中</h3>
    <form action="/user/update.do" method="post">
        用户名： <input type="text" name="name">   <br>
        省份：   <input type="text" name="address.province">   <br>
        城市：   <input type="text" name="address.city">   <br>

        省份list:<input type="text" name="list[0].province">   <br>
        城市list:<input type="text" name="list[1].city">   <br>

        省份map:<input type="text" name="map['one'].province">   <br>
        城市map:<input type="text" name="map['one'].city">   <br>

        <input type="submit" value="测试封装请求数据，观察日志">
    </form>

    <h3>请求参数乱码解决</h3>
    <form action="/user/find.do" method="get">
        用户名： <input type="text" name="name">   <br>
        <input type="submit" value="请求参数中文">
    </form>

    <h3>测试获取请求体</h3>
    <form action="/requestBody.do" method="post">
        用户ID： <input type="text" name="id">   <br>
        用户名： <input type="text" name="username">   <br>
        <input type="submit" value="测试获取请求体">
    </form>
</body>
</html>
