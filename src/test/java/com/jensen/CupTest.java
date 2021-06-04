package com.jensen;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CupTest {

    Cup cup = new Cup("Water", 75.0);

    @BeforeEach

     void setUp() {

        System.out.println("Cup test");
    }

    @Test
    @Order(1)
    @DisplayName("Test that cup has created")
    void testObjectCreation() {
        assertNotNull(cup);
        assertEquals("Water", cup.getLiquidType());
        assertEquals(75.0, cup.getPercentFull());
    }

    @Test
    @Order(2)
    @DisplayName("Test that cup is not empty")
    void testIsEmpty() {
        Cup cup = new Cup("Juice", 65.0);
        assertTrue(!cup.isEmpty());
    }

    @Test
    @Order(3)
    @DisplayName("Test that all asserts are true")
    void testAssertAll() {
        assertAll("All asserts true",
                () -> assertEquals("Water",cup.getLiquidType()),
                () -> assertEquals(75,cup.getPercentFull(),0.0001));
    }
    @Test
    @Order(4)
    @DisplayName("Test that exception is thrown")
    void testPercentThrows(){
        assertThrows(IllegalArgumentException.class,
                () -> cup.setPercentFull(101));
    }

    @Test
    @Order(5)
    @DisplayName("Test set liquid type")
    void testSetLiquid(){
        System.out.println("Set Liquid type");
        String liquidType = "Coffee";
        cup.setLiquidType(liquidType);
        assertEquals(cup.getLiquidType(),liquidType);

    }
    @Test
    @Order(6)
    @DisplayName("Test get liquid percentile")
    void testGetLiquid(){
        System.out.println("get liquid type");
        double expPercentile= 90.0;
        cup.setPercentFull(expPercentile);
        //double result = cup.getPercentFull();
        assertEquals(cup.getPercentFull(),expPercentile);
    }
    @Test
    @Order(7)
    @DisplayName("Test that cup is empty")
    void testEmpty(){
        System.out.println("Test that cup is empty");
        Cup emptyCup = new Cup(null,0.0);
        assertTrue(emptyCup.isEmpty());
        assertNotNull(cup.getLiquidType());
        assertNotEquals(cup.getLiquidType(),emptyCup.getLiquidType());
        assertNotEquals(cup.getPercentFull(),emptyCup.getPercentFull());
    }

    @Test //this is the test to set the liquid type to null(which is nothing) in this case it returns the original value
    @Order(8)
    void testSetLiquidToNull(){
        cup.setLiquidType(null);
        assertNotNull(cup.getLiquidType());
    }  // I did this for the line coverage

}