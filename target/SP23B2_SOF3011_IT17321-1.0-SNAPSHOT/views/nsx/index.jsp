<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<div class="col-8 offset-2">
    <form>
        <a href="/SP23B2_SOF3011_IT17321_war/nsx/create" class="btn btn-success">Add nhà sản xuất</a>
        <c:if test = "${f:length(dsNSX) == 0}">
            <h5>ko có dữ liệu</h5>
        </c:if>
        <c:if test = "${f:length(dsNSX) != 0}">
            <table class="table mt-3">
                <thead class="table-dark">
                <th>Mã</th>
                <th>Tên</th>
                <th colspan="2">Hành động</th>
                </thead>
                <tbody>
                <c:forEach var="nsx" items="${ dsNSX }">
                    <tr>
                        <td>${ nsx.ma }</td>
                        <td>${ nsx.ten }</td>

                        <td>
                            <a href="/SP23B2_SOF3011_IT17321_war/nsx/edit?ma=${ nsx.ma }" class="btn btn-primary">Cập nhật</a>
                            <a href="/SP23B2_SOF3011_IT17321_war/nsx/delete?ma=${ nsx.ma }" class="btn btn-danger">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </c:if>
    </form>
</div>

