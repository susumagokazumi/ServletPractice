<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<html>

<head>
<%--
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
  content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
  href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
  integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
  crossorigin="anonymous">
 --%>
<title>注文データリスト</title>
</head>

<body>
  <h2>顧客テーブルリスト</h2>
  <form action="customerListop" method="post">

    <table>
      <tr>
        <th>顧客ID</th>
        <th>顧客名</th>
      </tr>
       <c:forEach items="${customerList}" var="customer">
      <tr>
        <td><label class="form-check-label" for="check">${customer.customerId}</label></td>
      <td><c:out value="${customer.customerName}" /></td>
    
       </c:forEach>
    </table>
    <br>
    <div class="row center-block text-center">
      <div class="col-1">
        <button type="button" id="add"
          class="btn btn-outline-primary btn-block">追加</button>
      </div>
      <div class="col-1">
        <button type="button" id="return"
          class="btn btn-outline-secondary btn-block"
          onclick="history.back()">戻る</button>
      </div>
    </div>
<%--
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
      integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
      crossorigin="anonymous"></script>
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
      integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
      crossorigin="anonymous"></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
      integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
      crossorigin="anonymous"></script>
 --%>
    <script type="text/javascript">
$('#add').on('click', function() {
    alert("追加");
    location.href="/alphasweb/customerSave"

});
</script>
  </form>
</body>
</html>
