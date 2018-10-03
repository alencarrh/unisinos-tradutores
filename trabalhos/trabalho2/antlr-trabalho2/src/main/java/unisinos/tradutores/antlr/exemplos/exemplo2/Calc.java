package unisinos.tradutores.antlr.exemplos.exemplo2;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;

public class Calc {
    public static void main(String[] args) throws Exception {
        String inputFile = "./src/main/java/unisinos/tradutores/antlr/exemplos/exemplo2/input.txt";

        CharStream cs = CharStreams.fromPath(Paths.get(inputFile));
        LabeledExprLexer lexer = new LabeledExprLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LabeledExprParser parser = new LabeledExprParser(tokens);
        ParseTree tree = parser.prog(); // parse

        EvalVisitor eval = new EvalVisitor();
        eval.visit(tree);
    }
}