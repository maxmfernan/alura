import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Data {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);

        int anos = olimpiadasRio.getYear() - hoje.getYear();

        System.out.println("Quantos anos: " + anos);

        Period periodo = Period.between(olimpiadasRio, hoje);
        System.out.println(periodo);

        LocalDate proximasOlimpiadas = olimpiadasRio.plusYears(4);
        System.out.println(proximasOlimpiadas);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String proxOlimpFormatada = proximasOlimpiadas.format(formatador);
        System.out.println(proxOlimpFormatada);

        DateTimeFormatter formatadorCHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora.format(formatadorCHoras));


    }
}
