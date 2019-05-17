<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<!DOCTYPE html>
<!-- Mobile Menu start -->
	<div class="mobile-menu-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="mobile-menu">
						<nav id="dropdown">
							<ul class="mobile-menu-nav">
								<li><a data-toggle="collapse" data-target="#Charts"
									href="#">Home</a>
									<ul class="collapse dropdown-header-top">
										<li><a href="${pageContext.request.contextPath}/admin/home">Dashboard</a></li>
									</ul></li>
								<li><a data-toggle="collapse" data-target="#demoevent"
									href="#">Room</a>
									<ul id="demoevent" class="collapse dropdown-header-top">
										<li><a href="${pageContext.request.contextPath}/admin/room/add">Add Room</a></li>
										<li><a href="${pageContext.request.contextPath}/admin/room/display">Display Room</a></li>
									</ul></li>
								<li><a data-toggle="collapse" data-target="#democrou"
									href="#">Reservation</a>
									<ul id="democrou" class="collapse dropdown-header-top">
										<li><a href="#">view Reservation</a></li>
									</ul></li>
								<li><a data-toggle="collapse" data-target="#CheckInOut"
									href="#">CheckIn/Out</a>
									<ul id="CheckInOut" class="collapse dropdown-header-top">
										<li><a href="#">view CheckIn/Out</a></li>
									</ul></li>
								<li><a data-toggle="collapse" data-target="#user"
									href="#">User Management</a>
									<ul id="user" class="collapse dropdown-header-top">
										<li><a href="#">view Users</a></li>
									</ul></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Mobile Menu end -->
	
	<!-- Main Menu area start-->
	<div class="main-menu-area mg-tb-40">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<ul class="nav nav-tabs notika-menu-wrap menu-it-icon-pro">
						<li class="active"><a data-toggle="tab" href="#Home"><i
								class="notika-icon notika-house"></i> Home</a></li>
						<li><a data-toggle="tab" href="#Rooms"><i
								class="glyphicon glyphicon-bed"></i> Rooms</a></li>
						<li><a data-toggle="tab" href="#Reservation"><i
								class="notika-icon notika-edit"></i> Reservation</a></li>
						<li><a data-toggle="tab" href="#Check"><i
								class="notika-icon notika-bar-chart"></i> CheckIn/Out</a></li>
						<li><a data-toggle="tab" href="#Users"><i
								class="notika-icon notika-windows"></i> Users Management</a></li>
					</ul>
					<div class="tab-content custom-menu-content">
						<div id="Home"
							class="tab-pane in active notika-tab-menu-bg animated flipInX">
							<ul class="notika-main-menu-dropdown">
								<li><a href="${pageContext.request.contextPath}/admin/dashboard">Dashboard</a></li>
							</ul>
						</div>
						<div id="Rooms"
							class="tab-pane notika-tab-menu-bg animated flipInX">
							<ul class="notika-main-menu-dropdown">
								<li><a href="${pageContext.request.contextPath}/admin/room/add">Add Rooms</a></li>
								<li><a href="${pageContext.request.contextPath}/admin/room/display">Display Rooms</a></li>
							</ul>
						</div>
						<div id="Reservation"
							class="tab-pane notika-tab-menu-bg animated flipInX">
							<ul class="notika-main-menu-dropdown">
								<li><a href="#">View Reservation</a></li>
							</ul>
						</div>
						<div id="Check"
							class="tab-pane notika-tab-menu-bg animated flipInX">
							<ul class="notika-main-menu-dropdown">
								<li><a href="#">View CheckIn/Out</a></li>
							</ul>
						</div>
						<div id="Users"
							class="tab-pane notika-tab-menu-bg animated flipInX">
							<ul class="notika-main-menu-dropdown">
								<li><a href="#">view Users</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Main Menu area End-->