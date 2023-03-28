<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-8 offset-2">
    <form method="POST"
          action="/SP23B2_SOF3011_IT17321_war/cua-hang/store">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" required/>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control"  required/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="dia_chi" class="form-control" required />
            </div>
            <div class="col-6">
                <label>Thành phố</label>
                <select name="thanh_pho" class="form-select" required>
                    <option value="hn">Hà Nội</option>
                    <option value="ny">New York</option>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-12">
                <label>Quốc gia</label>
                <select name="quoc_gia" class="form-select" required>
                    <option value="vi">Việt Nam</option>
                    <option value="us">Mỹ</option>
                </select>
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


