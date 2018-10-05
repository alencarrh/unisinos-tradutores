package unisinos.tradutores.antlr.main.analiser;

import lombok.Builder;
import lombok.Getter;
import unisinos.tradutores.antlr.main.domain.Method;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

@Getter
@Builder
public class MethodAnaliser {

    private Map<String, Integer> commands;
    private final List<Method> methods;
    private static final String PREFIX = "\t-> ";

    private Integer getWeight(String command) {
        if (isNull(commands)) {
            initCommandWeight();
        }
        return commands.getOrDefault(command, 0);
    }

    private void initCommandWeight() {
        commands = new HashMap<>();
        commands.put("if", 1);
        commands.put("else ifif", 1);
        commands.put("case", 1);
        commands.put("for", 1);
        commands.put("do", 1);
        commands.put("while", 1);
        commands.put("?", 1);
        commands.put("catch", 1);
    }


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
        int complexidadeCiclomatica = method.getCommands().stream().mapToInt(this::getWeight).sum();
        complexidadeCiclomatica++;
        System.out.println(PREFIX + "Complexidade Ciclomática: " + complexidadeCiclomatica);
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
