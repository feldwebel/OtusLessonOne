package application;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Wallet {

    private Map<BanknotesEnum, Integer> Container = new HashMap<BanknotesEnum, Integer>();

    public Wallet()
    {
        for (BanknotesEnum note: BanknotesEnum.values()) {
            putBanknotes(note, 0);
        }
    }

    public Wallet putBanknotes(BanknotesEnum type, int quantity)
    {
        if (Container.containsKey(type)) {
            Container.put(type, Container.get(type) + quantity);
        } else {
            Container.put(type, quantity);
        }
        return this;
    }

    public int checkBanknotes(BanknotesEnum type)
    {
        if (!Container.containsKey(type))
            throw new NoSuchElementException("There is no such bank-note as " + type.toString());
        return Container.get(type);
    }

    public int getBanknotes(BanknotesEnum type, int quantity)
    {
        Integer notes = checkBanknotes(type);
        if (notes < quantity)
            throw new NoSuchElementException("You need " + quantity + "bank-note(s). We got just " + notes);

        Container.put(type, notes - quantity);

        return quantity;
    }

    public int getAllBanknotes(BanknotesEnum type)
    {
        Integer notes = checkBanknotes(type);
        Container.put(type, 0);

        return notes;
    }

    public Wallet getMoney(int sum)
    {
        int s = sum;

        Wallet w = new Wallet();
        for (BanknotesEnum note: BanknotesEnum.values()) {
            int value = note.getNote();
            if (value > s) continue;
            int a = s / value;
            s -= a * value;
            w.putBanknotes(note, a);
            getBanknotes(note, a);
        }
        if (s != 0) throw new RuntimeException("Cannot compose the sum");

        return w;
    }

    public int getTotalBalance()
    {
        int total = 0;
        for (BanknotesEnum note: BanknotesEnum.values()) {
            total += checkBanknotes(note) * note.getNote();
        }

        return total;
    }
}
