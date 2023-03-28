<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="col-8 offset-2">
  <form method="POST"
        action="/SP23B2_SOF3011_IT17321_war/khach-hang/update?ma=${kh.ma}">
    <div class="row mt-3">
      <div class="col-6">
        <label>Mã</label>
        <input type="text" name="ma" class="form-control" value="${kh.ma}" disabled/>
      </div>
      <div class="col-6">
        <label>Họ</label>
        <input type="text" name="ho" class="form-control" value="${ kh.ho }" required />
      </div>
    </div>
    <div class="row mt-3">
      <div class="col-6">
        <label>Tên đệm</label>
        <input type="text" name="ten_dem" class="form-control" value="${ kh.ten_dem }"  required/>
      </div>
      <div class="col-6">
        <label>Tên</label>
        <input type="text" name="ten" class="form-control" value="${ kh.ten }" required/>
      </div>
    </div>
    <div class="row mt-3">
      <div class="col-6">
        <label>Ngày sinh</label>
        <input type="date" name="ngay_sinh" class="form-control" value="${ kh.ngay_sinh }" required />
      </div>
      <div class="col-6">
        <label>SDT</label>
        <input type="tel" name="sdt" class="form-control"  value="${ kh.sdt }" required/>
      </div>
    </div>
    <div class="row mt-3">
      <div class="col-6">
        <label>Địa chỉ</label>
        <input type="text" name="dia_chi" class="form-control" value="${ kh.dia_chi }" required/>
      </div>
      <div class="col-6">
        <label>Mật khẩu</label>
        <input type="password" name="mat_khau" class="form-control" value="${ kh.mat_khau }" required />
      </div>
    </div>
    <div class="row mt-3">
      <div class="col-6">
        <label>Quốc gia</label>
        <select name="quoc_gia" class="form-select" required>
          <option value="vi" ${ kh.quoc_gia == "vi" ? "selected" : "" }>Việt Nam</option>
          <option value="us" ${ kh.quoc_gia == "us" ? "selected" : "" }>Mỹ</option>
        </select>
      </div>
      <div class="col-6">
        <label>Thành phố</label>
        <select name="thanh_pho" class="form-select" required>
          <option value="hn" ${ kh.thanh_pho == "hn" ? "selected" : "" }>Hà Nội</option>
          <option value="ny" ${ kh.thanh_pho == "ny" ? "selected" : "" }>New York</option>
        </select>
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

