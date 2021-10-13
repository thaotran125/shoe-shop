

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">
            <c:forEach items="${dsth}" var="o">
               <a href="Browser.html?maThuongHieu=${o.maThuongHieu}" > <li class="list-group-item ${cid == o.maThuongHieu ? "active":""}"> ${o.tenThuongHieu}</li> </a>
            </c:forEach>

        </ul>
    </div>
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase" >Last product</div>
        <div class="card-body">
            <img class="img-fluid" src="image/${p.hinh}" />
            <h5 class="card-title show_txt text-wrap">
							<a href="Detail.html?maSP=${o.masp }" title="${o.tensp }">${o.tensp }</a>
			</h5>
            <p class="card-text">${p.title}</p>
            <p class="bloc_left_price">${p.gia} VND</p>
        </div>
    </div>
    </div>
    
