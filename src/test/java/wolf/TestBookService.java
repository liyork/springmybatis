package com.wolf;

import com.alibaba.fastjson.JSON;
import com.wolf.entities.Book;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Description:
 * <br/> Created on 28/08/2018 9:04 AM
 *
 * @author 李超
 * @since 1.0.0
 */
public class TestBookService {

    static BookService bookservice;

    @BeforeClass
    public static void before() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        bookservice = ctx.getBean(BookService.class);
    }

    @Test
    public void testGetAllBooks() {
        List<Book> books = bookservice.getAllBooks();
        assertNotNull(books);
        books.forEach((s) -> System.out.println(JSON.toJSONString(s)));
    }

    @Test
    public void testAdd() {
        Book entity = new Book("Hibernate 第七版3", 78.1, new Date());
        try {
            assertEquals(1, bookservice.add(entity));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteInt() {
        assertEquals(1, bookservice.delete(9));
    }

    @Test
    public void testDeleteStringArray() {
        String[] ids = {"7", "11", "12"};
        assertEquals(3, bookservice.delete(ids));
    }

    @Test
    public void testUpdate() {
        Book entity = new Book("Hibernate 第二版", 79.1, new Date());
        try {
            assertEquals(1, bookservice.update(entity));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetBookById() {
        Book book = bookservice.getBookById(1);
        assertNotNull(book);
        System.out.println(JSON.toJSONString(book));
    }

    @Test
    public void testGetBookByIds() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        bookservice.getBookByIds(ids).forEach((s) -> System.out.println(JSON.toJSONString(s)));
    }

    @Test
    public void testGetBookByTitle() {
        assertNotNull(bookservice.getBookByTitle("Java"));
    }

    @Test
    public void testGetBookByCondition() {
        Book book = new Book();
        //book.setId(1);//注释掉则第二个if的and被省略
        book.setName("HeadFirst Java");
        List<Book> bookByCondition = bookservice.getBookByCondition(book);
        System.out.println(JSON.toJSONString(bookByCondition));
    }

    @Test
    public void testAddDouble() {
        //因为书名相同，添加第二本会失败，用于测试事务
        Book entity1 = new Book( "Hibernate 第八版", 78.1, new Date());
        Book entity2 = new Book( "Hibernate 第八版", 78.1, new Date());
        assertEquals(2, bookservice.add(entity1, entity2));
    }
}