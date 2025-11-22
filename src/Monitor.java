import java.util.concurrent.TimeUnit;

public class Monitor {

    private int readers = 0;
    private boolean isWriting = false;

    public synchronized void write(int id) throws InterruptedException {

        System.out.println("Value of readers " + readers);

        // Mientras haya lectores, el escritor no puede hacer nada
        while(readers != 0 || isWriting) {
            wait();
        }

        // Con esto, negamos que cualquier lector pueda continuar en su proceso de lectura
        // a su vez, que cualquier escritor pueda acceder al recurso
        isWriting = true;

        System.out.println("The writer " + id + " is modifying the resource");

        // Tiempo simulado de escritura
        TimeUnit.SECONDS.sleep(10);

        isWriting = false;

        notifyAll();
    }

    public synchronized void read(int id) throws InterruptedException {

        readers++;

        // Mientras un escritor esté en su proceso, el lector debe esperar a que este culmine
        while(isWriting){
            wait();
        }

        System.out.println("Reader " + id + " currently reading the resource");

        // Tiempo simulado de lectura
        TimeUnit.SECONDS.sleep(10);

        readers--;

        if (readers==0)
            notifyAll();
    }

}
