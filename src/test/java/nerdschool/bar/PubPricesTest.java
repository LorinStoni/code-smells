package nerdschool.bar;


import nerdschool.bar.drinks.Drink;
import nerdschool.bar.exceptions.IllegalActionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Pub spec")
class PubPricesTest {

    private Pub pub;

    @BeforeEach
    void setUp() throws Exception {
        pub = new Pub();
    }

    @Test
    @DisplayName("When we order one beer, then the price is 74 kr.")
    void oneBeerTest() {
        int actualPrice = pub.computeCost(Drink.BEER.getName(), false, 1);
        assertEquals(74, actualPrice);
    }

    @Test
    @DisplayName("When we order one Gin-Ginger, then the price is 152.5 (153) kr.")
    void oneGinGingerTest() {
        int actualPrice = pub.computeCost(Drink.GINGINGER.getName(), false, 1);
        assertEquals(153, actualPrice);
    }

    @Test
    @DisplayName("When we order one cider, then the price is 103 kr.")
    void testCidersAreCostly() {
        int actualPrice = pub.computeCost(Drink.CIDER.getName(), false, 1);
        assertEquals(103, actualPrice);
    }

    @Test
    @DisplayName("When we order a proper cider, then the price is 110 kr.")
    void testProperCidersAreEvenMoreExpensive() throws Exception {
        int actualPrice = pub.computeCost(Drink.PROPERCIDER.getName(), false, 1);
        assertEquals(110, actualPrice);
    }

    @Test
    @DisplayName("When we order a gin and tonic, then the price is 115 kr.")
    void testACocktail() throws Exception {
        int actualPrice = pub.computeCost(Drink.GT.getName(), false, 1);
        assertEquals(115, actualPrice);
    }

    @Test
    @DisplayName("When we order a bacardi special, then the price is 127 kr.")
    void testBacardiSpecial() throws Exception {
        int actualPrice = pub.computeCost(Drink.BACADISPECIAL.getName(), false, 1);
        assertEquals(127, actualPrice);
    }

    @Nested
    @DisplayName("Given a customer who is a student")
    class Students {
        @Test
        @DisplayName("When they order a beer, then they get a discount.")
        void testStudentsGetADiscountForBeer() throws Exception {
            int actualPrice = pub.computeCost(Drink.BEER.getName(), true, 1);
            assertEquals(67, actualPrice);
        }

        @Test
        @DisplayName("When they order multiple beers, they also get a discount.")
        void testStudentsGetDiscountsWhenOrderingMoreThanOneBeer() {
            int actualPrice = pub.computeCost(Drink.BEER.getName(), true, 2);
            assertEquals(67 * 2, actualPrice);
        }

        @Test
        @DisplayName("When they order a cocktail, they do not get a discount.")
        void testStudentsDoNotGetDiscountsForCocktails() {
            int actualPrice = pub.computeCost(Drink.GT.getName(), true, 1);
            assertEquals(115, actualPrice);
        }

        @Test
        @DisplayName("When they order a cocktail, they do not get a discount.")
        void testStudentsDoNotGetDiscountsForCocktailsWhiskey() {
            int actualPrice = pub.computeCost(Drink.WHISKY.getName(), true, 2);
            assertEquals(300, actualPrice);
        }
    }

    @Test
    @DisplayName("When they order a drink which is not on the menu, then they are refused.")
    void testThatADrinkNotInTheSortimentGivesError() {
        assertThrows(NoSuchElementException.class, () -> pub.computeCost("sanfranciscosling", false, 1));
    }

    @Nested
    @DisplayName("When they order more than two drinks")
    class MultipleDrinks {
        @Test
        @DisplayName("and the order is for cocktails, then they are refused.")
        void testCanBuyAtMostTwoDrinksInOneGo() {
            assertThrows(IllegalActionException.class, () -> pub.computeCost(Drink.BACADISPECIAL.getName(), false, 3));
        }

      @Test
      @DisplayName("and the order is for cocktails, then they are refused.")
      void testTooManyCocktailsOrder() {
        assertThrows(IllegalActionException.class, () -> pub.computeCost(Drink.WHISKY.getName(), false, 4));
      }

        @Test
        @DisplayName("and the order is for beers, then they are served.")
        void testCanOrderMoreThanTwoBeers() throws Exception {
            pub.computeCost(Drink.BEER.getName(), false, 5);
        }
    }
}
