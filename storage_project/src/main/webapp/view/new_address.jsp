<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New contractor</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/main_page.css">
    <link rel="stylesheet" href="/css/document.css">
</head>
<body>
<body>
<div class="wrapper">
    <div class="block_left">
        <div class="logo">
            <img src="pictures/logo.jpg">
            <a href="#">STORAGE</a>
        </div>
        <div class="menu-style">
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
                    <li><a class="dropdown-item" href="new_document">Create document</a></li>
                </ul>
            </div>
            <div class="btn-group aline">
                <button class="btn btn-secondary btn-lg dropdown-toggle strech" type="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
                    CREATE DOCUMENT
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="new_document?invoice_type=2">Input document</a></li>
                    <li><a class="dropdown-item" href="new_document?invoice_type=1">Output document</a></li>
                    <li><a class="dropdown-item" href="new_document?invoice_type=3">Write-off document</a></li>
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


            <div class="document-title">
                <h2>Create new address</h2>
            </div>
            <form action="new_address/save" method="post">
                <div class="grid-container">
                    <div>Country</div>
                    <div>
                        <select class="doc-input" name="country" required>
                            <c:forEach items="${countries}" var="country">
                                <option value="${country.id}">${country.countryName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>City</div>
                    <div>
                        <select class="doc-input" name="city" required>
                            <c:forEach items="${cities}" var="city">
                                <option value="${city.id}">${city.cityName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>Index</div>
                    <div>
                        <input type="text" class="doc-input" name="index" id="index-input"">
                    </div>
                    <div>Street</div>
                    <div>
                        <input type="text" class="doc-input" name="street" id="street-input">
                    </div>
                    <div>House number</div>
                    <div>
                        <input type="text" class="doc-input" name="houseNumber" id="houseNumber-input">
                    </div>
                </div>
                <button type="submit" class="btn btn-light edge">Save</button>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</body>
</html>
