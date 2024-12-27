import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicStore {

    static class Product {
        String name;
        double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return name + " - " + price + " USD";
        }
    }

    static class Cart {
        List<Product> items = new ArrayList<>();

        void addProduct(Product product) {
            items.add(product);
            System.out.println(product.name + " добавлен в корзину.");
        }

        void viewCart() {
            if (items.isEmpty()) {
                System.out.println("Корзина пуста.");
            } else {
                System.out.println("Ваша корзина:");
                double total = 0;
                for (Product product : items) {
                    System.out.println(product);
                    total += product.price;
                }
                System.out.println("Итого: " + total + " USD");
            }
        }

        void checkout() {
            if (items.isEmpty()) {
                System.out.println("Корзина пуста. Нечего покупать.");
            } else {
                viewCart();
                System.out.println("Спасибо за покупку!");
                items.clear();
            }
        }
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Гитара", 150.0));
        products.add(new Product("Барабаны", 300.0));
        products.add(new Product("Пианино", 500.0));
        products.add(new Product("Скрипка", 200.0));

        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Добро пожаловать в музыкальный магазин!");
            System.out.println("1. Просмотреть товары");
            System.out.println("2. Добавить товар в корзину");
            System.out.println("3. Просмотреть корзину");
            System.out.println("4. Оформить покупку");
            System.out.println("5. Выйти");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Товары в магазине:");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println((i + 1) + ". " + products.get(i));
                    }
                    break;
                case 2:
                    System.out.println("Введите номер товара для добавления в корзину: ");
                    int productNumber = scanner.nextInt();
                    if (productNumber > 0 && productNumber <= products.size()) {
                        cart.addProduct(products.get(productNumber - 1));
                    } else {
                        System.out.println("Неверный номер товара.");
                    }
                    break;
                case 3:
                    cart.viewCart();
                    break;
                case 4:
                    cart.checkout();
                    break;
                case 5:
                    System.out.println("Спасибо за визит в музыкальный магазин! До свидания!");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }

            System.out.println();
        }
    }
}
