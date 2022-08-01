package servidor;

import java.util.concurrent.ThreadFactory;

public class FabricaDeThreads implements ThreadFactory {
    private static long numero;

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r,"Thread Servidor Tarefas "+ numero );
        numero++;
        thread.setUncaughtExceptionHandler(new TratadorDeExcecao());
        return thread;
    }

}
