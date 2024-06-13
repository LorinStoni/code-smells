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

import java.util.HashMap;
import java.util.Map;

public class Recipe {

  private final Map<Incredient, Float> incredients;

  Recipe() {
    this.incredients = new HashMap<>();
  }

  Recipe(Map<Incredient, Float> incredients) {
    this.incredients = incredients;
  }

  public Map<Incredient, Float> getIncredients() {
    return incredients;
  }

}
