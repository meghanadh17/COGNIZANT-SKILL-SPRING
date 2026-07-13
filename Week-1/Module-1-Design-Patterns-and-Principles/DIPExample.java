interface Keyboard {
    void type();
}

class WiredKeyboard implements Keyboard {
    public void type() {
        System.out.println("Typing...");
    }
}

class Computer {
    Keyboard keyboard;

    Computer(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    void start() {
        keyboard.type();
    }
}

public class DIPExample {
    public static void main(String[] args) {
        Keyboard keyboard = new WiredKeyboard();
        Computer computer = new Computer(keyboard);
        computer.start();
    }
}