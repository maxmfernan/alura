package Lista;

public class Lista {
    private String[] elementos = new String[1000];
    private int indice = 0;

    public synchronized void adicionaElementos(String elemento){
        this.elementos[indice] = elemento;
        this.indice++;
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(this.estaCheia()){
            System.out.println("A lista está cheia. Notificando...");
            this.notify();
        }
    }

    public int tamanho(){
        return this.elementos.length;
    }

    public String pegaElemento(int posicao){
        return this.elementos[posicao];
    }

    public boolean estaCheia() {
        return this.indice == this.tamanho();
    }
}
