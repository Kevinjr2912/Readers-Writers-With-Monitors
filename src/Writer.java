public class Writer extends Thread {
    private Monitor monitor;
    private int id;

    public Writer(Monitor monitor, int id) {
        this.monitor = monitor;
        this.id = id;
    }

    @Override
    public void run () {
        try {
            this.monitor.write(this.id);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
