package com.wolf.mapper;

import com.wolf.entities.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description:接口定义方法，与BookMapper.xml映射
 * BookMapper.xml中的namespace与此dao对应
 * <br/> Created on 28/08/2018 8:59 AM
 *
 * @author 李超
 * @since 1.0.0
 */
public interface BookDAO {
    /**
     * 获得所有图书
     */
    public List<Book> getAllBooks();
    /**
     * 根据图书编号获得图书对象
     * @Param 可以实现参数名称转换。若没有@Param则默认就是参数名称
     */
    public Book getBookById(@Param("qqq") int id);

    public List<Book> getBookByIds(@Param("ids") List<Integer> ids);

    public List<Book> getBookByTitle(@Param("bookTitle") String bookTitle);
    /**
     * 添加图书
     */
    public int add(Book entity);
    /**
     * 根据图书编号删除图书
     */
    public int delete(int id);
    /**
     * 更新图书
     */
    public int update(Book entity);
}