package interpreter.parser.ast;

import interpreter.visitors.Visitor;

public class NotEq extends BinaryOp{
	
    public NotEq(Exp left, Exp right) {
		super(left, right);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visitNotEq(left, right);
	}
}
