

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Add Accountt</title>

</head>
<style>
img {
	width: 200px;
	height: 120px;
}
</style>
<body>

	<form class="form-horizontal" action="editAccount" method="post">
		<fieldset>

			<!-- Form Name -->
			<legend align="center" >EDIT ACCOUNT</legend>
			<c:if test="${alert !=-1 }">
				<div class="alert alert-${alert==1?"success":"danger" }" role="alert">${o.tenTK } ${alert==1?"edit success":"edit fail" }</div>
			</c:if>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="product_name_fr">user Name</label>
				<div class="col-md-4">
					<input name="userName" value="${o.tenTK }"
						class="form-control input-md" type="text" readonly="readonly">
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="product_name_fr">Full Name</label>
				<div class="col-md-4">
					<input name="fullName" value="${o.ten }" class="form-control input-md" required="" type="text">
				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="product_categorie">giới tính</label>
				<div class="col-md-4">
					<select name="phai">
						<c:if test="${o.phai ==0}">
							<option value="0" selected="selected">nam</option>
							<option value="1">nu</option>
						</c:if>
						<c:if test="${o.phai ==1}">
							<option value="0">nam</option>
							<option value="1" selected="selected">nu</option>
						</c:if>
					</select>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="product_weight">Phone Number</label>
				<div class="col-md-4">
					<input name="phone" value="${o.sdt }" class="form-control input-md" type="text" required="">
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="percentage_discount">Mail</label>
				<div class="col-md-4">
					<input name="mail" value="${o.mail }" class="form-control input-md" type="text" required="">
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="percentage_discount">Address</label>
				<div class="col-md-4">
					<input name="address" value="${o.dc }" class="form-control input-md" required="" type="text">
				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="product_categorie">Is Admin</label>
				<div class="col-md-4">
					<select name="isAdmin">
						<c:if test="${o.isAdmin ==0}">
							<option value="0" selected="selected">not admin</option>
							<option value="1">nu</option>
						</c:if>
						<c:if test="${o.isAdmin ==1}">
							<option value="0">is admin</option>
							<option value="1" selected="selected">nu</option>
						</c:if>
					</select>
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton">Save Change</label>
				<div class="col-md-4">
					<button name="btedit" class="btn btn-primary">Save</button>
				</div>
			</div>


		</fieldset>
	</form>
		     <a href="account" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Back To Manager Account</a>

<script type="text/javascript">
window.setTimeout(function() {
    $(".alert").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove(); 
    });
}, 4000);
</script>
</body>
</html>