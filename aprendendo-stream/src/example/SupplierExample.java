package example;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SupplierExample {
    public static void main(String[] args) {
        //Criando um supplier com expressão lambda
        Supplier<String> saudacao = () -> "Seja bem vindo(a)!";

        //Usando o Supplier para obter uma lista, o método .limit() determina o limite da lista
        List<String> listaSaudacoes = Stream.generate(saudacao).limit(5).toList();

        //Isso aqui é uma outra forma de passar um Supplier, aqui se cria um Supplier dentro do generate
        //O generate precisa de um Supplier então aqui estamos passando um objeto Supplier inteiro tendo até que reescrever seu método
        List<String> listaDespedida = Stream.generate(new Supplier<String>() {
            @Override
            public String get() {
                return "Tenha uma ótima viagem!";
            }
        }).limit(5).toList();

        //Uma forma melhor de fazer o que foi mostrado acima é:
        List<String> listaDespedida2 = Stream.generate(() -> "Tenha uma ótima viagem!!!").limit(1).toList();

        //Também da para relizar dessa forma, usando o collect para usar o toList(), mas perceba que resulta em um aviso
        List<String> listaDespedida3 = Stream.generate(() -> "Vai com Deus!").limit(2).collect(Collectors.toList());

        //Imprimindo cada item da lista de saudações
        listaSaudacoes.forEach(s -> System.out.println(s));

        //Resolvendo o aviso
        listaSaudacoes.forEach(System.out::println);
    }
}
