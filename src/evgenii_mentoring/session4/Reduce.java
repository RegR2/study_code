package evgenii_mentoring.session4;

import java.util.*;

public class Reduce {
    public static void main(String[] args) {
        List<Double> productPrices = Arrays.asList(100.0, 200.0, 150.0, 50.0, 80.0);

        System.out.println("Starting sum " + productPrices.stream().reduce(0.0, Double::sum));

        //task 1
        double finalPricePostDiscount = productPrices.stream().reduce(0.0, (a, b) -> a + (b - b * 0.20));

        System.out.println("Final sum is " + finalPricePostDiscount);

        double finalPricePostDiscountWithErrorHandling = productPrices
                .stream()
                .reduce(0.0, (a, b) -> b == null ? a + 0.0 : b < 0 ? a + b : a + (b - b * 0.20));
        System.out.println("Final sum with error handling is " + finalPricePostDiscountWithErrorHandling);

        double finalPricePostConditionalDiscounts = productPrices
                .stream()
                .reduce(0.0, (a, b) -> b < 100.00 ? a + b - b * 0.10 : b < 150.0 ? a + b - b * 0.15 : a + b - b * 0.20);
        System.out.println("Final sum with conditial discounts is " + finalPricePostConditionalDiscounts);


        //task 2 --> stream api file

        //task 3

        List<SalesRecord> salesData = Arrays.asList(
                new SalesRecord(12000, "Europe"),
                new SalesRecord(18000, "Asia"),
                new SalesRecord(2500, "Europe"),
                new SalesRecord(30000, "North America"),
                new SalesRecord(16500, "Asia"),
                new SalesRecord(8000, "Europe"),
                new SalesRecord(20500, "North America")
        );

        Map<String, Double> totalRevenueByRegion = salesData.parallelStream().reduce(new HashMap<>(), ((a, b) -> {
            if (a.containsKey(b.getRegion())) {
               double rev =  a.get(b.getRegion()) + b.getRevenue();
               a.put(b.getRegion(), rev);
            } else {
                a.put(b.getRegion(), b.getRevenue());
            }
            return a;
        }), ((a, b )-> a)); //didn't understand why we needed the second reduction if the first one returns the already usable map?

        System.out.println("totalRevenueByRegion " + totalRevenueByRegion);

        String highestRevenueRegion = totalRevenueByRegion.entrySet().stream().reduce(new SalesRecord(0.0, ""), ((a, b) -> {
            if (a.getRevenue() > b.getValue()) {
                return a;
            } else {
                return new SalesRecord(b.getValue(), b.getKey());
            }
        }), ((a, b) -> {
            if (a.getRevenue() > b.getRevenue()) {
                return a;
            } else {
                return b;
            }
        })).region;
        System.out.println("Region with highest revenue: " + highestRevenueRegion);

    }



    static class SalesRecord {
        double revenue;
        String region;

        SalesRecord(double revenue, String region) {
            this.revenue = revenue;
            this.region = region;
        }

        public double getRevenue() {
            return revenue;
        }

        public String getRegion() {
            return region;
        }
    }
}
