package com.cocreativeds;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ULIDTest {
    @Test
    void testGenULIDString0008() {
        //                            0   0     1     2     3     4     5     6     7     8  
        long ts = 0b00000000_00000000_000_00000_00001_00010_00011_00100_00101_00110_00111_01000L;

        byte[] bytes = new byte[10];

        String ulid = ULID.genULIDString(ts, bytes);
        assertEquals("00123456780000000000000000", ulid);
    }

    @Test
    void testGenULIDString0917() {
        //                            1   9     10    11    12    13    14    15    16    17  
        long ts = 0b00000000_00000000_001_01001_01010_01011_01100_01101_01110_01111_10000_10001L;

        byte[] bytes = new byte[10];

        String ulid = ULID.genULIDString(ts, bytes);
        assertEquals("19ABCDEFGH0000000000000000", ulid);
    }

    @Test
    void testGenULIDString1826() {
        //                            2   18    19    20    21    22    23    24    25    26  
        long ts = 0b00000000_00000000_010_10010_10011_10100_10101_10110_10111_11000_11001_11010L;

        byte[] bytes = new byte[10];

        String ulid = ULID.genULIDString(ts, bytes);
        assertEquals("2JKMNPQRST0000000000000000", ulid);
    }

    @Test
    void testGenULIDString2731() {
        //                            3   27    28    29    30    31    0     1     16    31  
        long ts = 0b00000000_00000000_011_11011_11100_11101_11110_11111_00000_00001_10000_11111L;

        byte[] bytes = new byte[10];

        String ulid = ULID.genULIDString(ts, bytes);
        assertEquals("3VWXYZ01GZ0000000000000000", ulid);
    }

    @Test
    void testGenULIDStringTimestamp() {
        long ts = System.currentTimeMillis();

        byte[] bytes = new byte[10];

        String ulid = ULID.genULIDString(ts, bytes);
        System.out.println("ULID: " + ulid);
    }

    @Test
    void testGenULIDStringRand10() {
        long ts = 0L;

        byte[] bytes = new byte[10];

        bytes[0] = (byte)0b11111_000;

        String ulid = ULID.genULIDString(ts, bytes);
        assertEquals("0000000000Z000000000000000", ulid);
    }

    @Test
    void testGenULIDStringRand11() {
        long ts = 0L;

        byte[] bytes = new byte[10];

        bytes[0] = 0b00000_111;
        bytes[1] = (byte)0b11000000;

        String ulid = ULID.genULIDString(ts, bytes);
        assertEquals("00000000000Z00000000000000", ulid);
    }

    @Test
    void testGenULIDStringRand12() {
        long ts = 0L;

        byte[] bytes = new byte[10];

        bytes[1] = (byte)0b00111110;

        String ulid = ULID.genULIDString(ts, bytes);
        assertEquals("000000000000Z0000000000000", ulid);
    }

    @Test
    void testGenULIDStringRand13() {
        long ts = 0L;

        byte[] bytes = new byte[10];

        bytes[1] = (byte)0b00000001;
        bytes[2] = (byte)0b11110000;

        String ulid = ULID.genULIDString(ts, bytes);
        assertEquals("0000000000000Z000000000000", ulid);
    }

    @Test
    void testGenULIDStringRand14() {
        long ts = 0L;

        byte[] bytes = new byte[10];

        bytes[2] = (byte)0b00001111;
        bytes[3] = (byte)0b10000000;

        String ulid = ULID.genULIDString(ts, bytes);
        assertEquals("00000000000000Z00000000000", ulid);
    }

    @Test
    void testGenULIDStringRand15() {
        long ts = 0L;

        byte[] bytes = new byte[10];

        bytes[3] = (byte)0b01111100;

        String ulid = ULID.genULIDString(ts, bytes);
        assertEquals("000000000000000Z0000000000", ulid);
    }

    @Test
    void testGenULIDStringRand16() {
        long ts = 0L;

        byte[] bytes = new byte[10];

        bytes[3] = (byte)0b00000011;
        bytes[4] = (byte)0b11100000;

        String ulid = ULID.genULIDString(ts, bytes);
        assertEquals("0000000000000000Z000000000", ulid);
    }

    @Test
    void testGenULIDStringRand17() {
        long ts = 0L;

        byte[] bytes = new byte[10];

        bytes[4] = (byte)0b00011111;

        String ulid = ULID.genULIDString(ts, bytes);
        assertEquals("00000000000000000Z00000000", ulid);
    }


    @Test
    void testGenULIDStringRand18() {
        long ts = 0L;

        byte[] bytes = new byte[10];

        bytes[5] = (byte)0b11111_000;

        String ulid = ULID.genULIDString(ts, bytes);
        assertEquals("000000000000000000Z0000000", ulid);
    }

    @Test
    void testGenULIDStringRand19() {
        long ts = 0L;

        byte[] bytes = new byte[10];

        bytes[5] = 0b00000_111;
        bytes[6] = (byte)0b11000000;

        String ulid = ULID.genULIDString(ts, bytes);
        assertEquals("0000000000000000000Z000000", ulid);
    }

    @Test
    void testGenULIDStringRand20() {
        long ts = 0L;

        byte[] bytes = new byte[10];

        bytes[6] = (byte)0b00111110;

        String ulid = ULID.genULIDString(ts, bytes);
        assertEquals("00000000000000000000Z00000", ulid);
    }

    @Test
    void testGenULIDStringRand21() {
        long ts = 0L;

        byte[] bytes = new byte[10];

        bytes[6] = (byte)0b00000001;
        bytes[7] = (byte)0b11110000;

        String ulid = ULID.genULIDString(ts, bytes);
        assertEquals("000000000000000000000Z0000", ulid);
    }

    @Test
    void testGenULIDStringRand22() {
        long ts = 0L;

        byte[] bytes = new byte[10];

        bytes[7] = (byte)0b00001111;
        bytes[8] = (byte)0b10000000;

        String ulid = ULID.genULIDString(ts, bytes);
        assertEquals("0000000000000000000000Z000", ulid);
    }

    @Test
    void testGenULIDStringRand23() {
        long ts = 0L;

        byte[] bytes = new byte[10];

        bytes[8] = (byte)0b01111100;

        String ulid = ULID.genULIDString(ts, bytes);
        assertEquals("00000000000000000000000Z00", ulid);
    }

    @Test
    void testGenULIDStringRand24() {
        long ts = 0L;

        byte[] bytes = new byte[10];

        bytes[8] = (byte)0b00000011;
        bytes[9] = (byte)0b11100000;

        String ulid = ULID.genULIDString(ts, bytes);
        assertEquals("000000000000000000000000Z0", ulid);
    }

    @Test
    void testGenULIDStringRand25() {
        long ts = 0L;

        byte[] bytes = new byte[10];

        bytes[9] = (byte)0b00011111;

        String ulid = ULID.genULIDString(ts, bytes);
        assertEquals("0000000000000000000000000Z", ulid);
    }

    @Test
    void testGenerate() {
        String ulid = ULID.generate();
        System.out.println(ulid);
        ulid = ULID.generate();
        System.out.println(ulid);
    }
}
