package tests;

import io.qameta.allure.*;
import org.junit.Test;
import org.junit.Assert;

@Epic("Kayak Application")
@Feature("Basic Tests")
public class SimpleJUnitTest {

    @Test
    @Story("Sample Test")
    @Description("Simple test to verify Allure reporting")
    @Severity(SeverityLevel.CRITICAL)
    public void testOne() {
        Allure.step("Step 1: Start test");
        Allure.step("Step 2: Verify basic assertion");
        Assert.assertTrue("Test should pass", true);
        Allure.step("Step 3: Test completed");
    }

    @Test
    @Story("Another Test")
    @Description("Second simple test")
    @Severity(SeverityLevel.NORMAL)
    public void testTwo() {
        Allure.step("Step 1: Initialize");
        Assert.assertEquals("Values should match", "Hello", "Hello");
        Allure.step("Step 2: Test finished");
    }
}
