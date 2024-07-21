package controller;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Desafio {
    public static void main(String[] args) {
        //Lista que será utilizada para fazer os desafios
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        int numeracao = 0;

        //Desafio 1: Mostre a lista na ordem numérica
        System.out.println("Desafio " + ++numeracao + ":");
        numeros.stream()
                .sorted()
                .forEach(n -> System.out.print(n + " "));

        System.out.println("\n\n\n");

        //
        //
        //

        //Desafio 2: Imprima a soma dos números pares da lista
        System.out.println("Desafio " + ++numeracao + ":");

        int somaNumerosPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);

        System.out.println("A soma de todos os números pares é: " + somaNumerosPares + "\n");

        System.out.println("\n\n\n");
        //
        //
        //

        //Desafio 3: Verifique se todos os números da lista são positivos
        System.out.println("Desafio " + ++numeracao + ":");

        numeros.forEach(
                n -> System.out.println(n > 0 ? "O número " + n + " é positivo" : "O número " + n + " não é positivo")
        );

        System.out.println(numeros.stream().allMatch(n -> n>0) ? "Todos são positivos" : "Há pelo menos 1 número negativo");

        System.out.println("\n\n\n");
        //
        //
        //

        //Desafio 4: Remova todos os valores ímpares
        System.out.println("Desafio " + ++numeracao + ":");

        List<Integer> numerosSemImpares = new ArrayList<>(numeros);
        numerosSemImpares.removeAll(
                numeros.stream().filter(n -> n % 2 != 0).toList()
        );

        numerosSemImpares.forEach(n -> System.out.print(n + " "));

        System.out.println("\n\n\n");
        //
        //
        //

        //Desafio 5: Calcule a média dos números maiores que 5
        System.out.println("Desafio " + ++numeracao + ":");

        int media = numeros.stream()
                .filter(n -> n > 5)
                .reduce(0, Integer::sum);

        media = media / numeros.stream()
                .filter(n -> n > 5)
                .toList()
                .size();

        System.out.println("A média dos números maiores que 5 da lista é: " + media);

        System.out.println("\n\n\n");
        //
        //
        //

        //Desafio 6: Verificar se a lista contém algum número maior que 10
        System.out.println("Desafio " + ++numeracao + ":");

        numeros.stream()
                .filter(n -> n > 10)
                .toList()
                .forEach(n -> System.out.println("O número " + n + " é maior que 10"));

        System.out.println("\n\n\n");
        //
        //
        //

        //Desafio 7: Encontrar o segundo número maior da lista
        System.out.println("Desafio " + ++numeracao + ":");

        Integer maior = numeros.stream().max(Integer::compare).get();

        List<Integer> numeros2 = new ArrayList<>(numeros);
        numeros2.remove(maior);

        int segundoMaior = numeros2.stream().max(Integer::compare).get();

        System.out.println("O segundo maior número da lista é: " + segundoMaior);

        System.out.println("\n\n\n");
        //
        //
        //

        //Desafio 8: Somar os dígitos de todos os números da lista
        System.out.println("Desafio " + ++numeracao + ":");

        int somaTotal = numeros.stream()
                .map(String::valueOf)
                .map(n -> {
                    if (n.length() == 1) {
                        return n;
                    } else {
                        int acum = 0;

                        for (int digito = 0; digito < n.length(); digito++) {

                            acum += Integer.parseInt(
                                    String.valueOf( n.charAt(digito) )
                            );

                        }

                        return Integer.toString(acum);
                    }
                })
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);

        System.out.println("A soma de todos os dígitos da lista é: " + somaTotal);

        System.out.println("\n\n\n");
        //
        //
        //

        //Desafio 9: Verificar se todos os números da lista são distintos (não se repetem)
        System.out.println("Desafio " + ++numeracao + ":");

        /*List<Integer> listaDeDistintos = numeros.stream()
                .distinct()
                .toList();

        if (listaDeDistintos.size() != numeros.size()) {
            System.out.println("A lista possui pelo menos 1 número que se repete");
        } else {
            System.out.println("A lista não possui nenhum número que se repete");
        }*/

        List<Integer> listaCopia1 = new ArrayList<>(numeros);

        numeros.stream()
                .distinct()
                .forEach(n -> {
                int aparicoes = 0;

                    for (int i : listaCopia1) {

                        if (n == i && aparicoes == 0) {
                            aparicoes++;

                        } else if (n == i && aparicoes >= 1) {

                            System.out.println("O número " + n + " aparece pelo menos mais de 1 vez na lista");
                            break;

                        }
                    }
                });

        System.out.println("\n\n\n");
        //
        //
        //

        //Desafio 10: Agrupe os valores ímpares múltiplos de 3 ou de 5
        System.out.println("Desafio " + ++numeracao + ":");

        List<Integer> multiplosDe3 = new ArrayList<>(numeros.stream()
                .filter(n -> n % 2 != 0 && n % 3 == 0).toList()
        );

        List<Integer> multiplosDe5 = new ArrayList<>(numeros.stream()
                .filter(n -> n % 2 != 0 && n % 5 == 0).toList()
        );

        List<Integer> multiplosDe3E5 = new ArrayList<>(multiplosDe3);
        multiplosDe3E5.addAll(multiplosDe5);

        multiplosDe3E5.stream().forEach(n -> System.out.print(n + " "));

        System.out.println("\n\n\n");
        //
        //
        //

        //Desafio 11: Encontre a soma dos quadrados de todos os números da lista
        System.out.println("Desafio " + ++numeracao + ":");

        double somaDosQuadrados = numeros.stream()
                .map(n -> Math.pow(n, 2))
                .reduce(Double::sum).get();

        System.out.println("A soma dos quadrados de cada número da lista é: " + somaDosQuadrados);

        System.out.println("\n\n\n");
        //
        //
        //

        //Desafio 12: Encontre o produto de todos os números da lista
        System.out.println("Desafio " + ++numeracao + ":");

        int produtoTodosOsNumeros = numeros.stream().reduce(1, (n1, n2) -> n1 * n2);

        System.out.println("O produto de todos os números da lista é: " + produtoTodosOsNumeros);

        System.out.println("\n\n\n");
        //
        //
        //

        //Desafio 13: Filtrar os números que estão dentro de um intervalo
        System.out.println("Desafio " + ++numeracao + ":");

        numeros.stream().filter(n -> n > 5 && n < 10).forEach(n -> System.out.print(n + " "));

        System.out.println("\n\n\n");
        //
        //
        //

        //Desafio 14: Encontre o maior número primo da lista
        System.out.println("Desafio " + ++numeracao + ":");

        int maiorNumeroPrimo = numeros.stream()
                .sorted()
                .filter(n -> {

                    for (int i = 2; i < n; i++) {
                        if (n % i == 0) return false;
                    }

                    return true;
                })
                .max(Integer::compare)
                .get();

        System.out.println("O maior número primo da lista é: " + maiorNumeroPrimo);

        System.out.println("\n\n\n");
        //
        //
        //

        //Desafio 15: Verifique se a lista contém pelo menos um número negativo
        System.out.println("Desafio " + ++numeracao + ":");

        System.out.println(numeros.stream().anyMatch(n -> n<0) ? "Existe pelo menos 1 número negativo" : "Não existe nenhum número negativo");

        System.out.println("\n\n\n");
        //
        //
        //

        //Desafio 16: Agrupe os números em pares e ímpares
        System.out.println("Desafio " + ++numeracao + ":");

        List<Integer> numerosPares = numeros.stream().filter(n -> n % 2 == 0).toList();
        List<Integer> numerosImpares = numeros.stream().filter(n -> n % 2 != 0).toList();

        System.out.print("Números pares: ");
        numerosPares.forEach(n -> System.out.print(n + " "));

        System.out.print("\nNúmeros ímpares: ");
        numerosImpares.forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("\n\n\n");
        //
        //
        //

        //Desafio 17: Filtrar os números primos da lista
        System.out.println("Desafio " + ++numeracao + ":");

        List<Integer> numerosPrimos = numeros.stream()
                .filter(n -> {

                    if (n == 1) return false;

                    for (int i = 2; i < n; i++) {
                        if (n % i == 0) return false;
                    }

                    return true;
                }).toList();

        System.out.print("Números primos da lista: ");
        numerosPrimos.forEach(n -> System.out.print(n + " "));

        System.out.println("\n\n\n");
        //
        //
        //

        //Desafio 18: Verifique se todos os números da lista são iguais
        System.out.println("Desafio " + ++numeracao + ":");

        List<Integer> listaDeIguais = numeros.stream().distinct().toList();

        System.out.println(listaDeIguais.size() != 1 ? "Há pelo menos 1 número diferente" : "Todos os números são iguais");

        System.out.println("\n\n\n");
        //
        //
        //

        //Desafio 19: Encontre a soma dos números divisíveis por 3 e 5
        System.out.println("Desafio " + ++numeracao + ":");

        Predicate<Integer> divisivelPor3E5 = n -> {
            return n % 3 == 0 && n % 5 == 0;
        };

        /*List<Integer> listaTeste = Arrays.asList(5, 10, 15, 21, 35, 30, 18, 42, 45, 55, 63, 60);
        int somaDosDivisiveisPor3E5Teste = listaTeste.stream().filter(divisivelPor3E5).reduce(0, (n1, n2) -> n1+n2);

        System.out.println(somaDosDivisiveisPor3E5Teste);*/

        int somaDosDivisiveisPor3E5 = numeros.stream().filter(divisivelPor3E5).reduce(0, Integer::sum);

        System.out.println("A soma de todos os números que são divisíveis por 3 e 5 simultaneamente é: " + somaDosDivisiveisPor3E5);
    }
}
