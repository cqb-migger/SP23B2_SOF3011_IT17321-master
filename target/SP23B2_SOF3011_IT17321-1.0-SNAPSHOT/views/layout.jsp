<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Quản lý</title>
  <link rel="stylesheet"
        href="/SP23B2_SOF3011_IT17321_war/css/bootstrap.min.css" />
</head>
<body>
<div class="mt-5">
  <h1 class="text-center">Quản lý</h1>
</div>
<nav class="navbar navbar-expand-lg bg-primary mt-5 ">
  <div class="container-fluid">
    <a class="navbar-brand text-bg-primary" href="/SP23B2_SOF3011_IT17321_war">IT17321</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <form class="d-flex" role="search">
      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-light" type="submit">Search</button>
    </form>
  </div>
</nav>
<div class="row bg-dark text-white position-relative overflow-hidden" style="min-height: 200px;">
  <img class="img-fluid"  style="position: absolute; top: 0; left: 0; width: 100%; height: 100%;" src="/SP23B2_SOF3011_IT17321_war/img/image.png" alt="" >
</div>
<div class="row mt-4" style="min-height: 500px;">
  <div class="col-1  row " >
    <div class="col-12">
      <a href="/SP23B2_SOF3011_IT17321_war/chuc-vu/index" class="ms-2 btn btn-primary">Quản lý chức vụ </a>
    </div>
    <div class="col-12">
      <a href="/SP23B2_SOF3011_IT17321_war/cua-hang/index" class="ms-2 mt-2 btn btn-primary">Quản lý cửa hàng</a>
    </div>
    <div class="col-12">
      <a href="/SP23B2_SOF3011_IT17321_war/nhan-vien/index" class="ms-2 mt-2 btn btn-primary">Quản lý nhân viên</a>
    </div>
    <div class="col-12">
      <a href="/SP23B2_SOF3011_IT17321_war/khach-hang/index" class="ms-2 mt-2 btn btn-primary">Quản lý khách hàng</a>
    </div>
    <div class="col-12">
      <a href="/SP23B2_SOF3011_IT17321_war/hoa-don/index" class="ms-2 mt-2 btn btn-primary">Quản lý hóa đơn</a>
    </div>
    <div class="col-12">
      <a href="/SP23B2_SOF3011_IT17321_war/san-pham/index" class="ms-2 mt-2 btn btn-primary">Quản lý sản phẩm</a>
    </div>
    <div class="col-12">
      <a href="/SP23B2_SOF3011_IT17321_war/nsx/index" class="ms-2 mt-2 btn btn-primary">Quản lý nhà sản xuất</a>
    </div>
    <div class="col-12">
      <a href="/SP23B2_SOF3011_IT17321_war/mau-sac/index" class="ms-2 mt-2 btn btn-primary">Quản lý màu sắc</a>
    </div>
    <div class="col-12">
      <a href="/SP23B2_SOF3011_IT17321_war/dong-sp/index" class="ms-2 mt-2 btn btn-primary">Quản lý dòng sản phẩm</a>
    </div>
    <div class="col-12">
      <a href="/SP23B2_SOF3011_IT17321_war/chitiet-sp/index" class="ms-2 mt-2 btn btn-primary">Quản lý chi tiết sản phẩm</a>
    </div>
    <div class="col-12">
      <a href="/SP23B2_SOF3011_IT17321_war/hoadon-chitiet/index" class="ms-2 mt-2 btn btn-primary">Quản lý hóa đơn chi tiết</a>
    </div>
  </div>
  <div class="col-11">
    <jsp:include page="${ view }" />
  </div>
</div>


<script src="/SP23B2_SOF3011_IT17321_war/js/bootstrap.min.js"></script>
</body>
</html>
