
import Category.Category;
import Category.CategoryDao;
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
public class CategoryDaoTest {
    
    CategoryDao categoryDao = new CategoryDao();
    
    
    @Test
    public void TestGetList() {
        List<Category> categorylist = CategoryDao.getList();
        
        assertNotNull(categorylist);
        assertTrue(categorylist.size() > 0);
    }
    
    @Test
    public void TestCreateAndDeleteCategory() {
        
        String categoryName = "TEST_CATEGORY";
        int categoryCreationResponse = categoryDao.createCategory(categoryName);
        
        assertTrue(categoryCreationResponse > 0);
        
        int categoryDeletionResponse = categoryDao.deleteCategory(categoryCreationResponse);
        
        assertNotNull(categoryDeletionResponse);
        assertTrue(categoryDeletionResponse > 0);
    }
    
    @Test
    public void TestGetCountofCategories() {
        
        int count = categoryDao.getCountofCategories();
        
        assertNotNull(count);
        assertTrue(count > 0);
        
    }
    
    @Test
    public void TestGetCountofBooksInACategory(){
        
        int categoryId = 1;
        int count = CategoryDao.getCountofBooksInACategory(categoryId);
        
        assertNotNull(count);
        assertTrue(count > 0);
        
    }
    
    @Test
    public void TestGetCountofBooksRequestByCategory(){
        
        int categoryId = 3;
        int count = CategoryDao.getCountofBooksRequestByCategory(categoryId);
        
        assertNotNull(count);
        assertTrue(count > 0);
    }
    
    @Test
    public void TestGetCategoryNameById(){
                
        String categoryName = "TEST_CATEGORY";
        int categoryCreationResponse = categoryDao.createCategory(categoryName);
        
        String returnedCategoryName = CategoryDao.getCategoryNameById(categoryCreationResponse);
        
        assertNotNull(returnedCategoryName);
        assertEquals("TEST_CATEGORY", returnedCategoryName);
          
        categoryDao.deleteCategory(categoryCreationResponse);
        
    }
    
}
