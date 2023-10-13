package seminars.first.Shop;

public class Product implements Comparable<Product> {
    private Integer cost; // Стоимость продукта
    private String title; // Название

    /**
     * Продукт
     *
     * @param title название продукта
     * @param cost  цена продукта
     */
    public Product(String title, Integer cost) {
        this.cost = cost;
        this.title = title;
    }

    // Геттеры, сеттеры:
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int compareTo(Product o) {
        if (this.cost != o.getCost()) {
            return this.cost - o.getCost();
        }
        return this.title.compareTo(o.getTitle());
    }
}