package org.uob.a2.gameobjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the {@code Usable} interface via a concrete implementation.
 */
class UsableTest {

    /**
     * A mock class to test the {@code Usable} interface.
     */
    private static class MockUsable implements Usable {
        private UseInformation useInformation;
        private String name;

        public MockUsable(String name, UseInformation useInformation) {
            this.name = name;
            this.useInformation = useInformation;
        }

        @Override
        public void setUseInformation(UseInformation useInfo) {
            this.useInformation = useInfo;
        }

        @Override
        public UseInformation getUseInformation() {
            return this.useInformation;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }

    /**
     * Tests setting and getting use information.
     */
    @Test
    void testSetAndGetUseInformation() {
        // Create a mock usable object
        UseInformation useInfo = new UseInformation(false, "open", "target1", "result1", "You opened the object.");
        MockUsable usable = new MockUsable("Test Object", useInfo);

        // Validate initial use information
        boolean testPassed =
            usable.getUseInformation() == useInfo;

        // Update and validate use information
        UseInformation newUseInfo = new UseInformation(true, "reveal", "target2", "result2", "You revealed something.");
        usable.setUseInformation(newUseInfo);
        testPassed &= (usable.getUseInformation() == newUseInfo);

        System.out.println("AUTOMARK::Usable.testSetAndGetUseInformation: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected to set and retrieve use information correctly.");
    }

    /**
     * Tests setting and getting the name of a usable object.
     */
    @Test
    void testSetAndGetName() {
        // Create a mock usable object
        UseInformation useInfo = new UseInformation(false, "open", "target1", "result1", "You opened the object.");
        MockUsable usable = new MockUsable("Test Object", useInfo);

        // Validate name
        boolean testPassed = "Test Object".equals(usable.getName());

        System.out.println("AUTOMARK::Usable.testSetAndGetName: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected name to match 'Test Object'.");
    }
}
