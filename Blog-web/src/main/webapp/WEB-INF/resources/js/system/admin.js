/*******************************************************************************
 * (c) Copyright 2017 lvxi. All Rights Reserved.
 ******************************************************************************/

/**
 * Created by lvxi on 2017/3/14.
 */
/**
 * 页面加载完毕调用
 */
$(document).ready(function () {
    $.mCustomScrollbar.defaults.theme="inset";
    $.mCustomScrollbar.defaults.scrollButtons.enable=true;
    $("#leftMenu .panel-body").mCustomScrollbar({
        axis:"y",
        autoHideScrollbar:true
    });
    $(".mCSB_container").css("margin-right","0px");


});
$(function() {
    var Accordion = function(el, multiple) {
        this.el = el || {};
        this.multiple = multiple || false;

        // Variables privadas
        var links = this.el.find('.link');
        console.log(links.size())
        // Evento
        links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
    }

    Accordion.prototype.dropdown = function(e) {
        var $el = e.data.el;
        $this = $(this),
            $next = $this.next();

        $next.slideToggle();
        $this.parent().toggleClass('open');
        /*
         if (!e.data.multiple) {
         $el.find('.submenu').not($next).slideUp().parent().removeClass('open');
         };*/
    }

    var accordion = new Accordion($('#accordion'), true);
});