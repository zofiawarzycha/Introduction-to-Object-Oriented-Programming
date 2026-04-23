public class BoxTester {
    public static void  main(String[] args) {
        Box box1 = new Box();
        Box box2 = new Box(2.0,3.0,4.0);

        System.out.println("Box 1: ");
        System.out.println("Width: " + box1.getWidth());
        System.out.println("Height: " + box1.getHeight());
        System.out.println("Depth: " + box1.getDepth());
        System.out.println("Surface Area: " + box1.getSurfaceArea());
        System.out.println("Volume: " + box1.getVolume());

        System.out.println();

        System.out.println("Box 2: ");
        System.out.println("Width: " + box2.getWidth());
        System.out.println("Height: " + box2.getHeight());
        System.out.println("Depth: " + box2.getDepth());
        System.out.println("Surface Area: " + box2.getSurfaceArea());
        System.out.println("Volume: " + box2.getVolume());
    }
}
