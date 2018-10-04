package unisinos.tradutores.antlr.main.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class Method {

    private final String name;
    @Singular
    private final List<String> commands;
    @Singular
    private final List<String> methodsCalls;
    private final Integer nesting;

}
