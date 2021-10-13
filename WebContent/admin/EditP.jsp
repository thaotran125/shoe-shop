<%-- 
    Document   : ManagerProduct
    Created on : Dec 28, 2020, 5:19:02 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Edit Product</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
    </head>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    <body>
<c:if test="${alert !=-1 }">
	<div align="center" class="alert alert-${alert==1?"success":"danger" }" role="alert">product id=${o.masp } ${alert==1?"edit success":"edit fail" }</div>
</c:if>
<form class="form-horizontal" action="editp.html" method="post">
<fieldset>

<!-- Form Name -->
<legend>PRODUCTS</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="product_name_fr">ID</label>  
  <div class="col-md-4">
  <input id="id" name="id" value="${o.masp }" class="form-control input-md"  type="text" readonly="readonly"> 
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="product_name_fr">Tên sản phẩm</label>  
  <div class="col-md-4">
  <input id="name" name="name" value="${o.tensp }" class="form-control input-md" required="" type="text"> 
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="product_categorie">Thương hiệu</label>
  <div class="col-md-4">
    <select id="thuonghieu" name="thuonghieu" class="form-control">
    <c:forEach items="${dsth }" var="th">
        <c:if test="${o.maThuongHieu == th.maThuongHieu }">
           <option  value="${th.maThuongHieu }" selected>${th.tenThuongHieu }</option>
        </c:if>
        <c:if test="${o.maThuongHieu != th.maThuongHieu }">
           <option  value="${th.maThuongHieu }">${th.tenThuongHieu }</option>
        </c:if>                       		
   </c:forEach>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="available_quantity">Giá</label>  
  <div class="col-md-4">
  <input id="gia" name="gia" value="${o.gia }" class="form-control input-md" required="" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="product_weight">Gia Giảm</label>  
  <div class="col-md-4">
  <input id="giagiam" name="giagiam" value="${o.giaGiam }" class="form-control input-md" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="percentage_discount"> Số Lượng</label>  
  <div class="col-md-4">
  <input id="sl" name="sl" value="${o.sl }" class="form-control input-md" required="" type="text">
    
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
            <option value="0" >nam</option>
            <option value="1" selected="selected">nu</option>
       </c:if>                              	 
    </select>
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="product_description">Title</label>
  <div class="col-md-4">                     
    <textarea class="form-control" name="title" required="">${o.title }</textarea>
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="product_name_fr">Mô tả</label>
  <div class="col-md-4">                     
    <textarea class="form-control" id="mota" name="mota">${o.mota }</textarea>
  </div>
</div>

 <!-- File Button --> 
<div class="form-group">
  <label class="col-md-4 control-label" for="filebutton">main_image</label>
  <div class="col-md-4">
    <input id="hinh" name="hinh" class="input-file" type="file" value="${o.hinh }">
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton">Thêm Sản Phẩm</label>
  <div class="col-md-4">
    <button id="btadd" name="btadd" class="btn btn-primary">Save</button>
  </div>
</div>

</fieldset>
</form>
	     <a href="product.html" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Back To Manager Product</a>
    
<script type="text/javascript">
window.setTimeout(function() {
    $(".alert").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove(); 
    });
}, 4000);
</script>
</body>
</html>