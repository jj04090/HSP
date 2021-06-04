<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>

	  <div class="login-register-area pt-75 pb-75">
          <div class="container">
              <div class="row">
                  <div class="col-lg-6">
                      <div class="login-register-wrap">
                          <div class="login-register-title">
                              <h1>회원가입</h1>
                          </div>
                          <div class="login-register-form">
                              <form name="registUser" action="/user" method="POST" enctype="multipart/form-data">
                                  <div class="login-register-input-style input-style">
                                      <label>이름 *</label>
                                      <input type="text" name="name" id="name">
                                  </div>
                                  <div class="login-register-input-style input-style">
                                      <label>ID *</label>
                                      <input type="text" name="user_id" id="user_id">
                                  </div>
                                  <div class="login-register-input-style input-style">
                                      <label>Password *</label>
                                      <input type="password" name="password" id="password">
                                  </div>
                                  <div class="login-register-input-style input-style">
                                      <label>이메일 주소 *</label>
                                      <input type="email" name="email" id="email">
                                  </div>
                                  <div class="login-register-input-style input-style">
                                      <label>주소</label>
                                      <input type="text" name="address" id="address">
                                  </div>
                                  <div class="login-register-input-style input-style">
                                      <label>상세 주소</label>
                                      <input type="text" name="detail_add" id="detail_add">
                                  </div>
                                  <div class="login-register-input-style input-style">
                                      <label>우편 번호</label>
                                      <input type="text" name="zip_code" id="zip_code">
                                  </div>
                                  <div class="login-register-btn">
                                      <button type="submit">등록하기</button>
                                  </div>
                              </form>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
      </div>
      
<%@ include file="../include/footer.jsp"%>
</body>
</html>