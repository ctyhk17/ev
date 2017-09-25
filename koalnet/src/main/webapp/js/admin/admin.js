$(document).ready(function(){
    
    
    $(document).ready(function(){
        $("#on").click(function(){
            $("#menu_m ul").slideToggle("slow");
             $("#one").toggleClass("one");
            $("#two").toggleClass("two");
            $("#three").toggleClass("three");
        });
    }); // End of m_menu
    
    


	$(".aside_menu_2").click(function(){     		
        $(this).parent().find("ul").stop().slideToggle(200);
        $(this).parent().find("span").stop().toggleClass('plus');
 	 });// End of side_menu
	
     $(".click_sub").click(function(){
          $(this).find("ul").stop().slideToggle(200);
    });// End of sub_menu
     
     $(".slide_left").click(function(){
         $(this).find("span").stop().toggleClass('this_span');
         $(".aside").toggleClass('aside_left');
      });// End of aside_menu
    
    
	        
});//End of ready