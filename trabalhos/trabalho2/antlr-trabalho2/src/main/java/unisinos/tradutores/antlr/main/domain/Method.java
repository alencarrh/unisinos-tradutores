package unisinos.tradutores.antlr.main.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class Method {

    private final String name;
    @Singular
    private final List<String> commands;

    @Singular
    private final Set<String> methodsCalls;

    @Singular
    private final List<String> blockStatements;

}
