package servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class DistribuirTarefas implements Runnable {

    private Socket socket;
    private ServidorTarefas servidor;
    public DistribuirTarefas(Socket socket, ServidorTarefas servidor) {
        this.socket = socket;
        this.servidor = servidor;
    }

    @Override
    public void run() {
        System.out.println("Distribuindo tarefas par " + socket);

        try {
            Scanner entradaCliente = new Scanner(socket.getInputStream());
            PrintStream respostaServidor = new PrintStream(socket.getOutputStream());
            Thread.sleep(20_000);

            while(entradaCliente.hasNext()){
                String comando = entradaCliente.nextLine();
                System.out.println(comando);
                switch(comando){
                    case "c1":{
                        respostaServidor.println("recebi comando " + comando);
                        break;
                    }
                    case "c2":{
                       respostaServidor.println("recebi comando " + comando);
                        break;
                    }
                    case "fim":{
                        servidor.parar();
                    }
                    default:{
                        respostaServidor.println("Comando não reconhecido.");
                    }
                }
            }
            respostaServidor.close();
        } catch (IOException | InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        
    }

}
