package evgenii_mentoring.session3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApi {
    public static void main(String[] args) {
        SalesRecord coffee = new SalesRecord(1, 1, "coffee", 2, 26.00);
        SalesRecord muffin = new SalesRecord(2, 7, "muffin", 1, 15.00);
        SalesRecord chair = new SalesRecord(3, 20, "chair", 6, 349.50);
        SalesRecord table = new SalesRecord(4, 15, "table", 1, 113.45);
        SalesRecord shirt = new SalesRecord(5, 21, "shirt", 4, 412.60);
        SalesRecord pants = new SalesRecord(6, 22, "pants", 2, 209.80);
        SalesRecord morePants = new SalesRecord(7, 22, "pants", 1, 104.50);

        List<SalesRecord> salesRecordList = Arrays.asList(coffee, muffin, chair, table, shirt, pants, morePants);

        Double totalSalesAmount = salesRecordList.stream().map(SalesRecord::getSalesAmount).reduce(0.0, Double::sum);
        System.out.println("Total sales amount: " + totalSalesAmount);

        System.out.println(" ");

        salesRecordList.forEach(record -> {
            System.out.println("Total sales quantity for " + record.productName + " is " + record.quantity);
        });

        System.out.println(" ");
        //alternative to finding most expensive sales record
        SalesRecord highestSalesRecord = salesRecordList.stream().max((s2, s1) -> Double.compare(s2.salesAmount, s1.salesAmount)).get();
        System.out.println("Product with highest sales amount (Alternative) = " + highestSalesRecord.productName);

        System.out.println(" ");

        salesRecordList = salesRecordList.stream().sorted((p1, p2) -> Double.compare(p2.salesAmount, p1.salesAmount)).toList();
        System.out.println("Product with highest sales amount = " + salesRecordList.get(0).productName);

        System.out.println(" ");

       List<SalesRecord> pantsSales = salesRecordList.stream().filter(salesRecord -> salesRecord.productName.equals("pants")).toList();
       pantsSales.forEach(sale -> System.out.println("pant sale transaction id: " + sale.transactionId));

        System.out.println(" ");

        salesRecordList.forEach(record -> {
            System.out.println("Average sale per transaction with id " + record.transactionId + " is " + record.salesAmount / record.quantity );
        });

        System.out.println(" ");

        Map<Integer, Long> mapOfProductIds = salesRecordList.stream().collect(Collectors.groupingBy(record -> record.productId, Collectors.counting()));
        Map.Entry<Integer, Long> highestFrequencyProduct = mapOfProductIds.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println("highest frequency product = " + highestFrequencyProduct.getKey());

    }
}
