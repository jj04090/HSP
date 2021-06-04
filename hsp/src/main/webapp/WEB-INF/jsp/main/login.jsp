<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>

      <div class="login-register-area pt-75 pb-75">
          <div class="container">
              <div class="row">
                  <div class="col-lg-8">
                      <div class="login-register-wrap login-register-gray-bg">
                          <div class="login-register-title">
                              <h1>로그인</h1>
                          </div>
                          <div class="login-register-form">
                              <form name="regit" action="/login" method="POST" enctype="multipart/form-data">
                                  <div class="login-register-input-style input-style input-style-white">
                                      <label>ID *</label>
                                      <input type="text" name="user_id" id="user_id" />
                                  </div>
                                  <div class="login-register-input-style input-style input-style-white">
                                      <label>Password *</label>
                                      <input type="password" name="password" id="password" />
                                  </div>
                                  <div class="lost-remember-wrap">
                                      <div class="lost-wrap">
                                          <a href="/find">계정을 잊으셨나요?</a>
                                      </div>
                                      <div class="lost-wrap">
                                          <a href="/user/regist">회원가입</a>
                                      </div>
                                  </div>
                                  <div class="login-register-btn">
                                      <button type="submit">로그인</button>
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