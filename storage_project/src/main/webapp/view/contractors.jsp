<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
            <a class="logo-style" href="products">STORAGE</a>
        </div>
        <div class="menu-style">
            <div class="btn-group aline">
                <button class="btn btn-secondary btn-lg strech" type="button">
                    <a class="new-style" href="products">PRODUCTS</a>
                </button>

            </div>
            <div class="btn-group aline">
                <button class="btn btn-secondary btn-lg dropdown-toggle strech" type="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
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
                <button class="btn btn-secondary btn-lg dropdown-toggle strech" type="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
                    CONTRACTORS
                </button>
                <ul id="myDropdown" class="dropdown-menu">
                    <li><a class="dropdown-item" href="contractors?contrTypeId=1">Suppliers</a></li>
                    <li><a class="dropdown-item" href="contractors?contrTypeId=2">Customers</a></li>
                </ul>
            </div>
            <sec:authorize access="hasAuthority('ADMIN')">
                <div class="btn-group aline">
                    <button class="btn btn-secondary btn-lg strech" type="button">
                        <a class="new-style" href="employees">EMPLOYEES</a>
                    </button>
                </div>
            </sec:authorize>
            <div class="btn-group aline">
                <button class="btn btn-secondary btn-lg dropdown-toggle strech rep" type="button"
                        data-bs-toggle="dropdown" aria-expanded="false">
                    REPORTS
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="/reports/product_balance">Product balance</a></li>
                    <li><a class="dropdown-item" href="/reports/sales_by_product">Sales by products</a></li>
                    <li><a class="dropdown-item" href="/reports/product_sales_by_contractor">Sales by contractors</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="block_center">
        <div class="bar">
            <div class="info-line">
                <div class="btn-group cntr-grp">
                    <button type="button" class="btn btn dropdown-toggle" data-bs-toggle="dropdown"
                            aria-expanded="false">
                        <i class="bi bi-person-circle"></i>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="employee_page">Employee info</a></li>
                    </ul>

                    <sec:authorize access="hasAuthority('ADMIN')">
                        <div class="buttonStyle float-right">
                            <button type="button" class="btn btn-secondary btn-lg " id="add-btn"><a
                                    href="/new_contractor">Add contractor</a></button>
                        </div>
                    </sec:authorize>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Code</th>
                    <th scope="col">Name</th>
                    <th scope="col">Contract number</th>
                    <th scope="col">Contractor type</th>
                    <th scope="col">Price type</th>
                </tr>
                </thead>
                <tbody>
                <%int number = 1; %>
                <C:forEach items="${contractors}" var="contractor">
                    <tr>
                        <td><%=number++%>
                        </td>
                        <td class="name">${contractor.code}</td>
                        <td><a class="my-style"
                               href="contractors/${contractor.contractorId}">${contractor.contractorName}</a></td>
                        <td>${contractor.contractNumber}</td>
                        <td>${contractor.contractorType.contractorType}</td>
                        <td>${contractor.priceType.priceType}</td>
                    </tr>
                </C:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
