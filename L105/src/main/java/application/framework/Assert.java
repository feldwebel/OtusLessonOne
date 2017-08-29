package application.framework;

public class Assert {

    public static final String MSG_ASSERT_TRUE_FAIL = "Assert TRUE fail";
    public static final String MSG_ASSERT_FALSE_FAIL = "Assert FALSE fail";
    public static final String MSG_ASSERT_EQUALS_FAIL = "Assert EQUALS fail";

    private Assert(){/*_*/}

    public static void assertTrue(boolean value)
    {
        if (!value) {
            throw new AssertionError(MSG_ASSERT_TRUE_FAIL);
        }
    }

    public static void assertFalse (boolean value)
    {
        if (value) {
            throw new AssertionError(MSG_ASSERT_FALSE_FAIL);
        }
    }

    public static void assertEquals (Object expected, Object real)
    {
        if (expected.getClass() != real.getClass() || expected != real) {
            throw new AssertionError(MSG_ASSERT_EQUALS_FAIL);
        }
    }
}
