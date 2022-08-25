const $gallery = $('.js-gallery');
const $thumbs = $('.js-thumbs');
const slideNumber = $gallery.find('.swiper-slide').length / 3;
const slidesPerView = 3;
let targetIndex;

const activeSlideClass = 'active';
let $thumbsActiveSlide;
let $galleryActiveSlide;

jQuery(document).ready(function ($) {
  $('#slow_nav  ul li').hover(
      function () {
        $('ul', this).stop().slideDown(400);
      },
      function () {
        $('ul', this).stop().slideUp(400);
      }
  );
});

//Бургерное меню и overlay
var btn__burger = $('.header .btn__burger');
var btn__burger2 = $('.overlay .btn__burger');

btn__burger.on('click', function() {
  
  btn__burger.removeClass('active');
  document.body.classList.add("lock-scroll");
  // btn__burger.removeClass('not-active');

  btn__burger2.addClass('active');
  // btn__burger2.addClass('not-active');

  $('.overlay').toggleClass('open');
  $('html').toggleClass('overflow');
});

btn__burger2.on('click', function() {
  document.body.classList.remove("lock-scroll");
  btn__burger2.addClass('active');
  
  // btn__burger2.addClass('not-active');

//   btn__burger.removeClass('active');
  
  
  btn__burger.removeClass('not-active');

  $('.overlay').toggleClass('open');
  $('html').toggleClass('overflow');
  
});

$('.overlay ul a').on('click',function(){
  $('.overlay').toggleClass('open');
  $('html').toggleClass('overflow');
//   btn__burger.toggleClass('active');
  btn__burger.toggleClass('not-active');
  $('.overlay').toggleClass('open');

});

var openVideo = document.querySelector(".play");
var videoPopUp = document.querySelector(".dark");

if (openVideo) {
    openVideo.addEventListener("click", function(event) {
    event.preventDefault();
    videoPopUp.classList.toggle("show");
    document.body.classList.add("lock-scroll");
    });


    videoPopUp.addEventListener("click", function(event) {
    event.preventDefault();
    $('.youtube-video')[0].contentWindow.postMessage('{"event":"command","func":"' + 'stopVideo' + '","args":""}', '*');
    videoPopUp.classList.remove("show");
    document.body.classList.remove("lock-scroll");
    });
}

$(document).ready(function () {
 
  }
      const $gallery = $('.js-gallery');
      const $thumbs = $('.js-thumbs');
      const slideNumber = $gallery.find('.swiper-slide').length / 3;
      const slidesPerView = 3;
      let targetIndex;
  
      const activeSlideClass = 'active';
      let $thumbsActiveSlide;
      let $galleryActiveSlide;
  
  
      let swiperGallery = new Swiper($gallery, {
          direction: 'vertical',
          loop: true,
          loopAdditionalSlides: 0,
          initialSlide: slideNumber,
          speed: 700,
          simulateTouch: false,
          spaceBetween: 20 });
  
  
      let swiperThumbs = new Swiper($thumbs, {
          direction: 'vertical',
          loop: true,
          loopAdditionalSlides: 0,
          slidesPerView: slidesPerView,
          initialSlide: slideNumber,
          centeredSlides: true,
          slideToClickedSlide: true,
          speed: 500,
          spaceBetween: 20 });
  
  
  //add custom active class for smooth animation
      $thumbsActiveSlide = $(swiperThumbs.slides).filter('.swiper-slide-active');
      $galleryActiveSlide = $(swiperGallery.slides).filter('.swiper-slide-active');
      $thumbsActiveSlide.addClass(activeSlideClass);
      $galleryActiveSlide.addClass(activeSlideClass);
  //---------------------------------------------
  
  
      swiperThumbs.on("slideChangeTransitionStart", function () {
          //add custom active class for smooth animation
          $thumbsActiveSlide = $(swiperThumbs.slides).filter('.swiper-slide-active');
          $thumbsActiveSlide.siblings().removeClass(activeSlideClass);
          //---------------------------------------------
  
          targetIndex = Number(swiperThumbs.realIndex);
          swiperThumbs.detachEvents();
          swiperGallery.slideTo(targetIndex + 1, 700, true);
      });
  
  // swiperThumbs.on("slideChangeTransitionEnd", function () {
  //   swiperThumbs.attachEvents();
  // });
  
      swiperGallery.on("slideChangeTransitionStart", function () {
          //add custom active class for smooth animation
          $galleryActiveSlide = $(swiperGallery.slides).filter('.swiper-slide-active');
          $galleryActiveSlide.siblings().removeClass(activeSlideClass);
          //---------------------------------------------
      });
  
      swiperGallery.on("slideChangeTransitionEnd", function () {
          if (targetIndex < slideNumber) {
              targetIndex += slideNumber;
              teleportTo(targetIndex);
          } else if (targetIndex >= slideNumber * 2) {
              targetIndex -= slideNumber;
              teleportTo(targetIndex);
          } else {
              //add custom active class for smooth animation
              $thumbsActiveSlide.addClass(activeSlideClass);
              $galleryActiveSlide.addClass(activeSlideClass);
              //---------------------------------------------
          }
          swiperThumbs.attachEvents();
      });
  
      function teleportTo(slideIndex) {
          swiperThumbs.slideTo(slideIndex + slidesPerView, 0, false);
          swiperGallery.slideTo(slideIndex + 1, 0, false);
  
          //add custom active class for smooth animation
          $thumbsActiveSlide = $(swiperThumbs.slides).filter('.swiper-slide-active');
          $galleryActiveSlide = $(swiperGallery.slides).filter('.swiper-slide-active');
          $thumbsActiveSlide.addClass(activeSlideClass);
          $galleryActiveSlide.addClass(activeSlideClass);
          //---------------------------------------------
      }
  
  //If u have images with lazy add this after swipers init
      function fixLazy() {
          let gallerylastIndex = slideNumber * 2;
          let thumbslastIndex = slideNumber * 2 + slidesPerView - 1;
          let $lastGallerySlide = $(swiperGallery.slides[gallerylastIndex]).find('.swiper-lazy');
          let $lastThumbsSlide = $(swiperThumbs.slides[thumbslastIndex]).find('.swiper-lazy');
  
          removeLazySlide($lastGallerySlide);
          removeLazySlide($lastThumbsSlide);
  
          let counter;
  
          if ((slidesPerView - 1) % 2 !== 0) {
              counter = Math.floor((slidesPerView - 1) / 2) + 1;
          } else {
              counter = (slidesPerView - 1) / 2;
          }
  
          for (let i = 0; i < counter; i++) {if (window.CP.shouldStopExecution(0)) break;
  
              let $prevSlide = $(swiperThumbs.slides[thumbslastIndex - (i + 1)]).find('.swiper-lazy');
              let $nextSlide = $(swiperThumbs.slides[thumbslastIndex + (i + 1)]).find('.swiper-lazy');
  
              removeLazySlide($prevSlide);
              removeLazySlide($nextSlide);
          }window.CP.exitedLoop(0);
      }
  
      function removeLazySlide($slide) {
          let data = $slide.data('background');
          $slide.attr('style', `background-image: url('${data}')`);
          $slide.removeAttr('data-background');
          $slide.addClass('swiper-lazy-loaded');
          $slide.empty();
      }
  });
  $(window).scroll(function () {
      var scrollPercent = 100 * $(window).scrollTop() / ($(document).height() - $(window).height());
      $('.bar__long').css('width', scrollPercent + "%");
  });
  
  jQuery(document).ready(function ($) {
      $('#slow_nav  ul li').hover(
          function () {
              $('ul', this).stop().slideDown(400);
          },
          function () {
              $('ul', this).stop().slideUp(400);
          }
      );
  });
  
  var swiper = new Swiper('.swiper-container', {
    slidesPerView: 4,
    spaceBetween: 30,
    slidesToScroll: 4,
    centeredSlides: false,
    autoplay: {
        delay: 1200,
        disableOnInteraction: false,
    },
    loop:true,
    pagination: {
        el: '.swiper-pagination',
        clickable: true,
    },
    breakpoints: {
        // when window width is >= 320px
        320: {
            slidesPerView: 1,
            spaceBetween: 20
        },
        // when window width is >= 480px
        480: {
            slidesPerView: 3,
            spaceBetween: 30
        },
        // when window width is >= 640px
        640: {
            slidesPerView: 4,
            spaceBetween: 40
        }
    }
});
  
var years = document.getElementById("years");
years ? years.innerHTML = new Date().getFullYear() - 1961 : null;

var currentYear = document.getElementById("currentYear");
currentYear ? currentYear.innerHTML = new Date().getFullYear() : null;
  
var google_language_translator = document.getElementById("google_language_translator");
google_language_translator ? google_language_translator.classList.add("hide") : null;

var uk = document.getElementsByClassName("uk");
var ukFlag = document.createElement("div");
ukFlag.setAttribute('class', 'ukFlag');
var ukFlag2 = document.createElement("div");
ukFlag2.setAttribute('class', 'ukFlag');
uk[0].appendChild(ukFlag);
uk[1].appendChild(ukFlag2);

var en = document.getElementsByClassName("en");
var enFlag = document.createElement("div");
enFlag.setAttribute('class', 'enFlag');
var enFlag2 = document.createElement("div");
enFlag2.setAttribute('class', 'enFlag');
en[0].appendChild(enFlag);
en[1].appendChild(enFlag2);

var fr = document.getElementsByClassName("fr");
var frFlag = document.createElement("div");
frFlag.setAttribute('class', 'frFlag');
var frFlag2 = document.createElement("div");
frFlag2.setAttribute('class', 'frFlag');
fr[0].appendChild(frFlag);
fr[1].appendChild(frFlag2);

