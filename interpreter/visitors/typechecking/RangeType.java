package interpreter.visitors.typechecking;

import static java.util.Objects.requireNonNull;

public class RangeType implements Type{
    
    private final Type fstType;
    private final Type sndType;

    public static final String TYPE_NAME = "RANGE";

    public RangeType(Type fstType, Type sndType){
        this.fstType = requireNonNull(fstType);
        this.sndType = requireNonNull(sndType);
    }

    public ProdType getBounds(){
        return new ProdType(fstType, sndType);
    }

    @Override
    public final boolean equals(Object Obj){
        if (this == Obj)
            return true;
        if (! (Obj instanceof RangeType))
            return false;
        return true;
    }
}
