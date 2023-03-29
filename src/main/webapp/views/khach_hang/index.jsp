<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<div class="col-8 offset-2">
        <a href="/SP23B2_SOF3011_IT17321_war/khach-hang/create" class="btn btn-success mt-3">Add Khách hàng</a>
        <c:if test = "${f:length(dsKhachHang) == 0}">
            <h5>ko có dữ liệu</h5>
        </c:if>
        <c:if test = "${f:length(dsKhachHang) != 0}">
            <table class="table mt-3">
                <thead class="table-dark">
                <th>Mã</th>
                <th>Họ</th>
                <th>Tên đệm</th>
                <th>Tên</th>
                <th>Ngày Sinh</th>
                <th>SĐT</th>
                <th>Địa chỉ</th>
                <th>Mật Khẩu</th>
                <th>Quốc gia</th>
                <th>Thành phố</th>
                <th colspan="2">Hành động</th>

                </thead>
                <tbody>
                <c:forEach var="kh" items="${ dsKhachHang }">
                    <tr>
                        <td>${ kh.ma }</td>
                        <td>${ kh.ho }</td>
                        <td>${ kh.tenDem}</td>
                        <td>${ kh.ten }</td>
                        <td>${ kh.ngaySinh }</td>
                        <td>${ kh.sdt }</td>
                        <td>${ kh.diaChi }</td>
                        <td>${ kh.matKhau }</td>
                        <td>
                            <c:if test ="${kh.quocGia == 'vi'}" >Việt Nam</c:if>
                            <c:if test ="${kh.quocGia == 'us'}" >Mỹ</c:if>
                        </td>
                        <td>
                            <c:if test ="${kh.thanhPho == 'hn'}" >Hà Nội</c:if>
                            <c:if test ="${kh.thanhPho == 'ny'}" >New York</c:if>
                        </td>


                        <td>
                            <a href="/SP23B2_SOF3011_IT17321_war/khach-hang/edit?ma=${ kh.ma }" class="btn btn-primary">Cập nhật</a>
                            <a href="/SP23B2_SOF3011_IT17321_war/khach-hang/delete?ma=${ kh.ma }" class="btn btn-danger">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </c:if>


</div>



