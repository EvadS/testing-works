package com.devskiller.orders;

import com.devskiller.orders.model.Customer;
import com.devskiller.orders.model.Order;
import com.devskiller.orders.model.OrderLine;
import com.devskiller.orders.model.Product;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrdersAnalyzer {

    /**
     * Should return at most three most popular products. Most popular product is the product that have the most occurrences
     * in given orders (ignoring product quantity).
     * If two products have the same popularity, then products should be ordered by name
     *
     * @param orders orders stream
     * @return list with up to three most popular products
     */
    public List<Product> findThreeMostPopularProducts(Stream<Order> orders) {
        // TODO: Implement this method

        Map<Product, Long> products = orders.flatMap(order -> order.getOrderLines().stream())
                .map(OrderLine::getProduct)
                .collect(Collectors.groupingBy(product -> product, Collectors.counting()));


        Comparator<Map.Entry<Product, Long>> reversedProductComparator = Comparator
                .comparing(Map.Entry<Product, Long>::getValue)
                .reversed()
                .thenComparing(entry -> entry.getKey().getName());

        return products.entrySet().stream()
                .sorted(reversedProductComparator)
                .map(Map.Entry::getKey)
                .limit(3)
                .collect(Collectors.toList());
    }

    /**
     * Should return the most valuable customer, that is the customer that has the highest value of all placed orders.
     * If two customers have the same orders value, then any of them should be returned.
     *
     * @param orders orders stream
     * @return Optional of most valuable customer
     */
    public Optional<Customer> findMostValuableCustomer(Stream<Order> orders) {
        // TODO: Implement this method

        Map<String, List<Order>> allOrdersByCustomer = orders.collect(Collectors.groupingBy(order -> order.getCustomer().getId()));

        Customer customerWithMaxValue = null;

        double maxValue = Double.MIN_VALUE;

        Set<Map.Entry<String, List<Order>>> entrySet = allOrdersByCustomer.entrySet();

        for (Map.Entry<String, List<Order>> entry : entrySet) {
            String customerId = entry.getKey();
            List<Order> allOrders = entry.getValue();

            double currentMaxValue = allOrders.stream()
                    .flatMap(o -> o.getOrderLines().stream())
                    .mapToDouble(orderLine -> orderLine.getProduct().getPrice()
                            .multiply(new BigDecimal(Optional.ofNullable(orderLine.getQuantity()).orElse(0))).doubleValue())
                    .sum();

            if(maxValue < currentMaxValue) {
                maxValue = currentMaxValue;
                Optional<Order> orderFound = entry.getValue().stream().findFirst();
                if(orderFound.isPresent()) {
                    customerWithMaxValue = orderFound.get().getCustomer();
                }
            }
        }

        return Optional.ofNullable(customerWithMaxValue);

    }

}
