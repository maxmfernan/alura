public class ServidorDeTeste {

    private boolean estaRodando = false;

    public static void main(String[] args) throws InterruptedException {
        ServidorDeTeste servidor = new ServidorDeTeste();
        servidor.rodar();
        servidor.alterandoAtributo();
    }

    private void rodar() {
        TarefaPararServidor tarefaParaServidor = new TarefaPararServidor(this);
        new Thread(tarefaParaServidor).start();
    }

    private void alterandoAtributo() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Main alterando estaRodando = true");
        this.ligar(); 

        Thread.sleep(5000);
        System.out.println("Main alterando estaRodando = false");
        this.parar();      
    }

    private synchronized void parar() {
        this.estaRodando = false;
    }

    private synchronized void ligar() {
        this.estaRodando = true;
    }

    public synchronized boolean estaRodando() {
        return this.estaRodando;
    }
}