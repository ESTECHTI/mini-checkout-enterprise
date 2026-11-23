package io.github.estechti.checkout;

import java.math.BigDecimal;
import java.util.List;

public record Order(List<OrderItem> items) {

  public Order {
    items = List.copyOf(items);
  }

  public BigDecimal total() {
    return items.stream()
        .map(OrderItem::subtotal)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
