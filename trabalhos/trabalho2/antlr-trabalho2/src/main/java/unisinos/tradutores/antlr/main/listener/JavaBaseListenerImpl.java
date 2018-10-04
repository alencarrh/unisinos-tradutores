package unisinos.tradutores.antlr.main.listener;


import lombok.Getter;
import unisinos.tradutores.antlr.main.domain.Method;
import unisinos.tradutores.antlr.main.gramatica.Java8BaseListener;
import unisinos.tradutores.antlr.main.gramatica.Java8Parser;

import java.util.ArrayList;
import java.util.List;

@Getter
public class JavaBaseListenerImpl extends Java8BaseListener {

    private final List<Method> methods;
    private Method.MethodBuilder currentMethod;

    public JavaBaseListenerImpl() {
        methods = new ArrayList<>();
    }

    /*
    Aqui deve ter o nome do método, verificar
     */
    @Override
    public void enterMethodBody(Java8Parser.MethodBodyContext ctx) {
        super.enterMethodBody(ctx);
    }

    @Override
    public void exitMethodBody(Java8Parser.MethodBodyContext ctx) {
        super.exitMethodBody(ctx);
    }

    public List<Method> result() {
        return methods;
    }
}
