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
        if (nonNull(currentMethod)) {
            methods.add(currentMethod.build());
        }
//        System.out.println("ENTER METHOD DECLARATOR: " + ctx.Identifier().getText());
        currentMethod = Method.builder().name(ctx.Identifier().getText());
    }

    @Override
    public void enterMethodInvocation(Java8Parser.MethodInvocationContext ctx) {
//        System.out.println("\tENTER METHOD INVOCATOIN: " + ctx.methodName().getText());
        if (nonNull(currentMethod)) {
            currentMethod.methodsCall(ctx.methodName().getText());
        }
    }

    @Override
    public void enterMethodInvocation_lf_primary(Java8Parser.MethodInvocation_lf_primaryContext ctx) {
//        System.out.println("\tENTER_METHOD_INVOCATOIN_lF_PRIMARY: " + ctx.Identifier().getText());
        if (nonNull(currentMethod)) {
            currentMethod.methodsCall(ctx.Identifier().getText());
        }
    }

    @Override
    public void enterMethodInvocation_lfno_primary(Java8Parser.MethodInvocation_lfno_primaryContext ctx) {
//        System.out.println("\tENTER_METHOD_INVOCATOIN_lF_NO_PRIMARY: " + ctx.Identifier().getText());
        if (nonNull(currentMethod)) {
            currentMethod.methodsCall(ctx.Identifier().getText());
        }
    }

    @Override
    public void enterBlockStatements(Java8Parser.BlockStatementsContext ctx) {
//        System.out.println("\tENTER BLOCK STATEMENTS: " + ctx.getText());
        if (nonNull(currentMethod)) {
            currentMethod.blockStatement(ctx.getText());
        }
    }

    @Override
    public void enterForStatement(Java8Parser.ForStatementContext ctx) {
        if (ctx.children.size() == 0 || ctx.children.size() == 1) {
            return;
        }
        else if(nonNull(currentMethod)){
            currentMethod.command(ctx.children.get(0).getText());
        }
    }

    @Override
    public void enterForStatementNoShortIf(Java8Parser.ForStatementNoShortIfContext ctx) {
        if (ctx.children.size() == 0 || ctx.children.size() == 1) {
            return;
        }
        else if(nonNull(currentMethod)){
            currentMethod.command(ctx.children.get(0).getText());
        }
    }

    @Override
    public void enterWhileStatement(Java8Parser.WhileStatementContext ctx) {
        if (ctx.children.size() == 0 || ctx.children.size() == 1) {
            return;
        }
        else if(nonNull(currentMethod)){
            currentMethod.command(ctx.children.get(0).getText());
        }
    }

    @Override
    public void enterWhileStatementNoShortIf(Java8Parser.WhileStatementNoShortIfContext ctx) {
        if (ctx.children.size() == 0 || ctx.children.size() == 1) {
            return;
        }
        else if(nonNull(currentMethod)){
            currentMethod.command(ctx.children.get(0).getText());
        }
    }

    @Override
    public void enterDoStatement(Java8Parser.DoStatementContext ctx) {
        if (ctx.children.size() == 0 || ctx.children.size() == 1) {
            return;
        }
        else if(nonNull(currentMethod)){
            currentMethod.command(ctx.children.get(0).getText());
        }
    }

    @Override
    public void enterIfThenStatement(Java8Parser.IfThenStatementContext ctx) {
        if (ctx.children.size() == 0 || ctx.children.size() == 1) {
            return;
        }
        else if(nonNull(currentMethod)){
            currentMethod.command(ctx.children.get(0).getText());
        }
    }

    @Override
    public void enterIfThenElseStatement(Java8Parser.IfThenElseStatementContext ctx) {
        if (ctx.children.size() == 0 || ctx.children.size() == 1) {
            return;
        }
        else if(nonNull(currentMethod)){
            currentMethod.command(ctx.children.get(0).getText());
        }
    }

    @Override
    public void enterIfThenElseStatementNoShortIf(Java8Parser.IfThenElseStatementNoShortIfContext ctx) {
        if (ctx.children.size() == 0 || ctx.children.size() == 1) {
            return;
        }
        else if(nonNull(currentMethod)){
            currentMethod.command(ctx.children.get(0).getText());
        }
    }

    @Override
    public void enterCatches(Java8Parser.CatchesContext ctx) {
        if (ctx.children.size() == 0 || ctx.children.size() == 1) {
            return;
        }
        else if(nonNull(currentMethod)){
            currentMethod.command(ctx.children.get(0).getText());
            System.out.println("catch" + ctx.children.get(0).getText());
        }
    }

    @Override
    public void enterConditionalExpression(Java8Parser.ConditionalExpressionContext ctx) {
        if (ctx.children.size() == 0 || ctx.children.size() == 1) {
            return;
        }
        else if(nonNull(currentMethod)){
            currentMethod.command(ctx.children.get(0).getText());
            System.out.println("catch" + ctx.children.get(0).getText());
        }
    }

    @Override
    public void enterSwitchLabel(Java8Parser.SwitchLabelContext ctx) {
        if (ctx.children.size() == 0 || ctx.children.size() == 1) {
            return;
        }
        else if(nonNull(currentMethod)){
            currentMethod.command(ctx.children.get(0).getText());
            System.out.println("catch" + ctx.children.get(0).getText());
        }
    }

    public List<Method> result() {
        methods.add(currentMethod.build());
        return methods;
    }
}
