package application.underdog;

import application.framework.exceptions.IntegerOverflowException;

public class UnderdogClass {

    private int intVar;
    private String stringVar;

    public static final String DEFAULT_STRING = "some string";
    public static final int DEFAULT_INT = 1;

    public UnderdogClass()
    {
        intVar = DEFAULT_INT;
        stringVar = DEFAULT_STRING;
    }

    public UnderdogClass setInt(int var)
    {
        intVar = var;
        return this;
    }

    public UnderdogClass setString(String var)
    {
        stringVar = var;
        return this;
    }

    public int getInt()
    {
        return intVar;
    }

    public String getString()
    {
        return stringVar;
    }

    public int getDouble()
    {
        long result = (long)intVar << 1;

        if (result > Integer.MAX_VALUE) {
            throw new IntegerOverflowException("Value " + intVar + "cannot be doubled");
        }

        return (int) result;
    }

    public String getRevert()
    {
        StringBuilder result = new StringBuilder();
        return result.append(stringVar).reverse().toString();
    }
}
