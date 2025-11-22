//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        Reader reader1 = new Reader(monitor,1);
        Reader reader2 = new Reader(monitor, 2);
        Reader reader3 = new Reader(monitor, 3);

        Writer writer1 = new Writer(monitor, 1);
        Writer writer2 = new Writer(monitor, 2);
        Writer writer3 = new Writer(monitor, 3);

        reader1.start();
        writer1.start();
        writer2.start();
        reader2.start();
        writer3.start();
        reader3.start();

    }
}