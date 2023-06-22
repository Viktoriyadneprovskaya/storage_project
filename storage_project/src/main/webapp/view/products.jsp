<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Products</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
  <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
  <link rel="stylesheet" href="/css/main_page.css">
  <link rel="stylesheet" href="/css/product.css">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="wrapper">
  <div class="block_left">
    <div class="logo">
      <img src="/pictures/logo.jpg">
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
          <li><a class="dropdown-item" href="#">Input documents</a></li>
          <li><a class="dropdown-item" href="outDocServlet">Output documents</a></li>
          <li><a class="dropdown-item" href="#">Write-off documents</a></li>
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
          <li><a class="dropdown-item" href="contractors?id=1">Suppliers</a></li>
          <li><a class="dropdown-item" href="contractors?id=2">Customers</a></li>
          <li><a class="dropdown-item" href="contractors?id=3">My organisation</a></li>
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

      <!--    </div>-->
    </div>
  </div>
  <div class="block_center">
    <div class="bar">
      <div class="btn-group cntr-grp">
        <button actype="button" class="btn btn dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
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
        <button type="button" class="btn btn-secondary btn-lg " id="add-btn">+ Add Product</button>
      </div>
      <table class="table table-striped table-hover">
        <thead>
        <tr>
          <th scope="col">Product name</th>
          <th scope="col">Measure unit</th>
          <th scope="col">Shelf life</th>
          <th scope="col">Basic price</th>
          <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <C:forEach items="${products}" var="product">
          <tr>
            <td>${product.name}</td>
            <td>${product.measureUnit.measureName}</td>
            <td>${product.shelfLife}</td>
            <td>${product.basicPrice}</td>
            <td>
              <div class="btn-group" role="group" aria-label="Basic example">
                <button type="button" class="btn btn-primary edit-btn"
                        onclick="openEditModal('${product.productId}', '${product.measureUnit.measureName}', '${product.shelfLife}', '${product.basicPrice}')">
                  <i class="bi bi-pen"></i>
                </button>
                <button type="button" class="btn btn-primary delete-btn">
                  <a href="delete?id=${product.productId}">
                    <i class="bi bi-trash"></i></a>
                </button>
              </div>
            </td>
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
              <input type="text" name="name" id="product-input" class="edge" placeholder="Product name"
<%--                     onblur="usernameValidation()" --%>
                     required>
<%--              <span class="error" id="error-username">Username is not valid, enter at least 4 symbols</span>--%>
              <input type="text" name="measureUnit" id="measureUnit-input" class="edge" placeholder="Measure unit"
<%--                     onblur="passwordValidation()" --%>
                     required>
<%--              <span class="error" id="error-password">Password</span>--%>
              <input type="text" name="shelfLife" id="shelfLife-input" class="edge" placeholder="Shelf life"
<%--                     onblur="firstNameValidation()" --%>
                     required>
<%--              <span class="error" id="error-firstname">Firstname shouldn't be empty and should contain only characters</span>--%>
              <input type="number" groupingUsed="false" maxFractionDigits="2" name="basicPrice" id="basicPrice-input" class="edge" placeholder="Basic price"
<%--                     onblur="lastNameValidation()" --%>
                     required>
<%--              <span class="error" id="error-lastname">Lastname shouldn't be empty and should contain only characters</span>--%>
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
              <input type="text" id="edit-productId" name="productId" value="${productId !=null ? ProductId : ''}" hidden>
              <input type="text" name="name" id="name-edit-input"
                     value="${name  !=null ? name : ''}" class="edge"
                     placeholder="name"
              <%--                           onblur="usernameValidation()"--%>
                     required>
              <%--                    <span class="error" id="error-username">Username is not valid, enter at least 4 symbols</span>--%>
<%--              <span class="error ${errors['username'] != null ? 's-visible' : ''}" id="error-edit-username">Username is not valid, enter at least 4 symbols</span>--%>
              <input type="text" name="measureUnit" id="measureUnit-edit-input"
                     value="${measureUnit.measureName !=null ? measureUnit.measureName : ''}" class="edge"
                     placeholder="measureUnit"
              <%--                           onblur="firstNameValidation()"--%>
                     required>
              <%--                    <span class="error" id="error-lastname">Lastname shouldn't be empty and should contain only characters</span>--%>
<%--              <span class="error ${errors['firstname'] != null ? 's-visible' : ''}" id="error-edit-firstname">Firstname shouldn't be empty and should contain only characters</span>--%>
              <input type="text" name="shelfLife" id="shelfLife-edit-input"
                     value="${shelfLife  !=null ? shelfLife : ''}" class="edge"
                     placeholder="shelf-life"
              <%--                           onblur="lastNameValidation()"--%>
                     required>
              <%--                    <span class="error" id="error-lastname">Lastname shouldn't be empty and should contain only characters</span>--%>
<%--              <span class="error ${errors['lastname'] != null ? 's-visible' : ''}" id="error-edit-lastname">Lastname shouldn't be empty and should contain only characters</span>--%>
              <input type="number" groupingUsed="false" maxFractionDigits="2" name="basicPrice" id="basicPrice-edit-input" value="${basicPrice  !=null ? basicPrice : ''}"
                     class="edge"
                     placeholder="BasicPrice"
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
</div>
</div>
<script src="/js/product.js"></script>
</body>
</html>
