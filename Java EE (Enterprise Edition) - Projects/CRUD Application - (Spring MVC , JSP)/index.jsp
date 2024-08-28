<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Destination List</title>
</head>
<body>
<h2>Destinations List</h2>
<a href="add">Add New Destination</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Category</th>
        <th>Description</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="destination" items="${listDestinations}">
        <tr>
            <td>${destination.id}</td>
            <td>${destination.name}</td>
            <td>${destination.category}</td>
            <td>${destination.description}</td>
            <td>
                <a href="edit?id=${destination.id}">Edit</a>
                |
                <a href="delete?id=${destination.id}" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
