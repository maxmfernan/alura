public class Principal{
    public static void main(String[] args) {
        String name = "John";
        Thread threadAssinaturas01 = new Thread(new TarefaBuscaAssinaturas("assinaturas1.txt", name));
        Thread threadAssinaturas02 = new Thread(new TarefaBuscaAssinaturas("assinaturas2.txt", name));
        Thread threadAutores = new Thread(new TarefaBuscaAssinaturas("autores.txt", name));

        threadAssinaturas01.start();
        threadAssinaturas02.start();
        threadAutores.start();
    }
}