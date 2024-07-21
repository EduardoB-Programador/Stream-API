package example;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*Representa uma função que aceita como um argumento do tipo T e retorna um valor booleano (true ou false)
*É normalmente utilizado para filtrar os elementos do Stream com base em alguma condição.
*/
public class PredicateExample {
    public static void main(String[] args) {
        //Criando uma lista de palavras
        List<String> palavras = Arrays.asList("Java", "Kotlin", "python", "JavaScript", "C", "go", "ruby");

        //Criando um predicate que retorna a condição de caso a palavra possua mais de 5 caracteres
        Predicate<String> maiorQue5Letras = palavra -> palavra.length() > 5;

        //Usando o predicate como filtro para filtrar e imprimir as palavras com mais de 5 letras
        palavras.stream().filter(maiorQue5Letras).forEach(System.out::println);

        //Criando um Predicate inteiro como parâmetro de filter, para filtrar e exibir apenas as palavras menores que 5 letras
        palavras.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() < 5;
            }
        }).forEach(System.out::println);

        //Criando uma expressão lambda como parâmetro de filter, para filtrar e exibir as palavras que possuem exatamente 4 letras
        palavras.stream().
                filter(p -> p.length() == 4)
                .forEach(System.out::println);

    }
}
