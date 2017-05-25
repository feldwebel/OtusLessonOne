import application.*;

import org.junit.Assert;
import org.junit.Test;

public class AtmDeviceTest {

    AtmDevice device;

    @Test
    public void resetTest()
    {
        device = getDevice(AtmTypesEnum.SUPER);

        device.reset();

        Assert.assertEquals(getDefaultWallet(AtmTypesEnum.SUPER), device.checkStatus());
    }

    @Test
    public void balanceTest()
    {
        device = getDevice(AtmTypesEnum.SUPER);

        Assert.assertEquals(getDefaultWallet(AtmTypesEnum.SUPER).getTotalBalance(), device.getBalance());
    }

    private AtmDevice getDevice(AtmTypesEnum type)
    {
        return new AtmDevice("Device", type, getCustomWallet(type));
    }

    private Wallet getCustomWallet(AtmTypesEnum type)
    {
        return getDefaultWallet(type).putBanknotes(BanknotesEnum.HUNDRED, 555);
    }

    private Wallet getDefaultWallet(AtmTypesEnum type)
    {
        return AtmDispenserFactory.me().getDispenser(type);
    }
}
