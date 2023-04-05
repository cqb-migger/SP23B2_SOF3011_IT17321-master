<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<div class="col-8 offset-2">
        <a href="/SP23B2_SOF3011_IT17321_war/hoa-don/create" class="btn btn-success mt-3">Add hóa đơn</a>
        <c:if test = "${f:length(dsHoaDon) == 0}">
            <h5>ko có dữ liệu</h5>
        </c:if>
        <c:if test = "${f:length(dsHoaDon) != 0}">
            <table class="table mt-3">
                <thead class="table-dark">
                <th>Mã</th>
                <th>Ngày tạo</th>
                <th>Ngày thanh toán</th>
                <th>Ngày ship</th>
                <th>Ngày nhận</th>
                <th>Tình trạng</th>
                <th>Tên người nhận</th>
                <th>Địa chỉ</th>
                <th>Sđt</th>
                <th>Khách Hàng</th>
                <th>Nhân Viên</th>
                <th colspan="2">Hành động</th>

                </thead>
                <tbody>
                <c:forEach var="hd" items="${ dsHoaDon }">
                    <tr>
                        <td>${ hd.ma }</td>
                        <td>${ hd.ngayTao }</td>
                        <td>${ hd.ngayThanhToan}</td>
                        <td>${ hd.ngayShip }</td>
                        <td>${ hd.ngayNhan }</td>
                        <td>
                            <c:if test ="${hd.tinhTrang == '0'}" >Đã thanh toán</c:if>
                            <c:if test ="${hd.tinhTrang == '1'}" >Chưa thanh toán</c:if>
                        </td>
                        <td>${ hd.tenNguoiNhan }</td>
                        <td>${ hd.diaChi }</td>
                        <td>${ hd.sdt }</td>
                        <td>${ hd.khachHang.ten }</td>
                        <td>${ hd.nhanVien.ten }</td>
                        <td>
                            <a href="/SP23B2_SOF3011_IT17321_war/hoa-don/edit?ma=${ hd.ma }" class="btn btn-primary">Cập nhật</a>
                        </td>
                        <td>
                            <a href="/SP23B2_SOF3011_IT17321_war/hoa-don/delete?ma=${ hd.ma }" class="btn btn-danger">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </c:if>


</div>

