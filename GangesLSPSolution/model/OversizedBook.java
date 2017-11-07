package model;

public class OversizedBook extends Book {

    private double shippingMultiplier;

    private static final double BASE_SHIPPING = 5.00;
    private static final String MIN_SIZE = "large";

    public OversizedBook(String title, double price) {
        super(title, price);

        // This if block is a way to come up with different prices for large books
        // More expensive books should have a higher shipping multiplier
        if (price > 9.50) {
            shippingMultiplier = 2;
        } else {
            shippingMultiplier = 1.5;
        }
    }

    // REQUIRES: model.Box must be large
    // MODIFIES: this
    // EFFECTS:  If the book fits in the given box, then the two are associated (the book is packaged).
    @Override
    public Box packageBook(Box b) {
        if (b.getSize().equals("large")) {
            System.out.println("The large box is big enough for this oversized book.");
        } else {
            System.out.println("This box is way too small for an oversized book!");
            return null;
        }
        this.setBox(b);
        b.setContents(this);
        return b;
    }

    // EFFECTS: Returns the shipping cost for this book
    @Override
    public double calculateShipping() {
        return BASE_SHIPPING * shippingMultiplier;
    }

    // EFFECTS: returns the minimum required size of box for packaging this book
    @Override
    public String getMinBoxSize() {
        System.out.println("An oversized book can only fit in a large box.");
        return MIN_SIZE;
    }

}
