package example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/*Represena uma função que aceita um argumento do tipo T e retorna um valor do tipo R
* É utilizado para transformar ou mapear os elementos de uma stream em outros valores, ou tipos
*/
public class FunctionExample {
    public static void main(String[] args) {
        //Criando uma lista
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        //Usando Function com expressão lambda para dobrar os números
        Function<Integer, Integer> dobrar = n -> n * 2;

        //Usando a Function criada para dobrar os números da primeira lista e inserir numa segunda lista
        List<Integer> numerosDobrados = numeros.stream().map(dobrar).toList();

        //Criando uma lista com os números da primeira lista triplicados, criando uma Function inteira
        List<Integer> numerosTriplicados = numeros.stream().map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer n) {
                return n * 3;
            }
        }).toList();

        //Criando uma lista com os números da primeira lista quintuplicados, passando como Function uma expressão lambda
        List<Integer> numerosQuintuplicados = numeros.stream()
                .map(e -> e * 5)
                .toList();

        //Exibindo os valores dobrados
        numerosDobrados.forEach(System.out::println);

        //Exibindo os valores triplicados
        numerosTriplicados.forEach(System.out::println);

        //Exibindo os valores quintuplicados
        numerosQuintuplicados.forEach(System.out::println);

        /*
         * Várias das coisas que foram feitas nas outras classes podem ser feitas nesse da mesma forma mas com o intuito
         * de não ficar repetindo várias linhas de código à-toa.
         *
         * Concluindo, as únicas coisas que serão repetidas que são consideradas redundates vão ser coisas novas que não
         * foram em nenhuma outra classe mostradas antes.
         */
    }
}
