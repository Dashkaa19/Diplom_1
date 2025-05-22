import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun mockedBun;

    @Mock
    private Ingredient mockedIngredient;

    @Test
    public void shouldSetBun() {
        Burger burger = new Burger();
        burger.setBuns(mockedBun);
        Assert.assertEquals(mockedBun, burger.bun);
    }

    @Test
    public void shouldAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(mockedIngredient);
        Assert.assertTrue(burger.ingredients.contains(mockedIngredient));
    }

    @Test
    public void shouldRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(mockedIngredient);
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(mockedIngredient));
    }

    @Test
    public void shouldMoveIngredient() {
        Burger burger = new Burger();
        Ingredient first = new Ingredient(IngredientType.FILLING, "Crispy Bacon", 200);
        Ingredient second = new Ingredient(IngredientType.SAUCE, "Garlic Mayo", 50);
        burger.addIngredient(first);
        burger.addIngredient(second);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Crispy Bacon", burger.ingredients.get(1).getName());
    }

    @Test
    public void shouldCalculateTotalPrice() {
        Burger burger = new Burger();
        float mockPrice = 99.99f;
        Mockito.when(mockedBun.getPrice()).thenReturn(mockPrice);
        Mockito.when(mockedIngredient.getPrice()).thenReturn(mockPrice);
        burger.setBuns(mockedBun);
        burger.addIngredient(mockedIngredient);
        float expected = mockPrice * 2 + mockPrice;
        Assert.assertEquals(expected, burger.getPrice(), 0.0001);
    }

    @Test
    public void shouldGenerateCorrectReceipt() {
        Burger burger = new Burger();

        Bun testBun = new Bun("Pretzel Bun", 1.5f);
        Ingredient ing1 = new Ingredient(IngredientType.FILLING, "Grilled Halloumi", 3.2f);
        Ingredient ing2 = new Ingredient(IngredientType.SAUCE, "Smoky BBQ", 0.8f);

        burger.setBuns(testBun);
        burger.addIngredient(ing1);
        burger.addIngredient(ing2);

        String expectedReceipt = String.format(
                "(==== %s ====)%n" +
                        "= filling %s =%n" +
                        "= sauce %s =%n" +
                        "(==== %s ====)%n%n" +
                        "Price: %f%n",
                testBun.getName(),
                ing1.getName(),
                ing2.getName(),
                testBun.getName(),
                burger.getPrice()
        );

        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}
