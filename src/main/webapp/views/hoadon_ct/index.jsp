<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<div class="col-8 offset-2">
        <a href="/SP23B2_SOF3011_IT17321_war/hoadon-chitiet/create" class="btn btn-success mt-3">Add hóa đơn</a>
        <c:if test = "${f:length(dsHoaDonChiTiet) == 0}">
            <h5>ko có dữ liệu</h5>
        </c:if>
        <c:if test = "${f:length(dsHoaDonChiTiet) != 0}">
            <table class="table mt-3">
                <thead class="table-dark">
                <th>Mã</th>
                <th>Số lượng</th>
                <th>Đơn giá</th>
                <th colspan="2">Hành động</th>

                </thead>
                <tbody>
                <c:forEach var="hdct" items="${ dsHoaDonChiTiet }">
                    <tr>
                        <td>${ hdct.ma }</td>
                        <td>${ hdct.so_luong }</td>
                        <td>${ hdct.don_gia}</td>


                        <td>
                            <a href="/SP23B2_SOF3011_IT17321_war/hoadon-chitiet/edit?ma=${ hdct.ma }" class="btn btn-primary">Cập nhật</a>
                            <a href="/SP23B2_SOF3011_IT17321_war/hoadon-chitiet/delete?ma=${ hdct.ma }" class="btn btn-danger">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </c:if>


</div>

