import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DukeTest {

    @Test
    public void parser() {
        parser tester = new parser(); // MyClass is tested

        // assert statements
        tester.setaction("todo");
        assertEquals(tester.getaction(),3);
        tester.setaction("list");
        assertEquals(tester.getaction(),1);
        tester.setaction("save");
        assertEquals(tester.getaction(),4);
        tester.setaction("load");
        assertEquals(tester.getaction(),6);
    }
}