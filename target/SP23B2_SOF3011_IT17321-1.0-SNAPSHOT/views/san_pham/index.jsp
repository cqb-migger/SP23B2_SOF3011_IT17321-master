<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<div class="col-8 offset-2">
    <form>
        <a href="/SP23B2_SOF3011_IT17321_war/san-pham/create" class="btn btn-success">Add sản phẩm</a>
        <c:if test = "${f:length(dsSanPham) == 0}">
            <h5>ko có dữ liệu</h5>
        </c:if>
        <c:if test = "${f:length(dsSanPham) != 0}">
            <table class="table mt-3">
                <thead class="table-dark">
                <th>Mã</th>
                <th>Tên</th>
                <th colspan="2">Hành động</th>
                </thead>
                <tbody>
                <c:forEach var="sp" items="${ dsSanPham }">
                    <tr>
                        <td>${ sp.ma }</td>
                        <td>${ sp.ten }</td>

                        <td>
                            <a href="/SP23B2_SOF3011_IT17321_war/san-pham/edit?ma=${ sp.ma }" class="btn btn-primary">Cập nhật</a>
                            <a href="/SP23B2_SOF3011_IT17321_war/san-pham/delete?ma=${ sp.ma }" class="btn btn-danger">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </c:if>
    </form>
</div>

