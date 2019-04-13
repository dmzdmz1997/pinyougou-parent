package com.pinyougou.service;

import java.util.Map;

/**
 * @author 朱惠
 * @date 2019/4/13 - 17:15
 */
public interface ItemSearchService {
    /** 搜索方法 */
    Map<String,Object> search(Map<String,Object> params);

}
