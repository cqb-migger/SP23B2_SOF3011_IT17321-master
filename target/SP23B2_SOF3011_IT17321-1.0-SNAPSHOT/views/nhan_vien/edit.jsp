<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="col-8 offset-2">
  <form method="POST"
        action="/SP23B2_SOF3011_IT17321_war/nhan-vien/update?ma=${nv.ma}">
    <div class="row mt-3">
      <div class="col-6">
        <label>Mã</label>
        <input type="text" name="ma" class="form-control" value="${nv.ma}" disabled/>
      </div>
      <div class="col-6">
        <label>Họ</label>
        <input type="text" name="ho" class="form-control" value="${ nv.ho }" required/>
      </div>
    </div>
    <div class="row mt-3">
      <div class="col-6">
        <label>Tên đệm</label>
        <input type="text" name="ten_dem" class="form-control" value="${ nv.ten_dem }" required />
      </div>
      <div class="col-6">
        <label>Tên</label>
        <input type="text" name="ten" class="form-control" value="${ nv.ten }" required />
      </div>
    </div>
    <div class="row mt-3">
      <div class="col-6">
        <label>Ngày sinh</label>
        <input type="date" name="ngay_sinh" class="form-control" value="${ nv.ngay_sinh }" required/>
      </div>
      <div class="col-6">
        <label>SDT</label>
        <input type="tel" name="sdt" class="form-control"  value="${ nv.sdt }" required/>
      </div>
    </div>
    <div class="row mt-3">
      <div class="col-6">
        <label>Địa chỉ</label>
        <input type="text" name="dia_chi" class="form-control" value="${ nv.dia_chi }" required/>
      </div>
      <div class="col-6">
        <label>Giới tính</label>
        <input class="form-check" type="radio" name="gioi_tinh" value="true" checked/>Nam
        <input class="form-check" type="radio" name="gioi_tinh" value="false"/>Nữ
      </div>
    </div>
    <div class="row mt-3">
      <div class="col-6 row">
        <label>Trạng thái</label>
        <input class="form-check col-5" type="radio" name="trang_thai" value="true" checked/> <label class="col-1">Làm</label>
        <input class="form-check col-5" type="radio" name="trang_thai" value="false"/><label class="col-1">Nghỉ</label>
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


