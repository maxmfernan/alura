package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorTarefas{
    private ServerSocket servidor;
    private ExecutorService threadPool;
    private Socket socket;
    private AtomicBoolean estaRodando;

    public ServidorTarefas() {
        System.out.println("Iniciando servidor...");
        try {
            this.servidor = new ServerSocket(12345);
            this.threadPool = Executors.newCachedThreadPool(new FabricaDeThreads());
            this.estaRodando = new AtomicBoolean(true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }

    }

    private void roda(){
        while(this.estaRodando.get()){
            try {
                socket = this.servidor.accept();
                System.out.println("Aceitando novo cliente na porta " + socket.getPort());
    
                DistribuirTarefas distribuirTarefas = new DistribuirTarefas(this.threadPool, socket, this);
    
                threadPool.execute(distribuirTarefas);
            } catch( SocketException e ){
                System.out.println("SockectException");
            } 
            catch ( IOException  e) {
                
                throw new RuntimeException(e);
            } 
            
            
        }
    }

    public void parar() {
        try {
            System.out.println("Parando...");
            this.estaRodando.set(false);
            servidor.close();
            threadPool.shutdown();
        } catch (IOException e) {
            
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws IOException, InterruptedException {

        ServidorTarefas servidor = new ServidorTarefas();

        servidor.roda();


        
        
    }




}