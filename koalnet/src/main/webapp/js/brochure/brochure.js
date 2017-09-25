$(document).ready(function(){
    
    
    $(document).ready(function(){
        $("#on").click(function(){
            $("#of").slideToggle("slow");
             $("#one").toggleClass("one");
            $("#two").toggleClass("two");
            $("#three").toggleClass("three");
        });
    }); // End of m_menu    
    
    $(document).ready(function(){
        $(".slider_0").click(function(){
            $(".box_3_con_hide").slideDown("slow");
            $(".slider_0").hide();
        });
         $(".slider_1").click(function(){
            $(".box_3_con_hide_1").slideDown("slow");
             $(".slider_1").hide();
        });
         $(".slider_2").click(function(){
            $(".box_3_con_hide_2").slideDown("slow");
             $(".slider_2").hide();
        });
    });  // End of slider_0

});//End of ready