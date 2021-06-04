<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>

      <div class="login-register-area pt-75 pb-75">
          <div class="container">
              <div class="row">
                  <div class="col-lg-6">
                      <div class="login-register-wrap login-register-gray-bg">
                          <div class="login-register-title">
                              <h1>아이디 찾기</h1>
                          </div>
                          <div class="login-register-form">
                              <form name="findID" action="/findID" method="POST" enctype="multipart/form-data">
                                  <div class="login-register-input-style input-style input-style-white">
                                      <label>이름 *</label>
                                      <input type="text" name="name" id="name" />
                                  </div>
                                  <div class="login-register-input-style input-style input-style-white">
                                      <label>이메일 주소 *</label>
                                      <input type="text" name="email" id="email" />
                                  </div>
                                  <div class="login-register-btn">
                                      <button type="submit">ID 찾기</button>
                                  </div>
                              </form>
                          </div>
                      </div>
                  </div>
                  <div class="col-lg-6">
                      <div class="login-register-wrap login-register-gray-bg">
                          <div class="login-register-title">
                              <h1>비밀번호 찾기</h1>
                          </div>
                          <div class="login-register-form">
                              <form name="findPW" action="/findPW" method="POST" enctype="multipart/form-data">
                                  <div class="login-register-input-style input-style input-style-white">
                                      <label>ID *</label>
                                      <input type="text" name="user_id" id="user_id" />
                                  </div>
                                  <div class="login-register-input-style input-style input-style-white">
                                      <label>이메일 주소 *</label>
                                      <input type="text" name="email" id="email" />
                                  </div>
                                  <div class="login-register-btn">
                                      <button type="submit">비밀번호 찾기</button>
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