<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<div class="col-8 offset-2">
        <a href="/SP23B2_SOF3011_IT17321_war/nhan-vien/create" class="btn btn-success mt-3">Add nhân viên</a>
        <c:if test = "${f:length(dsNhanVien) == 0}">
            <h5>ko có dữ liệu</h5>
        </c:if>
        <c:if test = "${f:length(dsNhanVien) != 0}">
            <table class="table mt-3">
                <thead class="table-dark">
                <th>Mã</th>
                <th>Họ</th>
                <th>Tên đệm</th>
                <th>Tên</th>
                <th>Ngày Sinh</th>
                <th>Giới tính</th>
                <th>SĐT</th>
                <th>Địa chỉ</th>
                <th>Trạng thái</th>
                <th colspan="2">Hành động</th>

                </thead>
                <tbody>
                <c:forEach var="nv" items="${ dsNhanVien }">
                    <tr>
                        <td>${ nv.ma }</td>
                        <td>${ nv.ho }</td>
                        <td>${ nv.ten_dem}</td>
                        <td>${ nv.ten }</td>
                        <td>${ nv.ngay_sinh }</td>
                        <td>
                            <c:if test="${nv.gioi_tinh == 'true'}">Nam</c:if>
                            <c:if test="${nv.gioi_tinh == 'false'}">Nữ</c:if>
                        </td>
                        <td>${ nv.sdt }</td>
                        <td>${ nv.dia_chi }</td>
                        <td>
                            <c:if test="${nv.trang_thai == 'true'}">Làm</c:if>
                            <c:if test="${nv.trang_thai == 'false'}">Nghỉ</c:if>
                        </td>


                        <td>
                            <a href="/SP23B2_SOF3011_IT17321_war/nhan-vien/edit?ma=${ nv.ma }" class="btn btn-primary">Cập nhật</a>
                            <a href="/SP23B2_SOF3011_IT17321_war/nhan-vien/delete?ma=${ nv.ma }" class="btn btn-danger">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </c:if>


</div>



