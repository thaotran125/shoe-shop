<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Manager Product</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="css/manager.css" rel="stylesheet" type="text/css" />
<style>
img {
	width: 200px;
	height: 120px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="table-wrapper">
		<c:if test="${alert !=-1 }">
			<div class="alert alert-${alert==1?"success":"danger" }" role="alert">${o.tensp } ${alert==1?"delete success":"delete fail" }</div>
		</c:if>
		<form action="delLstProduct" method="get">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>
							Manage <b>Product</b>
						</h2>
					</div>
					
					<div class="col-sm-6">
						<a href="./add.html" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>
                        <input class="btn btn-danger" type="submit" value="Delete" onclick="return confirm('Are you sure you want to delete');">
					</div>
				</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th><span class="custom-checkbox"> <input
								type="checkbox" id="selectAll"> <label for="selectAll"></label>
						</span></th>
						<th>ID</th>
						<th>thương hiệu</th>
						<th>tên sp</th>
						<th>giá</th>
						<th>giá giảm</th>
						<th>hình</th>
						<th>số lượng</th>
						<th>phái</th>
						<th>action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${dsp }" var="o">
						<tr>
							<td><span class="custom-checkbox"> <input
									type="checkbox" id="checkbox1" name="options" value="${o.masp }">
									<label for="checkbox1"></label>
							</span></td>
							<td>${o.masp }</td>


							<td><select name="loaisp" id="loaisp"
								autofocus="${th.tenThuongHieu } }">
									<c:forEach items="${dsth }" var="th">

										<c:if test="${o.maThuongHieu == th.maThuongHieu }">
											<option value="${th.maThuongHieu }" selected>${th.tenThuongHieu }</option>
										</c:if>
										<c:if test="${o.maThuongHieu != th.maThuongHieu }">
											<option value="${th.maThuongHieu }">${th.tenThuongHieu }</option>
										</c:if>

									</c:forEach>
							</select></td>
							<td>${o.tensp }</td>
							<td>${o.gia }</td>
							<td>${o.giaGiam }</td>
							<td><img src="./image/${o.hinh }" ></td>
							<td>1</td>
							<td>
								<select>
									<c:if test="${o.phai ==0}">
										<option value="0" selected="selected">nam</option>
										<option value="1">nu</option>
									</c:if>
									<c:if test="${o.phai ==1}">
										<option value="0">nam</option>
										<option value="1" selected="selected">nu</option>
									</c:if>

								</select>
							</td>
							<td>
							<a href="./editp.html?idp=${o.masp }" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a> 
								
								<a href="./deleteProudct.html?idp=${o.masp }" onclick="return confirm('Are you sure you want to delete');" class="delete" data-toggle="modal">
									<i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i>
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</form>
			<div class="clearfix">
				<div class="hint-text">
					Showing <b>5</b> out of <b>${tongsp}</b> entries
				</div>
				<ul class="pagination">
					<c:forEach begin="1" end="${tongSoTrang }" var="trang">
						<li class="page-item"><a class="page-link"
							href="product.html?trang=${trang }">${trang}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<a href="index.html" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Back to home</a>
	</div>

	<script type="text/javascript">
       
       $("#selectAll").click(function(){
    	    $('input:checkbox').not(this).prop('checked', this.checked);
    	});
       
       window.setTimeout(function() {
    	    $(".alert").fadeTo(500, 0).slideUp(500, function(){
    	        $(this).remove(); 
    	    });
    	}, 4000);
       </script>
</body>
</html>