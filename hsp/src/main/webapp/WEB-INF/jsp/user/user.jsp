<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>

     <div class="my-account-area pt-75 pb-75">
         <div class="container">
             <div class="row">
                 <div class="col-lg-12">
                     <!-- My Account Page Start -->
                     <div class="myaccount-page-wrapper">
                         <!-- My Account Tab Menu Start -->
                         <div class="row">
                             <div class="col-lg-4 col-md-4">
                                 <div class="myaccount-tab-menu nav" role="tablist">
                                     <a href="#account_view" data-toggle="tab">내 정보 조회</a>
                                     <a href="#password_edit" data-toggle="tab">비밀번호 변경</a>
                                     <a href="#address_view" data-toggle="tab">배송지 조회</a>
                                     <a href="#address_edit" data-toggle="tab">배송지 변경</a>
                                     <a href="#order_view" data-toggle="tab">주문 조회</a>
                                     <a href="#withdrawal" data-toggle="tab">회원탈퇴</a>
                                 </div>
                             </div>
                             <!-- My Account Tab Menu End -->
                             <!-- My Account Tab Content Start -->
                             <div class="col-lg-8 col-md-8">
                                 <div class="tab-content" id="myaccountContent">
                                     <!-- Single Tab Content Start -->
                                     <div class="tab-pane fade" id="account_view" role="tabpanel">
                                         <div class="myaccount-content">
                                             <div class="account-details-form">
                                                 <form name="edit" action="/user" method="POST" enctype="multipart/form-data">
                                                 	<input type="hidden" name="_method" value="PUT" />
                                                     <div class="row">
                                                         <div class="col-lg-12">
                                                             <div class="account-info input-style mb-30">
                                                                 <label>ID </label>
                                                                 <input type="text" name="user_id" value="${user.user_id}" id="user_id" readonly />
                                                             </div>
                                                         </div>
                                                         <div class="col-lg-12">
                                                             <div class="account-info input-style mb-30">
                                                                 <label>이름 </label>
                                                                 <input type="text" name="name" value="${user.name}" id="name" readonly />
                                                             </div>
                                                         </div>
                                                         <div class="col-lg-12">
                                                             <div class="account-info input-style mb-30">
                                                                 <label>주소 </label>
                                                                 <input type="text" name="address" value="${user.address}" id="address" readonly />
                                                             </div>
                                                         </div>
                                                         <div class="col-lg-12">
                                                             <div class="account-info input-style mb-30">
                                                                 <label>상세 주소 </label>
                                                                 <input type="text" name="detail_add" value="${user.detail_add}" id="detail_add" readonly />
                                                             </div>
                                                         </div>
                                                         <div class="col-lg-12">
                                                             <div class="account-info input-style mb-30">
                                                                 <label>우편 번호 </label>
                                                                 <input type="text" name="zip_code" value="${user.zip_code}" id="zip_code" readonly />
                                                             </div>
                                                         </div>
                                                     </div>
                                                     <input type="hidden" name="password" value="${user.password}" id="password" />
                                                 </form>
                                             </div>
                                         </div>
                                     </div>
                                     <!-- Single Tab Content End -->
                                     <!-- Single Tab Content Start -->
                                     <div class="tab-pane fade" id="password_edit" role="tabpanel">
                                         <div class="myaccount-content">
                                             <div class="account-details-form">
                                                 <form name="pwedit" action="/user/password" method="POST" enctype="multipart/form-data">
                                                 	<input type="hidden" name="_method" value="PUT" />
                                                     <div class="row">
                                                         <div class="col-lg-12">
                                                             <div class="account-info input-style mb-30">
                                                                 <label>현재 비밀번호 </label>
                                                                 <input type="password" name="password" id="password" />
                                                             </div>
                                                         </div>
                                                         <div class="col-lg-12">
                                                             <div class="account-info input-style mb-30">
                                                                 <label>새 비밀번호 </label>
                                                                 <input type="password" name="new_password" id="new_password" />
                                                             </div>
                                                         </div>
                                                     </div>
                                                     <input type="hidden" name="user_id" value="${user.user_id}" id="user_id" />
                                                     <div class="account-info-btn">
                                                         <button>비밀번호 변경</button>
                                                     </div>
                                                 </form>
                                             </div>
                                         </div>
                                     </div>
                                     <!-- Single Tab Content End -->
                                     <!-- Single Tab Content Start -->
                                     <div class="tab-pane fade" id="address_view" role="tabpanel">
                                         <div class="myaccount-content myaccount-address">
                                             <div class="row">
                                                 <div class="col-lg-6 col-md-6 col-12 col-sm-6">
                                                     <div class="myaccount-address-wrap">
                                                         <h3>배송지 주소</h3>
                                                         <div class="myaccount-address-content">
                                                             <h4>${user.address}</h4>
                                                             <p>${user.detail_add} <br>우편 번호 : ${user.zip_code} </p>
                                                             <p>휴대폰 : ${user.phone}</p>
                                                         </div>
                                                     </div>
                                                 </div>
                                             </div>
                                         </div>
                                     </div>
                                     <!-- Single Tab Content End -->
                                     <!-- Single Tab Content Start -->
                                     <div class="tab-pane fade" id="address_edit" role="tabpanel">
                                         <div class="myaccount-content">
                                             <div class="account-details-form">
                                                 <form name="edit" action="/user" method="POST" enctype="multipart/form-data">
                                                 	<input type="hidden" name="_method" value="PUT" />
                                                     <div class="row">
                                                         <div class="col-lg-12">
                                                             <div class="account-info input-style mb-30">
                                                                 <label>ID </label>
                                                                 <input type="text" name="user_id" value="${user.user_id}" id="user_id" readonly />
                                                             </div>
                                                         </div>
                                                         <div class="col-lg-12">
                                                             <div class="account-info input-style mb-30">
                                                                 <label>이름 </label>
                                                                 <input type="text" name="name" value="${user.name}" id="name" readonly />
                                                             </div>
                                                         </div>
                                                         <div class="col-lg-12">
                                                             <div class="account-info input-style mb-30">
                                                                 <label>주소 *</label>
                                                                 <input type="text" name="address" placeholder="${user.address}" id="address" />
                                                             </div>
                                                         </div>
                                                         <div class="col-lg-12">
                                                             <div class="account-info input-style mb-30">
                                                                 <label>상세 주소 *</label>
                                                                 <input type="text" name="detail_add" placeholder="${user.detail_add}" id="detail_add" />
                                                             </div>
                                                         </div>
                                                         <div class="col-lg-12">
                                                             <div class="account-info input-style mb-30">
                                                                 <label>우편 번호 *</label>
                                                                 <input type="text" name="zip_code" placeholder="${user.zip_code}" id="zip_code" />
                                                             </div>
                                                         </div>
                                                     </div>
                                                     <input type="hidden" name="password" value="${user.password}" id="password" />
                                                     <div class="account-info-btn">
                                                         <button>정보 수정</button>
                                                     </div>
                                                 </form>
                                             </div>
                                         </div>
                                     </div>
                                     <!-- Single Tab Content Start -->
                                     
                                     
                                     <!-- 주문 조회 구현 -->
                                     
                                     
                                     <!-- Single Tab Content End -->
                                     <div class="tab-pane fade" id="withdrawal" role="tabpanel">
                                         <div class="myaccount-content">
                                             <div class="account-details-form">
                                                 <form name="pwedit" action="/user" method="POST" enctype="multipart/form-data">
                                                 	<input type="hidden" name="_method" value="DELETE" />
                                                     <div class="row">
                                                        <span> 회원탈퇴 시, 삭제된 정보는 복구할 수 없습니다.
                                                        	<br> 회원탈퇴를 위한 조건을 확인하시길 바랍니다. <br>
                                                        	<br> - 회원님의 모든 개인 정보는 삭제됩니다.
                                                        	<br> - 플랫폼에서 활동하신 내역은 삭제되지 않습니다.
                                                        	<br> - 보유하신 채널이 없어야 합니다.
                                                        	<br> - 현재 구매 진행중인 상품이 없어야 합니다.
                                                        </span>
                                                        <fieldset>
                                                            <legend>본인 확인</legend>
                                                            <div class="row">
                                                                <div class="col-lg-12">
                                                                    <div class="account-info input-style mb-30">
		                                                                <label>현재 비밀번호 </label>
		                                                                <input type="password" name="password" id="password" />
		                                                            </div>
                                                                </div>
                                                            </div>
                                                            <input type="hidden" name="user_id" value="${user.user_id}" id="user_id" />
                                                            <div class="account-info-btn">
                                                         		<button>회원탈퇴 </button>
                                                     		</div>
                                                        </fieldset>
                                                     </div> 
                                                 </form>
                                             </div>
                                         </div>
                                     </div>
                                     <!-- Single Tab Content End -->
                                 </div>
                             </div> 
                             <!-- My Account Tab Content End -->
                         </div>
                     </div> <!-- My Account Page End -->
                 </div>
             </div>
         </div>
     </div>

<%@ include file="../include/footer.jsp"%>
</body>
</html>