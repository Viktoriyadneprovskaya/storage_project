<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products</title>
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
                    <li><a class="dropdown-item" href="/reports/product_balance">Product balance</a></li>
                    <li><a class="dropdown-item" href="/reports/sales_by_product">Sales by products</a></li>
                    <li><a class="dropdown-item" href="/reports/product_sales_by_contractor">Sales by contractors</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <div class="block_center">
<%--        <div class="bar">--%>
            <div class="info-line">
                <div class="btn-group cntr-grp">
                    <button type="button" class="btn btn">
                        <i class="bi bi-person-circle"></i><a class="dropdown-item" href="/employee_page">Employee
                        info</a>
                    </button>
<%--                </div>--%>

                <sec:authorize access="hasAuthority('ADMIN')">
                    <div class="buttonStyle float-right">
                        <button type="button" class="btn btn-secondary btn-lg " id="add-btn">+ Add Product</button>
                    </div>
                </sec:authorize>
            </div>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Product name</th>
                <th scope="col">Measure unit</th>
                <th scope="col">Shelf life</th>
                <th scope="col">Basic price</th>
                <sec:authorize access="hasAuthority('ADMIN')">
                    <th scope="col">Actions</th>
                </sec:authorize>
            </tr>
            </thead>
            <tbody>
            <%int number = 1; %>
            <C:forEach items="${products}" var="product">

                <tr>
                    <td><%=number++%>
                    </td>
                    <td>${product.name}</td>
                    <td>${product.measureUnit.measureName}</td>
                    <td>${product.shelfLife}</td>
                    <td>${product.basicPrice}</td>
                    <sec:authorize access="hasAuthority('ADMIN')">
                        <td>
                            <div class="btn-group" role="group" aria-label="Basic example">
                                <button type="button" class="btn edit-btn group-button"
                                        onclick="openEditModal('${product.productId}', '${product.name}','${product.measureUnit.measureUnitId}', '${product.shelfLife}','${product.basicPrice}')">
                                    <i class="bi bi-pen"></i>
                                </button>
                                <button type="button" class="btn delete-btn group-button">
                                    <a style="color: black" href="products/delete?id=${product.productId}">
                                        <i class="bi bi-trash"></i></a>
                                </button>
                            </div>
                        </td>
                    </sec:authorize>
                </tr>
            </C:forEach>
            </tbody>
        </table>

        <%--create start--%>
        <div class="modal" id="modal">
            <div class="modal-form">
                <span class="close" id="modal-close">&times</span>
                <h2 class="title">Create new product</h2>
                <form action="products/save" method="post">
                    <div class="aline-form">
                        <div class="edge">Enter product name
                            <input type="text" name="name" id="product-input" class="edge" placeholder="Product name"
                                   required>
                        </div>
                        <div class="edge">Enter measure unit
                            <select class="edge" name="measureUnit" required>
                                <C:forEach items="${measureUnits}" var="measureUnit">
                                    <option value="${measureUnit.measureUnitId}">${measureUnit.measureName}</option>
                                </C:forEach>
                            </select>
                        </div>
                        <div class="edge">Enter shelf life
                            <input type="text" name="shelfLife" id="shelfLife-input" class="edge"
                                   placeholder="Shelf life"
                                   required>
                        </div>
                        <div class="edge">Enter basic price
                            <input type="number" name="basicPrice"
                                   id="basicPrice-input" class="edge" placeholder="Basic price"
                                   required>
                        </div>
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
                <h2 class="title">Update existing product</h2>
                <form action="products/update" method="post">
                    <div class="aline-form">
                        <input type="text" id="edit-productId" name="productId"
                               value="${productId !=null ? productId : ''}" hidden>
                        <div class="edge">Product name
                            <input type="text" name="name" id="name-edit-input"
                                   value="${name  !=null ? name : ''}" class="edge"
                                   placeholder="name"
                                   required>
                        </div>
                        <div class="edge">Measure unit
                            <select name="measureUnit" id="measureUnit-edit-input" class="edge" required>
                                <C:forEach items="${measureUnits}" var="measureUnit">
                                    <option value="${measureUnit.measureUnitId}">${measureUnit.measureName}</option>
                                </C:forEach>
                            </select>
                        </div>
                        <div class="edge">Shelf life
                            <input type="text" name="shelfLife" id="shelfLife-edit-input"
                                   value="${shelfLife  !=null ? shelfLife : ''}" class="edge"
                                   placeholder="shelf-life"
                                   required>
                        </div>
                        <div class="edge">Basic price
                            <input type="text" name="basicPrice" id="basicPrice-edit-input"
                                   value="${basicPrice  !=null ? basicPrice : ''}"
                                   class="edge"
                                   placeholder="BasicPrice"
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="/js/product.js"></script>
</body>
</html>
