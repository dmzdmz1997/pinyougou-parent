package cn.itcast.lucene.dao;

import cn.itcast.lucene.pojo.Book;

import java.util.List;

/**
 * @author 朱惠
 * @date 2019/3/23 - 8:38
 */
public interface BookDao {
    /** 查询全部图书 */
    List<Book> findAll();

}
