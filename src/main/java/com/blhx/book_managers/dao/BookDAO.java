package com.blhx.book_managers.dao;

import com.blhx.book_managers.model.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookDAO {
//    String table_name="book";
//    String insert_field="name,author,price";
//    String select_field="id,status,"+insert_field;
    @Insert("insert into book (name,author,price) values(#{name},#{author},#{price})")
    int addBook( Book book);

    @Select("select * from book")
    List<Book> selectAll();

    @Update("update book set status=#{status} where id=#{id}")
    void  upDateBookStatus( @Param ("id") int id,@Param("status") int status);
}
