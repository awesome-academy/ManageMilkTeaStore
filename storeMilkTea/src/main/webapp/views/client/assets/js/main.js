(function ($) {
    "use strict";

    /*----------------------------
     jQuery MeanMenu
    ------------------------------ */
    $('nav#dropdown').meanmenu({
        meanScreenWidth: "991",
        meanMenuContainer: ".mobile-menu-area .container",
    });

    /*----------------------------
     wow js active
    ------------------------------ */
    new WOW().init();

    /*----------------------------
     owl active
    ------------------------------ */
    $(".product-curosel").owlCarousel({
        autoPlay: false,
        slideSpeed: 3000,
        pagination: false,
        navigation: false,
        items: 4,
        /* transitionStyle : "fade", */    /* [This code for animation ] */
        navigationText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"],
        itemsDesktop: [1199, 4],
        itemsDesktopSmall: [980, 3],
        itemsTablet: [767, 1],
        itemsMobile: [479, 1],
    });

    /*----------------------------
     owl active
    ------------------------------ */
    $(".upcoming-curosel").owlCarousel({
        autoPlay: false,
        slideSpeed: 3000,
        pagination: true,
        navigation: false,
        items: 1,
        /* transitionStyle : "fade", */    /* [This code for animation ] */
        navigationText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"],
        itemsDesktop: [1199, 1],
        itemsDesktopSmall: [980, 1],
        itemsTablet: [768, 1],
        itemsMobile: [479, 1],
    });
    /*----------------------------
     owl active
    ------------------------------ */
    $(".blog-curosel").owlCarousel({
        autoPlay: false,
        slideSpeed: 3000,
        pagination: false,
        navigation: false,
        items: 3,
        /* transitionStyle : "fade", */    /* [This code for animation ] */
        navigationText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"],
        itemsDesktop: [1199, 3],
        itemsDesktopSmall: [980, 3],
        itemsTablet: [768, 1],
        itemsMobile: [479, 1],
    });

    /*----------------------------
     owl active
    ------------------------------ */
    $(".brand-curosel").owlCarousel({
        autoPlay: false,
        slideSpeed: 3000,
        pagination: false,
        navigation: false,
        items: 6,
        /* transitionStyle : "fade", */    /* [This code for animation ] */
        navigationText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"],
        itemsDesktop: [1199, 5],
        itemsDesktopSmall: [980, 4],
        itemsTablet: [768, 2],
        itemsMobile: [479, 1],
    });

    /*----------------------------
     owl active
    ------------------------------ */
    $(".related-curosel").owlCarousel({
        autoPlay: false,
        slideSpeed: 3000,
        pagination: false,
        navigation: false,
        items: 4,
        /* transitionStyle : "fade", */    /* [This code for animation ] */
        navigationText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"],
        itemsDesktop: [1199, 3],
        itemsDesktopSmall: [980, 3],
        itemsTablet: [768, 2],
        itemsMobile: [479, 1],
    });
    /*----------------------------
     owl active
    ------------------------------ */
    $(".testimonial-carousel").owlCarousel({
        autoPlay: false,
        slideSpeed: 3000,
        pagination: true,
        navigation: false,
        items: 1,
        /* transitionStyle : "fade", */    /* [This code for animation ] */
        navigationText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"],
        singleItem: true,
    });
    /*----------------------------
     owl active
    ------------------------------ */
    $(".sale-off-carosel").owlCarousel({
        autoPlay: true,
        slideSpeed: 3000,
        pagination: false,
        navigation: false,
        items: 1,
        /* transitionStyle : "fade", */    /* [This code for animation ] */
        navigationText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"],
        singleItem: true,
    });

    /*----------------------------
     price-slider active
    ------------------------------ */
    $("#slider-range").slider({
        range: true,
        min: 40,
        max: 600,
        values: [60, 570],
        slide: function (event, ui) {
            $("#amount").val("$" + ui.values[0] + " - $" + ui.values[1]);
        }
    });
    $("#amount").val("$" + $("#slider-range").slider("values", 0) +
        " - $" + $("#slider-range").slider("values", 1));

    /*--------------------------
     scrollUp
    ---------------------------- */
    $.scrollUp({
        scrollText: '<i class="fa fa-angle-up"></i>',
        easingType: 'linear',
        scrollSpeed: 900,
        animation: 'fade'
    });

    /*---------------------
     countdown
    --------------------- */
    $('[data-countdown]').each(function () {
        var $this = $(this), finalDate = $(this).data('countdown');
        $this.countdown(finalDate, function (event) {
            $this.html(event.strftime('<span class="cdown days"><span class="time-count">%-D</span> <p>Days</p></span> <span class="cdown hour"><span class="time-count">%-H</span> <p>Hour</p></span> <span class="cdown minutes"><span class="time-count">%M</span> <p>Min</p></span> <span class="cdown second"> <span><span class="time-count">%S</span> <p>Sec</p></span>'));
        });
    });


    /*----- cart-plus-minus-button -----*/
    $(".cart-plus-minus").append('<div class="dec qtybutton">-</div><div class="inc qtybutton">+</div>');
    $(".qtybutton").on("click", function () {
        var $button = $(this);
        var oldValue = $button.parent().find("input").val();
        if ($button.text() == "+") {
            var newVal = parseFloat(oldValue) + 1;
        } else {
            // Don't allow decrementing below zero
            if (oldValue > 0) {
                var newVal = parseFloat(oldValue) - 1;
            } else {
                newVal = 0;
            }
        }
        $button.parent().find("input").val(newVal);
    });


    /*-------------------------
      showlogin toggle function
    --------------------------*/
    $('#showlogin').on('click', function () {
        $('#checkout-login').slideToggle(900);
    });

    /*-------------------------
      showcoupon toggle function
    --------------------------*/
    $('#showcoupon').on('click', function () {
        $('#checkout_coupon').slideToggle(900);
    });

    /*-------------------------
      Create an account toggle function
    --------------------------*/
    $('#cbox').on('click', function () {
        $('#cbox_info').slideToggle(900);
    });

    /*-------------------------
      Create an account toggle function
    --------------------------*/
    $('#ship-box').on('click', function () {
        $('#ship-box-info').slideToggle(1000);
    });


    $("#formRegistration").submit(function (e) {

        let Data = $(this).serializeArray().reduce(function (obj, item) {
            obj[item.name] = item.value;
            return obj;
        }, {});
        delete Data['confirmPassword'];
        $.ajax({
            type: "POST",
            url: "/users/register",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(Data),
            success: function (data) {
                $.fn.popupConfirm();
            },
            error: function (data) {
                $.fn.errorRegisterNotification();
            }
        });
        e.preventDefault();
    });

    $.fn.popupConfirm = function () {
        $('.popup-wrap').fadeIn(500);
        $('.popup-box').removeClass('transform-out').addClass('transform-in');

    };

    $('#popup-confirm-token').load(function () {
        $('.popup-wrap').fadeIn(500);
        $('.popup-box').removeClass('transform-out').addClass('transform-in');
        let statusMessages = $('#token-status').val();
        $('#token-title').text(statusMessages);
        if (statusMessages == "Expired") {
            $('#bt-create-token').show();
            $('#bt-success').hide();
        }
    });

    $('.popup-btn').click(function (e) {
        $('.popup-wrap').fadeIn(500);
        $('.popup-box').removeClass('transform-out').addClass('transform-in');

        e.preventDefault();
    });

    $('.popup-close').click(function (e) {
        $('.popup-wrap').fadeOut(500);
        $('.popup-box').removeClass('transform-in').addClass('transform-out');

        e.preventDefault();
    });


    $.fn.errorRegisterNotification = function () {

        $.notify({
            icon: "tim-icons icon-bell-55",
            message: "Khong th tao tai khoan"

        }, {
            type: 'danger',
            timer: 3000,
            placement: {
                from: 'top',
                align: 'right'
            }
        });
    }
    // ['primary', 'info', 'success', 'warning', 'danger'];


    let $_searchQuery = $('#search-query');


    $.ui.autocomplete.prototype._renderItem = function (ul, item) {
        let re = new RegExp($.trim(this.term.toLowerCase()));
        let t = item.label.replace(re, "<span style='font-weight:600;color:#5C5C5C;'>" + $.trim(this.term.toLowerCase()) +
            "</span>");
        return $("<li></li>")
            .data("item.autocomplete", item)
            .append("<div class=\"cart-img\">" +
                "<a href=\"#\"><img alt=\"\" src=\"/client/assets/img/cart/1.png\"></a>" +
                "</div>" +
                "<div class=\"cart-info\">" +
                "<h4>" +
                "<a href=\"#\">" + t + "</a>" +
                "</h4>" +
                "</div>")
            .appendTo(ul);
    };

    $.ajax({
        url: "/products",
        success: function (data) {
            $_searchQuery.autocomplete({
                source: $.fn.convertObjectToString(data)
            });
        },
        error: function (e) {
        }
    });

    $.fn.convertObjectToString = function (objects){
        let data = [];
         objects.forEach(function (element) {
             data.push(element.name)
         })
        return data;
    }


})(jQuery);




