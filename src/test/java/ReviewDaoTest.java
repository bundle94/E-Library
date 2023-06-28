
import Review.Review;
import Review.ReviewDao;
import Review.ReviewList;
import java.util.List;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import org.mockito.Mock;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author michael
 */
public class ReviewDaoTest {
    
    ReviewDao reviewDao = new ReviewDao();
    
    @Test
    public void TestCreateAndDeleteReview(){
         
        int userId = 1;
        int bookId = 5;
        String review = "This is a test";
        
        int creationResponse = reviewDao.create(userId, bookId, review);
        assertTrue(creationResponse > 0);
        
        int deleteResponse = reviewDao.deleteReview(creationResponse);
        assertTrue(deleteResponse > 0);
    }
    
    @Test
    public void TestGetBookReviews(){
        
        int userId = 1;
        int bookId = 5;
        String review = "This is a test";
        
        int creationResponse = reviewDao.create(userId, bookId, review);     
        List<Review> reviews = reviewDao.getBookReviews(bookId);
        
        assertNotNull(reviews);
        assertTrue(reviews.size() > 0);
    }
    
    @Test
    public void TestGetCountofBookReviews(){
        
        int bookId = 5;
        int count = reviewDao.getCountofBookReviews(bookId);
        
        assertTrue(count > 0);
    }
    
    @Test
    public void getAllBooksReviewWithCount() {
        
        List<ReviewList> reviewList = reviewDao.getAllBooksReviewWithCount();
        
        assertNotNull(reviewList);
        assertTrue(reviewList.size() > 0);
    }
}
