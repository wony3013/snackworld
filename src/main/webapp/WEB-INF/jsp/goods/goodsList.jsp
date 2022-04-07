<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-04-07
  Time: 오후 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>상품리스트</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col">
            <span style="font-weight: bold; font-size: 2rem">상품 리스트</span>
            <div class="btn-group">
                <select class="form-select" aria-label="Default select example" style="width: 150px">
                    <option selected>카테고리</option>
                    <option value="1">스낵</option>
                    <option value="2">초콜릿</option>
                    <option value="3">홈런볼</option>
                </select>
                <input type="search" class="form-control" placeholder="검색..." aria-label="Search">
            </div>
        </div>
    </div>
    <div class="row">
        <table class="table table-hover">
            <thead>
            <tr>
                <th> <input type="checkbox"/></th>
                <th>번호</th>
                <th>카테고리</th>
                <th>이미지</th>
                <th>상품명</th>
                <th>가격</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <input type="checkbox"/>
                </td>
                <td>1</td>
                <td>스낵</td>
                <td>이미지</td>
                <td>허니버터칩</td>
                <td>2000</td>
                <td>
                    <button type="button" class="btn btn-outline-primary">수정</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="row">
        <div class="d-grid gap-2 d-md-flex justify-content-md-end" style="padding-right: 1%">
            <button type="button" class="btn btn-outline-secondary">상품 삭제</button>
            <button type="button" class="btn btn-outline-primary">상품 추가</button>
        </div>
    </div>
    <div class="row">
        <div class="text-center">
            <ul class="pagination justify-content-center">
                <li class="page-item disabled">
                    <a class="page-link" href="#" tabindex="-1">Previous</a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="#">1</a>
                </li>
                <li class="page-item active">
                    <a class="page-link" href="#">2 <span class="sr-only"></span></a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="#">3</a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="#">Next</a>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
