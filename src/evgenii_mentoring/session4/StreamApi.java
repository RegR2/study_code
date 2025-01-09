package evgenii_mentoring.session4;

import evgenii_mentoring.session3.SalesRecord;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApi {
    public static void main(String[] args) {
        List<SalesEntry> sales = Arrays.asList(
                new SalesEntry("Apple iPhone 13", "Electronics", 30, 999.99),
                new SalesEntry("Samsung Galaxy S21", "Electronics", 25, 899.99),
                new SalesEntry("Dell XPS 13", "Computers", 15, 1299.99),
                new SalesEntry("MacBook Air", "Computers", 20, 999.99),
                new SalesEntry("Lenovo ThinkPad", "Computers", 10, 1199.99),
                new SalesEntry("Sony Headphones", "Accessories", 50, 199.99),
                new SalesEntry("Apple Watch Series 7", "Accessories", 45, 399.99)
        );
        Map<String, Double> revenueByCategory = sales.stream().collect(Collectors.groupingBy(SalesEntry::getCategory, Collectors.summingDouble(SalesEntry::getTotalRevenue)));
        System.out.println("Revenue by category: " + revenueByCategory);

        Map<String, Double> revenueByProducts = sales.stream().collect(Collectors.groupingBy(SalesEntry::getProductName, Collectors.summingDouble(SalesEntry::getTotalRevenue)));
        System.out.println("Revenue by product: " + revenueByProducts);

        SalesEntry topSellingProduct = sales.stream().sorted((a, b) -> Double.compare(b.getTotalRevenue(), a.getTotalRevenue())).toList().get(0);
        System.out.println("Top Selling Product: " +
                (topSellingProduct != null ? topSellingProduct.productName + ", Revenue: " +
                        topSellingProduct.getTotalRevenue() : "No sales data"));
    }
}
