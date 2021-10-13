<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
       <style>
.btn:hover{
     color: #fff;
    background-color: #e77e24 !important;
    border-color: #285e8e; 
}  </style>
    </head>
    <body>
        <jsp:include page="views/Menu.jsp"></jsp:include>
        <c:choose>
        	<c:when test="${param.maThuongHieu == null && param.maSP == null || param.txtsearch != null}">
        		<jsp:include page="views/Header.jsp"></jsp:include>
        	</c:when>
        </c:choose>
        
            <div class="container">
                <div class="row">
                    <div class="col">
                        <nav aria-label="breadcrumb" style="margin: 5px">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                                <li class="breadcrumb-item"><a href="#">Category</a></li>
                                <li class="breadcrumb-item active" aria-current="#">Sub-category</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
               <jsp:include page="views/Left.jsp"></jsp:include>

                    <div class="col-sm-9">
                       
                        <c:choose>
						<c:when test="${param.maThuongHieu != null }">
							<jsp:include page="views/Browser.jsp"></jsp:include>
						</c:when>
						<c:when test="${param.maSP != null }">
							<jsp:include page="views/Detail.jsp"></jsp:include>
						</c:when>
						<c:when test="${param.txtsearch != null }">
							<c:if test="${kq==1 }">
								<jsp:include page="views/Search.jsp"></jsp:include>
							</c:if>
							<c:if test="${kq!=1 }">
								<p>${mess }</p>
							</c:if>
						</c:when>
						<c:otherwise>
							<jsp:include page="views/SanPham.jsp"></jsp:include>
						</c:otherwise>
					</c:choose>
                    </div>
                </div>

            </div>
      

        <jsp:include page="Footer.jsp"></jsp:include>

    </body>
</html>

