<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="col-8 offset-2">
    <form method="POST"
          action="/SP23B2_SOF3011_IT17321_war/hoa-don/store">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control"  required />
            </div>
            <div class="col-6">
                <label>Ngày tạo</label>
                <input type="date" name="ngay_tao" class="form-control"  required />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Ngày thanh toán</label>
                <input type="date" name="ngay_thanhtoan" class="form-control"  required/>
            </div>
            <div class="col-6">
                <label>Ngày ship</label>
                <input type="date" name="ngay_ship" class="form-control" required />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Ngày nhận</label>
                <input type="date" name="ngay_nhan" class="form-control"  required   />
            </div>
            <div class="col-6">
                <label>Tình trạng</label>
                <select name="tinh_trang" class="form-select" required>
                    <option value="dtt" >Đã thanh toán</option>
                    <option value="ctt">Chưa thanh toán</option>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Tên người nhận</label>
                <input type="text" name="ten_nguoinhan" class="form-control" required/>
            </div>
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="dia_chi" class="form-control" required  />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-12">
                <label>Sđt</label>
                <input type="text" name="sdt" class="form-control" required/>
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

