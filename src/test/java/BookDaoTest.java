
import Book.Book;
import Book.BookDao;
import java.io.InputStream;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author michael
 */
public class BookDaoTest {
    
    BookDao bookDao = new BookDao();
   
    
    @Test
    public void TestGetBooks() {
        
        int categoryId = 1;
        int limit = 1;
        int start = 1;
        List<Book> book = BookDao.getBooks(categoryId, limit, start);
        
        assertNotNull(book);
        assertTrue(book.size() > 0);
    }
    
    @Test
    public void TestSearchBooks() {
        
        String query = "SELECT * from books where author LIKE ? ESCAPE '!'";
        String searchPhrase = "chi";
        boolean contains = true;
        boolean repeat = false;
        List<Book> book = BookDao.searchBooks(query, searchPhrase, contains, repeat);
        
        assertNotNull(book);
        assertTrue(book.size() > 0);
    }
    
    
    @Test
    public void TestCreateAndDeleteBook() {
        
        int bookId = bookDao.createBook("Testbook", "TEST_USER", "123456", "A test book", "10.00", InputStream.nullInputStream(), "10/02/1994", 20, 1, "test, unit test");
        
        assertNotNull(bookId);
        assertTrue(bookId > 0);
        
        int deleteResponse = bookDao.deleteBook(bookId);
        
        assertNotNull(deleteResponse);
        assertTrue(deleteResponse > 0);
    }
    
    @Test
    public void TestUpdateBook() {
        
        int bookId = bookDao.createBook("Testbook", "TEST_USER", "123456", "A test book", "10.00", InputStream.nullInputStream(), "10/02/1994", 20, 1, "test, unit test");
        
        assertNotNull(bookId);
        assertTrue(bookId > 0);
        
        int newQuantity = 50;
        String newPrice = "30.50";
        String tags = "new test tag, another test tag";
        
        int updateDetails = bookDao.updateBookDetails(newQuantity, newPrice, bookId, tags);
        
        Book book = bookDao.getBookById(bookId);
        
        assertEquals("30.50", book.getPrice());
        assertEquals(50, book.getQuantity());
        assertEquals("new test tag, another test tag", book.getTags());
        
        int deleteResponse = bookDao.deleteBook(bookId);
        
        assertNotNull(deleteResponse);
        assertTrue(deleteResponse > 0);
    }
    
    
    @Test
    public void TestGetAllBooks() {
        
        List<Book> book = bookDao.getAllBooks();
        
        assertNotNull(book);
        assertTrue(book.size() > 0);
    }
    
    @Test
    public void TestGetBookById() {
        int bookId = 1;
        Book book = bookDao.getBookById(bookId);
        assertNotNull(book);
        assertNotNull(book.getTitle());
    }
    
    @Test
    public void TestGetCountofBooks() {
        int count = bookDao.getCountofBooks();
        assertTrue(count > 0);
    }
    
    @Test
    public void TestGetTotalCountForPagination() {
        int categoryId = 1;
        int count = bookDao.getTotalCountForPagination(categoryId);
        assertTrue(count > 0);
    }
    
    
    
}
