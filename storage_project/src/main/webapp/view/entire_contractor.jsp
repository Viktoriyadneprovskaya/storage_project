<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

</head>
<body>
<div class="wrapper">
  <div class="block_left">
    <div class="logo">
      <img src="/pictures/logo.jpg">
      <a class="logo-style" href="products">STORAGE</a>
    </div>
    <div class="menu-style">
      <div class="btn-group aline">
        <button class="btn btn-secondary btn-lg strech" type="button">
          <a class="new-style" href="${pageContext.request.contextPath}/products">PRODUCTS</a>
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
          <div class="buttonStyle float-right">
            <button type="button" class="btn btn-secondary" onclick="openEditModal('${contractor.contractorId}', '${contractor.code}', '${contractor.contractorName}', '${contractor.contractNumber}', '${contractor.contractorType.contractorType}','${contractor.priceType.priceType}')">Edit contractor</button>
          </div>
          <div class="buttonStyle float-right">
            <button type="button" class="btn btn-secondary"><a href="/contractors/delete?id=${contractor.contractorId}&contrTypeId=${contractor.contractorType.contractorTypeID}">Delete contractor</a></button>
          </div>
        </div>
      </div>
      <h2>${contractor.contractorName.toUpperCase()} information</h2>
      <table class="table table-striped table-hover">
        <thead>
        <tr>
          <th scope="col">Name</th>
          <th scope="col">Code</th>
          <th scope="col">Contract number</th>
          <th scope="col">Contractor type</th>
          <th scope="col">Price type</th>
        </tr>
        </thead>
        <tbody>
          <tr>
            <td>${contractor.contractorName}</td>
            <td>${contractor.code}</td>
            <td>${contractor.contractNumber}</td>
            <td>${contractor.contractorType.contractorType}</td>
            <td>${contractor.priceType.priceType}</td>
          </tr>
        </tbody>
      </table>

    </br>
    </br>
      <h2>Address</h2>
      <table class="table table-striped table-hover">
        <thead>
        <tr>
          <th scope="col">Index</th>
          <th scope="col">Country</th>
          <th scope="col">City</th>
          <th scope="col">Address</th>
        </tr>
        </thead>
        <tbody>
          <tr>
            <td>${address.index}</td>
            <td>${address.country.countryName}</td>
            <td>${address.city.cityName}</td>
            <td>${address.street} ${address.houseNumber}</td>
          </tr>
        </tbody>
      </table>


      <%--edit start--%>
      <div class="modal" id="edit-modal">
        <div class="modal-form">
          <span class="close" id="edit-modal-close">&times</span>
          <h2 class="title">Update existing contractor</h2>
          <form action="/contractors/update" method="post">
            <div class="aline-form">
              <input type="text" id="edit-contractorId" name="contractorId"
                     value="${contractorId !=null ? contractorId : ''}" hidden>
              <%--                    <span class="error" id="error-username">Username is not valid, enter at least 4 symbols</span>--%>
              <%--              <span class="error ${errors['username'] != null ? 's-visible' : ''}" id="error-edit-username">Username is not valid, enter at least 4 symbols</span>--%>
              <div class="edge">Code
                <input type="text" name="code" id="code-edit-input"
                       value="${code !=null ? code : ''}" class="edge"
                       placeholder="code"
                <%--                           onblur="firstNameValidation()"--%>
                       required>
              </div>
              <div class="edge">Contractor name
                <input type="text" name="contractorName" id="contractorName-edit-input"
                       value="${contractorName  !=null ? contractorName : ''}" class="edge"
                       placeholder="name"
                <%--                           onblur="usernameValidation()"--%>
                       required>
              </div>
              <%--                    <span class="error" id="error-lastname">Lastname shouldn't be empty and should contain only characters</span>--%>
              <%--              <span class="error ${errors['firstname'] != null ? 's-visible' : ''}" id="error-edit-firstname">Firstname shouldn't be empty and should contain only characters</span>--%>
              <div class="edge">Contract number
                <input type="text" name="contractNumber" id="contractNumber-edit-input"
                       value="${contractNumber  !=null ? contractNumber : ''}" class="edge"
                       placeholder="contract number"
                <%--                           onblur="lastNameValidation()"--%>
                       required>
              </div>
              <%--                    <span class="error" id="error-lastname">Lastname shouldn't be empty and should contain only characters</span>--%>
              <%--              <span class="error ${errors['lastname'] != null ? 's-visible' : ''}" id="error-edit-lastname">Lastname shouldn't be empty and should contain only characters</span>--%>
              <div class="edge">Contractor type
                <select name="contractorType" id="contractorType-edit-input"  class="edge" required>
                  <C:forEach items="${contractorTypes}" var="contractorType">
                    <option value="${contractorType.contractorTypeID}" ${contractorType.contractorTypeID == contractor.contractorType.contractorTypeID ? 'selected = "selected"': ''}>${contractorType.contractorType}</option>
                  </C:forEach>
                </select>
              </div>
              <%--                    <span class="error" id="error-email">Enter correct email</span>--%>
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