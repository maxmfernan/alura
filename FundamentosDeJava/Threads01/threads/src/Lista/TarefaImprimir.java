package Lista;

public class TarefaImprimir implements Runnable{
    Lista lista;
    public TarefaImprimir(Lista lista) {
        this.lista = lista;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
       

        synchronized(lista){
            try {
                if( !lista.estaCheia()){
                    System.out.println("Vou esperar a notificação.");
                    lista.wait();
                    System.out.println("Fui notificado. Vou imprimir.");
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            for( int i = 0; i < lista.tamanho(); i++){
                System.out.println(lista.pegaElemento(i));
            }
        }

        
    }

}
