/*!
 * Contained Sticky Scroll v1.1
 * http://blog.echoenduring.com/2010/11/15/freebie-contained-sticky-scroll-jquery-plugin/
 *
 * Copyright 2010, Matt Ward
*/
(function( $ ){

  $.fn.containedStickyScroll = function( options ) {
  
    
	var defaults = {  
		unstick : false,
        easing: 'linear',
        duration: 500,
        queue: false,
        closeChar: 'STOP',
        closeTop: 10,
        closeRight:10
	}

	var options =  $.extend(defaults, options);
    var getObject = $("#sidebar");
    var winoffset;
    
    winoffset = (window.innerHeight / 2) - ($(getObject).height() / 2) - 100;
    console.log("$(getObject).height() :  " + $(getObject).height());
    console.log("winoffset :  " + winoffset);
    //console.log("getObject :  " + $("#sidebar"));
    
    if(options.unstick == true){
        this.css({"position": "relative",
                  "top" : "0px"
        });
        
        /*this.append('<a class="scrollFixIt">' + options.closeChar + '</a>');
        $(getObject + ' .scrollFixIt').css('position','absolute');
        $(getObject + ' .scrollFixIt').css('top',options.closeTop + 'px');
        $(getObject + ' .scrollFixIt').css('right',options.closeTop + 'px');
        $(getObject + ' .scrollFixIt').css('cursor','pointer');
        $(getObject + ' .scrollFixIt').click(function() {
            $(getObject).animate({ top: "0px" },
                //$(getObject).animate({ top: winoffset + "px" },
                { queue: options.queue, easing: options.easing, duration: options.duration });
            $(window).unbind();
            $('.scrollFixIt').remove();
        });*/
    } else {
        this.css({"position": "relative",
            "top" : winoffset + "px"
        });
    }
    
    $(window).scroll(function() {

        winoffset =(window.innerHeight / 2) - ($(getObject).height() / 2);
        

        console.log("$(window).scrollTop() :  " + $(window).scrollTop());
        console.log("winoffset :  " + winoffset);
        
        if($(window).scrollTop() > ($(getObject).parent().offset().top) &&
          ($(getObject).parent().height() + $(getObject).parent().position().top - 30) > ($(window).scrollTop() + $(getObject).height())){
            
            $(getObject).animate({ top: ($(window).scrollTop() + winoffset ) + "px" }, 
            //$(getObject).animate({ top: ($(window).scrollTop() - $("body").offset().top + winoffset) + "px" }, 
            { queue: options.queue, easing: options.easing, duration: options.duration });
        }
        else if($(window).scrollTop() < ($(getObject).parent().offset().top)){
            $(getObject).animate({ top: winoffset},
            { queue: options.queue, easing: options.easing, duration: options.duration });
        }
    });

  };
})( jQuery );
