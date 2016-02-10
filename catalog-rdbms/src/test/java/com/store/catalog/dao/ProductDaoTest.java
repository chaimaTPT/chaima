package com.store.catalog.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import java.util.Random;

import java.util.List;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.store.catalog.model.Category;
import com.store.catalog.model.Product;
import com.store.catalog.utils.ConstantUtils;

import static com.store.catalog.utils.ConstantUtils.*;

public class ProductDaoTest extends AbstractBaseDaoTestCase {

    
    @Autowired
    private ProductDao productDao ;
    
    @Autowired
    private CategoryDao categoryDao ;    
    
    private Product product = null;
    
    
    @Before
    public void setUp(){
        loadProduct();
    }
    
    @After
    public void tearDown(){
        categoryDao = null;
        productDao = null;
    }
/*
    @Test
    public void testCreateProduct() throws Exception {
        productDao.save(product);
        Product foundone=productDao.findOne(product.getId());
        assertTrue(foundone!=null);
        assertTrue(foundone.getId()==product.getId());
    }    
   
    @Test
    public void testUpdateProduct() throws Exception {
        productDao.save(product);
        product.setDescription(product.getDescription()+"updated");
        productDao.save(product);
        Product editedone=productDao.findOne(product.getId());
        assertEquals(editedone.getDescription(),product.getDescription());
    }    
    */
    
    @Test
    public void testGetProduct() throws Exception {
        productDao.save(product);
        Product found=productDao.findOne(product.getId());
        assertEquals(product,found);    }   

    /*
    @Test
    public void testRemoveProduct() throws Exception {
        productDao.save(product);
        Product found=productDao.findOne(product.getId());
        assertTrue(found!=null);
        productDao.delete(found.getId());
        assertTrue(productDao.findOne(product.getId())==null);
        }

    
    
    @Test
    public void testGetProducts() throws Exception {
        productDao.save(product);
        Product product2 = new Product();
        product.setId(new Random().nextLong());
        product2.setName(ConstantUtils.CATEGOY_NAME+"2");
        product2.setCategory(getCategory2());
        productDao.save(product2);
        Iterable<Product>lst=productDao.findAll();
        assertTrue(getIterableSize(lst)==2);    }    
    

    @Test
    public void testGetProductsWithCategoryId() throws Exception {
        productDao.save(product);
        Product product2  = new Product();
        product.setId(new Random().nextLong());
        product2.setName(ConstantUtils.CATEGOY_NAME+"2");
        product2.setCategory(getCategory2());
        productDao.save(product2);
        List<Product>lst=productDao.findByCategoryId(product2.getCategory().getId());
        assertTrue(lst.size()==1); 
        }    

    
    @Test
    public void testGetProductsByCategoryName() throws Exception {

        productDao.save(product);
        product = new Product();
        product.setId(new Random().nextLong());
        product.setName(ConstantUtils.CATEGOY_NAME+"2");
        product.setCategory(getCategory2());
        productDao.save(product);
        Iterable<Product>lst=productDao.findByCategoryName(getCategory2().getName());
        assertTrue(getIterableSize(lst)==1); 
        }        
    */
    
    private Category getCategory() {
        
    	Category category = new Category();
        category.setId(new Random().nextLong());
        category.setName(ConstantUtils.CATEGOY_NAME);
        category.setDescription(ConstantUtils.CATEGORY_DESCRIPTION);
        categoryDao.save(category);

		return category;
	}    
	
	private Category getCategory2() {
		Category category = new Category();
        category.setId(new Random().nextLong());

        category.setName("catName2");
        category.setDescription("description2");

        categoryDao.save(category);
        return category;
    }    
    
   
	private void loadProduct() {
    	product = new Product();
        product.setId(new Random().nextLong());
    	product.setName(ConstantUtils.PRODUCT_NAME);
    	product.setDescription(ConstantUtils.PRODUCT_DESCRIPTION);
    	
    	product.setCategory(getCategory());
	}
	
}

