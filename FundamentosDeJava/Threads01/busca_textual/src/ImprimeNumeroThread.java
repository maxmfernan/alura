public class ImprimeNumeroThread {
    public static void main(String[] args) {
        Thread printNumberThread01 = new Thread(new PrintNumber());
        Thread printNumberThread02 = new Thread(new PrintNumber());

        printNumberThread01.start();
        printNumberThread02.start();
    }

    public static class PrintNumber implements Runnable{

        @Override
        public void run() {
            for(int i = 1; i <= 1000; i ++){
                System.out.println("Thread: " + Thread.currentThread().getId() + ", número: " + i );
            }

            
        }
        
    }
}
