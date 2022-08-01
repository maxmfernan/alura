package servidor;

import java.io.PrintStream;

public class ComandoC2 implements Runnable{

    private PrintStream respostaServidor;

    public ComandoC2(PrintStream respostaServidor) {
        this.respostaServidor = respostaServidor;
    }

    @Override
    public void run() {
        System.out.println("Executando comando c2");
        try {
            Thread.sleep(20_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.respostaServidor.println("Comando c2 executando com sucesso!");
        
    }

}
