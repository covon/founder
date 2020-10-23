(function (window) {
    var HTTP=function () {
        this.get=function(){
            $.ajax({
                'type': type,
                'url': url,
                'data': data,
                'dataType': "json",
                'cache': false,
                'async': true,
                'success': success,
                'contentType': 'application/json;charset=utf-8',
                'complete': function (xhr, status) {
                    var SESSIONSTATUS = xhr.getResponseHeader("SESSIONSTATUS");
                    //如果响应头中包含 REDIRECT 则说明是拦截器返回的
                    if (SESSIONSTATUS == "TIMEOUT")
                    {
                        window.location.href = xhr.getResponseHeader("CONTEXTPATH");
                    }
                }
            });
        }

    }

    function ajax(type, url, data, success) {
        $.ajax({
            'type': type,
            'url': url,
            'data': data,
            'dataType': "json",
            'cache': false,
            'async': true,
            'success': success,
            'contentType': 'application/json;charset=utf-8',
            'complete': function (xhr, status) {
                var SESSIONSTATUS = xhr.getResponseHeader("SESSIONSTATUS");
                //如果响应头中包含 REDIRECT 则说明是拦截器返回的
                if (SESSIONSTATUS == "TIMEOUT")
                {
                    window.location.href = xhr.getResponseHeader("CONTEXTPATH");
                }
            }
        });
    }
    return the={
        get: function (url, data, success) {
            ajax("get", url, data, success);
        },

        post: function (url, data, success) {
            ajax("post", url, data, success);
        }
    }
    window.HTTP=new HTTP();
})(window);
