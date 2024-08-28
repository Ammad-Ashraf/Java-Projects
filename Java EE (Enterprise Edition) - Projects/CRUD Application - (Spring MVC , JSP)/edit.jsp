<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Destination</title>
</head>
<body>
<h2>Edit Destination</h2>
<form action="update" method="post">
    <input type="hidden" name="id" value="${destination.id}" />
    Name: <input type="text" name="name" value="${destination.name}" /><br/>
    Category: <input type="text" name="category" value="${destination.category}" /><br/>
    Description: <input type="text" name="description" value="${destination.description}" /><br/>
    <input type="submit" value="Update"/>
</form>
</body>
</html>
