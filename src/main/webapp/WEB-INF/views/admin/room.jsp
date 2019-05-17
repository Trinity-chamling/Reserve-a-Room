<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="">

<head>
	<title>Hotel Rooms</title>
	<meta charset="utf-8">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- favicon
			============================================ -->
	<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico">
	<!-- Google Fonts
			============================================ -->
	<!--<link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">  -->
	<!-- Bootstrap CSS
			============================================ -->
	<link rel="stylesheet" href="/css/bootstrap.min.css">
	<!-- Bootstrap CSS
			============================================ -->
	<link rel="stylesheet" href="/css/fontawesome-all.css">
	<!-- owl.carousel CSS
			============================================ -->
	<link rel="stylesheet" href="/css/owl.carousel.css">
	<link rel="stylesheet" href="/css/owl.theme.css">
	<link rel="stylesheet" href="/css/owl.transitions.css">
	<!-- meanmenu CSS
			============================================ -->
	<link rel="stylesheet" href="/css/meanmenu/meanmenu.min.css">
	<!-- animate CSS
			============================================ -->
	<link rel="stylesheet" href="/css/animate.css">
	<!-- normalize CSS
			============================================ -->
	<link rel="stylesheet" href="/css/normalize.css">
	<!-- mCustomScrollbar CSS
			============================================ -->
	<link rel="stylesheet"
		href="/css/scrollbar/jquery.mCustomScrollbar.min.css">
	<!-- jvectormap CSS
			============================================ -->
	<link rel="stylesheet"
		href="/css/jvectormap/jquery-jvectormap-2.0.3.css">
	
	<!-- notika icon CSS
			============================================ -->
	<link rel="stylesheet" href="/css/notika-custom-icon.css">
	<!-- wave CSS
			============================================ -->
	<link rel="stylesheet" href="/css/wave/waves.min.css">
	<!-- main CSS
			============================================ -->
	<link rel="stylesheet" href="/css/main.css">
	<!-- style CSS
			============================================ -->
	<link rel="stylesheet" href="/css/style.css">
	<!-- responsive CSS
			============================================ -->
	<link rel="stylesheet" href="/css/responsive.css">
	
	<!-- modernizr JS
			============================================ -->
	<script src="/js/vendor/modernizr-2.8.3.min.js"></script>

</head>

<body>
	<!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

	<!-- Start Header Top Area -->
	<%@include file="header.jsp"%>
	<!-- End Header Top Area -->


	<!-- Menubar start -->
	<%@include file="menubar.jsp" %>
	
	<!-- Mobile Menu start -->
	<!-- Mobile Menu end -->
		
	<!-- Main Menu area start-->
    <!-- Main Menu area End-->
			
	<!-- Menubar end -->
	
	<!--########## Content here ############ -->
	<div class="row">
	<div class="form-example-area">
        <div class="container">
			<div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="form-example-wrap">
                        <div class="cmp-tb-hd">
                        	<h2>
                        		<j:choose>
	                        		<j:when test="${edit.equals('true')}">Update </j:when>
	                        		<j:otherwise>Add New </j:otherwise>
                        		</j:choose>
                        		Room Information
                        	</h2>
                            <h3 class="text-danger">${saveError}</h3>
                            <h3>${congrulation}</h3>
                        </div>
                        <j:choose>
                        	<j:when test="${edit.equals('true')}">
                        		<form action="/admin/room/update" method="post" enctype="multipart/form-data">
	                        		
	                        		<div class="form-example-int mg-t-15">
										<div class="form-group">
											<label>ID</label>
											<div class="nk-int-st">
												<input type="text" class="form-control input-sm" name="rid"
													value="${room.id}" readonly>
											</div>
										</div>
									</div>
                        	</j:when>
                        	<j:otherwise>
                        		<form action="/admin/room/add" method="post" enctype="multipart/form-data">
                        	</j:otherwise>
                        </j:choose>
                        
							<div class="form-example-int">
								<div class="form-group">
									<label>Type</label>
									<div class="nk-int-st">
										<input type="text" class="form-control input-sm" name="rtype"
											placeholder="Enter Type of Room" value="<j:if test="${edit.equals('true')}">${room.type}</j:if>">
									</div>
								</div>
							</div>
							<div class="form-example-int mg-t-15">
								<div class="form-group">
									<label>Image</label>
									<p class="help-block" style="color:green"><j:if test="${edit.equals('true')}">Previous image name was: ${room.image}. Please Select an image.</j:if></p>
									<div class="nk-int-st">
										<input type="file" class="form-control input-sm" name="rimage">
									</div>
									<p class="text-danger">${uploadError}</p>
								</div>
							</div>
							<div class="form-example-int mg-t-15">
								<div class="form-group">
									<label>Description</label>
									<div class="nk-int-st">
										<textarea rows="" cols="" class="form-control input-sm" name="rdescription" placeholder="Enter Description of Room"><j:if test="${edit.equals('true')}">${room.description}</j:if></textarea>
										<%-- <input type="text" class="form-control input-sm" name="rdescription"
											placeholder="Enter Description of Room">--%>
									</div>
								</div>
							</div>
							<div class="form-example-int mg-t-15">
								<div class="form-group">
									<label>Rate</label>
									<div class="nk-int-st">
										<input type="text" class="form-control input-sm" name="rrate"
											placeholder="Enter price of Room" value="<j:if test="${edit.equals('true')}">${room.rate}</j:if>">
									</div>
								</div>
							</div>
							<div class="form-example-int mg-t-15">
								<div class="form-group">
									<label>Status</label>
									<div class="nk-int-st">
										<select name="rstatus" class="form-control input-sm">
											<option value="1" <j:choose> <j:when test="${edit.equals('true')}"> <j:if test="${room.status.equals('1')}">selected</j:if> </j:when> </j:choose> >Available</option>
											<option value="0" <j:choose> <j:when test="${edit.equals('true')}"> <j:if test="${room.status.equals('0')}">selected</j:if> </j:when> </j:choose> >Unavailable</option>
										</select>
									</div>
								</div>
							</div>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							<div class="form-example-int mg-t-15">
								<button type="submit" class="btn btn-success notika-btn-success">Save</button>
							</div>
						</form>
                    </div>
                </div>
              </div>
		</div>
	</div>
	</div>
	<!-- Breadcomb area Start-->
	<div class="row">
	<br/><br/>
	<div class="breadcomb-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="breadcomb-list">
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="breadcomb-wp">
									<div class="breadcomb-icon">
										<i class="notika-icon notika-windows"></i>
									</div>
									<div class="breadcomb-ctn">
										<h2>Room Information Table</h2>
										<p>Welcome to Hotel Room Reservation System</p>
									</div>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-3">
								<div class="breadcomb-report">
									<button data-toggle="tooltip" data-placement="left" title="Download Report" class="btn"><i class="notika-icon notika-sent"></i></button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<!-- Breadcomb area End-->
	
	<div class="data-table-area" id="ShowRooms">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-lg-12 col-lg-12">
                    <div class="data-table-list">
                        <div class="basic-tb-hd">
                            <h2>Rooms Details</h2>
                            <p>The users can view and edit and delete the Rooms information</p>
                        </div>
                        <div class="table-responsive">
                            <table id="data-table-basic" class="table table-striped">
                                <thead>
                                    <tr>
                                    	<th>Id</th>
                                        <th>Type</th>
                                        <th>Rate</th>
                                        <th>Description</th>
                                        <th>Image</th>
                                        <th>Status</th>
                                        <th>Edit</th>
                                        <th>Delete</th>
                                    </tr>
                                </thead>
                                <tbody>
                                
                                	<j:forEach items="${rooms}" var="r">
                                		<tr>
                                			<td>${r.id}</td>
                                			<td>${r.type}</td>
                                			<td>${r.rate}</td>
                                			<td>${r.description}</td>
                                			<td><img src="/image/room/${r.image}" height="150" width="150" alt="image"/></td>
                                			<td><j:choose><j:when test="${r.status.equals(true)}">available</j:when> <j:otherwise>unavailable</j:otherwise></j:choose></td>
                                			<td><a href="<j:url value="/admin/room/edit/${r.id}"/>">Edit</a></td>
                                			<td><a href="<j:url value="/admin/room/delete/${r.id}"/>">Delete</a></td>
                                		</tr>
                                	</j:forEach>
                                </tbody>
                               <tfoot>
                                    <tr>
                                        <th>Id</th>
                                        <th>Type</th>
                                        <th>Rate</th>
                                        <th>Description</th>
                                        <th>Image</th>
                                        <th>Status</th>
                                        <th>Edit</th>
                                        <th>Delete</th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<!--########## End of Content ##########-->	
	
	<!-- Start Footer area-->
	<%@include file="footer.jsp"%>
	<!-- End Footer area-->


</body>

<!-- jquery
		============================================ -->
<script src="/js/vendor/jquery-1.12.4.min.js"></script>
<!-- bootstrap JS
		============================================ -->
<script src="/js/bootstrap.min.js"></script>
<!-- wow JS
		============================================ -->
<script src="/js/wow.min.js"></script>
<!-- price-slider JS
		============================================ -->
<script src="/js/jquery-price-slider.js"></script>
<!-- owl.carousel JS
		============================================ -->
<script src="/js/owl.carousel.min.js"></script>
<!-- scrollUp JS
		============================================ -->
<script src="/js/jquery.scrollUp.min.js"></script>
<!-- meanmenu JS
		============================================ -->
<script src="/js/meanmenu/jquery.meanmenu.js"></script>
<!-- counterup JS
		============================================ -->
<script src="/js/counterup/jquery.counterup.min.js"></script>
<script src="/js/counterup/waypoints.min.js"></script>
<script src="/js/counterup/counterup-active.js"></script>
<!-- mCustomScrollbar JS
		============================================ -->
<script src="/js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
<!-- jvectormap JS
		============================================ -->
<script src="/js/jvectormap/jquery-jvectormap-2.0.2.min.js"></script>
<script src="/js/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="/js/jvectormap/jvectormap-active.js"></script>
<!-- sparkline JS
		============================================ -->
<script src="/js/sparkline/jquery.sparkline.min.js"></script>
<script src="/js/sparkline/sparkline-active.js"></script>
<!-- sparkline JS
		============================================ -->
<script src="/js/flot/jquery.flot.js"></script>
<script src="/js/flot/jquery.flot.resize.js"></script>
<script src="/js/flot/curvedLines.js"></script>
<script src="/js/flot/flot-active.js"></script>
<!-- knob JS
		============================================ -->
<script src="/js/knob/jquery.knob.js"></script>
<script src="/js/knob/jquery.appear.js"></script>
<script src="/js/knob/knob-active.js"></script>
<!--  wave JS
		============================================ -->
<script src="/js/wave/waves.min.js"></script>
<script src="/js/wave/wave-active.js"></script>
<!--  todo JS
		============================================ -->
<script src="/js/todo/jquery.todo.js"></script>
<!-- plugins JS
		============================================ -->
<script src="/js/plugins.js"></script>
<!--  Chat JS
		============================================ -->
<script src="/js/chat/moment.min.js"></script>
<script src="/js/chat/jquery.chat.js"></script>
<!-- main JS
		============================================ -->
<script src="/js/main.js"></script>
<!-- tawk chat JS
		============================================ -->
<script src="/js/tawk-chat.js"></script>
<!-- Data Table JS============================================ -->
    <script src="/js/data-table/jquery.dataTables.min.js"></script>
    <script src="/js/data-table/data-table-act.js"></script>

</html>