package com.dz.io.entity;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OrderSpec {


    @Test
    public void whenExtractOrdersThenOrdersCreated(){
        List<Order> orders = Order.extractOrders("LRMAL");
        assertThat(orders,hasSize(5));
        assertThat(orders,contains(Order.LEFT,Order.RIGHT,Order.MOVE_FORWARD, Order.INVALID,Order.LEFT));
    }

    @Test
    public void whenPassedValueThenGetOrder(){
        assertThat(Order.getOrder('L'),is(Order.LEFT));
        assertThat(Order.getOrder('R'),is(Order.RIGHT));
        assertThat(Order.getOrder('M'),is(Order.MOVE_FORWARD));
        assertThat(Order.getOrder('Z'),is(Order.INVALID));
    }
}
