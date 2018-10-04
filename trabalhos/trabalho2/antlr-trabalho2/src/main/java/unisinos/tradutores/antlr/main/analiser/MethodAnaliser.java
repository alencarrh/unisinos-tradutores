package unisinos.tradutores.antlr.main.analiser;

import lombok.Builder;
import lombok.Getter;
import unisinos.tradutores.antlr.main.domain.Method;

import java.util.List;

@Getter
@Builder
public class MethodAnaliser {

    private final List<Method> methods;

    public void analise() {
        methods.forEach(m -> System.out.println(m));

        //faz os calculos e printa
    }

    private void complexidadeCiclomatica() {


        //analisa e printa
    }

    private void fanOut() {
        //analisa e printa
    }

    private void nesting() {
        //analisa e printa
    }

}
