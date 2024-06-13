package nerdschool.bar;

import nerdschool.bar.drinks.Drink;
import nerdschool.bar.exceptions.IllegalActionException;

import java.util.NoSuchElementException;

public class Pub {

  public int computeCost(String drink, boolean student, int amount) {
    Drink correctDrink = Drink.ofName(drink)
        .orElseThrow(() -> new NoSuchElementException("The drink '" + drink + "' does not exist."));

    if (!correctDrink.amountIsPossible(amount)) {
      throw new IllegalActionException("Too many drinks, max amount: " + correctDrink.getMaxAmount() + ".");
    }

    if (student && correctDrink.hasStudentDiscount()) {
      return (int) Math.round(correctDrink.getBasePrice() * 0.9) * amount;
    }

    return correctDrink.getBasePrice() * amount;
  }

}
