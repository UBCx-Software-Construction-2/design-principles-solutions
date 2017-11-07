package model;

public class Box {

    private int size;
    private Book contents;

    private static final String[] SIZES = {"none", "small", "medium", "large"};
    private static final double BASE_SHIPPING = 5.50;

    // REQUIRES size must be one of "small", "medium", "large"
    public Box(String size) {
        if (size.equals("small")) {
            this.size = 1;
        } else if (size.equals("medium")) {
            this.size = 2;
        } else {
            this.size = 3;
        }

        contents = null;
    }

    // MODIFIES: this
    // EFFECTS: contents is assigned this book (i.e., the book is packaged)
    public void setContents(Book contents) {
        this.contents = contents;
    }

    // EFFECTS: returns the size of this box
    public String getSize() {
        return SIZES[size];
    }

    public double calculateShipping() {
        double price = BASE_SHIPPING * size;
        if (contents != null) {
            price = price + contents.calculateShipping();
        }
        return price;
    }
}
