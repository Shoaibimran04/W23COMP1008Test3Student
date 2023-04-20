package com.example.w23comp1008test3student;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class StoreTest {

    private Store store;
    private Product product1, product2;
    @Before
    public void setUp() throws Exception {
        store = new Store("BestBuy","Happy St",10);
        product1 = new Product("Asus 15.6",349.99,"laptops");
        product2 = new Product("Dell Inspiron",1449.99,"laptops");
    }

    @Test
    public void setStreetName() {
        store.setStreetName("Great Stuff");
        assertEquals("Great Stuff",store.getStreetName());
    }

    @Test
    public void setStreetNameConstructor() {
        store = new Store("Big","Great Stuff",100);
        assertEquals("Great Stuff",store.getStreetName());
    }

    @Test
    public void setStreetNameInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            store.setStreetName("123");});
    }

    @Test
    public void setStreetNumber() {
        store.setStreetNumber(100);
        assertEquals(100, store.getStreetNumber());
    }

    @Test
    public void setStreetNumberInvalidLow() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            store.setStreetNumber(0);});
    }

    @Test
    public void setStreetNumberInvalidHigh() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            store.setStreetNumber(10001);});
    }

    @Test
    public void setStreetNumberInvalidHighConstructor() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            new Store("Bobs","Bayfield",10001);});
    }

    @Test
    public void setStoreName() {
        store.setStoreName("Rickys");
        assertEquals("Rickys",store.getStoreName());
    }

    @Test
    public void setStoreNameInvalidConstructor() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            new Store("B","Bayfield",100);});
    }

    @Test
    public void setStoreNameInvalidWithSpaces() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            new Store(" B ","Bayfield",100);});
    }

    @Test
    public void setProducts() {
        Product product1 = new Product("Asus 15.6",349.99,"laptops");
        Product product2 = new Product("Dell Inspiron",1449.99,"laptops");
        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        store.setProducts(products);
        assertEquals(products, store.getProducts());
    }

    @Test
    public void addProduct() {
        Product product1 = new Product("Asus 15.6",349.99,"laptops");
        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        store.addProduct(product1);
        assertEquals(products, store.getProducts());
    }

    //349.99+1449.99 = 1799.98
    @Test
    public void inventoryValue() {
        store.addProduct(product1);
        store.addProduct(product2);
        assertEquals(1799.98, store.getInventoryValue(),0.0001);
    }

    @Test
    public void inventoryValueNoProducts() {
        assertEquals(0.0, store.getInventoryValue(),0.0001);
    }

    @Test
    public void inventoryValueOneProduct() {
        store.addProduct(product1);
        assertEquals(349.99, store.getInventoryValue(),0.0001);
    }

    @Test
    public void getNumProductsEmpty() {
        assertEquals(0, store.getNumOfProducts());
    }

    @Test
    public void getNumProductsOne() {
        store.addProduct(product1);
        assertEquals(1, store.getNumOfProducts());
    }

    @Test
    public void getNumProductsMany() {
        store.addProduct(product1);
        store.addProduct(product2);
        store.addProduct(product1);
        store.addProduct(product2);
        assertEquals(4, store.getNumOfProducts());
    }

    @Test
    public void setStreetNameInvalidEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            store.setStreetName("");});
    }

}