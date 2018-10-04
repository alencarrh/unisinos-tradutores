package unisinos.tradutores.antlr.main.listener;


import lombok.Getter;
import unisinos.tradutores.antlr.main.domain.Method;
import unisinos.tradutores.antlr.main.gramatica.JavaBaseListener;
import unisinos.tradutores.antlr.main.gramatica.JavaParser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Objects.isNull;

@Getter
public class JavaBaseListenerImpl extends JavaBaseListener {

    private final List<Method> methods;
    private Method.MethodBuilder currentMethod;

    public JavaBaseListenerImpl() {
        methods = new ArrayList<>();
    }

    @Override
    public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
        currentMethod = Method.builder().name(ctx.Identifier().getText());
        System.out.print("METHOD: ");
        System.out.println(ctx.Identifier());
    }

    /*
    Ação de quando sair de um método
     */
    @Override
    public void exitMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
        methods.add(currentMethod.build());
        currentMethod = null;

        System.out.print("################ EXIT METHOD: ");
        System.out.println(ctx.Identifier());
    }

    @Override
    public void enterBlockStatement(JavaParser.BlockStatementContext ctx) {
        super.enterBlockStatement(ctx);
    }

    @Override
    public void exitBlockStatement(JavaParser.BlockStatementContext ctx) {
        super.exitBlockStatement(ctx);
    }

    @Override
    public void enterStatement(JavaParser.StatementContext ctx) {
        if (isNull(currentMethod) || ctx.children.size() == 0 || ctx.children.size() == 1) {
            return;
        }
        currentMethod.command(ctx.children.get(0).getText());
//        System.out.println("\tENTER STATEMENT: " + ctx.children.get(0).getText() + " - " + ctx.children.size());
    }


    @Override
    public void enterStatementExpression(JavaParser.StatementExpressionContext ctx) {

        if (isNull(currentMethod) || ctx.children.size() == 0) {
            return;
        }

        ctx.children.forEach(c -> currentMethod.methodsCall(c.getText()));

//        System.out.println("\tENTER STATEMENT EXPRESSION: ");
//        ctx.children.forEach(c -> System.out.println("\t\t" + c.getText()));

    }

    @Override
    public void enterSwitchLabel(JavaParser.SwitchLabelContext ctx) {
        if (isNull(currentMethod) || ctx.children.size() == 0) {
            return;
        }

//        System.out.println("\tENTER SWITCH LABEL: " + ctx.children.get(0).getText());
//        currentMethod.command(ctx.children.get(0).getText());
    }

    public List<Method> result() {
        return methods;
    }
}
