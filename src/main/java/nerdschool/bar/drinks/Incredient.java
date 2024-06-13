/*
 * Incredient.java
 *
 * Creator:
 * 13.06.2024 07:35 lorin.steiner
 *
 * Maintainer:
 * 13.06.2024 07:35 lorin.steiner
 *
 * Last Modification:
 * $Id:$
 *
 * Copyright (c) 2024 ABACUS Research AG, All Rights Reserved
 */
package nerdschool.bar.drinks;

public enum Incredient {

  RUM(65),
  GRENADINE(10),
  LIMEJUICE(10),
  GREENSTUFF(10),
  TONICWATER(20),
  GIN(85),
  GINGER(25);

  private final int price;

  Incredient(int price) {
    this.price = price;
  }

  public int getPrice() {
    return price;
  }

}
