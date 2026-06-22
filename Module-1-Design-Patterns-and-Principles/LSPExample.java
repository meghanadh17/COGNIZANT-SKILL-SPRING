class Bird {
    void move() {
        System.out.println("Bird is moving");
    }
}

class Sparrow extends Bird {}

public class LSPExample {
    public static void main(String[] args) {
        Bird bird = new Sparrow();
        bird.move();
    }
}