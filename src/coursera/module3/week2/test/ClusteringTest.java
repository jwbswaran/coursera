package coursera.module3.week2.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import coursera.common.EdgeBundle;
import coursera.common.FileIO;
import coursera.module3.week2.Clustering;

public class ClusteringTest {

    private Clustering clustering;
    
    private FileIO fileIO;
    
    @Before
    public void setup() {
        this.clustering = new Clustering();
        this.fileIO = new FileIO();
    }
    
    @Test
    public void testWithDiscussionForumTestCase() {
        String fileName = "src\\coursera\\module3\\week2\\test\\testFiles\\discussionForumTestCase.txt";
        EdgeBundle edgeBundle = null;
        
        try {
            edgeBundle = fileIO.getEdgeBundleFromFile(fileName);
        } catch (IOException e) {
            fail();
        }
        
        int maxSpacing = clustering.maxSpacingForKClusters(2, edgeBundle);
        
        assertEquals(100, maxSpacing);
    }
    
    @Test
    public void testWithDiscussionForumTestCase2() {
        String fileName = "src\\coursera\\module3\\week2\\test\\testFiles\\discussionForumTestCase2.txt";
        EdgeBundle edgeBundle = null;
        
        try {
            edgeBundle = fileIO.getEdgeBundleFromFile(fileName);
        } catch (IOException e) {
            fail();
        }
        
        int maxSpacing = clustering.maxSpacingForKClusters(2, edgeBundle);
        assertEquals(5, maxSpacing);
        
        maxSpacing = clustering.maxSpacingForKClusters(3, edgeBundle);
        assertEquals(2, maxSpacing);
        
        maxSpacing = clustering.maxSpacingForKClusters(5, edgeBundle);
        assertEquals(1, maxSpacing);
    }
}
