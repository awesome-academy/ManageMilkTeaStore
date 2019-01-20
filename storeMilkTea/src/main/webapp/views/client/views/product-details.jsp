<%--
  Created by IntelliJ IDEA.
  User: tungct
  Date: 2019-01-02
  Time: 00:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- shop-area start -->
<div class="shop-area">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="row">
                    <div class="col-md-5 col-sm-5 col-xs-12">
                        <div class="single-pro-tab-content">
                            <!-- Tab panes -->
                            <div class="tab-content">
                                <div role="tabpanel" class="tab-pane active" id="home"><a href="#"><img class="zoom" src="img/product/15.jpg" data-zoom-image="img/product/15.jpg" alt="" /></a></div>
                                <div role="tabpanel" class="tab-pane" id="profile"><a href="#"><img class="zoom" src="img/product/9.jpg" data-zoom-image="img/product/9.jpg" alt="" /></a></div>
                                <div role="tabpanel" class="tab-pane" id="messages"><a href="#"><img class="zoom" src="img/product/3.jpg" data-zoom-image="img/product/3.jpg" alt="" /></a></div>
                                <div role="tabpanel" class="tab-pane" id="settings"><a href="#"><img class="zoom" src="img/product/4.jpg" data-zoom-image="img/product/4.jpg" alt="" /></a></div>
                                <div role="tabpanel" class="tab-pane" id="settingss"><a href="#"><img class="zoom" src="img/product/4.jpg" data-zoom-image="img/product/4.jpg" alt="" /></a></div>
                            </div>
                            <!-- Nav tabs -->
                            <ul class="single-product-tab" role="tablist">
                                <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab"><img src="img/product/15.jpg" alt="" /></a></li>
                                <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab"><img src="img/product/9.jpg" alt="" /></a></li>
                                <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab"><img src="img/product/3.jpg" alt="" /></a></li>
                                <li role="presentation"><a href="#settingss" aria-controls="settings" role="tab" data-toggle="tab"><img src="img/product/4.jpg" alt="" /></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-7 col-sm-7 col-xs-12 shop-list shop-details">
                        <div class="product-content">
                            <h3><a href="single-product.html">${product.name}</a></h3>
                            <div class="price">
                                <span>$${product.price}</span>
                            </div>
                            <div class="s-p-rating">
                                <span class="review-no">04 Review (s)</span>
                                <span class="review-no add-review"><a href="#reviews">Add your review</a></span>
                            </div>
                            <div class="pro-size">
                                <label>size <span>*</span></label>
                                <select>
                                    <c:forEach var="size" items="${sizes}">
                                        <option value="${size.size}">${size.size}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="product-action">
                                <div class="cart-plus">
                                    <form action="#">
                                        <div class="cart-plus-minus"><input type="text" value="1" /></div>
                                    </form>
                                </div>
                                <div class="button-cart">
                                    <button><i class="fa fa-shopping-cart"></i> add to cart</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <div class="product-tabs">
                            <div>
                                <!-- Nav tabs -->
                                <ul class="pro-details-tab" role="tablist">
                                    <li role="presentation"><a href="#page-comments" aria-controls="page-comments" role="tab" data-toggle="tab">Reviews (1)</a></li>
                                </ul>
                                <!-- Tab panes -->
                                <div class="tab-content">
                                    <div role="tabpanel" class="tab-pane active" id="page-comments">
                                        <div class="product-tab-desc">
                                            <div class="product-page-comments">
                                                <h2>1 review for Integer consequat ante lectus</h2>
                                                <ul>
                                                    <li>
                                                        <div class="product-comments">
                                                            <img src="img/author.jpg" alt="" />
                                                            <div class="product-comments-content">
                                                                <p><strong>admin</strong> -
                                                                    <span>March 7, 2015:</span>
                                                                    <span class="pro-comments-rating">
																				<i class="fa fa-star"></i>
																				<i class="fa fa-star"></i>
																				<i class="fa fa-star"></i>
																				<i class="fa fa-star"></i>
																			</span>
                                                                </p>
                                                                <div class="desc">
                                                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam fringilla augue nec est tristique auctor. Donec non est at libero vulputate rutrum.
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </li>
                                                </ul>
                                                <div class="review-form-wrapper">
                                                    <h3>Add a review</h3>
                                                    <form action="#">
                                                        <input type="text" placeholder="your name"/>
                                                        <input type="email" placeholder="your email"/>
                                                        <div class="your-rating">
                                                            <h5>Your Rating</h5>
                                                            <span>
																		<a href="#"><i class="fa fa-star"></i></a>
																		<a href="#"><i class="fa fa-star"></i></a>
																	</span>
                                                            <span>
																		<a href="#"><i class="fa fa-star"></i></a>
																		<a href="#"><i class="fa fa-star"></i></a>
																		<a href="#"><i class="fa fa-star"></i></a>
																	</span>
                                                            <span>
																		<a href="#"><i class="fa fa-star"></i></a>
																		<a href="#"><i class="fa fa-star"></i></a>
																		<a href="#"><i class="fa fa-star"></i></a>
																		<a href="#"><i class="fa fa-star"></i></a>
																	</span>
                                                            <span>
																		<a href="#"><i class="fa fa-star"></i></a>
																		<a href="#"><i class="fa fa-star"></i></a>
																		<a href="#"><i class="fa fa-star"></i></a>
																		<a href="#"><i class="fa fa-star"></i></a>
																		<a href="#"><i class="fa fa-star"></i></a>
																	</span>
                                                        </div>
                                                        <textarea id="product-message" cols="30" rows="10" placeholder="Your Rating"></textarea>
                                                        <input type="submit" value="submit" />
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="section-title">
                            <h2>Related product</h2>
                            <div class="title-icon">
                                <span><i class="fa fa-angle-left"></i> <i class="fa fa-angle-right"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="related-curosel">
                        <c:forEach var="product" items="${relateProducts}">
                            <!-- single-product start -->
                            <div class="col-md-12">
                                <div class="single-product">
                                    <div class="product-img">
                                        <a href="single-product.html">
                                            <img src="img/product/2.jpg" alt="" />
                                            <img class="secondary-img" src="img/product/1.jpg" alt="" />
                                        </a>
                                        <div class="product-action">
                                            <div class="button-top">
                                                <a href="#" data-toggle="modal" data-target="#productModal"><i class="fa fa-search"></i></a>
                                                <a href="#" ><i class="fa fa-heart"></i></a>
                                            </div>
                                            <div class="button-cart">
                                                <button><i class="fa fa-shopping-cart"></i> add to cart</button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="product-content">
                                        <h3><a href="/products/${product.id}">${product.name}</a></h3>
                                        <div class="price">
                                            <span>$${product.price}</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- single-product end -->
                        </c:forEach>
                    </div>
                </div>
            </div>
            <!-- left-sidebar start -->
            <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                <!-- widget-categories start -->
                <aside class="widget widget-categories">
                    <h3 class="sidebar-title">Categories</h3>
                    <ul class="sidebar-menu">
                        <li><a href="#">Clothes</a> <span class="count">(14)</span></li>
                        <li><a href="#">Men</a> <span class="count">(9)</span></li>
                        <li><a href="#">Shoes</a> <span class="count">(2)</span></li>
                        <li><a href="#">Sunglasses</a> <span class="count">(2)</span></li>
                        <li><a href="#">Women</a> <span class="count">(8)</span></li>
                    </ul>
                </aside>
                <!-- widget-categories end -->
                </div>
            <!-- left-sidebar end -->
        </div>
    </div>
</div>
<!-- shop-area end -->
