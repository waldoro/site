/*!
* Start Bootstrap - Agency v7.0.11 (https://startbootstrap.com/theme/agency)
* Copyright 2013-2022 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-agency/blob/master/LICENSE)
*/
//
// Scripts
//

window.addEventListener('DOMContentLoaded', event => {

    // Navbar shrink function
    var navbarShrink = function () {
        const navbarCollapsible = document.body.querySelector('#mainNav');
        if (!navbarCollapsible) {
            return;
        }
        if (window.scrollY === 0) {
            navbarCollapsible.classList.remove('navbar-shrink')
        } else {
            navbarCollapsible.classList.add('navbar-shrink')
        }

    };

    // Shrink the navbar
    navbarShrink();

    // Shrink the navbar when page is scrolled
    document.addEventListener('scroll', navbarShrink);

    // Activate Bootstrap scrollspy on the main nav element
    const mainNav = document.body.querySelector('#mainNav');
    if (mainNav) {
        new bootstrap.ScrollSpy(document.body, {
            target: '#mainNav',
            offset: 74,
        });
    }

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll('#navbarResponsive .nav-link')
    );
    responsiveNavItems.map(function (responsiveNavItem) {
        responsiveNavItem.addEventListener('click', () => {
            if (window.getComputedStyle(navbarToggler).display !== 'none') {
                navbarToggler.click();
            }
        });
    });

});

// Example starter JavaScript for disabling form submissions if there are invalid fields
(function () {
    'use strict';

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.querySelectorAll('.needs-validation');

    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
        .forEach(function (form) {
            form.addEventListener('submit', function (event) {
                if (!form.checkValidity()) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated')
            }, false)
        })
})();


function initValidacjaPodsumowanieForm() {

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.querySelectorAll('.needs-validation-podsumowanie')

    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
        .forEach(function (form) {
            form.addEventListener('submit', function (event) {
                let email = $("#email").val();
                let email2 = $("#email2").val();
                if (!form.checkValidity() || email !== email2) {
                    $("#email2").addClass("is-invalid");
                    event.preventDefault();
                    event.stopPropagation();
                } else {
                    form.classList.add('was-validated');
                }
                if (email === email2) {
                    $("#email2").removeClass("is-invalid");
                }


            }, false)
        })

}

// Example starter JavaScript for disabling form submissions if there are invalid fields
(function () {
    'use strict';
    initValidacjaPodsumowanieForm()
})();

//GALLERY
$('.portfolio-menu ul li').click(function () {
    $('.portfolio-menu ul li').removeClass('active');
    $(this).addClass('active');

    var selector = $(this).attr('data-filter');
    $('.portfolio-item').isotope({
        filter: selector
    });
    return false;
});

$(document).ready(function () {
    var popup_btn = $('.popup-btn');
    popup_btn.magnificPopup({
        type: 'image',
        gallery: {
            enabled: true
        }
    });
});

// Kontakt form


$(document).ready(function () {
    $('#contactForm input,textarea').on('input', () => {
        onFormFieldsChange();

    })
});

function onFormFieldsChange() {
    const name = $('#name').val();
    const email = $('#email').val();
    const message = $('#message').val();
    if (name?.length > 0 && email?.length > 0 && message?.length > 0 && $('#submitButton').hasClass('disabled')) {
        $('#submitButton').removeClass('disabled');
        $('#submitButton').on('click', onSubmitClick);
    } else if (name?.length === 0 || email?.length === 0 || message?.length === 0) {
        $('#submitButton').addClass('disabled');
        $('#submitButton').off();
    }
}

function onSubmitClick() {
    const name = $('#name').val();
    const email = $('#email').val();
    const message = $('#message').val();
    const phone = $('#phone').val();
    let data = {
        'name': encodeURIComponent(name),
        'email': email,
        'message': encodeURIComponent(message),
        'phone': phone,
    };
    let request = $.ajax({
        type: "POST",
        url: "/ks/contact/form",
        data: data
    });
    request.done(function (msg) {
        success();
    });

    request.fail(function (jqXHR, textStatus) {
        error();
    });
}

function success() {
    let elem = '<div class="success-message">Wiadomość została wysłana</div>';
    $('body').append(elem);
    $('#name').val("");
    $('#email').val("");
    $('#message').val("");
    $('#phone').val("");
    setTimeout(function () {
        $('.success-message').remove();
    }, 2000,);
}

function error() {
    let elem = '<div class="error-message">Problem z wysłaniem wiadomości</div>';
    $('body').append(elem);
    setTimeout(function () {
        $('.error-message').remove();
    }, 4000,);
}


$(document).ready(function () {
    const imgPath = $('.masthead').data('img-path');
    $('.masthead').css('background-image', 'url(' + imgPath + ')');
});

$(document).ready(function() {

    function calculateHeight() {
        var width = $('div.carousel-inner').outerWidth();
        $("div.carousel-inner").css("height", width * 1.44);
    }
    $(window).resize(function() {
        calculateHeight();
    });
    calculateHeight();
});