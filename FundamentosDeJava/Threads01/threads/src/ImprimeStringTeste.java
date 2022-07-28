public class ImprimeStringTeste {
    public static void main(String[] args) throws InterruptedException {
        Runnable printRunnable = () -> System.out.println("Hello world");
        Thread threadPrintStr = new Thread(printRunnable, "PrintString");
        threadPrintStr.sleep(5000);
        threadPrintStr.start();

    }
}
