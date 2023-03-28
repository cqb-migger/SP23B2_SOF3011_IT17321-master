<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-8 offset-2">
  <form method="POST"
        action="/SP23B2_SOF3011_IT17321_war/hoadon-chitiet/update?ma=${hdct.ma}">
    <div class="row mt-3">
      <div class="col-6">
        <label>Mã</label>
        <input type="text" name="ma" class="form-control" value="${hdct.ma}" disabled/>
      </div>
      <div class="col-6">
        <label>Số lượng</label>
        <input type="text" name="so_luong" class="form-control" value="${ hdct.so_luong }" required/>
      </div>
    </div>
    <div class="row mt-3">
      <div class="col-12">
        <label>Đơn giá</label>
        <input type="text" name="don_gia" class="form-control" value="${hdct.don_gia}" required/>
      </div>
    </div>


    <div class="row mt-3">
      <div class="col-6">
        <button class="btn btn-primary">Sửa</button>
      </div>
      <div class="col-6"></div>
    </div>
  </form>
</div>

