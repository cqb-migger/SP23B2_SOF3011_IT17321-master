<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<div class="col-8 offset-2">
    <form>
        <a href="/SP23B2_SOF3011_IT17321_war/chitiet-sp/create" class="btn btn-success">Add chi tiết sản phẩm</a>
        <c:if test = "${f:length(dsCtsp) == 0}">
            <h5>ko có dữ liệu</h5>
        </c:if>
        <c:if test = "${f:length(dsCtsp) != 0}">
            <table class="table mt-3">
                <thead class="table-dark">
                <th>Mã</th>
                <th>Năm bảo hành</th>
                <th>Mô tả</th>
                <th>Số lượng tồn</th>
                <th>Giá nhập</th>
                <th>Giá bán</th>
                <th colspan="2">Hành động</th>
                </thead>
                <tbody>
                <c:forEach var="ctsp" items="${ dsCtsp }">
                    <tr>
                        <td>${ ctsp.ma }</td>
                        <td>${ ctsp.nam_bh }</td>
                        <td>${ ctsp.mo_ta }</td>
                        <td>${ ctsp.so_lt }</td>
                        <td>${ ctsp.gia_nhap }</td>
                        <td>${ ctsp.gia_ban }</td>

                        <td>
                            <a href="/SP23B2_SOF3011_IT17321_war/chitiet-sp/edit?ma=${ ctsp.ma }" class="btn btn-primary">Cập nhật</a>
                            <a href="/SP23B2_SOF3011_IT17321_war/chitiet-sp/delete?ma=${ ctsp.ma }" class="btn btn-danger">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </c:if>

    </form>
</div>

