public class Box {

    private double  width;
    private double height;
    private double  depth;

    public Box() {
        width = 1.0;
        height = 1.0;
        depth = 1.0;
    }

    public Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDepth() {
        return depth;
    }

    public double getSurfaceArea() {
        return 2*(width*height + width*depth + height*depth);
    }
    public double getVolume() {
        return width * height * depth;
    }
}
