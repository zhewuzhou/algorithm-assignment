package examples;

import org.junit.Test;

import java.util.ArrayList;

public class MemoryExceptionTest {
    @Test(expected = OutOfMemoryError.class)
    public void shouldThrowOOM() {
        ArrayList<Object> objects = new ArrayList<>();

        while (true) {
            objects.add(new Object());
        }
    }

    
}
