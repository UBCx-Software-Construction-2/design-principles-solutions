package model;

/**
 * model.Customer interface for making requests of various Ganges.com, Inc. services.
 */
public class GangesServiceManager {

    private BookRetailer bookRetailer;
    private CloudStorage cloudStorage;
    private int customerIdCounter;

    public static final int FIRST_CUSTOMER_NUMBER = 100;

    public GangesServiceManager() {
        this.bookRetailer = new BookRetailer();
        this.cloudStorage = new CloudStorage();
        this.customerIdCounter = FIRST_CUSTOMER_NUMBER;
    }

    // EFFECTS: Create a new customer with the given address and name
    public Customer signUpNewCustomer(String address, String name) {
        return new Customer(name, address, customerIdCounter++);
    }

    // EFFECTS: Print out all books for sale.
    public void listAvailableBooks() {
        bookRetailer.listAvailableBooks();
    }

    // REQUIRES: bookNumber is >= 1
    // MODIFIES: bookRetailer
    // EFFECTS: Creates a purchase order for the given customer and book number
    public BookOrder orderBook(Customer c, int bookNumber) {
        return bookRetailer.orderBook(c, bookNumber);
    }

    // MODIFIES: bookRetailer
    // EFFECTS: Removes the given order number from the book orders, if it exists
    public boolean cancelBookOrder(int orderNumber) {
        return bookRetailer.cancelBookOrder(orderNumber);
    }

    // MODIFIES: cloudStorage
    // EFFECTS: Stores the given data in the cloud under this customer's account
    public void putData(Customer c, String data) {
        cloudStorage.putData(c.getUniqueId(), data);
    }

    // Returns the given customer's data from the cloud
    public String getData(Customer c) {
        return cloudStorage.getData(c.getUniqueId());
    }

    // MODIFIES: cloudStorage
    // EFFECTS: Deletes this customer's data from the cloud
    public String deleteData(Customer c) {
        return cloudStorage.deleteData(c.getUniqueId());
    }

}
