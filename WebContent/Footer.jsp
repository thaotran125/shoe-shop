<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Footer -->
<footer class="text-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-lg-4 col-xl-3">
                <h5>Shop Shoe</h5>
                <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                <div><i class='fas fa-map-marker-alt' style="line-height: 2.1;"></i> 101 đõ xuân hợp, phước long b, quận 9,tp>HCM</div>
                <div><i class='fas fa-map-marker-alt' style="line-height: 2.1;"></i> 102 hùng vương, phường 6, tp Mỹ Tho, Tiền Giang</div>
                <div><i class='fas fa-map-marker-alt' style="line-height: 2.1;"></i> 877B, tân thới, tân phú đông, tiền giang</div>
                <div><i class='fas fa-phone' style="line-height: 2.1;"></i> 0399551234</div>
                <div><i class="fa fa-envelope" style="line-height: 2.1;"></i> shop1shoe@gmail.com</div>
            </div>

            <div class="col-md-2 col-lg-2 col-xl-2 mx-auto">
                <h5>HƯỚNG DẪN</h5>
                <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                <ul class="list-unstyled">
                    <li><a href="#">HƯỚNG DẪN MUA HÀNG</a></li>
                    <li><a href="#">GIAO NHẬN VÀ THANH TOÁN</a></li>
                    <li><a href="#">ĐỔI TRẢ VÀ BẢO HÀNH</a></li>
                    <li><a href="#">ĐĂNG KÍ THÀNH VIÊN</a></li>
                </ul>
            </div>

            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto">
                <h5>CHÍNH SÁCH</h5>
                <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                <ul class="list-unstyled" >
                    <li><a href="#">CHÍNH SÁCH ĐỔI HÀNG</a></li>
                    <li><a href="#">CHÍNH SÁCH BẢO HÀNH</a></li>
                    <li><a href="#">CHÍNH SÁCH THANH TOÁN</a></li>
                    <li><a href="#">HÌNH THỨC VẬN CHUYỂN</a></li>
                    <li><a href="#">CHÍNH SÁCH BẢO MẬT</a></li>
                </ul>
            </div>

            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto">
                <h5>THƯƠNG HIẸU</h5>
                <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                <ul class="list-unstyled" >
                    <c:forEach items="${dsth}" var="o">
               			<a href="Browser.html?maThuongHieu=${o.maThuongHieu}" style="text-transform: uppercase;"> <li> ${o.tenThuongHieu}</li> </a>
            		</c:forEach>
                </ul>
            </div>
            <div class="col-12 copyright mt-3">
                <p class="float-left">
                    <a href="#">Back to top</a>
                </p>
                <p class="text-right text-muted">created with <i class="fa fa-heart"></i> by <a href="https://t-php.fr/43-theme-ecommerce-bootstrap-4.html"><i>tui</i></a> | <span>v. 1.0</span></p>
            </div>
        </div>
    </div>
</footer>