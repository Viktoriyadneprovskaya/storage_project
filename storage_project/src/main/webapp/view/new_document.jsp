<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="С" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/main_page.css">
    <link rel="stylesheet" href="/css/document.css">
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
            <div class="btn-group aline">
                <button class="btn btn-secondary btn-lg strech" type="button">
                    <a class="new-style" href="employees">EMPLOYEES</a>
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
            </div>
            </div>
            <div class="document-title">
                <h2>CREATE NEW SALES DOCUMENT</h2>
            </div>
            <form:form action="new_document/save?invoice_type=2" method="post" modelAttribute="documentCommand">

                <div class="grid-container">
                    <div>Contractor:</div>
                    <div>
                        <select class="doc-input" name="contractor" required>
                            <C:forEach items="${documentCommand.contractors}" var="contractor">
                                <option value="${contractor.contractorId}">${contractor.contractorName}</option>
                            </C:forEach>
                        </select>
                    </div>
                    <div>My organization:</div>
                    <div>${documentCommand.myOrganization.name}</div>
                    <div>My organization address:</div>
                    <div>${documentCommand.myOrganization.address}</div>
                </div>

                <button onclick="addRow()" type="button" class="btn btn aline-button">
                    <i class="bi bi-plus"></i></button>
                <div class="line">
                    <div>
                        <strong>#</strong>
                    </div>
                    <div>
                        <strong>Product name</strong>
                    </div>
                    <div>
                        <strong>Measure unit</strong>
                    </div>
                    <div>
                        <strong>Quantity</strong>
                    </div>
                </div>
                <C:forEach items="${documentCommand.docDetailsRows}" var="docDetailsRow" varStatus="status">
                <div id="table" class="table">
                <div class="dynamic-line">
                    ${status.count}
                    <select class="doc-input" name="docDetailsRows[${status.index}].products" required>
                        <C:forEach items="${docDetailsRow.products}" var="product">
                            <option value="${product.productId}">${product.name}</option>
                        </C:forEach>
                    </select>
                    <select class="doc-input" name="docDetailsRows[${status.index}].measureUnits" required>
                        <C:forEach items="${docDetailsRow.measureUnits}" var="measureUnit">
                            <option value="${measureUnit.measureUnitId}">${measureUnit.measureName}</option>
                        </C:forEach>
                    </select>
                    <input class="doc-input input1" name="docDetailsRows[${status.index}].quantities" required>
                    </div>
                    </div>
                </C:forEach>

                <button id="submitButton" type="submit" class="btn btn-light edge">CREATE</button>
            </form:form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/js/new_document.js"></script>
</body>
</html>