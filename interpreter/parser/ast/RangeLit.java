package interpreter.parser.ast;

import interpreter.visitors.Visitor;

public class RangeLit extends BinaryOp {
    
    public RangeLit(Exp left, Exp right){
        super(left, right);
    }

    @Override
    public <T> T accept(Visitor<T> visitor){
        return visitor.visitRangeLit(left, right);
    }
} 
