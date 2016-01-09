

import info.hccis.admin.model.jpa.Deliverable;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author csigouin
 */
public class testCalculateAverage {
    
    public final static double TEST_RESULT_AVERAGE_CORRECT = 73.25;
//    public final static double TEST_RESULT_AVERAGE_INCORRECT = 5.25;
    
    private static Deliverable deliverable;
    private static List<Deliverable> deliverables = new ArrayList();
    
    public testCalculateAverage() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        // Add some values
        
        /*
            Grade x Weight = Result
            ---------------------
            .60 x .25 = .15
            .75 x .35 = .2625
            .80 x .40 = .32
            ---------------------
                        .7325 x 100 = 73.25%
        
        */
        
        deliverable = new Deliverable(2, "Assignments", 25, "60");
        deliverables.add(deliverable);
        
        deliverable = new Deliverable(3, "Midterm", 35, "75");
        deliverables.add(deliverable);
        
        deliverable = new Deliverable(4, "Final", 40, "80");
        deliverables.add(deliverable);
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCalculateAverageMethodForCorrectReturnValue() {
        
        Double resultDouble = 0.0;
        
        String resultString = Deliverable.calculateAverage(deliverables);
        
        try {
            resultDouble = Double.parseDouble(resultString);
        } catch ( Exception ex ) {
            System.out.println(ex.getMessage());
        }
        
        Assert.assertEquals(TEST_RESULT_AVERAGE_CORRECT, resultDouble);
        
    }
    
}
