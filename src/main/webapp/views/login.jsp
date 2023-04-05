
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<%--<div class="alert alert-danger">--%>
<%--    ${ errorMessage }--%>
<%--        <% session.removeAttribute("errorMessage"); %>--%>
<%--</div>--%>
<c:if test="${not empty sessionScope.errorMessage}">
    <div class="alert alert-danger" role="alert">
            ${sessionScope.errorMessage}
    </div>
    <% session.removeAttribute("errorMessage"); %>
</c:if>
<form method="POST" action="/SP23B2_SOF3011_IT17321_war/login">
    <div class="mt-3">
        <label>Mã</label>
        <input name="ma" class="form-control" type="text" />
    </div>
    <div class="mt-3">
        <label>Mật khẩu</label>
        <input name="matKhau" class="form-control" type="password" />
    </div>
    <div class="mt-3">
        <button class="btn btn-primary">Đăng nhập</button>
    </div>
</form>