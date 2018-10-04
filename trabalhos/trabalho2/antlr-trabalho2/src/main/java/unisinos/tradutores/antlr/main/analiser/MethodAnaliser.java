package unisinos.tradutores.antlr.main.analiser;

import lombok.Builder;
import lombok.Getter;
import unisinos.tradutores.antlr.main.domain.Method;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Builder
public class MethodAnaliser {

    private final List<Method> methods;

    private static final String PREFIX = "\t-> ";

    public void analise() {

        System.out.println("Resultados:");

        methods.forEach(method -> {
            System.out.println("-> Método: " + method.getName());
            complexidadeCiclomatica(method);
            fanOut(method);
            nesting(method);
        });
    }

    private void complexidadeCiclomatica(final Method method) {

        //analisa e printa
    }

    private void fanOut(final Method method) {
        System.out.println(PREFIX + "Fanout: " + method.getMethodsCalls().size());
    }

    private void nesting(final Method method) {
        int nesting = 1;
        int currentNesting = 1;

        final List<String> blockStatements = new ArrayList<>(method.getBlockStatements());
        Collections.reverse(blockStatements);

        for (int i = 0; i < blockStatements.size() - 1; i++) {
            String current = blockStatements.get(i);
            String next = blockStatements.get(i + 1);
            if (current.length() == next.length()) {
                continue;
            }
            if (next.contains(current)) {
                currentNesting++;
            }
            if (currentNesting > nesting) {
                nesting = currentNesting;
            }
        }

        System.out.println(PREFIX + "Aninhamento: " + nesting);


    }

}
