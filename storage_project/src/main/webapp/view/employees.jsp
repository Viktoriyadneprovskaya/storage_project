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
            <a href="#">STORAGE</a>
        </div>
        <div class="menu-style">
            <!--    <div class="menu">-->
            <div class="btn-group aline">
                <button class="btn btn-secondary btn-lg strech" type="button">
                    <a href="products">PRODUCTS</a>
                </button>

            </div>
            <div class="btn-group aline">
                <button class="btn btn-secondary btn-lg dropdown-toggle strech" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    DOCUMENTS
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="documents?invoice_type=2">Input documents</a></li>
                    <li><a class="dropdown-item" href="documents?invoice_type=1">Output documents</a></li>
                    <li><a class="dropdown-item" href="documents?invoice_type=3">Write-off documents</a></li>
                </ul>
            </div>
            <div class="btn-group aline">
                <button class="btn btn-secondary btn-lg dropdown-toggle strech" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    PRODUCT MOVEMENT
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="#">List documents</a></li>
                    <li><a class="dropdown-item" href="#">Another action</a></li>
                    <li><a class="dropdown-item" href="#">Something else here</a></li>
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
                    <a href="employees">EMPLOYEES</a>
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
            <div class="btn-group cntr-grp">
                <button type="button" class="btn btn dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="bi bi-person-circle"></i>
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="#">Action</a></li>
                    <li><a class="dropdown-item" href="#">Another action</a></li>
                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="#">Separated link</a></li>
                </ul>


                <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>


            <div class="buttonStyle float-right">
                <button type="button" class="btn btn-secondary btn-lg " id="add-btn">+ Add employee</button>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th scope="col">Username</th>
                    <th scope="col">Full name</th>
                    <th scope="col">Job title</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${employees}" var="employee">
                    <tr>
                        <td>${employee.username}</td>
                        <td>${employee.lastName} ${employee.firstName}</td>
                        <td>${employee.jobTitle.name}</td>
                        <td>
                            <div class="btn-group" role="group" aria-label="Basic example">
                                <button type="button" class="btn btn-primary edit-btn"
                                        onclick="openEditModal('${employee.id}','${employee.username}', '${employee.firstName}', '${employee.lastName}', '${employee.jobTitle.name}')">
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
                    <h2 class="title">Create new product</h2>
                    <form action="employees/save" method="post">
                        <div class="aline-form">
                            <div class="aline-form">
                                <span>Username</span>
                                <input type="text" name="username" id="username-input" class="edge"
                                <%--                     onblur="usernameValidation()" --%>
                                       required>
                                <div class="aline-form">
                                    <span>Password</span>
                                    <input type="text" name="password" id="password-input" class="edge"
                                    <%--                     onblur="usernameValidation()" --%>
                                           required>
                            <span>Firstname</span>
                            <input type="text" name="firstName" id="firstName-input" class="edge"
                            <%--                     onblur="usernameValidation()" --%>
                                   required>
                            <%--              <span class="error" id="error-username">Username is not valid, enter at least 4 symbols</span>--%>
                            <span>Lastname</span>
                            <input type="text" name="lastName" id="lastName-input" class="edge"
                                   placeholder="Lastname"
                            <%--                     onblur="passwordValidation()" --%>
                                   required>
                            <%--              <span class="error" id="error-password">Password</span>--%>
                            <span>Job title</span>
                                    <form action="employees" method="post">
                                        <select name="jobTitle" required>
                                            <c:forEach items="${jobTitles}" var="jobTitle">
                                                <option value="${jobTitle.id}">${jobTitle.name}</option>
                                            </c:forEach>
                                        </select>
                                    </form>
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
                           Username <input type="text" name="username" id="username-edit-input"
                                   value="${username  !=null ? username : ''}" class="edge"
                                   placeholder="Username"
                            <%--                           onblur="usernameValidation()"--%>
                                   required>
                            <input type="text" name="firstName" id="firstName-edit-input"
                                   value="${firstName  !=null ? firstName : ''}" class="edge"
                                   placeholder="First name"
                            <%--                           onblur="usernameValidation()"--%>
                                   required>
                            <%--                    <span class="error" id="error-username">Username is not valid, enter at least 4 symbols</span>--%>
                            <%--              <span class="error ${errors['username'] != null ? 's-visible' : ''}" id="error-edit-username">Username is not valid, enter at least 4 symbols</span>--%>
                            <input type="text" name="lastName" id="lastName-edit-input"
                                   value="${lastName !=null ? lastName : ''}" class="edge"
                                   placeholder="Last name"
                            <%--                           onblur="firstNameValidation()"--%>
                                   required>
                            <%--                    <span class="error" id="error-lastname">Lastname shouldn't be empty and should contain only characters</span>--%>
                            <%--              <span class="error ${errors['firstname'] != null ? 's-visible' : ''}" id="error-edit-firstname">Firstname shouldn't be empty and should contain only characters</span>--%>
                            <select class="aline-form" name="jobTitle" id="jobTitle-edit-input" required>
                                <c:forEach items="${jobTitles}" var="jobTitle">
                                    <option value="${jobTitle.id}">${jobTitle.name}</option>
                                </c:forEach>
                            </select>
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
