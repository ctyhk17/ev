var swiper_1 = new Swiper('.swiper-container-tab', {
        pagination: '.swiper-pagination',
        slidesPerView: 3,
        paginationClickable: true,
        spaceBetween: 0,
        freeMode: true,
		pagination: false
    });

	$('.tabs > li > a').on('click', function(e){
		$(this).parent().addClass('active').siblings().removeClass('active');
		var tabIdx = $(this).parent().index();
		swiper_2.slideTo(tabIdx+1, 300);
		e.preventDefault();
	});

	var tabLen = $('.tabs > li').length;
    /* End of swiper-container-tab 2017-06-27 */

	/* 2017-06-27 수정 */
	var swiper_2 = new Swiper('.swiper-container-2', {
		autoHeight: true,
        slidesPerView: 1,
        spaceBetween: 0,
		pagination: false,
		loop: true,
		onInit: function(swiper){
			
		},
		onSlideChangeStart: function(swiper){
			var idx = swiper.activeIndex-1;
			if( idx < 0 ) { 
				idx = tabLen - 1;
			} else if( idx == tabLen ){
				idx = 0;
			}
			$('.tabs > li').removeClass('active').eq(idx).addClass('active');
			if( idx < tabLen ) {
				swiper_1.slideTo(idx-1, 300);
			}
		}
    });
	/* End of container 2017-06-27  수정 */
    /* swiper-container-tab에서 swiper-container-2를 tab으로 사용할경우 div class="swiper-container-2" 사용할것 */