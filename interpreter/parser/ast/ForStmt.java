package interpreter.parser.ast;

import static java.util.Objects.requireNonNull;

import interpreter.visitors.Visitor;

public class ForStmt implements Stmt {
	private final VarIdent ident;
    private final Exp exp;
	private final Block block;

	public ForStmt(VarIdent ident, Exp exp, Block block) {
		this.ident = requireNonNull(ident);
        this.exp = requireNonNull(exp);
		this.block = requireNonNull(block);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + ident + "," + exp + "," + block + ")";
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visitForStmt(ident, exp, block);
	}

}