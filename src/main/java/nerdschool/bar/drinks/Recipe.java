/*
 * Recipe.java
 *
 * Creator:
 * 13.06.2024 07:21 lorin.steiner
 *
 * Maintainer:
 * 13.06.2024 07:21 lorin.steiner
 *
 * Last Modification:
 * $Id:$
 *
 * Copyright (c) 2024 ABACUS Research AG, All Rights Reserved
 */
package nerdschool.bar.drinks;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Recipe {

  private final Map<Incredient, Float> incredients = new EnumMap<>(Incredient.class);

  Recipe() {
  }

  Recipe(Incredient inc1, float quantityInc1, Incredient inc2, float quantityInc2, Incredient i3, float quantityInc3) {
    this.incredients.put(inc1, quantityInc1);
    this.incredients.put(inc2, quantityInc2);
    this.incredients.put(i3, quantityInc3);
  }

  Recipe(Incredient inc1, float quantityInc1, Incredient inc2, float quantityInc2) {
    this.incredients.put(inc1, quantityInc1);
    this.incredients.put(inc2, quantityInc2);
  }

  Recipe(Incredient inc1, float quantityInc1, Incredient inc2, float quantityInc2, Incredient i3, float quantityInc3, Incredient i4, float quantityInc4) {
    this.incredients.put(inc1, quantityInc1);
    this.incredients.put(inc2, quantityInc2);
    this.incredients.put(i3, quantityInc3);
    this.incredients.put(i4, quantityInc4);
  }

  public Map<Incredient, Float> getIncredients() {
    return incredients;
  }

  public int getTotalPrice() {
    return (int) Math.round(
        incredients
            .entrySet()
            .stream()
            .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue().floatValue())
            .sum()
    );
  }

}
