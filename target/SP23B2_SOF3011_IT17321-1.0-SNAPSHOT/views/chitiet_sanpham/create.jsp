<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-8 offset-2">
    <form method="POST"
          action="/SP23B2_SOF3011_IT17321_war/chitiet-sp/store">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" required  />
            </div>
            <div class="col-6">
                <label>Năm bảo hành</label>
                <input type="date" name="nam_bh" class="form-control" required />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mô tả</label>
                <input type="text" name="mo_ta" class="form-control" required />
            </div>
            <div class="col-6">
                <label>Số lượng tồn</label>
                <input type="text" name="so_lt" class="form-control" required />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Giá nhập</label>
                <input type="text" name="gia_nhap" class="form-control" required/>
            </div>
            <div class="col-6">
                <label>Giá bán</label>
                <input type="text" name="gia_ban" class="form-control" required/>
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

