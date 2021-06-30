package practice3;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class ModelTest {
    private Model model;

    @Before
    public void setUp() throws Exception {
        model = new Model();
    }

    @Test
    public void shouldSetNumberInList_checkValueTest() {
        boolean value = model.checkValue(10);

        assertTrue(value);
    }

    @Test
    public void shouldSetMinAndMaxBorders_setPrimaryBarrierTest() {
        String expectedBound = "10 to 20";
        assertEquals(expectedBound, model.setPrimaryBarrier(10, 20));

    }

    @Test
    public void shouldGetNumbersFromList_getYourWayTest() {
        List<Integer> actual = model.getYourWay();
        actual.add(10);
        actual.add(20);
        actual.add(30);

        String expectedOutput = "[10, 20, 30]";
        assertEquals(expectedOutput, actual.toString());

    }
}