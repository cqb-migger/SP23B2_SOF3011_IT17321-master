<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="col-8 offset-2">
    <form method="POST"
          action="/SP23B2_SOF3011_IT17321_war/nhan-vien/store">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control"  required/>
            </div>
            <div class="col-6">
                <label>Họ</label>
                <input type="text" name="ho" class="form-control"  required />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Tên đệm</label>
                <input type="text" name="ten_dem" class="form-control" required />
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" required />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Ngày sinh</label>
                <input type="date" name="ngay_sinh" class="form-control"  required/>
            </div>
            <div class="col-6">
                <label>SDT</label>
                <input type="tel" name="sdt" class="form-control"  required />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="dia_chi" class="form-control" required />
            </div>
            <div class="col-6">
                <label>Giới tính</label>
                <input type="radio" name="gioi_tinh" value="true" checked/>Nam
                <input type="radio" name="gioi_tinh" value="false"/>Nữ
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
                <button class="btn btn-primary">Thêm mới</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>
</div>

