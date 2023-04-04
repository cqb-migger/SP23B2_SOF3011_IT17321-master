<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<div class="col-8 offset-2">
    <form>
        <a href="/SP23B2_SOF3011_IT17321_war/cua-hang/create" class="btn btn-success">Add cửa hàng</a>
        <c:if test = "${f:length(dsCuaHang) == 0}">
            <h5>ko có dữ liệu</h5>
        </c:if>

        <c:if test = "${f:length(dsCuaHang) != 0}">
            <table class="table mt-3">
                <thead class="table-dark">
                <th>Mã</th>
                <th>Tên</th>
                <th>Địa chỉ</th>
                <th>Thành phố</th>
                <th>Quốc gia</th>
                <th colspan="2">Hành động</th>
                </thead>
                <tbody>
                <c:forEach var="ch" items="${ dsCuaHang }">
                    <tr>
                        <td>${ ch.ma }</td>
                        <td>${ ch.ten }</td>
                        <td>${ ch.diaChi }</td>
                        <<td>
                        <c:if test ="${ch.thanhPho == 'hn'}" >Hà Nội</c:if>
                        <c:if test ="${ch.thanhPho == 'ny'}" >New York</c:if>
                    </td>
                        <td>
                            <c:if test ="${ch.quocGia == 'vi'}" >Việt Nam</c:if>
                            <c:if test ="${ch.quocGia == 'us'}" >Mỹ</c:if>
                        </td>

                        <td>
                            <a href="/SP23B2_SOF3011_IT17321_war/cua-hang/edit?ma=${ ch.ma }" class="btn btn-primary">Cập nhật</a>
                            <a href="/SP23B2_SOF3011_IT17321_war/cua-hang/delete?ma=${ ch.ma }" class="btn btn-danger">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </c:if>


    </form>
</div>

