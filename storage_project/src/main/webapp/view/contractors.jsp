<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contractors</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
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
                <button class="btn btn-secondary btn-lg dropdown-toggle strech" type="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
                    DOCUMENTS
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="documents?invoice_type=2">Input documents</a></li>
                    <li><a class="dropdown-item" href="documents?invoice_type=1">Output documents</a></li>
                    <li><a class="dropdown-item" href="documents?invoice_type=3">Write-off documents</a></li>
                </ul>
            </div>
            <div class="btn-group aline">
                <button class="btn btn-secondary btn-lg dropdown-toggle strech" type="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
                    PRODUCT MOVEMENT
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="#">List documents</a></li>
                    <li><a class="dropdown-item" href="#">Another action</a></li>
                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                </ul>
            </div>
            <div class="btn-group aline">
                <button class="btn btn-secondary btn-lg dropdown-toggle strech" type="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
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
                <button class="btn btn-secondary btn-lg dropdown-toggle strech rep" type="button"
                        data-bs-toggle="dropdown" aria-expanded="false">
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
<%--    </div>--%>
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
                    <li>
                        <hr class="dropdown-divider">
                    </li>
                    <li><a class="dropdown-item" href="#">Separated link</a></li>
                </ul>


                <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>


            <div class="buttonStyle float-right">
                <button type="button" class="btn btn-secondary btn-lg " id="add-btn"><a href="new_contractor">Add
                    contractor</a></button>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th scope="col">Code</th>
                    <th scope="col">Name</th>
                    <th scope="col">Contract number</th>
                    <th scope="col">Contractor type</th>
                    <th scope="col">Price type</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <C:forEach items="${contractors}" var="contractor">
                    <tr>
                        <td class="name">${contractor.code}</td>
                        <td><a href="contractors/${contractor.contractorId}">${contractor.contractorName}</a></td>
                        <td>${contractor.contractNumber}</td>
                        <td>${contractor.contractorType.contractorType}</td>
                        <td>${contractor.priceType.priceType}</td>
                        <td>
                            <div class="btn-group" role="group" aria-label="Basic example">
                                <button type="button" class="btn btn-primary edit-btn"
                                        onclick="openEditModal('${contractor.contractorId}', '${contractor.code}', '${contractor.contractorName}', '${contractor.contractNumber}', '${contractor.contractorType.contractorType}','${contractor.priceType.priceType}')">
                                    <i class="bi bi-pen"></i>
                                </button>
                                <button type="button" class="btn btn-primary delete-btn">
                                    <a href="contractors/delete?id=${contractor.contractorId}&contrTypeId=${contractor.contractorType.contractorTypeID}">
                                        <i class="bi bi-trash"></i></a>
                                </button>
                            </div>
                        </td>
                    </tr>
                </C:forEach>
                </tbody>
            </table>

            <%--create start--%>
            <%--            <div class="modal" id="modal">--%>
            <%--                <div class="modal-form">--%>
            <%--                    <span class="close" id="modal-close">&times</span>--%>
            <%--                    <h2 class="title">Create new contractor</h2>--%>
            <%--                    <form action="contractors/save" method="post">--%>
            <%--                        <div class="aline-form">--%>
            <%--                            <input type="text" name="name" id="contractorName-input" class="edge" placeholder="Contractor name"--%>
            <%--                            &lt;%&ndash;                     onblur="usernameValidation()" &ndash;%&gt;--%>
            <%--                                   required>--%>
            <%--                            &lt;%&ndash;              <span class="error" id="error-username">Username is not valid, enter at least 4 symbols</span>&ndash;%&gt;--%>
            <%--                            <input type="text" name="code" id="code-input" class="edge"--%>
            <%--                                   placeholder="Code"--%>
            <%--                            &lt;%&ndash;                     onblur="passwordValidation()" &ndash;%&gt;--%>
            <%--                                   required>--%>
            <%--                            &lt;%&ndash;              <span class="error" id="error-password">Password</span>&ndash;%&gt;--%>
            <%--                            <input type="text" name="contractNumber" id="contractNumber-input" class="edge"--%>
            <%--                                   placeholder="Contract number"--%>
            <%--                            &lt;%&ndash;                     onblur="firstNameValidation()" &ndash;%&gt;--%>
            <%--                                   required>--%>
            <%--                            &lt;%&ndash;              <span class="error" id="error-firstname">Firstname shouldn't be empty and should contain only characters</span>&ndash;%&gt;--%>
            <%--&lt;%&ndash;                            должен подтягиваться автоматом,подумать как сделать&ndash;%&gt;--%>
            <%--                            <input type="text" name="contractorType"--%>
            <%--                                   id="contractorType-input" class="edge" value="1"--%>
            <%--                            &lt;%&ndash;                     onblur="lastNameValidation()" &ndash;%&gt;--%>
            <%--                                   required>--%>
            <%--                            &lt;%&ndash;              <span class="error" id="error-lastname">Lastname shouldn't be empty and should contain only characters</span>&ndash;%&gt;--%>
            <%--&lt;%&ndash;                            это не нужно, должно подтягиваться автоматом&ndash;%&gt;--%>
            <%--                            <input type="text" name="priceType"--%>
            <%--                                   id="priceType-input" class="edge"--%>
            <%--                            &lt;%&ndash;                     onblur="lastNameValidation()" &ndash;%&gt;--%>
            <%--                                   required>--%>
            <%--                            &lt;%&ndash;              <span class="error" id="error-lastname">Lastname shouldn't be empty and should contain only characters</span>&ndash;%&gt;--%>
            <%--                            <button type="submit" class="btn btn-light edge">Save</button>--%>
            <%--                        </div>--%>
            <%--                    </form>--%>
            <%--                </div>--%>
            <%--            </div>--%>
            <%--            &lt;%&ndash;      create end&ndash;%&gt;--%>


            <%--edit start--%>
            <div class="modal" id="edit-modal">
                <div class="modal-form">
                    <span class="close" id="edit-modal-close">&times</span>
                    <h2 class="title">Update existing contractor</h2>
                    <form action="contractors/update" method="post">
                        <div class="aline-form">
                            <input type="text" id="edit-contractorId" name="contractorId"
                                   value="${contractorId !=null ? contractorId : ''}" hidden>
                            <%--                    <span class="error" id="error-username">Username is not valid, enter at least 4 symbols</span>--%>
                            <%--              <span class="error ${errors['username'] != null ? 's-visible' : ''}" id="error-edit-username">Username is not valid, enter at least 4 symbols</span>--%>
                            <input type="text" name="code" id="code-edit-input"
                                   value="${code !=null ? code : ''}" class="edge"
                                   placeholder="code"
                            <%--                           onblur="firstNameValidation()"--%>
                                   required>
                            <input type="text" name="name" id="contractorName-edit-input"
                                   value="${contractorName  !=null ? contractorName : ''}" class="edge"
                                   placeholder="name"
                            <%--                           onblur="usernameValidation()"--%>
                                   required>
                            <%--                    <span class="error" id="error-lastname">Lastname shouldn't be empty and should contain only characters</span>--%>
                            <%--              <span class="error ${errors['firstname'] != null ? 's-visible' : ''}" id="error-edit-firstname">Firstname shouldn't be empty and should contain only characters</span>--%>
                            <input type="text" name="contractNumber" id="contractNumber-edit-input"
                                   value="${contractNumber  !=null ? contractNumber : ''}" class="edge"
                                   placeholder="contract number"
                            <%--                           onblur="lastNameValidation()"--%>
                                   required>
                            <%--                    <span class="error" id="error-lastname">Lastname shouldn't be empty and should contain only characters</span>--%>
                            <%--              <span class="error ${errors['lastname'] != null ? 's-visible' : ''}" id="error-edit-lastname">Lastname shouldn't be empty and should contain only characters</span>--%>
                            <input type="text" name="contractorType"
                                   id="contractorType-edit-input"
                                   value="${contractorType.contractorType  !=null ? contractorType.contractorType : ''}"
                                   class="edge"
                                   placeholder="Contractor type"
                            <%--                           onblur="emailValidation()"--%>
                                   required>
                            <%--                    <span class="error" id="error-email">Enter correct email</span>--%>
                            <input type="text" name="priceType"
                                   id="priceType-edit-input"
                                   value="${priceType.priceType  !=null ? priceType.priceType : ''}"
                                   class="edge"
                                   placeholder="Price type"
                            <%--                           onblur="emailValidation()"--%>
                                   required>
                            <%--                    <span class="error" id="error-email">Enter correct email</span>--%>
                            <button type="submit" class="edge">Update</button>
                        </div>
                    </form>
                </div>
            </div>
            <%--      edit end--%>

        </div>
    </div>
</div>
<script src="/js/contractors.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
