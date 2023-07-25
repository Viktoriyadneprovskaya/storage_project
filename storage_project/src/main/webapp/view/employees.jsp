<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employees</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/main_page.css">
    <link rel="stylesheet" href="/css/additional.css">
</head>
<body>
<div class="wrapper">
    <div class="block_left">
        <div class="logo">
            <img src="pictures/logo.jpg">
            <a class="logo-style" href="products">STORAGE</a>
        </div>
        <div class="menu-style">
            <!--    <div class="menu">-->
            <div class="btn-group aline">
                <button class="btn btn-secondary btn-lg strech" type="button">
                    <a class="new-style" href="products">PRODUCTS</a>
                </button>

            </div>
            <div class="btn-group aline">
                <button class="btn btn-secondary btn-lg dropdown-toggle strech" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    DOCUMENTS
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="documents?invoice_type=2">Input documents</a></li>
                    <li><a class="dropdown-item" href="documents?invoice_type=1">Sales documents</a></li>
                </ul>
            </div>
            <div class="btn-group aline">
                <button class="btn btn-secondary btn-lg dropdown-toggle strech" type="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
                    CREATE DOCUMENT
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="/new_input_document?invoice_type=1">Input document</a></li>
                    <li><a class="dropdown-item" href="/new_document?invoice_type=2">Sales document</a></li>
                </ul>
            </div>
            <div class="btn-group aline">
                <button class="btn btn-secondary btn-lg dropdown-toggle strech" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    CONTRACTORS
                </button>
                <ul id="myDropdown" class="dropdown-menu">
                    <li><a class="dropdown-item" href="contractors?contrTypeId=1">Suppliers</a></li>
                    <li><a class="dropdown-item" href="contractors?contrTypeId=2">Customers</a></li>
                </ul>
            </div>
            <div class="btn-group aline">
                <button class="btn btn-secondary btn-lg strech" type="button">
                    <a class="new-style" href="employees">EMPLOYEES</a>
                </button>
            </div>
            <div class="btn-group aline">
                <button class="btn btn-secondary btn-lg dropdown-toggle strech rep" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    REPORTS
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="#">Action</a></li>
                    <li><a class="dropdown-item" href="#">Another action</a></li>
                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="block_center">
        <div class="bar">
            <div class="info-line">
                <div class="btn-group cntr-grp">
                    <button type="button" class="btn btn dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="bi bi-person-circle"></i>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="employee_page">Employee info</a></li>
                    </ul>

            <div class="buttonStyle float-right">
                <button type="button" class="btn btn-secondary btn-lg " id="add-btn">+ Add employee</button>
            </div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Username</th>
                    <th scope="col">Full name</th>
                    <th scope="col">Job title</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <%int number = 1; %>
                <c:forEach items="${employees}" var="employee">
                    <tr>
                        <td><%=number++%></td>
                        <td>${employee.username}</td>
                        <td>${employee.lastName} ${employee.firstName}</td>
                        <td>${employee.jobTitle.name}</td>
                        <td>
                            <div class="btn-group" role="group" aria-label="Basic example">
                                <button type="button" class="btn btn-primary edit-btn"
                                        onclick="openEditModal('${employee.id}','${employee.username}', '${employee.firstName}', '${employee.lastName}', '${employee.jobTitle.id}')">
                                <i class="bi bi-pen"></i>
                                </button>
                                <button type="button" class="btn btn-primary delete-btn">
                                    <a href="employees/delete?id=${employee.id}">
                                        <i class="bi bi-trash"></i></a>
                                </button>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <%--create start--%>
            <div class="modal" id="modal">
                <div class="modal-form">
                    <span class="close" id="modal-close">&times</span>
                    <h2 class="title">Create new employee</h2>
                    <form action="employees/save" method="post">
                        <div class="aline-form">
                            <div class="aline-form">
                                <div class="edge"> Enter username
                                <input type="text" name="username" id="username-input" class="edge"
                                <%--                     onblur="usernameValidation()" --%>
                                       required>
                                </div>
                                    <div class="edge">Enter password
                                    <input type="text" name="password" id="password-input" class="edge"
                                    <%--                     onblur="usernameValidation()" --%>
                                           required>
                                    </div>
                            <div class="edge">Enter firstname
                            <input type="text" name="firstName" id="firstName-input" class="edge"
                            <%--                     onblur="usernameValidation()" --%>
                                   required>
                            </div>
                            <%--              <span class="error" id="error-username">Username is not valid, enter at least 4 symbols</span>--%>
                            <div class="edge">Enter lastname
                            <input type="text" name="lastName" id="lastName-input" class="edge"
                                   placeholder="Lastname"
                            <%--                     onblur="passwordValidation()" --%>
                                   required>
                            </div>
                            <%--              <span class="error" id="error-password">Password</span>--%>
                            <div class="edge">Enter job title
                                        <select name="jobTitle"  class="edge" required>
                                            <c:forEach items="${jobTitles}" var="jobTitle">
                                                <option value="${jobTitle.id}">${jobTitle.name}</option>
                                            </c:forEach>
                                        </select>
                            </div>
                            <%--              <span class="error" id="error-firstname">Firstname shouldn't be empty and should contain only characters</span>--%>
                            <button type="submit" class="btn btn-light edge">Save</button>
                        </div>
                    </form>
                </div>
            </div>
            <%--      create end--%>


            <%--edit start--%>
            <div class="modal" id="edit-modal">
                <div class="modal-form">
                    <span class="close" id="edit-modal-close">&times</span>
                    <h2 class="title">Update employee</h2>
                    <form action="employees/update" method="post">
                        <div class="aline-form">
                            <input type="text" id="edit-id" name="id"
                                   value="${id !=null ? id : ''}" hidden>
                            <div class="edge">Username
                                <input type="text" name="username" id="username-edit-input"
                                   value="${username  !=null ? username : ''}" class="edge"
                                   placeholder="Username"
                            <%--                           onblur="usernameValidation()"--%>
                                   required>
                            </div>
                            <div class="edge">Firstname
                            <input type="text" name="firstName" id="firstName-edit-input"
                                   value="${firstName  !=null ? firstName : ''}" class="edge"
                                   placeholder="First name"
                            <%--                           onblur="usernameValidation()"--%>
                                   required>
                            </div>
                            <%--                    <span class="error" id="error-username">Username is not valid, enter at least 4 symbols</span>--%>
                            <%--              <span class="error ${errors['username'] != null ? 's-visible' : ''}" id="error-edit-username">Username is not valid, enter at least 4 symbols</span>--%>
                            <div class="edge">Lastname
                            <input type="text" name="lastName" id="lastName-edit-input"
                                   value="${lastName !=null ? lastName : ''}" class="edge"
                                   placeholder="Last name"
                            <%--                           onblur="firstNameValidation()"--%>
                                   required>
                            </div>
                            <%--                    <span class="error" id="error-lastname">Lastname shouldn't be empty and should contain only characters</span>--%>
                            <%--              <span class="error ${errors['firstname'] != null ? 's-visible' : ''}" id="error-edit-firstname">Firstname shouldn't be empty and should contain only characters</span>--%>
                            <div class="edge">Job title
                            <select class="edge" name="jobTitle" id="jobTitle-edit-input" required>
                                <c:forEach items="${jobTitles}" var="jobTitle">
                                    <option value="${jobTitle.id}">${jobTitle.name}</option>
                                </c:forEach>
                            </select>
                            </div>
                            <%--                    <span class="error" id="error-lastname">Lastname shouldn't be empty and should contain only characters</span>--%>
                            <%--              <span class="error ${errors['lastname'] != null ? 's-visible' : ''}" id="error-edit-lastname">Lastname shouldn't be empty and should contain only characters</span>--%>
                            <button type="submit" class="edge">Update</button>
                        </div>
                    </form>
                </div>
            </div>
            <%--      edit end--%>

        </div>
    </div>
</div>
</div>
</div>
<script src="/js/employee.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
