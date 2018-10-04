package unisinos.tradutores.antlr.main.listener;


import lombok.Getter;
import unisinos.tradutores.antlr.main.domain.Method;
import unisinos.tradutores.antlr.main.gramatica.Java8BaseListener;
import unisinos.tradutores.antlr.main.gramatica.Java8Parser;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Getter
public class JavaBaseListenerImpl extends Java8BaseListener {

    private final List<Method> methods;
    private Method.MethodBuilder currentMethod;

    public JavaBaseListenerImpl() {
        methods = new ArrayList<>();
    }


    @Override
    public void enterMethodDeclarator(Java8Parser.MethodDeclaratorContext ctx) {
        if(nonNull(currentMethod)){
            methods.add(currentMethod.build());
        }
        System.out.println("ENTER METHOD DECLARATOR: " + ctx.Identifier().getText());
        currentMethod = Method.builder().name(ctx.Identifier().getText());
    }


    @Override
    public void enterMethodInvocation(Java8Parser.MethodInvocationContext ctx) {
        System.out.println("\tENTER METHOD INVOCATOIN: " + ctx.methodName().getText());
        currentMethod.methodsCall(ctx.methodName().getText());
    }

    @Override
    public void enterMethodInvocation_lf_primary(Java8Parser.MethodInvocation_lf_primaryContext ctx) {
        System.out.println("\tENTER_METHOD_INVOCATOIN_lF_PRIMARY: " + ctx.Identifier().getText());
        currentMethod.methodsCall(ctx.Identifier().getText());
    }

    @Override
    public void enterMethodInvocation_lfno_primary(Java8Parser.MethodInvocation_lfno_primaryContext ctx) {
        System.out.println("\tENTER_METHOD_INVOCATOIN_lF_NO_PRIMARY: " + ctx.Identifier().getText());
        currentMethod.methodsCall(ctx.Identifier().getText());
    }

    public List<Method> result() {
        return methods;
    }
}
