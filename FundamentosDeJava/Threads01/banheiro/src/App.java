public class App {
    public static void main(String[] args) throws Exception {
        
        Banheiro banheiro = new Banheiro();
        //BanheiroReentrantLock banheiro = new BanheiroReentrantLock();
        Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "João");
        Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Pedro");
        Thread limpeza = new Thread(new TarefaNumero3(banheiro), "Maria");

        convidado1.start();
        convidado2.start();
        limpeza.start();

    }
}
