package hudson.plugins.analysis.ast;

import java.util.ArrayList;
import java.util.List;

import com.puppycrawl.tools.checkstyle.api.DetailAST;

/**
 * Displays all information about the package in the abstract syntax tree.
 *
 * @author Christian M�stl
 */
public class NamePackageAst extends Ast {
    /**
     * Creates a new instance of {@link NamePackageAst}.
     *
     * @param fileName   the name of the Java file
     * @param lineNumber the line number that contains the warning
     */
    public NamePackageAst(final String fileName, final int lineNumber) {
        super(fileName, lineNumber);
    }

    @Override
    public List<DetailAST> chooseArea() {
        List<DetailAST> chosen = new ArrayList<DetailAST>();

        chosen.add(getRoot());
        chosen.addAll(calcAllChildren(getRoot().getFirstChild()));

        StringBuilder stringBuilder = new StringBuilder();
        for (DetailAST element : chosen) {
            stringBuilder.append(element.getText());
        }
        setName(stringBuilder.toString());

        return chosen;
    }
}