package cn.itcast.lucene.dao.impl;

import cn.itcast.lucene.dao.BookDao;
import cn.itcast.lucene.pojo.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 朱惠
 * @date 2019/3/23 - 8:39
 */
public class BookDaoImpl implements BookDao {
    public List<Book> findAll() {
        ArrayList<Book> books = new ArrayList<Book>();
        Connection connection = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        try {
            connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/lucene_db","root","root");
            // 编写sql语句
            String sql = "select * from book";
             psmt = connection.prepareStatement(sql);
             rs = psmt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setBookName(rs.getString("bookname"));
                book.setPrice(rs.getFloat("price"));
                book.setPic(rs.getString("pic"));
                book.setBookDesc(rs.getString("bookdesc"));
                books.add(book);
            }
        }catch (Exception ex){
                ex.printStackTrace();
        }finally {
            try {
                rs.close();
                psmt.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }
}
