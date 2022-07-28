package banco;

public class TarefaAcessaBanco implements Runnable {
    PoolDeConexao pool;
    GerenciadorDeTransacao tx;

    public TarefaAcessaBanco(PoolDeConexao pool, GerenciadorDeTransacao tx) {
        this.pool = pool;
        this.tx = tx;
    }
    @Override
    public void run() {
        synchronized(pool){
            System.out.println("Peguei a chave do pool.");
            pool.getConnection();

            synchronized(tx){
                System.out.println("Começando a gerenciar a tx.");
                tx.begin();
            }
        }
        
    }

}
