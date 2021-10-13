<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin of menu-->
<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="index.html">Shoes</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                
               
                <c:if test="${tk.isAdmin ==1 }">
                	<li class="nav-item">
                    	<a class="nav-link" href="account">Manager Account</a>
               		</li>
                </c:if>
                <c:if test="${tk.isAdmin ==1 }">
                	<li class="nav-item">
                    	<a class="nav-link" href="product.html">Manager Product</a>
                	</li>
                </c:if>
                <c:if test="${tk !=null }">
                	<li class="nav-item">
                    	<a class="nav-link" href="#">Hello ${tk.ten }</a>
                	</li>
                </c:if>
                <c:if test="${tk !=null }">
                	<li class="nav-item">
                    	<a class="nav-link" href="logout.html">Logout</a>
                	</li>
                </c:if>
                 <c:if test="${tk ==null }">
                	<li class="nav-item">
                    <a class="nav-link" href="views/Login.jsp">Login</a>
                	</li>
                </c:if>
                
                <li>
                <div class="dropdown show">
               		<a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   				 		Shop
  					</a>
  					<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    					<c:forEach items="${dsth}" var="o">
               				<a class="dropdown-item" href="Browser.html?maThuongHieu=${o.maThuongHieu}" >${o.tenThuongHieu}</a>
            			</c:forEach>
  					</div>
  				</div>
            	</li>
            </ul>

            <form action="search.html" method="get" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input name="txtsearch" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <a class="btn btn-primary btn-sm ml-3" href="showcart.html">
                    <i class="fa fa-shopping-cart"></i> Cart
                    <span class="badge badge-light">3</span>
                </a>
            </form>
        </div>
    </div>
</nav>
<!--end of menu-->
