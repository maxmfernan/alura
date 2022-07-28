import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStrings {
    
    public static void main(String[] args) {
        
        List<String> palavras = new ArrayList<String>();

        palavras.add("alura online");
        palavras.add("editora casa do código");
        palavras.add("caelum");

        // Comparator<String> comparador = new ComparadorPorTamanho();
        // //Collections.sort(palavras, comparador);
        // palavras.sort(comparador);
        // System.out.println(palavras);

        // palavras.forEach(
        //     (palavra) -> System.out.println(palavra)
        // );


        //Instância de uma classe anônima atribuída a uma variável
        // Consumer<String> consumidor = new Consumer<String>() {

        //     @Override
        //     public void accept(String t) {
        //         System.out.println(t);
                
        //     }
            
        // };
        // palavras.forEach(consumidor);

        //Instância de uma classe anônima passada direito como argumento
        // palavras.forEach(
        //     new Consumer<String>() {

        //         @Override
        //         public void accept(String t) {
        //             System.out.println(t);
                    
        //         }
                
        //     }
        // );

        //Atribuindo a uma variável de um tipo "interface funcional" uma expressão lambda apropriada
        // Consumer<String> consumidor = (s) -> System.out.println(s);
        // palavras.forEach(consumidor);

        //Passando a expressão lambda diretamente como argumento
        // palavras.forEach((s) -> System.out.println(s));

        //Método sort com lambda
        // palavras.sort((s1,s2) -> Integer.compare(s1.length(), s2.length()));
        // palavras.forEach((s) -> System.out.println(s));

        //Escrevendo o código abaixo usando uma expressão lambda
        // new Thread(
        //     new Runnable(){

        //         @Override
        //         public void run() {
        //             System.out.println("Executando um Runnable.");
                    
        //         }

        //     }
        // ).start();

        // new Thread(() -> System.out.println("Executando um Runnable.")).start();


        //Ordene uma lista usando o método estático default comparing da classe Compare
            //Use classe anônima
            // Function<String, Integer> funcao = new Function<String,Integer>() {

            //     @Override
            //     public Integer apply(String t) {
            //         // TODO Auto-generated method stub
            //         return t.length();
            //     }
                
            // };
            // palavras.sort(
            //     Comparator.comparing(funcao)
            // );
            
            
            //Use lambda
            palavras.sort(
                Comparator.comparing( (s)-> s.length() )
            );

            //Use method reference
            palavras.sort(
                Comparator.comparing(String::length)
            );

        //Use method reference no foreach
        palavras.forEach(System.out::println);

        //Use method reference em algum outro caso
        palavras.sort(
            String.CASE_INSENSITIVE_ORDER
        );
        palavras.forEach(System.out::println);
        //palavras.removeIf(String::equals("caelum"));
        


    }
}

class ComparadorPorTamanho implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        
        return (o1.length() < o2.length()) ? -1: (o1.length() > o2.length()? 1: 0);

    }
    
}
