package application;

public enum BanknotesEnum {

    FIVE_THOUSAND(5000),
    THOUSAND(1000),
    FIVE_HUNDRED(500),
    HUNDRED(100),
    FIFTY(50),
    TEN(10);

    private int note;

    BanknotesEnum(int i) {
        this.note = i;
    }

    public int getNote()
    {
        return note;
    }
}
