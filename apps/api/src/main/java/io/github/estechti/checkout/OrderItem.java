package io.github.estechti.checkout;

import java.math.BigDecimal;

public record OrderItem(BigDecimal unitPrice, int quantity) {

  public OrderItem {
    if (quantity < 1) {
      throw new IllegalArgumentException("Quantity must be at least 1");
    }

    if (unitPrice == null) {
      throw new IllegalArgumentException("Unit price is required");
    }

    if (unitPrice.signum() < 0) {
      throw new IllegalArgumentException("Unit price cannot be negative");
    }
  }

  public BigDecimal subtotal() {
    return unitPrice.multiply(BigDecimal.valueOf(quantity));
  }
}
