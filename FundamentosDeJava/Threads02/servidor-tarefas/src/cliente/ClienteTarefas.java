package cliente;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteTarefas {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 12345);

        System.out.println("conexao estabelecida");

        
        Thread threadEnviaComando = new Thread(
                new Runnable(){

                    @Override
                    public void run() {
                        try {
                            System.out.println("Pode inviar comandos!");
                            PrintStream saida = new PrintStream(socket.getOutputStream());;
                            
                            Scanner teclado = new Scanner(System.in);
                            while(teclado.hasNextLine()){
                                String linha = teclado.nextLine().trim();
                                if(linha.equals("")){
                                    break;
                                }
                                saida.println(linha);
                            }
                            saida.close();
                            teclado.close();
                        } catch (IOException e) {
                            
                            throw new RuntimeException(e);
                        }

                        
                    }
                
                }
            );
        
       Thread threadRecebeResposta = new Thread(
                new Runnable(){

                    @Override
                    public void run() {
                        System.out.println("recebendo dados do servidor");
                        Scanner respostaServidor;
                        try {
                            respostaServidor = new Scanner(socket.getInputStream());
                            while(respostaServidor.hasNextLine()){
                                String linha = respostaServidor.nextLine();
                                System.out.println(linha);
                            }
                            respostaServidor.close();
                            
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
        );

        threadEnviaComando.start();
        threadRecebeResposta.start();

        try {
            threadEnviaComando.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        socket.close();
    }
}
