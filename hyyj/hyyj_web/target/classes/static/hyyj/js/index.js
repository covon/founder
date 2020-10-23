$(document).ready(function() {
	//加载菜单
    getMenuList();

});
function getMenuList() {
    ajax({
        type:"post",
        url:"/index/genMenuList",
        data:{},
        async: false,
        success:function (data) {
        	var htmlstr="";
            $.each(data, function( index, value ) {
            	if(value.hasChild){
                    htmlstr+='<li class="lsm-sidebar-item"><a href="javascript:;"><i class="my-icon lsm-sidebar-icon '+value.img+'"></i>\n' +
                        '<span>'+value.name+'</span><i class="my-icon lsm-sidebar-more"></i></a><ul>';
                    $.each(value.cnodes, function( inde, valu ) {
                        htmlstr+='<li><a href="javascript:void(0);" onclick="">\n' +
                            '<span>'+valu.name+'</span></a></li>';
					})
                    htmlstr+='</ul></li>';

				}else {
                    htmlstr+='<li class="lsm-sidebar-item" ><a href="javascript:;"onclick="openPage(\'mainPage\',\''+value.url+'\')">\n' +
                        '<i class="my-icon lsm-sidebar-icon '+value.img+'"></i><span>'+value.name+'</span></a></li>';
				}
                document.getElementById("lefside").innerHTML = htmlstr;
            });
        }
        // ,complete:function (xhr, status) {
        //     var SESSIONSTATUS = xhr.getResponseHeader("SESSIONSTATUS");
        //     //如果响应头中包含 REDIRECT 则说明是拦截器返回的
        //     if (SESSIONSTATUS == "TIMEOUT")
        //     {
        //         window.location.href = xhr.getResponseHeader("CONTEXTPATH");
        //     }
        // }
    });
}
function fff(){
    ajax({
        type:"get",
        url:"/index/getValue",
        data:{},
        // type: 'get', //请求方式
        // url: 'http://172.25.18.14:9200', //请求地址
        // data: { //请求参数
        // 	name: 'zhaangsahng',
        // 	age: 18
        // },
        success: function(data) { //成功则调用  data参数哪来的？
            console.log(data)
        },
        error: function(data) { //失败则调用
            // console.log(data, xhr)
        }

    })
}

function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null){
		return unescape(r[2]);
	}
	return null;
}
