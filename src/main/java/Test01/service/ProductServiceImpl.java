package Test01.service;

import Test01.domain.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("listResourceService")
@ConditionalOnProperty(name = "service.products", havingValue = "list")
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
