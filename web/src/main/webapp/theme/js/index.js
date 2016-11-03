/**
 * Created by mutou on 2016/11/2.
 */
define(function(require,exports,modlue) {
    require('jquery-3.1.0.min');
    ajaxUrl();
    function ajaxUrl(){
        $.ajax({
            type:'post',
            url:"/book/listJson.html",
            dataType:'json',
            success:function(json){
                if (json.result != undefined && !json.result) {
                    //当存在非法字符时，模拟数据为空
                    $('.testclass').html("");
                    $("#kkpager").html('暂无数据');
                    return;
                }


                //总记录数
                $(".quickBar span em").html(json.data.totalPages);
                require.async('/plugins/handlebars-v1.3.0/handlebars-v1.3.0.js',function(){
                    var tpl = require('/theme/tpl/book/bookList.tpl');
                    var template = Handlebars.compile(tpl);
                    var html = template(json);
                    $('.testclass').html(html);
                });
                //分页插件
                if(json.data.number != null && json.data.totalPages > 0)
                {
                    require.async(['/plugins/pager/pager.css','/plugins/pager/pager'],function(){
                        kkpager.generPageHtml({
                            pno : json.data.number,//当前页码
                            total : json.data.totalPages,//总页码
                            totalRecords : json.data.numberOfElements,//总数据条数
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
                                    type:"post",
                                    url:"/book/listJson.html",
                                    data : {page:n},
                                    dataType:"json",//这个必不可少，如果缺少，导致传回来的不是json格式
                                    success:function(json){
                                        require.async(['/plugins/handlebars-v1.3.0/handlebars-v1.3.0.js'],function(){
                                            var tpl = require('/theme/tpl/book/bookList.tpl');
                                            var template = Handlebars.compile(tpl);
                                            var html    = template(json);
                                            $('.testclass').html(html);
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
})