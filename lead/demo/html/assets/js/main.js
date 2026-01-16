(function ($) {
    "use strict";

    //========== Preloader Start =========//
    $(window).on('load', function () {
        $('.preloader').fadeOut(1000);
    });
    //========== Preloader Start =========//




    //========== Lightcase Start =========//
    $('a[data-rel^=lightcase]').lightcase();

    //========== Preloader End =========//


    //========== Pure counter initializing start =========//
    new PureCounter();
    //========== Pure counter initializing end =========//



    $(document).ready(function () {

        //initialized the nice select
        $('select').niceSelect();


        //background image insert from data-attribute
        function background() {
            var img = $('.bg--image');
            img.css('background-image', function () {
                var bg = ('url(' + $(this).data('background') + ')');
                return bg;
            });
        }
        background();

        //========== Scroll to top Start =========//
        $(function () {
            $(window).on('scroll', function () {
                if ($(this).scrollTop() > 300) {
                    $('.scrollToTop').css({
                        'bottom': '5%',
                        'opacity': '1',
                        'transition': 'all .5s ease'
                    });
                } else {
                    $('.scrollToTop').css({
                        'bottom': '-30%',
                        'opacity': '0',
                        'transition': 'all .5s ease'
                    })
                }
            });

            //Click event to scroll to top
            $('a.scrollToTop').on('click', function () {
                $('html, body').animate({
                    scrollTop: 0
                }, 500);
                return false;
            });
        });

        //========== Scroll to to top end =========//


        // wow animation
        // new WOW().init();




        //====banner  slider================
        var swiper = new Swiper(".banner__slider", {
            slidesPerView: 1,
            spaceBetween: 20,
            loop: true,
            autoplay: {
                delay: 3500,
                disableOnInteraction: false,
            },
        });

        //====feature category slider================
        var swiper = new Swiper(".feature-category__slider", {
            slidesPerView: 2,
            spaceBetween: 15,
            autoplay: {
                delay: 5000,
                disableOnInteraction: false,
            },
            navigation: {
                nextEl: ".feature-category__slider-next",
                prevEl: ".feature-category__slider-prev",
            },
            breakpoints: {
                576: {
                    slidesPerView: 3,
                    spaceBetween: 20,
                },
                992: {
                    slidesPerView: 4,
                },
                1200: {
                    slidesPerView: 5,
                    spaceBetween: 30,
                },
                1400: {
                    slidesPerView: 6,
                },
            },
        });



        //====best deal slider================
        var swiper = new Swiper(".best-deal__slider", {
            slidesPerView: 1,
            spaceBetween: 24,
            autoplay: {
                delay: 5000,
                disableOnInteraction: false,
            },
            navigation: {
                nextEl: ".best-deal__slider-next",
                prevEl: ".best-deal__slider-prev",
            },
            breakpoints: {

                1200: {
                    slidesPerView: 2,
                },
            },
        });



        //============= product quick view slider =================
        var proThumb = new Swiper(".product__single-thumbslider", {
            loop: true,
            spaceBetween: 10,
            slidesPerView: 3,
            freeMode: true,
            watchSlidesProgress: true,
        });

        var proSingle = new Swiper(".product__single-slider", {
            loop: true,
            spaceBetween: 10,
            navigation: {
                nextEl: ".product__single-next",
                prevEl: ".product__single-prev",
            },
            // thumbs: {
            //     swiper: proThumb,
            // },
        });


        //testimonial-slider 
        var swiper = new Swiper(".related-product__slider", {
            slidesPerView: 1,
            spaceBetween: 24,
            autoplay: {
                delay: 3500,
                disableOnInteraction: false,
            },
            loop: true,
            breakpoints: {
                576: {
                    slidesPerView: 2,
                },
                768: {
                    slidesPerView: 3,
                },
                1200: {
                    slidesPerView: 4,
                },
                1400: {
                    slidesPerView: 5,
                },
            },
        });


        //testimonial-slider 
        var swiper = new Swiper(".testimonial__slider", {
            slidesPerView: 1,
            spaceBetween: 24,
            autoplay: {
                delay: 3500,
                disableOnInteraction: false,
            },
            loop: true,
            breakpoints: {
                768: {
                    slidesPerView: 2,
                },
                1024: {
                    slidesPerView: 3,
                },
            },
        });

        //testimonial slider 2
        var swiper = new Swiper(".testimonial__slider2", {
            spaceBetween: 30,
            loop: true,
            autoplay: {
                delay: 3500,
                disableOnInteraction: false,
            },
            hashNavigation: {
                watchState: true,
            },
            pagination: {
                el: ".testimonial__slider2-pagination",
                clickable: true,
            },
        });



        //blog-slider (blog section style 2)
        var swiper = new Swiper(".blog__slider", {
            slidesPerView: 1,
            spaceBetween: 24,
            autoplay: {
                delay: 3500,
                disableOnInteraction: false,
            },
            navigation: {
                nextEl: ".blog__slider-next",
                prevEl: ".blog__slider-prev",
            },
            loop: true,
            breakpoints: {
                576: {
                    slidesPerView: 2,
                },
            },
        });


        //========== case masonry Start =========//

        $(window).on('load', function () {
            // init Isotope
            var $grid = $('.case__gallery').isotope({
                itemSelector: '.masonary-item',
                // layoutMode: 'fitRows',
                masonry: {
                    columnWidth: 0,
                }
            });

            // filter functions
            var filterFns = {
                // show if number is greater than 50
                numberGreaterThan50: function () {
                    var number = $(this).find('.number').text();
                    return parseInt(number, 10) > 50;
                },
            };

            // bind filter button click
            $('.case__filter').on('click', 'li', function () {
                var filterValue = $(this).attr('data-filter');
                // use filterFn if matches value
                filterValue = filterFns[filterValue] || filterValue;
                $grid.isotope({
                    filter: filterValue
                });
            });


            // change is-checked class on buttons
            $('.case__filter').each(function (i, buttonGroup) {
                var $buttonGroup = $(buttonGroup);
                $buttonGroup.on('click', 'li', function () {
                    $buttonGroup.find('.is-checked').removeClass('is-checked');
                    $(this).addClass('is-checked');
                });
            });
        });



        //======== Shop cart quantity ============
        // shop cart + - start here
        var CartPlusMinus = $('.cart-plus-minus');
        CartPlusMinus.prepend('<div class="dec qtybutton">-</div>');
        CartPlusMinus.append('<div class="inc qtybutton">+</div>');
        $(".qtybutton").on("click", function () {
            var $button = $(this);
            var oldValue = $button.parent().find("input").val();
            if ($button.text() === "+") {
                var newVal = parseFloat(oldValue) + 1;
            } else {
                // Don't allow decrementing below zero
                if (oldValue > 0) {
                    var newVal = parseFloat(oldValue) - 1;
                } else {
                    newVal = 1;
                }
            }
            $button.parent().find("input").val(newVal);
        });
    });






    //progressbar
    window.addEventListener('DOMContentLoaded', function () {
        const circle = new CircularProgressBar('pie');
        setInterval(() => {
            const options = {
                index: 0,
                percent: Math.floor((Math.random() * 100) + 1)
            }
            circle.animationTo(options);
        }, 2000);
    });



    //contact form js
    $(function () {
        // Get the form.
        var form = $('#contact-form');
        // Get the messages div.
        var formMessages = $('.form-message');
        // Set up an event listener for the contact form.
        $(form).submit(function (e) {
            // Stop the browser from submitting the form.
            e.preventDefault();
            // Serialize the form data.
            var formData = $(form).serialize();
            // Submit the form using AJAX.
            $.ajax({
                    type: 'POST',
                    url: $(form).attr('action'),
                    data: formData
                })
                .done(function (response) {
                    // Make sure that the formMessages div has the 'success' class.
                    $(formMessages).removeClass('error');
                    $(formMessages).addClass('success');
                    // Set the message text.
                    $(formMessages).text(response);
                    // Clear the form.
                    $('#contact-form input, #contact-form textarea').val('');
                })
                .fail(function (data) {
                    // Make sure that the formMessages div has the 'error' class.
                    $(formMessages).removeClass('success');
                    $(formMessages).addClass('error');
                    // Set the message text.
                    if (data.responseText !== '') {
                        $(formMessages).text(data.responseText);
                    } else {
                        $(formMessages).text('Oops! An error occured and your message could not be sent.');
                    }
                });
        });
    });


    //Countdown js initialization
    document.addEventListener('readystatechange', event => {
        if (event.target.readyState === "complete") {
            var clockdiv = document.getElementsByClassName("countdown");
            var countDownDate = new Array();
            for (var i = 0; i < clockdiv.length; i++) {
                countDownDate[i] = new Array();
                countDownDate[i]['el'] = clockdiv[i];
                countDownDate[i]['time'] = new Date(clockdiv[i].getAttribute('data-date')).getTime();
                countDownDate[i]['days'] = 0;
                countDownDate[i]['hours'] = 0;
                countDownDate[i]['seconds'] = 0;
                countDownDate[i]['minutes'] = 0;
            }

            var countdownfunction = setInterval(function () {
                for (var i = 0; i < countDownDate.length; i++) {
                    var now = new Date().getTime();
                    var distance = countDownDate[i]['time'] - now;
                    countDownDate[i]['days'] = Math.floor(distance / (1000 * 60 * 60 * 24));
                    countDownDate[i]['hours'] = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                    countDownDate[i]['minutes'] = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                    countDownDate[i]['seconds'] = Math.floor((distance % (1000 * 60)) / 1000);

                    if (distance < 0) {
                        countDownDate[i]['el'].querySelector('.countdown__number-days').innerHTML = 0;
                        countDownDate[i]['el'].querySelector('.countdown__number-hours').innerHTML = 0;
                        countDownDate[i]['el'].querySelector('.countdown__number-minutes').innerHTML = 0;
                        countDownDate[i]['el'].querySelector('.countdown__number-seconds').innerHTML = 0;
                    } else {
                        countDownDate[i]['el'].querySelector('.countdown__number-days').innerHTML = countDownDate[i]['days'];
                        countDownDate[i]['el'].querySelector('.countdown__number-hours').innerHTML = countDownDate[i]['hours'];
                        countDownDate[i]['el'].querySelector('.countdown__number-minutes').innerHTML = countDownDate[i]['minutes'];
                        countDownDate[i]['el'].querySelector('.countdown__number-seconds').innerHTML = countDownDate[i]['seconds'];
                    }
                }
            }, 1000);
        }
    });


    //header category
    document.addEventListener('click', function (e) {
        if (e.target && e.target.id != 'category-btn') {
            $('.overlay').removeClass('active');
        }
    });

    $(".dropdown-toggle").click(function () {
        $('.overlay').toggleClass('active');
    });

    $('.primary-nav').coreNavigation({
        menuPosition: "left", // left, right, center, bottom
        container: true, // true or false
        animated: true,
        responsideSlide: true,
        animatedIn: 'animate__fadeInDown',
        animatedOut: 'animate__fadeOutUp',
        dropdownEvent: 'click', // Hover, Click & Accordion
    });

    //mobile menu toggle bar active class add for collapsing style
    $('.toggle-bar').on('click', function () {
        $(this).toggleClass('open');
    })
    $('.dropdown-overlay').on('click', function (e) {
        var element = $('.toggle-bar');
        if (element.hasClass('open')) {
            element.removeClass('open');
        }
    });


    //mobile menu top header showing toggle class
    $('.toogle-bar-top').on('click', function (e) {
        var element = $('.header__middle');
        if (element.hasClass('show')) {
            element.removeClass('show');
            element.slideUp(400, "swing");
            $('.overlayTwo').removeClass('active');
        } else {
            element.addClass('show');
            element.slideDown(400, "swing");
            $('.overlayTwo').addClass('active');
        }
    });



    //==== Range slider
    var $range = $(".widget__price-slider"),
        $inputFrom = $(".widget__price-from"),
        $inputTo = $(".widget__price-to"),
        instance,
        min = 0,
        max = 1000,
        from = 0,
        to = 0;

    $range.ionRangeSlider({
        skin: "round",
        type: "double",
        min: min,
        max: max,
        from: 200,
        to: 800,
        onStart: updateInputs,
        onChange: updateInputs,
        prefix: "$"
    });
    instance = $range.data("ionRangeSlider");

    function updateInputs(data) {
        from = data.from;
        to = data.to;

        $inputFrom.prop("value", from);
        $inputTo.prop("value", to);
    }

    $inputFrom.on("input", function () {
        var val = $(this).prop("value");

        // validate
        if (val < min) {
            val = min;
        } else if (val > to) {
            val = to;
        }

        instance.update({
            from: val
        });
    });

    $inputTo.on("input", function () {
        var val = $(this).prop("value");

        // validate
        if (val < from) {
            val = from;
        } else if (val > max) {
            val = max;
        }

        instance.update({
            to: val
        });
    });

}(jQuery));