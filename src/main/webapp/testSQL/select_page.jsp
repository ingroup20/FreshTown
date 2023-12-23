<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>FreshTown likeStore: Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>FreshTown likeStore: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for FreshTown likeStore: Home</p>

<h3>��Ƭd��:</h3>
	
<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllLikeStore.jsp'>List</a> all LikeStore.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="likeStore.do" >
        <b>��J�|���s�� (�p1):</b>
        <input type="text" name="customerId">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="�e�X">
    </FORM>
  </li>

<%--   <jsp:useBean id="likeStoreSvc" scope="page" class="com.like_store.model.LikeStoreService" /> --%>
   
<!--   <li> -->
<!--      <FORM METHOD="post" ACTION="likeStore.do" > -->
<!--        <b>��ܷ|���s��:</b> -->
<!--        <select size="1" name="customerId"> -->
<%--          <c:forEach var="likeStoreVO" items="${likeStoreSvc.all}" >  --%>
<%--           <option value="${likeStoreVO.customerId}">${likeStoreVO.customerId} --%>
<%--          </c:forEach>    --%>
<!--        </select> -->
<!--        <input type="hidden" name="action" value="getOne_For_Display"> -->
<!--        <input type="submit" value="�e�X"> -->
<!--     </FORM> -->
<!--   </li> -->
  
<!--   <li> -->
<!--      <FORM METHOD="post" ACTION="likeStore.do" > -->
<!--        <b>��ܩ��a�s��:</b> -->
<!--        <select size="1" name="storeId"> -->
<%--          <c:forEach var="likeStoreVO" items="${likeStoreSvc.all}" >  --%>
<%--           <option value="${likeStoreVO.storeId}">${likeStoreVO.storeId} --%>
<%--          </c:forEach>    --%>
<!--        </select> -->
<!--        <input type="hidden" name="action" value="getOne_For_Display"> -->
<!--        <input type="submit" value="�e�X"> -->
<!--      </FORM> -->
<!--   </li> -->
</ul>


<h3>���é��a�޲z</h3>

<ul>
  <li><a href='addLikeStore.jsp'>Add</a> a new LikeStore.</li>
</ul>

</body>
</html>