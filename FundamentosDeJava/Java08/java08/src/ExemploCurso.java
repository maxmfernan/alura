import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

class Curso{
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos){
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome(){
        return nome;
    }

    public int getAlunos(){
        return alunos;
    }
}

public class ExemploCurso {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        // int sum = cursos.stream()
        //     .filter((c) -> c.getAlunos() > 55)
        //     .mapToInt(Curso::getAlunos)
        //     .sum();
            
        // System.out.println(sum);

        // cursos.stream()
        //     .map(Curso::getNome)
        //     .forEach(System.out::println);

        // cursos.stream()
        //     .filter( (c) -> c.getAlunos() > 100)
        //     .findAny()
        //     .ifPresent((c) -> System.out.println(c.getNome()));

        //     List<Curso> cursosFiltrados = cursos.stream()
        //     .filter( (c) -> c.getAlunos() > 100)
        //     .collect(Collectors.toList());

        // System.out.println(cursosFiltrados);

        cursos.stream()
            .mapToDouble(Curso::getAlunos)
            .average();
            
        
            
    }
    
}
