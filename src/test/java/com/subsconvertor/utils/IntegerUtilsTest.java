package com.subsconvertor.utils;

import junit.framework.TestCase;

/**
 *
 */
public class IntegerUtilsTest extends TestCase {

    public void testmilliSecsToHMSMs() {
        assertEquals("00:00:00,001", IntegerUtils.milliSecsToHMSMsSubRipString(1));

        assertEquals("00:00:01,000", IntegerUtils.milliSecsToHMSMsSubRipString(1000));

        assertEquals("01:00:00,000", IntegerUtils.milliSecsToHMSMsSubRipString(3600 * 1000));

        System.out.println(IntegerUtils.milliSecsToHMSMsSubRipString(11268));
    }

}
