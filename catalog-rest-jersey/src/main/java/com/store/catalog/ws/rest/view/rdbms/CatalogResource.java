package com.store.catalog.ws.rest.view.rdbms;

import com.store.catalog.model.ProductDTO;
import com.store.catalog.service.catalog.CatalogService;
import com.store.catalog.model.CategoryDTO;
import com.store.catalog.model.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by ZCadi on 26/10/2015.
 */
@Path("/catalog")

public class CatalogResource {



    @Autowired CatalogService catalogServiceImpl;

    public CatalogService getCatalogServiceImpl() {
        return catalogServiceImpl;
    }

    public void setCatalogServiceImpl(CatalogService catalogServiceImpl) {
        this.catalogServiceImpl = catalogServiceImpl;
    }




    @Path("/categories")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoryDTO> getCategories() {
        return catalogServiceImpl.findCategories();
    }


    @Path("/category/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategory(@PathParam("id") Long id) throws Exception {
      return Response.ok(catalogServiceImpl.findCategory(id)).build();
    }
    @Path("/category")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCategory(CategoryDTO categoryDTO) throws Exception {
        return Response.ok(catalogServiceImpl.createCategory(categoryDTO)).build();
        

    }

    @Path("/category")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCategory(CategoryDTO categoryDTO) throws Exception {
    	catalogServiceImpl.updateCategory(categoryDTO);

       return Response.ok().build();

    }

    @Path("/category/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCategory(@PathParam("id") Long id) throws Exception {
    	catalogServiceImpl.deleteCategory(id);
        return Response.ok().build();

    }

    @Path("/products")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDTO> getProducts() throws Exception {
    	
    	return catalogServiceImpl.findProducts();
    }

    @Path("/product/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("id") Long id) throws Exception {

        return Response.ok(catalogServiceImpl.findProduct(id)).build();
    }

    @Path("/product/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(ProductDTO productDTO) throws Exception {

        return Response.ok(catalogServiceImpl.createProduct(productDTO)).build();
    }

    @Path("/product/update")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(ProductDTO productDTO) throws Exception {

    	catalogServiceImpl.updateProduct(productDTO);

        return Response.ok().build();
    }

    @Path("/product/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteProduct(@PathParam("id") Long id) throws Exception {

    	catalogServiceImpl.deleteProduct(id);
        return Response.ok().build();
    }
 
    @Path("/items")
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public List<ItemDTO> getItems() throws Exception {

    	return catalogServiceImpl.findItems();
    }

    @Path("/item/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItem(@PathParam("id") Long id) throws Exception {
    	return Response.ok(catalogServiceImpl.findItems(id)).build();
    }

    @Path("/item")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createItem(ItemDTO itemDTO) throws Exception {

        return Response.ok(catalogServiceImpl.createItem(itemDTO)).build();

    }

    @Path("/item/update")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateItem(ItemDTO itemDTO) throws Exception {
    	catalogServiceImpl.updateItem(itemDTO);
        return Response.ok().build();

    }

    @Path("/item/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteItem(@PathParam("id") Long id) throws Exception {

    	catalogServiceImpl.deleteItem(id);
        return Response.ok().build();
    }

    @Path("/item/search/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ItemDTO> getItemsByName(@PathParam("name") String name) throws Exception {

    	return catalogServiceImpl.searchItems(name);
    }

}
