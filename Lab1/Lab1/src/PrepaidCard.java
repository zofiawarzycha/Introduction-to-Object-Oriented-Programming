public class PrepaidCard {

    private int balance;

    public PrepaidCard() {
        balance = 100;
    }

    public PrepaidCard(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void topUp(int amount) {
        this.balance += amount;
    }

    public void pay(int amount) {
        if  (balance < amount) {
            System.out.println("Insufficient funds!");
        } else {
            this.balance -= amount;
        }
    }

    public void transferTo(PrepaidCard anotherCard, int amount) {
        if (balance < amount) {
            System.out.println("Insufficient funds to transfer!");
        } else {
            this.balance -= amount;
            anotherCard.topUp(amount);
        }
    }
}
