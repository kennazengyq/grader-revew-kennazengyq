import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }
  @Test 
	public void testMergeOneEmpty() {
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        for (int i = (int)'a'; i <= (int)'z'; i++){
            list1.add(Character.toString((char)i));
        }
        assertEquals(ListExamples.merge(list1,list2),list1);
	}

  @Test 
	public void testMerge() {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("a", "c", "d"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("b", "e", "f"));
        ArrayList<String> ans = new ArrayList<>(Arrays.asList("a","b","c","d","e","f"));
        assertEquals(ListExamples.merge(list1,list2), ans);
	}

  @Test
  public void testMergeSame(){
    ArrayList<String> list1 = new ArrayList<>(Arrays.asList("a", "a", "a"));
    ArrayList<String> list2 = new ArrayList<>(Arrays.asList("a", "a", "a"));
    ArrayList<String> ans = new ArrayList<>(Arrays.asList("a", "a", "a", "a", "a", "a"));
    assertEquals(ListExamples.merge(list1,list2), ans);
  }


}
