public class Banheiro{
    
    private boolean ehSujo = true;

    public void fazNumero1(){
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " Bantendo na porta");
        synchronized(this){

           


            System.out.println(nome + " Entrando no banheiro.");
            if( ehSujo ){
                esperaLaFora(nome);
            }
            System.out.println(nome +" Fazendo a coisa rápida.");
    
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    
            System.out.println(nome +" dando descarga.");
            System.out.println(nome +" lavando a mão.");
            System.out.println(nome +" saindo do banheiro.");
        }
        

    }

    public void fazNumero2(){
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " Bantendo na porta");


        synchronized(this){
            System.out.println(nome +" Entrando no banheiro.");
            if( this.ehSujo ){
                esperaLaFora(nome);
            }
            System.out.println(nome +" Fazendo a coisa demorada.");
    
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    
            System.out.println(nome +" dando descarga.");
            System.out.println(nome +" lavando a mão.");
            System.out.println(nome +" saindo do banheiro.");
        }
        
    }

    public void limpa(){
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " Bantendo na porta");


        synchronized(this){
            System.out.println(nome +" Entrando no banheiro.");
            if( !this.ehSujo ){
                System.out.println("Já está limpo.");
                return;
            }

            System.out.println(nome +" Limpando o banheiro.");
    
            try {
                Thread.sleep(13000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            ehSujo = false;
            System.out.println(nome +" saindo do banheiro.");
            this.notifyAll();
        }
    }
    private void esperaLaFora(String nome){
        System.out.println(nome + " Eca, banheiro está sujo");
        
        try {
            this.wait();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}