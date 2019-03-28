package com.itheima.utils;

import com.alibaba.druid.util.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 朱惠
 * @date 2019/3/16 - 19:42
 */
public class StringToTimestampConverter implements Converter<String, Timestamp> {
    @Override
    public Timestamp convert(String source) {
        try {
            if (StringUtils.isEmpty(source)){
                return null;
            }
            //String--->Date   字符串转日期
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(source);
            //Date------>Timestamp
            Timestamp timestamp = new Timestamp(date.getTime());
            return timestamp;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
