package banco;

public class TarefaAcessaBancoProcedimento implements Runnable {

    PoolDeConexao pool;
    GerenciadorDeTransacao tx;
    public TarefaAcessaBancoProcedimento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
        this.pool = pool;
        this.tx = tx;
    }

    @Override
    public void run() {
        synchronized(tx){
            System.out.println("Começando a tx.");
            tx.begin();

            synchronized(pool){
                System.out.println("Peguei a conexão.");
                pool.getConnection();
            }
        }
        
    }

}
