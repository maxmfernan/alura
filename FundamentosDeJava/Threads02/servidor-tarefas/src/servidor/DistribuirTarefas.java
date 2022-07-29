package servidor;

import java.net.Socket;

public class DistribuirTarefas implements Runnable {

    private Socket socket;
    public DistribuirTarefas(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Distribuindo tarefas par " + socket);
        try {
            Thread.sleep(20_000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
