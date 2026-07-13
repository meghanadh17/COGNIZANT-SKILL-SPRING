interface Printer {
    void print();
}

class SimplePrinter implements Printer {
    public void print() {
        System.out.println("Printing document...");
    }
}

public class ISPExample {
    public static void main(String[] args) {
        Printer p = new SimplePrinter();
        p.print();
    }
}