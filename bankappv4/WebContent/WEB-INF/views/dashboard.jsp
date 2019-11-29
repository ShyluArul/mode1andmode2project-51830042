<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>

.column {
  float: center;
  width: 33.33%;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
In this example</style>
<body>

<h3>Welcome ${username}</h3> 
<sec:authorize access="hasAnyRole('ROLE_ADMIN')"> 

<div class="row">
  <div class="column"></div>
  <div class="column">
  <h4>User Management</h4>
  <br />
  <div class="btn-group-vertical" style="position:relative;float:center;">

<a href="admin/adduser" class="btn btn-primary btn-lg active" role="button">Add new user</a>

 <a href="admin/allusers" class="btn btn-primary btn-lg active" role="button">Update user</a>

<a href="admin/allusers" class="btn btn-primary btn-lg active" role="button">Delete user</a>

<a href="admin/allusers" class="btn btn-primary btn-lg active" role="button">List User Details</a>

</div>	</div>
  <div class="column"></div>
</div>

</sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_MGR')"> 
<div class="row">
  <div class="column"></div>
  <div class="column">
  <h4>Account Management</h4>
  <br />
  <div class="btn-group-vertical" style="position:relative;float:center;">

<a href="mgr/allaccounts" class="btn btn-primary btn-lg active" role="button">List All Account</a>

 <a href="mgr/addaccount" class="btn btn-primary btn-lg active" role="button">Add new Account</a>

<a href="mgr/allaccounts" class="btn btn-primary btn-lg active" role="button">Update Account</a>

<a href="mgr/allaccounts" class="btn btn-primary btn-lg active" role="button">Delete Account</a>

</div>	</div>
  <div class="column"></div>
</div>
</sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_CLERK')"> 
<div class="row">
  <div class="column"></div>
  <div class="column">
  <h4>Transaction Management</h4>
  <br />
  <div class="btn-group-vertical" style="position:relative;float:center;">

<a href="clerk/allaccounts" class="btn btn-primary btn-lg active" role="button">List All Accounts</a>

 <a href="clerk/transfer" class="btn btn-primary btn-lg active" role="button">Transfer</a>

<a href="clerk/withdraw" class="btn btn-primary btn-lg active" role="button">Withdraw</a>

<a href="clerk/deposit" class="btn btn-primary btn-lg active" role="button">Deposit</a>

</div>	</div>
  <div class="column"></div>
</div>
</sec:authorize>
<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<c:if test="${pageContext.request.userPrincipal.name != null}">
	<div 
    style="width:40px;
    height:auto;
    padding:150px 120px 140px 180px;
    text-align:center;
    top:0;
    position:relative;float:right;">

    <a href="javascript:document.getElementById('logout').submit()" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-log-out"></span> Log out
        </a>

</div>
	
	
</c:if>



</body>
</html>