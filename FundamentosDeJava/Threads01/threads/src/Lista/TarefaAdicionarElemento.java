package Lista;

import java.util.List;

public class TarefaAdicionarElemento implements Runnable{

    //private List<String> lista;
    private Lista lista;
    private int numeroDaThread;

    public TarefaAdicionarElemento(Lista lista, int numeroDaThread){
        this.lista = lista;
        this.numeroDaThread = numeroDaThread;
    }

    @Override
    public void run() {
        for( int i = 0; i < 100; i++){
            lista.adicionaElementos("Thread " + numeroDaThread + " - " + i);
        
        }
        
    }

    
}
