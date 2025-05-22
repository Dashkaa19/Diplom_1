import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType input;
    private final String expectedName;

    public IngredientTypeTest(IngredientType input, String expectedName) {
        this.input = input;
        this.expectedName = expectedName;
    }

    @Parameterized.Parameters(name = "Enum value: {0}, expected name: \"{1}\"")
    public static Object[][] testData() {
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }

    @Test
    public void shouldReturnCorrectEnumName() {
        assertEquals("Enum name mismatch", expectedName, input.name());
    }

    @Test
    public void valueOfShouldReturnCorrectEnum() {
        assertSame("Enum valueOf did not return expected constant", input, IngredientType.valueOf(expectedName));
    }
}
