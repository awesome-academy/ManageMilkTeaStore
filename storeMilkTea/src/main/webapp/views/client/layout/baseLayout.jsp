<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
           prefix="tilesx" %>
<tiles:importAttribute name="javascripts"/>
<tiles:importAttribute name="stylesheets"/>

<!doctype html>
<html class="no-js" lang="">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title><tiles:insertAttribute name="title" ignore="true"/></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="shortcut icon" type="image/x-icon" href="/client/assets/img/favicon.ico">
    <!-- Place favicon.ico in the root directory -->

    <!-- stylesheets -->
    <c:forEach var="css" items="${stylesheets}">
        <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
    </c:forEach>
    <!-- end stylesheets -->


</head>
<body>
<!--[if lt IE 8]>
<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade
    your browser</a> to improve your experience.</p>
<![endif]-->
<!-- Add your site or application content here -->
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="slider" ignore="true"/>
<tiles:insertAttribute name="breadcrumb" ignore="true"/>
<tiles:insertAttribute name="body"/>
<tiles:insertAttribute name="footer"/>
<!-- QUICKVIEW PRODUCT -->
<div id="quickview-wrapper">
    <!-- Modal -->
    <div class="modal fade" id="productModal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                    <div class="modal-product">
                        <div class="product-images">
                            <div class="main-image images">
                                <img alt="" src="/client/assets/img/product/13.jpg">
                            </div>
                        </div><!-- .product-images -->

                        <div class="product-info">
                            <h1>Diam quis cursus</h1>
                            <div class="price-box">
                                <p class="price"><span class="special-price"><span class="amount">$132.00</span></span>
                                </p>
                            </div>
                            <a href="shop.html" class="see-all">See all features</a>
                            <div class="quick-add-to-cart">
                                <form method="post" class="cart">
                                    <div class="numbers-row">
                                        <input type="number" id="french-hens" value="3">
                                    </div>
                                    <button class="single_add_to_cart_button" type="submit">Add to cart</button>
                                </form>
                            </div>
                            <div class="quick-desc">
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam fringilla augue nec est
                                tristique auctor. Donec non est at libero vulputate rutrum. Morbi ornare lectus quis
                                justo gravida semper. Nulla tellus mi, vulputate adipiscing cursus eu, suscipit id
                                nulla.
                            </div>
                            <div class="social-sharing">
                                <div class="widget widget_socialsharing_widget">
                                    <h3 class="widget-title-modal">Share this product</h3>
                                    <ul class="social-icons">
                                        <li><a target="_blank" title="Facebook" href="#" class="facebook social-icon"><i
                                                class="fa fa-facebook"></i></a></li>
                                        <li><a target="_blank" title="Twitter" href="#" class="twitter social-icon"><i
                                                class="fa fa-twitter"></i></a></li>
                                        <li><a target="_blank" title="Pinterest" href="#" class="pinterest social-icon"><i
                                                class="fa fa-pinterest"></i></a></li>
                                        <li><a target="_blank" title="Google +" href="#" class="gplus social-icon"><i
                                                class="fa fa-google-plus"></i></a></li>
                                        <li><a target="_blank" title="LinkedIn" href="#" class="linkedin social-icon"><i
                                                class="fa fa-linkedin"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div><!-- .product-info -->
                    </div><!-- .modal-product -->
                </div><!-- .modal-body -->
            </div><!-- .modal-content -->
        </div><!-- .modal-dialog -->
    </div>
    <!-- END Modal -->
</div>
<!-- END QUICKVIEW PRODUCT -->

<!-- Start login and register -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    ×
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    Login/Registration
                </h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-8" style="border-right: 1px dotted #C2C2C2;padding-right: 30px;">
                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#Login" data-toggle="tab">Login</a></li>
                            <li><a href="#Registration" data-toggle="tab">Registration</a></li>
                        </ul>
                        <!-- Tab panes -->
                        <div class="tab-content">
                            <div class="tab-pane active" id="Login">
                                <form role="form" class="form-horizontal">
                                    <div class="form-group">
                                        <label for="email" class="col-sm-2 control-label">
                                            Email</label>
                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" id="email1" placeholder="Email"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputPassword1" class="col-sm-2 control-label">
                                            Password</label>
                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" id="exampleInputPassword1"
                                                   placeholder="Email"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="exampleInputPassword1" class="col-sm-2 control-label">
                                        </label>
                                        <div class="col-sm-10">
                                            <a href="javascript:;">Forgot your password?</a>

                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-2">
                                        </div>
                                        <div class="col-sm-10">
                                            <button type="submit" class="btn btn-primary btn-sm">
                                                Submit
                                            </button>

                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="tab-pane" id="Registration">
                                <form role="form" id="formRegistration" name="registration" class="form-horizontal">
                                    <div class="form-group">
                                        <label for="email" class="col-sm-2 control-label">
                                            Email</label>
                                        <div class="col-sm-10">
                                            <input name="email" type="email" class="form-control" id="email" placeholder="Email"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="password" class="col-sm-2 control-label">
                                            Password</label>
                                        <div class="col-sm-10">
                                            <input name="password" type="password" class="form-control" id="password"
                                                   placeholder="Password"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="confirmPassword" class="col-sm-2 control-label">
                                            Password</label>
                                        <div class="col-sm-10">
                                            <input type="password" name="confirmPassword" class="form-control" id="confirmPassword"
                                                   placeholder="Confirm Password"/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-2">
                                        </div>
                                        <div class="col-sm-10">
                                            <button class="btn btn-primary btn-sm">
                                                Save & Continue
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div id="OR" class="hidden-xs">
                            OR
                        </div>
                    </div>
                    <div class="col-md-4 mx-auto">
                        <div class="row text-center sign-with">
                            <div class="col-md-12">
                                <h3>
                                    Sign in with</h3>
                            </div>
                            <div class="col-md-12">
                                <div class="btn-group btn-group-justified">
                                    <a href="#" class="btn btn-primary">Facebook</a>
                                    <a href="#" id="login-button" disabled class="btn btn-danger">Google</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Start login and register -->

<div class="popup-wrap">
    <div class="popup-box">
        <h2>Xác thực</h2>
        <h3>Bạn cần vào email để xác thực</h3>
        <a class="close-btn popup-close" href="#">x</a>
    </div>
</div>

<!-- scripts -->
<c:forEach var="script" items="${javascripts}">
    <script src="<c:url value="${script}"/>"></script>
</c:forEach>
<%-- End scripts --%>
<script async defer src="https://apis.google.com/js/api.js" onload="this.onload=function(){};HandleGoogleApiLibrary()" onreadystatechange="if (this.readyState === 'complete') this.onload()"></script>

</body>
</html>