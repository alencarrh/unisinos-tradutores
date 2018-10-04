//package unisinos.tradutores.antlr.exemplos.exemplo3Java;
//
//import org.antlr.v4.runtime.ANTLRInputStream;
//import org.antlr.v4.runtime.CommonTokenStream;
//import org.antlr.v4.runtime.ParserRuleContext;
//import org.antlr.v4.runtime.Token;
//import org.antlr.v4.runtime.tree.*;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStream;
//
//public class ExtractInterfaceTool {
//    public static void main(String[] args) throws Exception {
//        String inputFile = "./src/main/java/unisinos/tradutores/antlr/exemplos/exemplo3Java/Demo.java";
//
//        InputStream is;
//        is = new FileInputStream(inputFile);
//        ANTLRInputStream input = new ANTLRInputStream(is);
//
//        JavaLexer lexer = new JavaLexer(input);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        JavaParser parser = new JavaParser(tokens);
//        ParseTree tree = parser.compilationUnit(); // parse
//
//        ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
//        ExtractInterfaceListener extractor = new ExtractInterfaceListener(parser);
//        walker.walk(extractor, tree); // initiate walk of tree with listener
//    }
//}