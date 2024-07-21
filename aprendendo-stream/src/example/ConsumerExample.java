package example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*O Consumer representa uma operação que recebe uma única entrada e não retorna nada
* Impressão (System.out.println()) não é retornar!!!
* */

public class ConsumerExample {
    public static void main(String[] args) {
        //Lista de números inteiros
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        //Usando o Consumer com expressão lambda pra imprimir números pares
        Consumer<Integer> imprimirNumeroPar = numero -> {
            if (numero % 2 == 0) {
                System.out.println(numero);
            }
        };

        //Da pra fazer assim
        numeros.forEach(imprimirNumeroPar);

        //Ou assim
        numeros.forEach(n -> {
            if (n % 2 == 0) {
                System.out.println(n);
            }
        });

        //Ou assim
        numeros.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer n) {
                if (n % 2 == 0) {
                    System.out.println(n);
                }
            }
        });

    }

}
