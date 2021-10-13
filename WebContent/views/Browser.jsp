<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-sd-9">
	<div id="content" class="row">
		<c:forEach items="${arrp }" var="o">
			<div class="product col-12 col-md-6 col-lg-4">
				<div class="card">
					<img class="card-img-top" src="image/${o.hinh }" alt="${o.tensp }">
					<div class="card-body">
						<h5 class="card-title show_txt text-wrap">
							<a href="Detail.html?maSP=${o.masp }" title="${o.tensp }">${o.tensp }</a>
						</h5>
							<div class="stars">
								<i class="fa fa-star blue-star" style="color: orange;" aria-hidden="true"></i>
								<i class="fa fa-star blue-star" style="color: orange;" aria-hidden="true"></i>
								<i class="fa fa-star blue-star" style="color: orange;" aria-hidden="true"></i>
								<i class="fa fa-star blue-star" style="color: orange;" aria-hidden="true"></i>
								<i class="fa fa-star gray-star" aria-hidden="true"></i>
							</div>
							<p class="card-text show_txt">đã bán ${o.sl }</p>
					
								<div class="col clearfix">
									<p class="">${o.giaGiam }<span style=" text-decoration: line-through;"> ${o.gia }</span> </p>
								</div>
								<div class="col">
									<a href="cart.html?id=${o.masp }" class="btn" style="background-color:#3399cc; color: #fff; font-weight: bold;">Add to cart</a>
								</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

	<div class="pagination">
		<c:forEach begin="1" end="${tongSoTrang }" var="trang">
			<li class="page-item"><a class="page-link"
				href="index.html?trang=${trang }">${trang}</a></li>
		</c:forEach>
	</div>
</div>