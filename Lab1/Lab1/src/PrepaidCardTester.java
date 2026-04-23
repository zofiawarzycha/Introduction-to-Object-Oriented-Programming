public class PrepaidCardTester {
    public static void main(String[] args) {

        PrepaidCard Card1 = new PrepaidCard();
        PrepaidCard Card2 =  new PrepaidCard();

        System.out.println("Starting balances:");
        System.out.println("Card 1: " + Card1.getBalance());
        System.out.println("Card 2: " + Card2.getBalance());

        System.out.println("\nTopping up Card1 with 100: ");
        Card1.topUp(100);
        System.out.println("Card 1 is now: " + Card1.getBalance());

        System.out.println("\nTopping up Card2 with 50:");
        Card2.topUp(50);
        System.out.println("Card 1 is now: " + Card1.getBalance());
        System.out.println("Card 2 is now: " + Card2.getBalance());

        System.out.println("\nPaying with Card2 for a 10$ pizza slice:");
        Card2.pay(10);
        System.out.println("Card 1 is now: " + Card1.getBalance());
        System.out.println("Card 2 is now: " + Card2.getBalance());

        System.out.println("\nTransfering 50$ from Card1 to Card2:");
        Card1.transferTo(Card2, 50);
        System.out.println("Card 1 is now: " + Card1.getBalance());
        System.out.println("Card 2 is now: " + Card2.getBalance());

        System.out.println("\nFinal balances:");
        System.out.println("Card 1: " + Card1.getBalance());
        System.out.println("Card 2: " + Card2.getBalance());
    }
}
