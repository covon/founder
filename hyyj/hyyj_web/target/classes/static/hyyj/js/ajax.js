function ajax(options) {
    var defaults = {
        type: options.type || 'post',
        url: options.url || '',
        data: options.data || {},
        dataType: 'json',
        cache: false,
        async: false,
        contentType:'application/json;charset=utf-8',
        success: options.success || function() {},
        error: options.error ||function() {}

    };
    // 覆盖对象 使用options对象的属性覆盖defaults对象的属性
    // Object.assign(defaults, options);


    $(document).ajaxComplete(function (event, xhr, settings) {
        var SESSIONSTATUS = xhr.getResponseHeader("SESSIONSTATUS");
        //如果响应头中包含 REDIRECT 则说明是拦截器返回的
        if (SESSIONSTATUS == "TIMEOUT")
        {
            window.location.href = xhr.getResponseHeader("CONTEXTPATH");
        }
    })

    $.ajax(defaults);

}

