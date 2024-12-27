package evgenii_mentoring.session2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Product coffee = new Product("coffee", 13.00, "food");
        Product muffin = new Product("muffin", 15.00, "food");
        Product chair = new Product("chair", 50.00, "furniture");
        Product table = new Product("table", 100.00, "furniture");
        Product redShirt = new Product("red shirt", 89.99, "clothes");
        Product tShirt = new Product("t-shirt", 58.99, "clothes");

        List<Product> listOfProducts = Arrays.asList(coffee, muffin, chair, table, redShirt, tShirt);

        ProductPredicate filterByPrice = product -> product.price <= 50.00;
        ProductPredicate filterByCategory = product -> Objects.equals(product.category, "food");
        ProductPredicate filterByName = product -> product.name.contains("shirt");
        ProductPredicate findRedShirt = product -> product.name.equals("red shirt");

        ProductTransformer applyDiscount = product -> {
            product.price = product.price - (product.price * 0.10);
            return product;
        };

        ListProductTransformer findRedShirtAndApplySuffixAndDiscount = products -> {
            Product foundRedShirt = products.stream().filter(findRedShirt::test).toList().get(0);
            foundRedShirt.name = "discounted - " + foundRedShirt.name;

            return applyDiscount.apply(foundRedShirt);
        };

        ProductAction printProducts = product -> System.out.println("product: " + product.name + ", price: " + product.price + ", category: " + product.category);

        System.out.println("Find all products less than or equal to 50");
        List<Product> findAllProductsLessThan50 = listOfProducts.stream().filter(filterByPrice::test).toList();
        findAllProductsLessThan50.forEach(printProducts::action);

        System.out.println(" ");

        System.out.println("Find all food products");
        List<Product> findAllFoodProducts = listOfProducts.stream().filter(filterByCategory::test).toList();
        findAllFoodProducts.forEach(printProducts::action);

        System.out.println(" ");

        System.out.println("Find all shirt products");
        List<Product> findAllShirts = listOfProducts.stream().filter(filterByName::test).toList();
        findAllShirts.forEach(printProducts::action);

        System.out.println(" ");

        System.out.println("Applying discount for all products less than 50");
        findAllProductsLessThan50.forEach(applyDiscount::apply);
        findAllProductsLessThan50.forEach(printProducts::action);

        System.out.println(" ");

        System.out.println("Applying discount to red shirt");
        Product getRedShirt = findRedShirtAndApplySuffixAndDiscount.apply(listOfProducts);
        printProducts.action(getRedShirt);
    }
}
