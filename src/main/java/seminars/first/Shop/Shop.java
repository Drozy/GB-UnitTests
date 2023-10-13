package seminars.first.Shop;

import java.util.Collections;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    // В Product добавлен метод compareTo
    public List<Product> sortProductsByPrice() {
        List<Product> sortedProducts = products;
        Collections.sort(sortedProducts);
        return sortedProducts;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        return sortProductsByPrice().get(products.size() - 1);
    }

}