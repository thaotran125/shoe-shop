<%-- 
    Document   : ManagerProduct
    Created on : Dec 28, 2020, 5:19:02 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add Product</title>

<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="css/manager.css" rel="stylesheet" type="text/css" />
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<style>
img {
	width: 200px;
	height: 120px;
}
</style>
<body>

	<form class="form-horizontal" action="add.html" method="post">
		<fieldset>

			<!-- Form Name -->
			<legend>PRODUCTS</legend>

			<c:if test="${alert !=-1 }">
				<div class="alert alert-${alert==1?"success":"danger" }" role="alert">${alert==1?"insert product success":"insert fail" }</div>
			</c:if>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="product_name_fr">Tên
					sản phẩm</label>
				<div class="col-md-4">
					<input id="name" name="name" placeholder="name product" required="" class="form-control input-md" type="text">

				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="product_categorie">Thương hiệu</label>
				<div class="col-md-4">
					<select id="thuonghieu" name="thuonghieu" class="form-control">
						<c:forEach items="${dsth }" var="th">
							<option value="${th.maThuongHieu }">${th.tenThuongHieu }</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="available_quantity">Giá</label>
				<div class="col-md-4">
					<input id="gia" name="gia" placeholder="Price" class="form-control input-md" type="text" required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="product_weight">Gia Giảm</label>
				<div class="col-md-4">
					<input id="giagiam" name="giagiam" placeholder="Price sale" class="form-control input-md" type="text" required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="percentage_discount">
					Số Lượng</label>
				<div class="col-md-4">
					<input id="sl" name="sl" placeholder="amount" class="form-control input-md" type="text" required="">

				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="product_categorie">giới tính</label>
				<div class="col-md-4">
					<select id="phai" name="phai" class="form-control">
						<option value="0">Nam</option>
						<option value="1">Nư</option>
					</select>
				</div>
			</div>

			<!-- Textarea -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="product_description">Title</label>
				<div class="col-md-4">
					<textarea class="form-control" name="title" required="" rows="4"></textarea>
				</div>
			</div>

			<!-- Textarea -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="product_name_fr" >Mô tả</label>
				<div class="col-md-4">
					<textarea class="form-control" id="mota" name="mota" required="" rows="5"></textarea>
				</div>
			</div>

			<!-- File Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="filebutton">main_image</label>
				<div class="col-md-4">
					<input id="hinh" name="hinh" class="input-file" type="file">
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton">Thêm Sản Phẩm</label>
				<div class="col-md-4">
					<button id="btadd" name="btadd" class="btn btn-primary">Add</button>
				</div>
			</div>

		</fieldset>
	</form>
	     <a href="product.html" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Back To Manager Product</a>


	<script type="text/javascript">
		window.setTimeout(function() {
			$(".alert").fadeTo(500, 0).slideUp(500, function() {
				$(this).remove();
			});
		}, 4000);
	</script>
</body>
</html>