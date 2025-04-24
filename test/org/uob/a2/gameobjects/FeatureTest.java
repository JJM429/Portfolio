package org.uob.a2.gameobjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the {@code Feature} class.
 */
class FeatureTest {

    /**
     * Tests the creation of a {@code Feature} object and its attributes.
     */
    @Test
    void testFeatureAttributes() {
        // Create a feature
        Feature feature = new Feature("feature1", "Painting", "A beautiful painting of a landscape.", false);

        // Validate attributes
        boolean testPassed =
            "feature1".equals(feature.getId()) &&
            "Painting".equals(feature.getName()) &&
            "A beautiful painting of a landscape.".equals(feature.getDescription()) &&
            !feature.getHidden();

        System.out.println("AUTOMARK::Feature.testFeatureAttributes: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected all feature attributes to match.");
    }

    /**
     * Tests the string representation of a {@code Feature} object.
     */
    @Test
    void testToStringMethod() {
        // Create a feature
        Feature feature = new Feature("feature1", "Painting", "A beautiful painting of a landscape.", false);

        // Validate toString output
        String expected = "GameObject {id='feature1', name='Painting', description='A beautiful painting of a landscape.', hidden=false}";
        boolean testPassed = expected.equals(feature.toString());

        System.out.println("AUTOMARK::Feature.testToStringMethod: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected toString output to match the expected format.");
    }

    /**
     * Tests setting and getting the hidden state of the feature.
     */
    @Test
    void testSetAndGetHidden() {
        // Create a feature
        Feature feature = new Feature("feature1", "Painting", "A beautiful painting of a landscape.", true);

        // Update and validate the hidden state
        feature.setHidden(false);
        boolean testPassed = !feature.getHidden();

        System.out.println("AUTOMARK::Feature.testSetAndGetHidden: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected hidden state to be updated to 'false'.");
    }
}
