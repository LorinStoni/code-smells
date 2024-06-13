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

public enum Drink implements Sellable {

  BEER("hansa", 74, true),
  CIDER("grans", 103, true);

  private static final int NOMAXAMOUNT = -1;
  private static final int NOFIXPRICE = -1;

  private final String name;
  private final int maxAmount;
  private final Recipe recipe;
  private final int fixPrice;
  private final boolean hasStudentDiscount;

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

  @Override
  public final int getPrice() {
    if (fixPrice == NOFIXPRICE) {
      // calculate price
      return (int) recipe.getIncredients()
          .entrySet()
          .stream()
          .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue().floatValue())
          .sum();
    }

    return fixPrice;
  }

  @Override
  public final boolean hasStudentDiscount() {
    return hasStudentDiscount;
  }

}
