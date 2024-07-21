package example;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/*Representa uma operação que combina dois argumentos do tipo T e retorna um resultado do mesmo tipo T.
*É utilizado para realizar operações de redução em pares de elementos, como somar números ou combinar objetos.
* */

public class BinaryOperatorExample {
    public static void main(String[] args) {
        //Criando uma lista de números
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        //Gerando um BinaryOperator para somar todos os elementos de uma lista
        //BinaryOperator<Integer> somar = Integer::sum;
        BinaryOperator<Integer> somar = (n1, n2) -> n1 + n2;

        //Criando a variável resultado que representa a soma de todos os números da lista criada
        int resultado = numeros.stream().reduce(0, somar);

        /*int resultado = numeros.stream()
                .reduce(0, new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer n1, Integer n2) {
                        return n1 + n2;
                    }
                });*/

        /*int resultado = numeros.stream().reduce(0, (n1, n2) -> n1 + n2);*/

        //Exibindo o valor final
        System.out.println("O resultado da soma de todos os valores da lista é: " + resultado);
    }
}
