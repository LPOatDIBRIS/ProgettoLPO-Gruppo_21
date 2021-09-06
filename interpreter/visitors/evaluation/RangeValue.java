package interpreter.visitors.evaluation;

import java.util.Iterator;


public class RangeValue implements Value, Iterable<Integer>{
    private final Integer fstVal;
    private final Integer sndVal;

    public RangeValue(Integer fstVal, Integer sndVal){
        this.fstVal = fstVal;
        this.sndVal = sndVal;
    }

    public PairValue getBounds(){
        return new PairValue(new IntValue(fstVal), new IntValue(sndVal));
    }

    @Override
    public RangeValue toRange() { return this; }

    @Override
    public String toString() { return "[ " + this.fstVal + " : " + this.sndVal + " ]"; }

    @Override
    public final boolean equals(Object Obj){
        if (this == Obj)
            return true;
        if (! (Obj instanceof RangeValue))
            return false;
        
        var R = (RangeValue) Obj;
        if ((fstVal - sndVal == 0)  && (R.fstVal - R.sndVal == 0))
            return true;
        if (fstVal.equals(R.fstVal) && sndVal.equals(R.sndVal))
            return true;
        return false;
    } 

    @Override
    public Iterator<Integer> iterator(){
        return new Iterator<Integer>(){
            
            private Integer current = fstVal;
            
            public boolean hasNext(){
                return (current == sndVal) ? false : true;
            }

            public Integer next(){
                if (!hasNext())
                    throw new IndexOutOfBoundsException();

                var return_aux = current;
                current += (fstVal < sndVal) ? 1 : -1;
                
                return return_aux;
            }

            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
}
