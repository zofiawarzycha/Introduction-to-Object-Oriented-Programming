import java.math.BigDecimal;

public class Supply {

    private String name;
    private int quantity;
    private BigDecimal cost;

    public Supply(String name, int quantity, BigDecimal cost) {
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
    }

    public String getName() { return this.name; }
    public int getQuantity() { return this.quantity; }
    public BigDecimal getCost() { return this.cost; }
}