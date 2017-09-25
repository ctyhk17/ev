var option = {
		showOn: "both", 
		buttonImage: "/images/icon_calendar.gif", 
		buttonImageOnly: true,
		changeMonth: true, 
		changeYear: true,
		prevText: '이전달',
        nextText: '다음달',
        dateFormat: "yy-mm-dd",
        currentText: '오늘',
        monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
        monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
        dayNames: ['일','월','화','수','목','금','토'],
        dayNamesShort: ['일','월','화','수','목','금','토'],
        dayNamesMin: ['일','월','화','수','목','금','토'],
        weekHeader: 'Wk',
        dateFormat: 'yy-mm-dd',
        firstDay: 0,
        isRTL: false,
        showMonthAfterYear: true,
        yearSuffix: '년'
};
$.datepicker.setDefaults(option);



// 숫자 콤마 표시
function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

// 콤마 명시적 제거
function removeComma(str)
{
	var rtnVal = str.replace(/,/g,"");
	return rtnVal;
}


/** 
 * input 숫자와 콤마만 입력되게 하기.
 * include js : jquery.number.js
 * input 속성에 numberOnly 추가
 * jsp : <input type="text" id="amount" name="amount" numberOnly placeholder="0" />
 * $(this).number(true);
 * $.number( 5020.2364 );				// Outputs 5,020
 * $.number( 5020.2364, 2 );			// Outputs: 5,020.24
 * $.number( 135.8729, 3, ',' );		// Outputs: 135,873
 * $.number( 5020.2364, 1, ',', ' ' );	// Outputs: 5 020,2 
 */
 /*
$(document).on("keyup", "input:text[numberOnly]", function() {
	$(this).number(true);
});
 */





