package application;

import java.util.HashMap;
import java.util.Map;

public class AtmDepartment implements AtmServiceInterface {

    Map<String, AtmDevice> atm = new HashMap<String, AtmDevice>();

    public AtmDepartment addDevice(AtmDevice device)
    {
        if (atm.containsKey(device.getId()))
            throw new RuntimeException("The device is allready added");

        atm.put(device.getId(), device);

        return this;
    }

    public int getBalance() {
        int balance = 0;
        for (AtmDevice device: atm.values()) {
            balance += device.getBalance();
        }
        return balance;
    }

    public void reset() {
        for (String id: atm.keySet()) {
            atm.get(id).reset();
        }
    }
}
