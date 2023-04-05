<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<div class="col-8 offset-2">
    <form method="POST"
          action="/SP23B2_SOF3011_IT17321_war/hoadon-chitiet/store">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã Hóa Đơn</label>
                <select class="form-select" name="idHoaDon" >
                    <c:forEach var="hd" items="${ dsHoaDon }">
                        <option value="${hd.id}" >${hd.ma}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>Số lượng</label>
                <input type="text" name="soLuong" class="form-control" required />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Đơn giá</label>
                <input type="text" name="donGia" class="form-control" required />
            </div>
            <div class="col-6">
                <label>Chi Tiết Sản Phẩm</label>
                <select class="form-select" name="idChiTietSanPham" >
                    <c:forEach var="ctsp" items="${ dsChiTietSanPham }">
                        <option value="${ctsp.id}" >${ctsp.moTa}</option>
                    </c:forEach>
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

