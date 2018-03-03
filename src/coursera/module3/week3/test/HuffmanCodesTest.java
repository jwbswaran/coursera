package coursera.module3.week3.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.PriorityQueue;

import coursera.common.model.HuffmanSymbol;
import org.junit.Before;
import org.junit.Test;

import coursera.common.FileIO;
import coursera.module3.week3.HuffmanCodes;

public class HuffmanCodesTest {

    private HuffmanCodes hc;

    private FileIO fileIO;

    @Before
    public void setup() {
        fileIO = new FileIO();
    }

    @Test
    public void testGetMaxLengthOfCodeWordWithDiscussionForumTestCase1() {
        String fileName = "src/coursera/module3/week3/test/Test1.txt";

        PriorityQueue<HuffmanSymbol> pq = null;

        try {
            pq = fileIO.getPriorityQueueFromHuffmanFile(fileName);
        } catch (IOException e) {
            fail();
        }

        hc = new HuffmanCodes(pq);

        assertEquals(5, hc.getMaxLengthOfCodeWord());
    }

    @Test
    public void testGetMinLengthOfCodeWordWithDiscussionForumTestCase1() {
        String fileName = "src/coursera/module3/week3/test/Test1.txt";

        PriorityQueue<HuffmanSymbol> pq = null;

        try {
            pq = fileIO.getPriorityQueueFromHuffmanFile(fileName);
        } catch (IOException e) {
            fail();
        }

        hc = new HuffmanCodes(pq);

        assertEquals(2, hc.getMinLengthOfCodeWord());
    }

    @Test
    public void testGetMaxLengthOfCodeWordWithDiscussionForumTestCase2() {
        String fileName = "src/coursera/module3/week3/test/Test2.txt";

        PriorityQueue<HuffmanSymbol> pq = null;

        try {
            pq = fileIO.getPriorityQueueFromHuffmanFile(fileName);
        } catch (IOException e) {
            fail();
        }

        hc = new HuffmanCodes(pq);

        assertEquals(6, hc.getMaxLengthOfCodeWord());
    }

    @Test
    public void testGetMinLengthOfCodeWordWithDiscussionForumTestCase2() {
        String fileName = "src/coursera/module3/week3/test/Test2.txt";

        PriorityQueue<HuffmanSymbol> pq = null;

        try {
            pq = fileIO.getPriorityQueueFromHuffmanFile(fileName);
        } catch (IOException e) {
            fail();
        }

        hc = new HuffmanCodes(pq);

        assertEquals(3, hc.getMinLengthOfCodeWord());
    }

    @Test
    public void testGetMaxLengthOfCodeWordWithDiscussionForumTestCase3() {
        String fileName = "src/coursera/module3/week3/test/Test3.txt";

        PriorityQueue<HuffmanSymbol> pq = null;

        try {
            pq = fileIO.getPriorityQueueFromHuffmanFile(fileName);
        } catch (IOException e) {
            fail();
        }

        hc = new HuffmanCodes(pq);

        assertEquals(9, hc.getMaxLengthOfCodeWord());
    }

    @Test
    public void testGetMinLengthOfCodeWordWithDiscussionForumTestCase3() {
        String fileName = "src/coursera/module3/week3/test/Test3.txt";

        PriorityQueue<HuffmanSymbol> pq = null;

        try {
            pq = fileIO.getPriorityQueueFromHuffmanFile(fileName);
        } catch (IOException e) {
            fail();
        }

        hc = new HuffmanCodes(pq);

        assertEquals(4, hc.getMinLengthOfCodeWord());
    }

    @Test
    public void testGetMaxLengthOfCodeWordWithDiscussionForumTestCase4() {
        String fileName = "src/coursera/module3/week3/test/Test4.txt";

        PriorityQueue<HuffmanSymbol> pq = null;

        try {
            pq = fileIO.getPriorityQueueFromHuffmanFile(fileName);
        } catch (IOException e) {
            fail();
        }

        hc = new HuffmanCodes(pq);

        assertEquals(14, hc.getMaxLengthOfCodeWord());
    }

    @Test
    public void testGetMinLengthOfCodeWordWithDiscussionForumTestCase4() {
        String fileName = "src/coursera/module3/week3/test/Test4.txt";

        PriorityQueue<HuffmanSymbol> pq = null;

        try {
            pq = fileIO.getPriorityQueueFromHuffmanFile(fileName);
        } catch (IOException e) {
            fail();
        }

        hc = new HuffmanCodes(pq);

        assertEquals(6, hc.getMinLengthOfCodeWord());
    }
}
