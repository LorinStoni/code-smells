/*
 * Drink.java
 *
 * Creator:
 * 13.06.2024 07:02 lorin.steiner
 *
 * Maintainer:
 * 13.06.2024 07:02 lorin.steiner
 *
 * Last Modification:
 * $Id:$
 *
 * Copyright (c) 2024 ABACUS Research AG, All Rights Reserved
 */
package nerdschool.bar.drinks;

import java.util.Map;
import java.util.Optional;

public enum Drink implements Sellable {

  BEER(
      "hansa",
      74,
      true
  ),
  CIDER(
      "grans",
      103,
      true
  ),
  PROPERCIDER(
      "strongbow",
      110,
      true
  ),
  GT(
      "gt",
      2,
      new Recipe(
          Incredient.GIN, 1f,
          Incredient.TONICWATER, 1f,
          Incredient.GREENSTUFF, 1f
      ),
      false
  ),
  BACADISPECIAL(
      "bacardi_special",
      2,
      new Recipe(
          Incredient.GIN, 0.5f,
          Incredient.RUM, 1f,
          Incredient.GRENADINE, 1f,
          Incredient.LIMEJUICE, 1f
      ),
      false
  ),
  WHISKY(
      "whisky",
      150,
      3,
      false
  ),
  GINGINGER(
      "Gin-Ginger",
      new Recipe(
          Incredient.GIN, 1.5f,
          Incredient.GINGER, 1f
      ),
      true
  );

  private static final int NOMAXAMOUNT = -1;
  private static final int NOFIXPRICE = -1;

  private final String name;
  private final int maxAmount;
  private final Recipe recipe;
  private final int fixPrice;
  private final boolean hasStudentDiscount;

  public static Optional<Drink> ofName(String name) {
    for (Drink d : Drink.values()) {
      if (d.name.equals(name)) {
        return Optional.of(d);
      }
    }
    return Optional.empty();
  }

  Drink(String name, int fixPrice, boolean hasStudentDiscount) {
    this.name = name;
    this.fixPrice = fixPrice;
    this.hasStudentDiscount = hasStudentDiscount;

    maxAmount = NOMAXAMOUNT;
    recipe = new Recipe();
  }

  Drink(String name, int fixPrice, int maxAmount, boolean hasStudentDiscount) {
    this.name = name;
    this.fixPrice = fixPrice;
    this.maxAmount = maxAmount;
    this.hasStudentDiscount = hasStudentDiscount;

    this.recipe = new Recipe();
  }

  Drink(String name, Recipe recipe, boolean hasStudentDiscount) {
    this.name = name;
    this.recipe = recipe;
    this.hasStudentDiscount = hasStudentDiscount;

    this.maxAmount = NOMAXAMOUNT;
    this.fixPrice = NOFIXPRICE;
  }

  Drink(String name, int maxAmount, Recipe recipe, boolean hasStudentDiscount) {
    this.name = name;
    this.maxAmount = maxAmount;
    this.recipe = recipe;
    this.hasStudentDiscount = hasStudentDiscount;

    this.fixPrice = NOFIXPRICE;
  }

  public final String getName() {
    return name;
  }

  public final Recipe getRecipe() {
    return recipe;
  }

  public int getMaxAmount() {
    return maxAmount;
  }

  public boolean amountIsPossible(int amount) {
    return maxAmount == NOMAXAMOUNT || amount <= maxAmount;
  }

  @Override
  public final int getBasePrice() {
    if (fixPrice == NOFIXPRICE) {
      return recipe.getTotalPrice();
    }

    return fixPrice;
  }

  @Override
  public final boolean hasStudentDiscount() {
    return hasStudentDiscount;
  }

}
