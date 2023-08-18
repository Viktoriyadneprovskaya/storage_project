<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Full contractor info</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/main_page.css">
    <link rel="stylesheet" href="/css/additional.css">
    <link rel="stylesheet" href="/css/document.css">

</head>
<body>
<div class="wrapper">
    <div class="block_left">
        <div class="logo">
            <img src="/pictures/logo.jpg">
            <a class="logo-style" href="/products">STORAGE</a>
        </div>
        <div class="menu-style">
            <div class="btn-group aline">
                <button class="btn btn-secondary btn-lg strech" type="button">
                    <a class="new-style" href="/products">PRODUCTS</a>
                </button>

            </div>
            <div class="btn-group aline">
                <button class="btn btn-secondary btn-lg dropdown-toggle strech" type="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
                    DOCUMENTS
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="/documents?invoice_type=2">Input documents</a></li>
                    <li><a class="dropdown-item" href="/documents?invoice_type=1">Sales documents</a></li>
                </ul>
            </div>
            <div class="btn-group aline">
                <button class="btn btn-secondary btn-lg dropdown-toggle strech" type="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
                    CREATE DOCUMENT
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="/documents/new_document?invoice_type=1">Input document</a></li>
                    <li><a class="dropdown-item" href="/documents/new_document?invoice_type=2">Sales document</a></li>
                </ul>
            </div>
            <div class="btn-group aline">
                <button class="btn btn-secondary btn-lg dropdown-toggle strech" type="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
                    CONTRACTORS
                </button>
                <ul id="myDropdown" class="dropdown-menu">
                    <li><a class="dropdown-item" href="/contractors?contrTypeId=1">Suppliers</a></li>
                    <li><a class="dropdown-item" href="/contractors?contrTypeId=2">Customers</a></li>
                </ul>
            </div>
            <sec:authorize access="hasAuthority('ADMIN')">
                <div class="btn-group aline">
                    <button class="btn btn-secondary btn-lg strech" type="button">
                        <a class="new-style" href="/employees">EMPLOYEES</a>
                    </button>
                </div>
            </sec:authorize>
            <div class="btn-group aline">
                <button class="btn btn-secondary btn-lg dropdown-toggle strech rep" type="button"
                        data-bs-toggle="dropdown" aria-expanded="false">
                    REPORTS
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="/reports/product_balance">Product Balance</a></li>
                    <li><a class="dropdown-item" href="/reports/sales_by_product">Sales by products</a></li>
                    <li><a class="dropdown-item" href="/reports/product_sales_by_contractor">Sales by contractors</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <div class="block_center">
            <div class="info-line">
                <div class="btn-container">
                    <sec:authorize access="hasAuthority('ADMIN')">
                            <button type="button" class="btn btn-secondary btn-custom"
                                    onclick="openEditModal('${contractor.contractorId}', '${contractor.code}', '${contractor.contractorName}', '${contractor.contractNumber}', '${contractor.contractorType.contractorType}','${contractor.priceType.priceType}')">
                                Edit
                            </button>
                        <button type="button" class="btn btn-secondary btn-custom" data-contractor-id="${contractor.contractorId}"
                                data-contractor-type-id="${contractor.contractorType.contractorTypeID}" id="deleteButton">Delete</button>
                    </sec:authorize>
                </div>
    <button type="button" class="btn employee-button">
        <a href="/employee_page"><i class="bi bi-person-circle"></i></a>
    </button>

            </div>
            <h2>${contractor.contractorName.toUpperCase()} information</h2>
            <div class="grid-container">
                <div>Code:</div>
                <div>
                    ${contractor.code}
                </div>
                <div>Contractor name:</div>
                <div>
                    ${contractor.contractorName}
                </div>
                <div>Contract number:</div>
                <div>
                    ${contractor.contractNumber}
                </div>
                <div>Contractor type</div>
                <div>
                   ${contractor.contractorType.contractorType}
                </div>
                <div>Price type</div>
                <div>
                    ${contractor.priceType.priceType}
                </div>
                <div>Index</div>
                <div>
                    ${address.index}
                </div>
                <div>Country</div>
                <div>
                   ${address.country.countryName}
                </div>
                <div>City</div>
                <div>
                    ${address.city.cityName}
                </div>
                <div>Street</div>
                <div>
                    ${address.street}
                </div>
                <div>House number</div>
                <div>
                   ${address.houseNumber}
                </div>
            </div>

            <%--edit start--%>
            <div class="modal" id="edit-modal">
                <div class="modal-form">
                    <span class="close" id="edit-modal-close">&times</span>
                    <h2 class="title">Update existing contractor</h2>
                    <form action="/contractors/update" method="post">
                        <div class="aline-form">
                            <input type="text" class="hidden-input" id="edit-contractorId" name="contractorId">
                            <div class="edge">Code
                                <input type="text" name="code" id="code-edit-input"
                                       value="${code !=null ? code : ''}" class="edge"
                                       placeholder="code"
                                       required>
                            </div>
                            <div class="edge">Contractor name
                                <input type="text" name="contractorName" id="contractorName-edit-input"
                                       value="${contractorName  !=null ? contractorName : ''}" class="edge"
                                       placeholder="name"
                                       required>
                            </div>
                            <div class="edge">Contract number
                                <input type="text" name="contractNumber" id="contractNumber-edit-input"
                                       value="${contractNumber  !=null ? contractNumber : ''}" class="edge"
                                       placeholder="contract number"
                                       required>
                            </div>
                            <div class="edge">Contractor type
                                <select name="contractorType" id="contractorType-edit-input" class="edge" required>
                                    <C:forEach items="${contractorTypes}" var="contractorType">
                                        <option value="${contractorType.contractorTypeID}" ${contractorType.contractorTypeID == contractor.contractorType.contractorTypeID ? 'selected = "selected"': ''}>${contractorType.contractorType}</option>
                                    </C:forEach>
                                </select>
                            </div>
                            <div class="edge">Price type
                                <select name="priceType" id="priceType-edit-input" class="edge" required>
                                    <C:forEach items="${priceTypes}" var="priceType">
                                        <option value="${priceType.priceTypeId}" ${priceType.priceTypeId == contractor.priceType.priceTypeId ? 'selected = "selected"': ''}>${priceType.priceType}</option>
                                    </C:forEach>
                                </select>
                            </div>
                            <div class="edge">Index
                                <input type="text" name="index" id="index-edit-input"
                                       value="${address.index  !=null ? address.index : ''}" class="edge"
                                       placeholder="index"
                                       required>
                            </div>
                            <div class="edge">Country
                                <select name="country" id="country-edit-input" class="edge" required>
                                    <C:forEach items="${countries}" var="country">
                                        <option value="${country.id}" ${country.id == address.country.id ? 'selected = "selected"': ''}>${country.countryName}</option>
                                    </C:forEach>
                                </select>
                            </div>
                            <div class="edge">City
                                <select name="city" id="city-edit-input" class="edge" required>
                                    <C:forEach items="${cities}" var="city">
                                        <option value="${city.id}" ${city.id == address.city.id ? 'selected = "selected"': ''}>${city.cityName}</option>
                                    </C:forEach>
                                </select>
                            </div>
                            <div class="edge">Street
                                <input type="text" name="street" id="street-edit-input"
                                       value="${address.street  !=null ? address.street : ''}" class="edge"
                                       placeholder="street"
                                       required>
                            </div>
                            <div class="edge">House number
                                <input type="text" name="houseNumber" id="house-edit-input"
                                       value="${address.houseNumber !=null ? address.houseNumber : ''}" class="edge"
                                       placeholder="index"
                                       required>
                            </div>
                            <button type="submit" class="edge">Update</button>
                        </div>
                    </form>
                </div>
            </div>
            <%--      edit end--%>
    </div>
</div>
<script src="/js/contractors/contractors.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
