<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<h2>メニュー</h2>
<h4>ようこそ &nbsp; ${user.userName} &nbsp; さん</h4>
<a href="/alphasweb/customerList">顧客リスト</a> <br><br>
<a href="/alphasweb/prodList">商品リスト</a> <br><br>
<a href="/alphasweb/orderList">注文データ</a> <br><br>

<div class="row center-block text-center">
      <div class="col-1">
        <input type="submit" id="logout" class="btn btn-outline-primary btn-block" value="ログアウト">
      </div>
      </div>
      

<script type="text/javascript" >
$('#logout').on('click', function() {
    location.href="/alphasweb-main/src/com/alphacmc/alphasweb/servlet/LogoutServlet.java"
      
});

</script>


</body>
</html>

