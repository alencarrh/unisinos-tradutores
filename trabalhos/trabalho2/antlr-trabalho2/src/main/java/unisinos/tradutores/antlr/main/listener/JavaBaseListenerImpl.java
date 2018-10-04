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

        if (nonNull(ctx.Identifier())) {
            currentMethod = Method.builder().name(ctx.Identifier().getText());
        }
    }

    @Override
    public void enterMethodInvocation(Java8Parser.MethodInvocationContext ctx) {
        if (nonNull(currentMethod) && nonNull(ctx.methodName())) {
            currentMethod.methodsCall(ctx.methodName().getText());
        }
    }

    @Override
    public void enterMethodInvocation_lf_primary(Java8Parser.MethodInvocation_lf_primaryContext ctx) {
        if (nonNull(currentMethod) && nonNull(ctx.Identifier())) {
            currentMethod.methodsCall(ctx.Identifier().getText());
        }
    }

    @Override
    public void enterMethodInvocation_lfno_primary(Java8Parser.MethodInvocation_lfno_primaryContext ctx) {
        if (nonNull(currentMethod) && nonNull(ctx.Identifier())) {
            currentMethod.methodsCall(ctx.Identifier().getText());
        }
    }

    @Override
    public void enterBlockStatements(Java8Parser.BlockStatementsContext ctx) {
        if (nonNull(currentMethod)) {
            currentMethod.blockStatement(ctx.getText());
        }
    }

    @Override
    public void enterForStatement(Java8Parser.ForStatementContext ctx) {
        if (ctx.children.size() < 2) {
            return;
        }

        if (nonNull(currentMethod)) {
            currentMethod.command(ctx.children.get(0).getText());
        }
    }

    @Override
    public void enterForStatementNoShortIf(Java8Parser.ForStatementNoShortIfContext ctx) {
        if (ctx.children.size() < 2) {
            return;
        }
        if (nonNull(currentMethod)) {
            currentMethod.command(ctx.children.get(0).getText());
        }
    }

    @Override
    public void enterWhileStatement(Java8Parser.WhileStatementContext ctx) {
        if (ctx.children.size() < 2) {
            return;
        }

        if (nonNull(currentMethod)) {
            currentMethod.command(ctx.children.get(0).getText());
        }
    }

    @Override
    public void enterWhileStatementNoShortIf(Java8Parser.WhileStatementNoShortIfContext ctx) {
        if (ctx.children.size() < 2) {
            return;
        }

        if (nonNull(currentMethod)) {
            currentMethod.command(ctx.children.get(0).getText());
        }
    }

    @Override
    public void enterDoStatement(Java8Parser.DoStatementContext ctx) {
        if (ctx.children.size() < 2) {
            return;
        }

        if (nonNull(currentMethod)) {
            currentMethod.command(ctx.children.get(0).getText());
        }
    }

    @Override
    public void enterIfThenStatement(Java8Parser.IfThenStatementContext ctx) {
        if (ctx.children.size() < 2) {
            return;
        }

        if (nonNull(currentMethod)) {
            currentMethod.command(ctx.children.get(0).getText());
        }
    }

    @Override
    public void enterIfThenElseStatement(Java8Parser.IfThenElseStatementContext ctx) {
        if (ctx.children.size() < 2) {
            return;
        }

        if (nonNull(currentMethod)) {
            currentMethod.command(ctx.children.get(0).getText());
        }
    }

    @Override
    public void enterIfThenElseStatementNoShortIf(Java8Parser.IfThenElseStatementNoShortIfContext ctx) {
        if (ctx.children.size() < 2) {
            return;
        }

        if (nonNull(currentMethod)) {
            currentMethod.command(ctx.children.get(0).getText());
        }
    }

    @Override
    public void enterCatches(Java8Parser.CatchesContext ctx) {
        if (ctx.children.size() < 2) {
            return;
        }

        if (nonNull(currentMethod)) {
            currentMethod.command(ctx.children.get(0).getText());
        }
    }

    @Override
    public void enterConditionalExpression(Java8Parser.ConditionalExpressionContext ctx) {
        if (ctx.children.size() < 2) {
            return;
        }

        if (nonNull(currentMethod)) {
            currentMethod.command(ctx.children.get(0).getText());
        }
    }

    @Override
    public void enterSwitchLabel(Java8Parser.SwitchLabelContext ctx) {
        if (ctx.children.size() < 2) {
            return;
        }

        if (nonNull(currentMethod)) {
            currentMethod.command(ctx.children.get(0).getText());
        }
    }

    public List<Method> result() {
        methods.add(currentMethod.build());
        return methods;
    }
}
