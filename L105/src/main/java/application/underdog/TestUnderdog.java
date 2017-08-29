package application.underdog;

import application.framework.Assert;
import application.framework.annotations.After;
import application.framework.annotations.Before;
import application.framework.annotations.Expects;
import application.framework.annotations.Test;

public class TestUnderdog {

    UnderdogClass cls;

    @Before
    public void setup()
    {
        cls = new UnderdogClass();
        System.out.println("Let's out tests begin!");
    }

    @After
    public void teardown()
    {
        System.out.println("That's all folks!");
    }

    @Test
    public void simple()
    {
        Assert.assertEquals(UnderdogClass.DEFAULT_INT, cls.getInt());
        Assert.assertEquals(UnderdogClass.DEFAULT_STRING, cls.getString());
    }

    @Test
    public void doubleSuccess()
    {
        Assert.assertEquals(UnderdogClass.DEFAULT_INT * 2, cls.getDouble());
    }

    @Test
    @Expects("IntegerOverflowException")
    public void doubleOverflow()
    {
        cls.setInt(Integer.MAX_VALUE);
        Assert.assertEquals(Integer.MAX_VALUE*2, cls.getDouble());
    }

    @Test
    public void testFails()
    {
        Assert.assertTrue(false);
    }
}
