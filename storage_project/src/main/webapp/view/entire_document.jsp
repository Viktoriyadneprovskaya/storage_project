<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Document info</title>
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
                <button class="btn btn-secondary btn-lg dropdown-toggle strech" type="button" data-bs-toggle="dropdown" aria-expanded="false">
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
                <button class="btn btn-secondary btn-lg dropdown-toggle strech" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    CONTRACTORS
                </button>
                <ul id="myDropdown" class="dropdown-menu">
                    <li><a class="dropdown-item" href="/contractors?contrTypeId=1">Suppliers</a></li>
                    <li><a class="dropdown-item" href="/contractors?contrTypeId=2">Customers</a></li>

                </ul>
            </div>
            <div class="btn-group aline">
                <button class="btn btn-secondary btn-lg strech" type="button">
                    <a class="new-style" href="/employees">EMPLOYEES</a>
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
                        <button type="button" class="btn btn-secondary"><a href="/entire_document/update?document_id=${document.documentId}">Edit document</a></button>
                    </div>
                    <div class="buttonStyle float-right">
                        <button type="button" class="btn btn-secondary"><a href="/documents/delete?id=${document.documentId}">Delete document</a></button>
                    </div>

            </div>
            </div>
            <div class="document-title">
                <h2>${document.invoiceType.invoiceType.toUpperCase()} document #${document.documentId} from ${document.creationDate}</h2>
            </div>
            <div class="grid-container">
                <div>${document.contractor.contractorType.contractorType.toUpperCase()}</div>
                <div>${document.contractor.contractorName}</div>
                <div>MY ORGANIZATION:</div>
                <div>${document.myOrganization.name}</div>
                <div>CONTRACT NUMBER:</div>
                <div>${document.contractor.contractNumber}</div>
                <div>MY ORGANIZATION ADDRESS:</div>
                <div>${document.myOrganization.address}</div>
            </div>

            <div class="entire-line">
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
                <div>
                    <strong>Price, hrn/kg</strong>
                </div>
                <div>
                    <strong>Sum, hrn</strong>
                </div>
                <%int number = 1; %>
            <C:forEach items="${doc_details}" var="doc_detail">
                <div><%=number++%></div>
                <div>${doc_detail.product.name}</div>
                <div>${doc_detail.unit.measureName}</div>
                <div>${doc_detail.quantity}</div>
                <div>${doc_detail.price}</div>
                <div>${doc_detail.sum}</div>
            </C:forEach>
            </div>
            <div class="sum">Total sum: ${sum}hrn</div>
            <button type="submit" class="btn btn-light edge">PRINT</button>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>