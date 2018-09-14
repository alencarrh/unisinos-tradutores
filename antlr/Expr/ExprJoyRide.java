import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;

public class ExprJoyRide {

    public static void main(String[] args) throws Exception {

        String inputFile = null; 

        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
 
       if ( inputFile!=null ) is = new FileInputStream(inputFile);

        ANTLRInputStream input = new ANTLRInputStream(is); 

        ExprLexer lexer = new ExprLexer(input);
 
        CommonTokenStream tokens = new CommonTokenStream(lexer); 

        ExprParser parser = new ExprParser(tokens); 

        ParseTree tree = parser.prog(); // parse; start at prog <label id="code.tour.main.6"/>
        
        ParseTreeWalker pw = new ParseTreeWalker();
        ExprBaseListener listener = new ExprBaseListener();
        
        pw.walk(listener,tree);
        
        System.out.println(tree.toStringTree(parser)); // print tree as text <label id="code.tour.main.7"/>
        
        
        
    }
}
