package com.store.catalog.dao;

import com.store.catalog.utils.ConstantUtils;
import static com.store.catalog.utils.ConstantUtils.*;
import com.store.catalog.model.Category;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

import static org.junit.Assert.*;

public class CategoryDaoTest  extends AbstractBaseDaoTestCase{

    
    
    @Autowired
    private CategoryDao categoryDao;
    
    
    private Category category = null;
    
    @Before
    public void setUp(){
        loadCategory();
    }

    
    @After
    public void tearDown(){
        category = null;
        categoryDao = null;
    }


    @Test
    public void testCreateCategory() throws Exception {
        categoryDao.save(category);
        Category foundone=categoryDao.findOne(category.getId());
        assertTrue(foundone!=null);
        assertTrue(foundone.getId()==category.getId());


    }

    @Test
    public void testUpdateCategory() throws Exception {
        categoryDao.save(category);
        category.setDescription(category.getDescription()+"updated");
        categoryDao.save(category);
        Category editedone=categoryDao.findOne(category.getId());
        assertEquals(editedone.getDescription(),category.getDescription());
    }

    @Test
    public void testGetCategory() throws Exception {
        categoryDao.save(category);
        Category found=categoryDao.findOne(category.getId());
        assertEquals(category,found);
    }

    @Test
    public void testRemoveCategory() throws Exception {
        categoryDao.save(category);
        Category found=categoryDao.findOne(category.getId());
        assertTrue(found!=null);
        categoryDao.delete(found.getId());
        assertTrue(categoryDao.findOne(category.getId())==null);
    }


    @Test
    public void testGetCategories() throws Exception {
        categoryDao.save(category);
        category = new Category(); category.setId(new Random().nextLong());

        category.setName(ConstantUtils.CATEGOY_NAME+"2");
        categoryDao.save(category);
        Iterable<Category>lst=categoryDao.findAll();
        assertTrue(getIterableSize(lst)==2);
    }

    
    /**
     * 
     * create an instanciated object. The one declared as private field in the test class
     */   


    private void  loadCategory() {
        category = new Category(); category.setId(new Random().nextLong());

        category.setName(ConstantUtils.CATEGOY_NAME);
        category.setDescription(ConstantUtils.CATEGORY_DESCRIPTION);
    }



    
}
