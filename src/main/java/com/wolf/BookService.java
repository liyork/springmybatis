package com.wolf;

import com.wolf.entities.Book;
import com.wolf.mapper.BookDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:业务处理bean
 * <br/> Created on 28/08/2018 9:03 AM
 *
 * @author 李超
 * @since 1.0.0
 */
@Service
public class BookService{

    @Resource
    BookDAO bookdao;

    public List<Book> getAllBooks() {
        return bookdao.getAllBooks();
    }

    public Book getBookById(int id){
        return bookdao.getBookById(id);
    }

    public List<Book> getBookByIds(List<Integer> ids){
        return bookdao.getBookByIds(ids);
    }

    public List<Book> getBookByTitle(String bookTitle){
        return bookdao.getBookByTitle(bookTitle);
    }

    public List<Book> getBookByCondition(Book book){
        return bookdao.getBookByCondition(book);
    }

    public int add(Book entity) throws Exception {
        if(entity.getName()==null||entity.getName().equals("")){
            throw new Exception("书名必须不为空");
        }
        return bookdao.add(entity);
    }

    @Transactional
    public int add(Book entity1,Book entityBak){
        int rows=0;
        rows=bookdao.add(entity1);
        rows=bookdao.add(entityBak);
        return rows;
    }

    public int delete(int id) {
        return bookdao.delete(id);
    }

    /**
     * 多删除
     */
    public int delete(String[] ids){
        int rows=0;
        for (String idStr : ids) {
            int id=Integer.parseInt(idStr);
            rows+=delete(id);
        }
        return rows;
    }

    public int update(Book entity) {
        return bookdao.update(entity);
    }

}