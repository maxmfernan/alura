import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BanheiroReentrantLock{
    Lock lock = new ReentrantLock();
    
    public void fazNumero1(){

        String nome = Thread.currentThread().getName();

        System.out.println(nome + " Bantendo na porta");
        

        lock.lock();
        System.out.println(nome + " Entrando no banheiro.");
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
        lock.unlock();
        

    }

    public void fazNumero2(){
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " Bantendo na porta");


        lock.lock();
        System.out.println(nome +" Entrando no banheiro.");
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
        
        lock.unlock();
        
    }
}