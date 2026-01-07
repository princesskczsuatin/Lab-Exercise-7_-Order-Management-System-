package com.store.main;
import com.store.order.*;
import com.store.payment.Payable;
import java.util.ArrayList;
import java.util.Iterator;

public class OrderApp {
    public static void main(String[] args) {
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(new OnlineOrder(101, 1500));
        orders.add(new OnlineOrder(102, 2500));
        orders.add(new OnlineOrder(103, 3500));
        for (Order order : orders) {
            order.processOrder();
            if (order instanceof Payable) {
                ((Payable) order).pay();
            }
        }
        System.out.println("\n========= Order Summaries =========");
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            System.out.println(order.getOrderSummary());
            if (order.getStatus() == OrderStatus.CANCELLED) {
                iterator.remove();
            }
        }
    }
}
