package Test01.service;

import Test01.domain.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductServiceImpl implements ProductService{

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Asus Vivobook 15", 330, 300),
            new Product(2, "Asus Tuff", 1100, 50),
            new Product(3, "Acer Nitro V", 850, 100),
            new Product(4, "Dell Inspiron 3550", 400, 500)
    ));


    @Override
    public List<Product> getProducts() {
        return products;
    }
}
