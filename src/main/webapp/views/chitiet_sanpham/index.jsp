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
                <th>Năm Sản Xuất</th>
                <th>Mô tả</th>
                <th>Số lượng tồn</th>
                <th>Giá nhập</th>
                <th>Giá bán</th>
                <th>Sản phẩm</th>
                <th>Nhà sản xuất</th>
                <th>Màu sắc</th>
                <th>Dòng sản Phẩm</th>

                <th colspan="2">Hành động</th>
                </thead>
                <tbody>
                <c:forEach var="ctsp" items="${ dsCtsp }">
                    <tr>
                        <td>${ ctsp.namSX }</td>
                        <td>${ ctsp.moTa }</td>
                        <td>${ ctsp.soLuongTon }</td>
                        <td>${ ctsp.giaNhap }</td>
                        <td>${ ctsp.giaBan }</td>
                        <td>${ ctsp.sanPham.ten }</td>
                        <td>${ ctsp.nsx.ten }</td>
                        <td>${ ctsp.mauSac.ten }</td>
                        <td>${ ctsp.dongSp.ten }</td>

                        <td>
                            <a href="/SP23B2_SOF3011_IT17321_war/chitiet-sp/edit?id=${ ctsp.id }" class="btn btn-primary">Cập nhật</a>
                        </td>
                        <td>
                            <a href="/SP23B2_SOF3011_IT17321_war/chitiet-sp/delete?id=${ ctsp.id }" class="btn btn-danger">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </c:if>

    </form>
</div>

