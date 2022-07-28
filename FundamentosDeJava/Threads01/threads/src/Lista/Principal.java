package Lista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        //List<String> lista = Collections.synchronizedList(new ArrayList<String>());
        Lista lista = new Lista();
        
        for( int i = 0; i < 10; i++ ){
            Thread thread = new Thread( new TarefaAdicionarElemento(lista, i));
            thread.start();
        }

        new Thread(new TarefaImprimir(lista)).start();
        
    

        

    }
}
