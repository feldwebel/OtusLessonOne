package application;

public class AtmDevice implements AtmServiceInterface, AtmUserInterface {

    private Wallet dispenser;

    private AtmTypesEnum type;

    private String id;

    private AtmDispenserFactory dispenserFactory = AtmDispenserFactory.me();

    public AtmDevice(String id, AtmTypesEnum type, Wallet dispenser)
    {
        this.type = type;
        this.dispenser = dispenser;
        this.id = id;
    }

    public AtmDevice(String id, AtmTypesEnum type)
    {
        this.type = type;
        this.dispenser = new Wallet();
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public Wallet getMoney(int sum)
    {
        return dispenser.getMoney(sum);
    }

    public void putMoney(BanknotesEnum type, Integer quantity)
    {
        dispenser.putBanknotes(type, quantity);
    }

    public int getBalance()
    {
        return dispenser.getTotalBalance();
    }

    public Wallet checkStatus()
    {
        return dispenser;
    }

    public void reset()
    {
        dispenser = dispenserFactory.getDispenser(getType());
    }

    public AtmTypesEnum getType()
    {
        return type;
    }
}
