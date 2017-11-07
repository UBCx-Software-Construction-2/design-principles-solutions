package model;

import java.util.HashMap;

/**
 * Store and manage data (Strings) in the cloud.
 */
public class CloudStorage {

    private HashMap<Integer, String> dataStorage;


    public CloudStorage() {
        this.dataStorage = new HashMap<>();
    }

    // MODIFIES: this
    // EFFECTS: Stores the given data in the cloud under this customer's account
    public void putData(int customerId, String data) {
        dataStorage.put(customerId, data);
    }

    // Returns the given customer's data from the cloud
    public String getData(int customerId) {
        return dataStorage.get(customerId);
    }

    // MODIFIES: this
    // EFFECTS: Deletes this customer's data from the cloud
    public String deleteData(int customerId) {
        return dataStorage.remove(customerId);
    }
}
