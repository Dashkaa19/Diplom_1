import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Ingredient: type={0}, name=\"{1}\", price={2}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {IngredientType.FILLING, "Spicy Chicken Strip", 5.49f},
                {IngredientType.SAUCE, "Garlic Ranch", 1.25f},
                {IngredientType.SAUCE, "", 0f},
                {IngredientType.FILLING, "Extra Crispy Onions", 2.75f},
                {IngredientType.SAUCE, "Truffle Mayo", 3.33f}
        });
    }

    @Test
    public void shouldReturnCorrectType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, ingredient.getType());
    }

    @Test
    public void shouldReturnCorrectName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void shouldReturnCorrectPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0.0001);
    }
}
