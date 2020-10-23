package com.founder.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUtils {
	@SuppressWarnings("unchecked")
	public static Map<String,Object>convertToMap(List<Object>list){
        @SuppressWarnings("rawtypes")
		Map<String,Object>map =new HashMap();
        for(Object ob:list){
            Map<String,Object> param =(Map<String, Object>) ob;
          map.put(param.get("name")+"",param.get("value"));
        }
        return map;
    }
}
