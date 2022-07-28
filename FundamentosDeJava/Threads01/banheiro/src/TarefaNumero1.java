
public class TarefaNumero1 implements Runnable{

    private Banheiro banheiro;
    //private BanheiroReentrantLock banheiro;

    public TarefaNumero1(Banheiro banheiro){
        this.banheiro = banheiro;
    }
    
    // public TarefaNumero1(BanheiroReentrantLock banheiro){
    //     this.banheiro = banheiro;
    // }

    @Override
    public void run() {
        this.banheiro.fazNumero1();
        
    }

}
