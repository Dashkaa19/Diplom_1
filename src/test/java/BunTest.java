import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.Collections;

@RunWith(Parameterized.class)
public class BunTest {

    private final String testName;
    private final float testPrice;

    public BunTest(String testName, float testPrice) {
        this.testName = testName;
        this.testPrice = testPrice;
    }

    @Parameterized.Parameters(name = "Test case: name = \"{0}\", price = {1}")
    public static Object[][] testData() {
        return new Object[][]{
                {"Sesame Bun", 2.49f},
                {"Brioche Deluxe", 3.75f},
                {"   ", 1.99f},
                {"🔥 Spicy Bun 🔥", 2.25f},
                {"Gluten-Free", 0f},
                {null, 1.50f},
                {"Multigrain", -1.25f},
                {"Mega Bun", Float.MAX_VALUE},
                {"Mini Bun", Float.MIN_VALUE},
                {"Nano Bun", 1.0E-40f},
                {"Giga Bun", 3.4E38f},
                {"Unicode — булочка", 2.99f},
                {String.join("", Collections.nCopies(50, "BunX")), 4.44f},
                {"!@#$%^&*()", 1.11f}
        };
    }

    @Test
    public void shouldReturnCorrectName() {
        Bun bun = new Bun(testName, testPrice);
        Assert.assertEquals("Name mismatch", testName, bun.getName());
    }

    @Test
    public void shouldReturnCorrectPrice() {
        Bun bun = new Bun(testName, testPrice);
        Assert.assertEquals("Price mismatch", testPrice, bun.getPrice(), 0.0001);
    }
}
