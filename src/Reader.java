public class Reader extends Thread {
    private Monitor monitor;
    private int id;

    public Reader(Monitor monitor, int id) {
        this.monitor = monitor;
        this.id = id;
    }

    @Override
    public void run () {
        try {
            monitor.read(this.id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
