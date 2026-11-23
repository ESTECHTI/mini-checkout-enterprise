package io.github.estechti.checkout;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderItemTest {

  @Test
  void calculateSubtotalFromUnitPriceAndQuantity() {
    var item = new OrderItem(new BigDecimal("19.90"), 3);

    assertEquals(new BigDecimal("59.70"), item.subtotal());
  }

  @Test
  void rejectsZeroQuantity() {
    var unitPrice = new BigDecimal("19.90");

    assertThrows(IllegalArgumentException.class, () -> new OrderItem(unitPrice, 0));
  }

  @Test
  void returnsUnitPriceWhenQuantityIsOne() {
    var unitPrice = new BigDecimal("19.90");
    var item = new OrderItem(unitPrice, 1);

    assertEquals(unitPrice, item.subtotal());
  }

  @Test
  void rejectsNegativeUnitPrice() {
    var unitPrice = new BigDecimal("-0.01");

    assertThrows(IllegalArgumentException.class, () -> new OrderItem(unitPrice, 1));
  }

  @Test
  void rejectsMissingUnitPrice() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new OrderItem(null, 1)
    );
  }
}
