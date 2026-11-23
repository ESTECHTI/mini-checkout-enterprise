package io.github.estechti.checkout;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

  @Test
  void calculatesTotalFromAllItemSubtotals() {
    var order = new Order(List.of(
        new OrderItem(new BigDecimal("19.90"), 2),
        new OrderItem(new BigDecimal("5.50"), 1)));

    assertEquals(new BigDecimal("45.30"), order.total());
  }

  @Test
  void returnsZeroWhenOrderHasNoItems() {
    var order = new Order(List.of());

    assertEquals(BigDecimal.ZERO, order.total());
  }

  @Test
  void preservesTotalWhenOriginalListChanges() {
    var items = new ArrayList<OrderItem>();
    items.add(new OrderItem(new BigDecimal("10.00"), 2));
    var order = new Order(items);

    items.clear();

    assertEquals(new BigDecimal("20.00"), order.total());
  }
}