package uk.ac.assessment.process;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for ProcessingUnit.
 */
public class ProcessingUnitTest
{

    private static ProcessingUnit processingUnit;

    private static final String INVALID_INPUT1 = "4,7,8,9";

    private static final String INVALID_INPUT2 = "[[1,9][3,5]";

    private static final String INPUT_1_PROCESS = "[[1,5]]";

    private static final String INPUT_W_SPACES = "[[7 ,9] ,  [2, 4], [ 9, 10]]";

    private static final String INPUT3 = "[[0,3 ],[15,18],[17,20],[2,10]]";

    private static final String INPUT4 = "[[7,9],[2,4]]";

    private static final String INPUT5 = "[[1,5],[2,4],[3,6],[3,5]]";

    private static final String INPUT6 = "[[11,15],[6,8],[5,7],[1,5],[9,10],[7,12]]";

    private static final String INPUT7 = "[[12,17],[8,9],[7,11],[5,6],[1,4],[18,22],[10,11],[23,25],[22,25]]";

    @Before
    public void setUpClass(){
        processingUnit = new ProcessingUnit();
    }

    @Test(expected = InvalidInputException.class)
    public void failsInvalidInput1() throws InvalidInputException {
        processingUnit.validateInput(INVALID_INPUT1);
    }

    @Test(expected = InvalidInputException.class)
    public void failsInvalidInput2() throws InvalidInputException {
        processingUnit.calculateProcessingUnit(INVALID_INPUT2);
    }

    @Test
    public void testInput1Process() throws InvalidInputException {
        assertEquals(1, processingUnit.calculateProcessingUnit(INPUT_1_PROCESS));
    }

    @Test
    public void testInputWSpaces() throws InvalidInputException {
        assertEquals(2, processingUnit.calculateProcessingUnit(INPUT_W_SPACES));
    }

    @Test
    public void testInput3() throws InvalidInputException {
        assertEquals(2, processingUnit.calculateProcessingUnit(INPUT3));
    }

    @Test
    public void testInput4() throws InvalidInputException {
        assertEquals(1, processingUnit.calculateProcessingUnit(INPUT4));
    }

    @Test
    public void testInput5() throws InvalidInputException {
        assertEquals(4, processingUnit.calculateProcessingUnit(INPUT5));
    }

    @Test
    public void testInput6() throws InvalidInputException {
        assertEquals(3, processingUnit.calculateProcessingUnit(INPUT6));
    }

    @Test
    public void testInput7() throws InvalidInputException {
        assertEquals(2, processingUnit.calculateProcessingUnit(INPUT7));
    }
}
