<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>STORAGE</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet" href="css/storage_first.css"/>
</head>
<body>
    <div class="form-container">
        <h2 class="title">StorageApp</h2>
        <c:if test="${param.error != null}">
            Invalid username and password
        </c:if>
        <form action="login" method="POST">
            <div class="input-form">
                <input name="username" type="text" class="input" placeholder="Enter username">
            </div>
            <div class="input-form">
                <input name="password" type="password" class="input" placeholder="Enter password">
            </div>
            <div class="reg-center">
                <button class="reg-button btn" type="submit">Login</button>
            </div>
        </form>
    </div>
</body>
</html>