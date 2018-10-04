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

    public enum Commands {
        IF {
            public String toString() {
                return "if";
            }
        },

        ELSE_IF {
            public String toString() {
                return "else ifif";
            }
        },

        CASE {
            public String toString() {
                return "case";
            }
        },

        FOR {
            public String toString() {
                return "for";
            }
        },

        DO {
            public String toString() {
                return "do";
            }
        },

        WHILE {
            public String toString() {
                return "while";
            }
        },

        QUESTION {
            public String toString() {
                return "?";
            }
        },

        CATCH {
            public String toString() {
                return "catch";
            }
        }
    }

    private final List<Method> methods;

    private static final String PREFIX = "\t-> ";

    public int complexidadeCiclomatica;

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
        complexidadeCiclomatica = 1;
        method.getCommands().forEach(c -> {
            for (Commands co : Commands.values()){
                if (co.toString().equals(c.toString())){
                    complexidadeCiclomatica++;
                }
            }
        });

        System.out.println(PREFIX + "Complexidade Ciclomática: " + complexidadeCiclomatica);
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
