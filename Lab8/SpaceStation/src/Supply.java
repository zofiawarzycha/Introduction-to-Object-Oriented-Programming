import java.math.BigDecimal;

public class Supply {

    private String name;
    private int quantity;
    private BigDecimal cost;
    private boolean isConsumable;

    public Supply(String name, int quantity, BigDecimal cost, boolean isConsumable) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative. Got: " + quantity);
        }
        if (cost.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Cost cannot be negative. Got: " + cost);
        }
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
        this.isConsumable = isConsumable;
    }

    public BigDecimal getTotalPrice() {
        return cost.multiply(BigDecimal.valueOf(quantity));
    }

    public String getName()        { return name; }
    public int getQuantity()       { return quantity; }
    public BigDecimal getCost()    { return cost; }
    public boolean isConsumable()  { return isConsumable; }

    @Override
    public String toString() {
        return "Supply{name='" + name + "', qty=" + quantity
                + ", unitCost=" + cost + ", totalPrice=" + getTotalPrice()
                + ", consumable=" + isConsumable + "}";
    }
}
