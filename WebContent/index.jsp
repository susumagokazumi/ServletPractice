<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>

<body>
<header>
<h6>ユーザー名：${user.userName}<br>ユーザーID：${user.userId}</h6>

</header>
<h2>メニュー</h2>
<br>
<h3>ようこそ&nbsp; ${user.userName} &nbsp;さん</h3>
<br>
<a href="/alphasweb/customerList">顧客リスト</a> <br><br>
<a href="/alphasweb/prodList">商品リスト</a> <br><br>
<a href="/alphasweb/orderList">注文データ</a> <br><br>
<a href="/alphasweb/logout">ログアウト</a> <br><br>

</body>
</html>

