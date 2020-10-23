var i = 0;
$(document).ready(function() {
	$("#loginBtn").click(function() {
		var name = $("#username").val();
		var password = $("#password").val();
		if (name == '') {
			layer.alert("用户名不能为空！");
		} else if(password=='') {
			layer.alert("密码不能为空！");
		}else{
			var _query_load_index = layer.load(0, {
			    shade: [0.5,'#95A1AA']
			});
                $.ajax({
                    type:"post",
                    url:"/login/loginIn",
                    data:{"username":name,"password":password},
                    async: false,
                    success:function (data) {
                    	if(data.success==1){
                            setcookie("token",data.token,0.5);
                            window.location.href="/index.html"
                            layer.close(_query_load_index);
						}else{
                            layer.alert(data.date);
                            layer.close(_query_load_index);
						}
                    }
                });

		}
	});
});
function setcookie(name,value,hour){
    var d= new Date();
    d.setTime(d.getTime()+(hour*60*60*1000));
    var expires = d.toGMTString();
    document.cookie = name+"="+value+";expires="+expires;
}

$(document).keyup(function(event){
	  if(event.keyCode ==13&&i==0){
		  i++;
	    $("#loginBtn").trigger("click");
	  }
});