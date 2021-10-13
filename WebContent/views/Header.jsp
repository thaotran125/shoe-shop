<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <style>
  /* Make the image fully responsive */
  .carousel-inner img {
    width: 100%;
    height: 100%;
  }
  

  </style>
<div id="demo" class="carousel slide" data-ride="carousel" style="margin-bottom: 20px">

  <!-- Indicators -->
  
  
  <!-- The slideshow -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="image/banner1.jpg" alt="" width="1100" height="500">
      <div class="carousel-caption d-none d-md-block">
      	<h5>Shop Shoe</h5>
      	<p>Mang theo su uy tin</p>
  	  </div>
    </div>
    <div class="carousel-item">
      <img src="image/banner2.jpg" alt="" width="1100" height="500">
    </div>
    <div class="carousel-item">
      <img src="image/banner3.jpg" alt="" width="1100" height="500">
      <div class="carousel-caption d-none d-md-block">
      	<a class="btn btn-primary" href="cart.html?id=27" role="button">Add Cart</a>
      	<p>Mang theo su uy tin</p>
  	  </div>
    </div>
  </div>
  
  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>
<script>
$( document ).ready(function(){
    $('.carousel').carousel({
      interval: 3000
    })
});
</script>