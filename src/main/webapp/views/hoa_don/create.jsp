<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>



<c:if test="${not empty sessionScope.errorMessage}">
    <div class="alert alert-danger" role="alert">
            ${sessionScope.errorMessage}
    </div>
    <% session.removeAttribute("errorMessage"); %>
</c:if>



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
                <input type="date" name="ngayTao" class="form-control"  required />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Ngày thanh toán</label>
                <input type="date" name="ngayThanhToan" class="form-control"  required/>
            </div>
            <div class="col-6">
                <label>Ngày ship</label>
                <input type="date" name="ngayShip" class="form-control" required />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Ngày nhận</label>
                <input type="date" name="ngayNhan" class="form-control"  required   />
            </div>
            <div class="col-6">
                <label>Tình trạng</label>
                <select name="tinhTrang" class="form-select" required>
                    <option value="0" >Đã thanh toán</option>
                    <option value="1">Chưa thanh toán</option>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Tên người nhận</label>
                <input type="text" name="tenNguoiNhan" class="form-control" required/>
            </div>
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="diaChi" class="form-control" required  />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Sđt</label>
                <input type="text" name="sdt" class="form-control" required/>
            </div>
            <div class="col-6">
                <label>Khách Hàng</label>
                <select class="form-select" name="idKhachHang" >
                    <c:forEach var="kh" items="${ dsKhachHang }">
                        <option value="${kh.id}" >${kh.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Nhân Viên</label>
                <select class="form-select" name="idNhanVien" >
                    <c:forEach var="nv" items="${ dsNhanVien }">
                        <option value="${nv.id}" >${nv.ten}</option>
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

