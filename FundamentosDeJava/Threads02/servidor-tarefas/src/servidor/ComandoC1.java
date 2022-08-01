package servidor;

import java.io.PrintStream;

public class ComandoC1 implements Runnable{

    private PrintStream respostaServidor;

    public ComandoC1(PrintStream respostaServidor) {
        this.respostaServidor = respostaServidor;
    }

    @Override
    public void run() {
        System.out.println("Executando comando c1");
        try {
            Thread.sleep(20_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.respostaServidor.println("Comando c1 executando com sucesso!");
        
    }

}
