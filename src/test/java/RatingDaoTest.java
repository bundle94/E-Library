
import Rating.Rating;
import Rating.RatingDao;
import java.util.List;
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
public class RatingDaoTest {
    
    RatingDao ratingDao = new RatingDao();
    
    @Test
    public void TestCreate(){
        int userId = 1;
        int bookId = 5;
        int score = 4;
        
        int createRatingResponse = ratingDao.create(userId, bookId, score);
        
        assertNotNull(createRatingResponse);
        assertTrue(createRatingResponse > 0);
    }
    
    @Test
    public void TestGetUserBookRatingScore() {
        int userId = 1;
        int bookId = 5;
        
        int score = ratingDao.getUserBookRatingScore(userId, bookId);
        
        assertNotNull(score);
    }
    
    @Test
    public void TestGetAverageBookRatingScore() {
         
        int bookId = 5;
        double averageBookRatingScore = ratingDao.getAverageBookRatingScore(bookId);
        
        assertNotNull(averageBookRatingScore);
        assertTrue(averageBookRatingScore > 0);
    }
    
    @Test
    public void TestUpdateRatingScore(){
        int userId = 1;
        int bookId = 5;
        int score = 2;
        
        int updateRatingResponse = ratingDao.create(userId, bookId, score);
        
        assertNotNull(updateRatingResponse);
        assertTrue(updateRatingResponse > 0);
    }
    
    @Test
    public void TestGetAllRatings(){
        
        List<Rating> ratings = RatingDao.getAllRatings();
        
        assertNotNull(ratings);
        assertTrue(ratings.size() > 0 );
    }
    
    @Test
    public void TestGetCountofBookRatings(){
        
        int bookId = 5;
        
        int count = ratingDao.getCountofBookRatings(bookId);
        
        assertNotNull(count);
        assertTrue(count > 0 );
    }
}
