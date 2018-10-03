package unisinos.tradutores.antlr.trabalho.ga.listener;

import unisinos.tradutores.antlr.exemplos.exemplo3Java.JavaBaseListener;
import unisinos.tradutores.antlr.exemplos.exemplo3Java.JavaParser;

public class JavaBaseListenerImpl extends JavaBaseListener {


    /*
    Ação de quando entrar em um método
     */
    @Override
    public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
        super.enterMethodDeclaration(ctx);
    }

    /*
    Ação de quando sair de um método
     */
    @Override
    public void exitMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
        super.exitMethodDeclaration(ctx);
    }

    /*
    Verificar os valores dos métodos "statement"
    vamos usar a entrado em um bloco para saber o nivel de aninhamento.
    começa em 1 e é incrementado pelo nivel de blocos um dentro do outro
     */
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
        super.enterStatement(ctx);
    }

    @Override
    public void exitStatement(JavaParser.StatementContext ctx) {
        super.exitStatement(ctx);
    }

    @Override
    public void enterStatementExpression(JavaParser.StatementExpressionContext ctx) {
        super.enterStatementExpression(ctx);
    }

    @Override
    public void exitStatementExpression(JavaParser.StatementExpressionContext ctx) {
        super.exitStatementExpression(ctx);
    }
}
