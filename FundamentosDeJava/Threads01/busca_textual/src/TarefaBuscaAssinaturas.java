import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TarefaBuscaAssinaturas implements Runnable{
    String nomeArquivo;
    String nome;
    

    public TarefaBuscaAssinaturas(String nomeArquivo, String nome) {
        this.nomeArquivo = nomeArquivo;
        this.nome = nome;
    }


    @Override
    public void run() {

        int numLinha = 1;

        try {
            Scanner scanner = new Scanner(new File(this.nomeArquivo));
            while(scanner.hasNextLine()){
                String linha = scanner.nextLine();

                if( linha.toLowerCase().contains(this.nome.toLowerCase())){
                    System.out.println(this.nomeArquivo + " - " + numLinha + " - " + linha);
                }
                numLinha++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        } finally{
            
        }
        
    }

}
