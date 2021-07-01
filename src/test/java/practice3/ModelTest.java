package practice3;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class ModelTest {
    private Model model;
    private Field secretNumber;

    @Before
    public void setUp() throws Exception {
        model = new Model();
        secretNumber = model.getClass().getDeclaredField("secretValue");
        secretNumber.setAccessible(true);

        model.setPrimaryBarrier(model.getPRIMARY_MIN_BARRIER(), model.getPRIMARY_MAX_BARRIER());
    }

    @Test
    public void randomizeNumber_whenChangeInputNumber_setSecretValueTest() throws IllegalAccessException {
        int oldNumber = -1;
        secretNumber.set(model, -1);
        model.setSecretValue();
        int newNumber = (int) secretNumber.get(model);

        assertNotEquals(oldNumber, newNumber);
    }

    @Test
    public void randomizeNumber_whenInRange_setSecretValueTest() {
        model.setSecretValue();

        assertEquals(0, model.getMinBarrier());
        assertEquals(100, model.getMaxBarrier());
    }

    @Test
    public void checkNumber_whenEqualNumber_setSecretValueTest() throws IllegalAccessException {
        model.setSecretValue();
        int orderedValue = 90;
        secretNumber.set(model, orderedValue);
        boolean res = model.checkValue(orderedValue);

        assertFalse(res);
    }

    @Test
    public void checkNumber_whenSmallerNumber_setSecretValueTest() throws IllegalAccessException {
        model.setSecretValue();
        int orderedValue = 30;
        secretNumber.set(model, orderedValue);
        boolean res = model.checkValue(orderedValue - 10);

        assertTrue(res);
    }

    @Test
    public void checkNumber_whenGreaterNumber_checkValueTest() throws IllegalAccessException {
        model.setSecretValue();
        int orderedValue = 30;
        secretNumber.set(model, orderedValue);
        boolean res = model.checkValue(orderedValue + 10);

        assertTrue(res);
    }

    @Test
    public void checkIfNumbersInRangeUsingLoop_setSecretValueTest() {
        for (int i = 0; i < 10000; i++) {
            model.setSecretValue();
            int guessedNumber = model.getSecretValue();
            boolean inRangeValue = guessedNumber > model.getMinBarrier() && guessedNumber < model.getMaxBarrier();
            assertTrue(inRangeValue);
        }
    }

    @Test
    public void setNumberInList_checkValueTest() {
        boolean value = model.checkValue(10);

        assertTrue(value);
    }

    @Test
    public void setMinAndMaxBorders_setPrimaryBarrierTest() {
        String expectedBound = "10 to 20";
        assertEquals(expectedBound, model.setPrimaryBarrier(10, 20));

    }

}