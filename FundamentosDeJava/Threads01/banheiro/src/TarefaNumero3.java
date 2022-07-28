
public class TarefaNumero3 implements Runnable {
    private Banheiro banheiro;
    //private BanheiroReentrantLock banheiro;

    public TarefaNumero3(Banheiro banheiro){
        this.banheiro = banheiro;
    }
    
    // public TarefaNumero2(BanheiroReentrantLock banheiro){
    //     this.banheiro = banheiro;
    // }
    
    @Override
    public void run() {
        this.banheiro.limpa();
        
    }

}
