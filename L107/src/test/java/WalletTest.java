import application.BanknotesEnum;
import application.Wallet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

public class WalletTest {

    private Wallet w;

    @Before
    public void before()
    {
        w = new Wallet();
    }

    @Test
    public void simple()
    {
        w.putBanknotes(BanknotesEnum.TEN, 14)
            .putBanknotes(BanknotesEnum.FIFTY, 88);

        Assert.assertEquals(10, w.getBanknotes(BanknotesEnum.TEN, 10));
        Assert.assertEquals(4, w.checkBanknotes(BanknotesEnum.TEN));
        Assert.assertEquals(88, w.getAllBanknotes(BanknotesEnum.FIFTY));
    }

    @Test(expected = NoSuchElementException.class)
    public void error()
    {
        w.putBanknotes(BanknotesEnum.TEN, 14);

        w.getBanknotes(BanknotesEnum.TEN, 88);
    }

    @Test
    public void getMoneySuccessful()
    {
        setUpWallet();

        Wallet result = w.getMoney(12350);
        Assert.assertEquals(2, result.checkBanknotes(BanknotesEnum.FIVE_THOUSAND));
        Assert.assertEquals(2, result.checkBanknotes(BanknotesEnum.THOUSAND));
        Assert.assertEquals(3, result.checkBanknotes(BanknotesEnum.HUNDRED));
        Assert.assertEquals(1, result.checkBanknotes(BanknotesEnum.FIFTY));

    }

    @Test(expected = RuntimeException.class)
    public void getMoneyFailed()
    {
        setUpWallet();

        w.getMoney(1005001488);
    }

    @Test
    public void getTotalBalance()
    {
        w.putBanknotes(BanknotesEnum.TEN, 50)
            .putBanknotes(BanknotesEnum.HUNDRED, 30)
        ;
        Assert.assertEquals(3500, w.getTotalBalance());
    }

    private Wallet setUpWallet()
    {
        return
            w.putBanknotes(BanknotesEnum.TEN, 100)
                .putBanknotes(BanknotesEnum.FIFTY, 100)
                .putBanknotes(BanknotesEnum.HUNDRED, 100)
                .putBanknotes(BanknotesEnum.FIVE_HUNDRED, 100)
                .putBanknotes(BanknotesEnum.THOUSAND, 100)
                .putBanknotes(BanknotesEnum.FIVE_THOUSAND, 100);
    }
}
