package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ParDeclaration extends Declaration {
	public ParDeclaration(Declaration dAST1, Declaration dAST2, SourcePosition thePosition) {
		super(thePosition);
		D1 = dAST1;
		D2 = dAST2;
	}

	public Object visit(Visitor v, Object o) {
		return v.visitParDeclaration(this, o);
	}
	public Declaration D1;
	public Declaration D2;
}
