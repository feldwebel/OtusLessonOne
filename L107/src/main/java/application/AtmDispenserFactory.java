package application;

public class AtmDispenserFactory {

    public static AtmDispenserFactory _instance = null;

    private AtmDispenserFactory(){}

    public static synchronized AtmDispenserFactory me() {
        if (_instance == null)
            _instance = new AtmDispenserFactory();
        return _instance;
    }

    public Wallet getDispenser(AtmTypesEnum type)
    {
        Wallet w = new Wallet();

        switch(type) {
            case SUPER:
                return newInit(100, w);
            case EXTRA:
                return newInit(1000, w);
            case OLD_IS_GOLD:
                return oldInit(100, w);
            default:
                return w;
        }
    }

    private Wallet oldInit(int number, Wallet w)
    {
        return
            w.putBanknotes(BanknotesEnum.TEN, number)
                .putBanknotes(BanknotesEnum.FIFTY, number)
                .putBanknotes(BanknotesEnum.HUNDRED, number)
                .putBanknotes(BanknotesEnum.FIVE_HUNDRED, number)
                .putBanknotes(BanknotesEnum.THOUSAND, number)
        ;
    }

    private Wallet newInit(int number, Wallet w)
    {
        return
            oldInit(number, w).putBanknotes(BanknotesEnum.FIVE_THOUSAND, number);
    }
}
