package com.store.catalog.dao;

import com.store.catalog.model.Product;
import com.store.catalog.utils.ConstantUtils;
import com.store.catalog.model.Category;
import com.store.catalog.model.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

import static com.store.catalog.utils.ConstantUtils.*;

import static org.junit.Assert.*;

import java.util.List;

public class ItemDaoTest extends AbstractBaseDaoTestCase {
    


    private Item item = null;

    @Autowired
    private ItemDao itemDao ;
    
    @Autowired
    private ProductDao productDao ;
    
    @Autowired
    private CategoryDao categoryDao ;    
   
    @Before
    public void setUp(){
        loadItem();
    }
    
    @After
    public void tearDown(){
        categoryDao = null;
        productDao = null;
        itemDao  = null;
        item = null;
    }


    @Test
    public void testCreateItem() throws Exception {
        itemDao.save(item);
        Item foundone=itemDao.findOne(item.getId());
        assertTrue(foundone!=null);
        assertTrue(foundone.getId()==item.getId());    }


    @Test
    public void testUpdateItem() throws Exception {
        itemDao.save(item);
        Product prouduct2=getProduct("modified","modified");
        item.setProduct(prouduct2);
        itemDao.save(item);
        Item editedone=itemDao.findOne(item.getId());
        assertEquals(editedone.getProduct(),item.getProduct());    }

    @Test
    public void testGetItem() throws Exception {
        itemDao.save(item);
        Item found=itemDao.findOne(item.getId());
        assertEquals(item,found);
        }


    @Test
    public void testRemoveItem() throws Exception {
        itemDao.save(item);
        Item found=itemDao.findOne(item.getId());
        assertTrue(found!=null);
        itemDao.delete(found.getId());
        assertTrue(itemDao.findOne(item.getId())==null);
    }


    @Test
    public void testGetItems() throws Exception {
        itemDao.save(item);
        Item item2 = getAnotherItem();
        itemDao.save(item2);
        Iterable<Item>lst=itemDao.findAll();
        assertTrue(getIterableSize(lst)==2);  
        }


    @Test
    public void testGetItemsWithProductId() throws Exception {
        itemDao.save(item);
        Item item2  = getAnotherItem();
        itemDao.save(item2);
        List<Item>lst=itemDao.findByProductId(item2.getProduct().getId());
        assertTrue(lst.size()==1); 
        }


    @Test
    public void testSearchItem() throws Exception {
         itemDao.save(item);
        Item item2  = getAnotherItem();
        itemDao.save(item2);
        List<Item>lst=itemDao.findByNameContaining(ITEM_NAME);
        assertTrue(lst.size()==2);
        }
    
    
    /**
     * 
     * @return an instanciated object. The one declared as private field in the test class
     */    
	private void loadItem() {
	   	item = new Item();
        item.setId(new Random().nextLong());

        item.setName(ITEM_NAME);
        item.setImagePath(ITEM_IMAGE_PATH);
        item.setUnitCost(ITEM_PRICE);
        item.setProduct(getProduct());
    }
    
    
    private Item getAnotherItem() {
        Item item2 = new Item();
        item2.setId(new Random().nextLong());
        item2.setName(ITEM_NAME + "2");
        item2.setImagePath(ITEM_IMAGE_PATH + "2");
        item2.setUnitCost(ITEM_PRICE + 10d); 
        item2.setProduct(getProduct());

        return item2;
    }    
    
    

	private Product getProduct() {
	   	Product product = new Product();
        product.setId(new Random().nextLong());

        product.setName(PRODUCT_NAME);
        product.setDescription(PRODUCT_DESCRIPTION);

        Category category = getCategory();
        product.setCategory(category);

        productDao.save(product);        
        
        return product;

	}    
	
	private Product getProduct(String name, String desc) {
	   	Product product = new Product();
        product.setId(new Random().nextLong());

        product.setName(name);
        product.setDescription(desc);

        Category category = getCategory();
        product.setCategory(category);

        productDao.save(product);        
        
        return product;

	}	
	
	private Category getCategory() {
		Category category = new Category();
        category.setId(new Random().nextLong());
        System.out.println(category.getId());
        category.setName(CATEGOY_NAME);
        category.setDescription(CATEGORY_DESCRIPTION);

        categoryDao.save(category);
        return category;
    }        
}