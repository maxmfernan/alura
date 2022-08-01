package servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

public class DistribuirTarefas implements Runnable {

    private Socket socket;
    private ServidorTarefas servidor;
    private ExecutorService threadPool;
    public DistribuirTarefas(ExecutorService threadPool, Socket socket, ServidorTarefas servidor) {
        this.threadPool = threadPool;
        this.socket = socket;
        this.servidor = servidor;
    }

    @Override
    public void run() {
        System.out.println("Distribuindo tarefas par " + socket);

        try {
            Scanner entradaCliente = new Scanner(socket.getInputStream());
            PrintStream respostaServidor = new PrintStream(socket.getOutputStream());
            

            while(entradaCliente.hasNext()){
                String comando = entradaCliente.nextLine();
                System.out.println(comando);
                switch(comando){
                    case "c1":{
                        respostaServidor.println("recebi comando " + comando);
                        ComandoC1 c1 = new ComandoC1(respostaServidor);
                        this.threadPool.execute(c1);
                        break;
                    }
                    case "c2":{
                       respostaServidor.println("recebi comando " + comando);
                       ComandoC2 c2 = new ComandoC2(respostaServidor);
                       this.threadPool.execute(c2);
                        break;
                    }
                    case "fim":{
                        System.out.println("Desligando servidor...");
                        servidor.parar();
                        return;
                    }
                    default:{
                        respostaServidor.println("Comando não reconhecido.");
                    }
                }
            }
            respostaServidor.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        
    }

}
