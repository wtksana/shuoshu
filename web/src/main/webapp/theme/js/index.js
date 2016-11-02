/**
 * Created by mutou on 2016/11/2.
 */
function ajaxUrl(param){
    $.ajax({
        type:'get',
        url:'/invest/investJson.html?' + param + '&randomTime=' + (new Date()).getTime(),
        dataType:'json',
        success:function(json){
            if (json.result != undefined && !json.result) {
                //当存在非法字符时，模拟数据为空
                $('.investListBox').html("");
                $("#kkpager").html('暂无数据');
                $('.quickBar').find('em').html('0');
                return;
            }
            //总记录数
            $(".quickBar span em").html(json.data.page.total);
            require.async('/plugins/handlebars-v1.3.0/handlebars-v1.3.0.js',function(){
                require.async('/plugins/handlebars-v1.3.0/transFormatJson',function(){
                    var tpl = require('../../tpl/investList.tpl');
                    var template = Handlebars.compile(tpl);
                    var html = template(json);
                    $('.investListBox').html(html);
                    //偶数行增加背景颜色
                    /*$(".investItem:odd").addClass("investItemBg");*/
                    //不同的进度，更换成不同的颜色
                    require.async('/plugins/jquery.knob/jquery.knob.min',function(){
                        $('.knob').each(function(){
                            var val = parseInt($(this).val());
                            if(val <= 25 && val > 0)
                            {
                                $(this).attr("data-fgColor","#33cb57");
                            }
                            else if(val == 0)
                            {
                                $(this).attr("data-fgColor","#33cb57");
                            }
                            else if(val > 25 && val <= 50)
                            {
                                $(this).attr("data-fgColor","#33cb57");
                            }
                            else if(val > 50 && val < 100)
                            {
                                $(this).attr("data-fgColor","#33cb57");
                            }
                            else if(val == 100)
                            {
                                var isIE = function(ver){
                                    var b = document.createElement('b')
                                    b.innerHTML = '<!--[if IE ' + ver + ']><i></i><![endif]-->'
                                    return b.getElementsByTagName('i').length === 1
                                }
                                if(isIE(8)){
                                    $(this).parent().addClass("investComplete100");
                                }
                                $(this).attr("data-fgColor","#33cb57");
                            }
                        });
                        $('.knob').knob({
                            'width':50,
                            'height':50,
                            'thickness':.1,
                            'readOnly' : true
                        });

                    });
                });
            });

            //分页插件
            if(json.data.page.pages > 0)
            {
                require.async(['/plugins/pager/pager.css','/plugins/pager/pager'],function(){
                    kkpager.generPageHtml({
                        pno : json.data.page.currentPage,//当前页码
                        total : json.data.page.pages,//总页码
                        totalRecords : json.data.page.total,//总数据条数
                        isShowFirstPageBtn	: false,
                        isShowLastPageBtn	: false,
                        isShowTotalPage 	: false,
                        isShowTotalRecords 	: false,
                        isGoPage 			: false,
                        lang:{
                            prePageText				: '<',
                            nextPageText			: '>'
                        },
                        mode:'click',//click模式匹配getHref 和 click
                        click:function(n,total,totalRecords){
                            $.ajax({
                                type:"get",
                                url:"/invest/investJson.html?" + param + "&randomTime=" + (new Date()).getTime() + "&page=" + n,
                                dataType:"json",//这个必不可少，如果缺少，导致传回来的不是json格式
                                success:function(json){
                                    require.async(['/plugins/handlebars-v1.3.0/handlebars-v1.3.0.js','/plugins/handlebars-v1.3.0/transFormatJson'],function(){
                                        var tpl = require('../../tpl/investList.tpl');
                                        var template = Handlebars.compile(tpl);
                                        var html    = template(json);
                                        $('.investListBox').html(html);
                                        //偶数行增加背景颜色
                                        $(".investItem:odd").addClass("investItemBg");
                                        //判断是否是IE浏览器
                                        //if(!+[1,]) require('/plugins/jquery.knob/excanvas');
                                        //不同的进度，更换成不同的颜色
                                        require.async('/plugins/jquery.knob/jquery.knob.min',function(){
                                            $('.knob').each(function(){
                                                var val = parseInt($(this).val());
                                                if(val <= 25 && val > 0)
                                                {
                                                    $(this).attr("data-fgColor","#33cb57");
                                                }
                                                else if(val == 0)
                                                {
                                                    $(this).attr("data-fgColor","#33cb57");
                                                }
                                                else if(val > 25 && val <= 50)
                                                {
                                                    $(this).attr("data-fgColor","#33cb57");
                                                }
                                                else if(val > 50 && val < 100)
                                                {
                                                    $(this).attr("data-fgColor","#33cb57");
                                                }
                                                else if(val == 100)
                                                {
                                                    var isIE = function(ver){
                                                        var b = document.createElement('b')
                                                        b.innerHTML = '<!--[if IE ' + ver + ']><i></i><![endif]-->'
                                                        return b.getElementsByTagName('i').length === 1
                                                    }
                                                    if(isIE(8)){
                                                        $(this).parent().addClass("investComplete100");
                                                    }
                                                    $(this).attr("data-fgColor","#33cb57");
                                                }
                                            });
                                            $('.knob').knob({
                                                'width':50,
                                                'height':50,
                                                'thickness':.1,
                                                'readOnly' : true
                                            });
                                        });
                                    });
                                }
                            });
                            this.selectPage(n); //处理完后可以手动条用selectPage进行页码选中切换
                        }
                    });
                });
            }else{
                $("#kkpager").html('暂无数据');
            }
        }
    })
}