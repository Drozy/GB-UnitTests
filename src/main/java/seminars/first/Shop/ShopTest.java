package seminars.first.Shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */

    public static void main(String[] args) {

        Product cookies = new Product("cookies", 60);
        Product bread = new Product("bread", 30);
        Product milk = new Product("milk", 100);
        Product apples = new Product("apples", 80);
        Product chicken = new Product("chicken", 230);

        List<Product> products = new ArrayList<>();
        products.add(cookies);
        products.add(bread);
        products.add(milk);
        products.add(apples);
        products.add(chicken);

        Shop myShop = new Shop();
        myShop.setProducts(products);

        List<Product> productsInShop = myShop.getProducts();

        // Проверка списка продуктов
        assertThat(productsInShop.size()).isEqualTo(5);
        assertThat(productsInShop.contains(cookies)).isTrue();
        assertThat(productsInShop.contains(bread)).isTrue();
        assertThat(productsInShop.contains(milk)).isTrue();
        assertThat(productsInShop.contains(apples)).isTrue();
        assertThat(productsInShop.contains(chicken)).isTrue();
//        assertThat(productsInShop.containsAll(products)).isTrue();

        // Проверка корректности работы метода getMostExpensiveProduct
        assertThat(myShop.getMostExpensiveProduct()).isEqualTo(chicken);
        assertThat(myShop.getMostExpensiveProduct().getCost()).isEqualTo(230);

        // Проверка корректности работы метода sortProductsByPrice
        assertThat(myShop.sortProductsByPrice().get(0).getCost()).isEqualTo(30);

        Product cheapestProduct = bread;
        Product mostExpProduct = myShop.getMostExpensiveProduct();
        for (Product p : products) {
            if (p.getCost() < cheapestProduct.getCost())
                cheapestProduct = p;
            if (p.getCost() > mostExpProduct.getCost())
                mostExpProduct = p;
        }
        assertThat(myShop.sortProductsByPrice().get(0)).isEqualTo(cheapestProduct);
        assertThat(myShop.sortProductsByPrice().get(products.size() - 1)).isEqualTo(mostExpProduct);
        
        Collections.sort(products);
        assertThat(myShop.sortProductsByPrice()).isEqualTo(products);

    }
}