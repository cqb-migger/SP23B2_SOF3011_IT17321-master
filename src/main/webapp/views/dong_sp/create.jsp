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
          action="/SP23B2_SOF3011_IT17321_war/dong-sp/store">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" required/>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" required/>
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

