package com.store.main;
import com.store.order.*;
import com.store.payment.Payable;
import java.util.ArrayList;
import java.util.Iterator;

public class OrderApp {
    public static void main(String[] args) {
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(new OnlineOrder(141, 15400));
        orders.add(new OnlineOrder(142, 25600));
        orders.add(new OnlineOrder(143, 35900));
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
