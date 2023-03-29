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
        <input type="text" name="tenDem" class="form-control" value="${ kh.tenDem }"  required/>
      </div>
      <div class="col-6">
        <label>Tên</label>
        <input type="text" name="ten" class="form-control" value="${ kh.ten }" required/>
      </div>
    </div>
    <div class="row mt-3">
      <div class="col-6">
        <label>Ngày sinh</label>
        <input type="date" name="ngaySinh" class="form-control" value="${ kh.ngaySinh }" required />
      </div>
      <div class="col-6">
        <label>SDT</label>
        <input type="tel" name="sdt" class="form-control"  value="${ kh.sdt }" required/>
      </div>
    </div>
    <div class="row mt-3">
      <div class="col-6">
        <label>Địa chỉ</label>
        <input type="text" name="diaChi" class="form-control" value="${ kh.diaChi }" required/>
      </div>
      <div class="col-6">
        <label>Mật khẩu</label>
        <input type="password" name="matKhau" class="form-control" value="${ kh.matKhau }" required />
      </div>
    </div>
    <div class="row mt-3">
      <div class="col-6">
        <label>Quốc gia</label>
        <select name="quocGia" class="form-select" required>
          <option value="vi" ${ kh.quocGia == "vi" ? "selected" : "" }>Việt Nam</option>
          <option value="us" ${ kh.quocGia == "us" ? "selected" : "" }>Mỹ</option>
        </select>
      </div>
      <div class="col-6">
        <label>Thành phố</label>
        <select name="thanhPho" class="form-select" required>
          <option value="hn" ${ kh.thanhPho == "hn" ? "selected" : "" }>Hà Nội</option>
          <option value="ny" ${ kh.thanhPho == "ny" ? "selected" : "" }>New York</option>
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

