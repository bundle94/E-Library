
import Book.Book;
import Favourite.FavouriteDao;
import Favourite.UserFavourites;
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
public class FavouriteDaoTest {
    
    FavouriteDao favouriteDao = new FavouriteDao();
    
    
    @Test
    public void TestCreate(){
        int userId = 1;
        int bookId = 5;
        
        int favouriteCreationResponse = favouriteDao.create(userId, bookId);
        
        assertNotNull(favouriteCreationResponse);
        assertTrue(favouriteCreationResponse > 0);
    }
    
    @Test
    public void TestFavouriteExists(){
        
        int userId = 1;
        int bookId = 5;
        boolean favouriteExists = favouriteDao.favouriteExists(userId, bookId);
        
        assertTrue(favouriteExists);
    }
    
    @Test
    public void TestGetUserFavourites(){
        int userId = 1;
        
        List<Book> favourites = favouriteDao.getUserFavourites(userId);
        
        assertNotNull(favourites);
        assertTrue(favourites.size() > 0);
        
    }
    
    @Test
    public void TestGetUsersFavouritesCount(){
       
        List<UserFavourites> usersFavourites = favouriteDao.getUsersFavouritesCount();
       
        assertNotNull(usersFavourites);
        assertTrue(usersFavourites.size() > 0);
    }
    
    @Test
    public void TestDeleteFavourite(){
        
        int userId = 1;
        int bookId = 5;
        int deleteResponse = favouriteDao.deleteFavourite(userId, bookId);
        
        assertNotNull(deleteResponse);
        assertTrue(deleteResponse > 0);
    }
    
    
}
