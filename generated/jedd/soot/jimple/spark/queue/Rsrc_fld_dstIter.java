package soot.jimple.spark.queue;

import soot.util.*;
import soot.jimple.spark.bdddomains.*;
import soot.jimple.spark.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Rsrc_fld_dstIter extends Rsrc_fld_dst {
    protected Iterator r;
    
    public Rsrc_fld_dstIter(Iterator r) {
        super();
        this.r = r;
    }
    
    public Iterator iterator() {
        ;
        return new Iterator() {
            public boolean hasNext() { return r.hasNext(); }
            
            public Object next() {
                return Rsrc_fld_dstIter.this.new Tuple((VarNode) r.next(), (SparkField) r.next(), (VarNode) r.next());
            }
            
            public void remove() { throw new UnsupportedOperationException(); }
        };
    }
    
    public jedd.internal.RelationContainer get() {
        final jedd.internal.RelationContainer ret =
          new jedd.internal.RelationContainer(new Attribute[] { src.v(), fld.v(), dst.v() },
                                              new PhysicalDomain[] { V1.v(), FD.v(), V2.v() },
                                              ("<soot.jimple.spark.bdddomains.src:soot.jimple.spark.bdddomai" +
                                               "ns.V1, soot.jimple.spark.bdddomains.fld:soot.jimple.spark.bd" +
                                               "ddomains.FD, soot.jimple.spark.bdddomains.dst:soot.jimple.sp" +
                                               "ark.bdddomains.V2> ret = jedd.internal.Jedd.v().falseBDD(); " +
                                               "at /home/olhotak/soot-2-jedd/src/soot/jimple/spark/queue/Rsr" +
                                               "c_fld_dstIter.jedd:43,8"),
                                              jedd.internal.Jedd.v().falseBDD());
        while (r.hasNext()) {
            ret.eqUnion(jedd.internal.Jedd.v().literal(new Object[] { r.next(), r.next(), r.next() },
                                                       new Attribute[] { src.v(), fld.v(), dst.v() },
                                                       new PhysicalDomain[] { V1.v(), FD.v(), V2.v() }));
        }
        return new jedd.internal.RelationContainer(new Attribute[] { dst.v(), src.v(), fld.v() },
                                                   new PhysicalDomain[] { V2.v(), V1.v(), FD.v() },
                                                   ("return ret; at /home/olhotak/soot-2-jedd/src/soot/jimple/spa" +
                                                    "rk/queue/Rsrc_fld_dstIter.jedd:47,8"),
                                                   ret);
    }
    
    public boolean hasNext() { return r.hasNext(); }
    
    private final class Tuple extends soot.jimple.spark.queue.Rsrc_fld_dst.Tuple {
        private VarNode _src;
        
        public VarNode src() { return _src; }
        
        private SparkField _fld;
        
        public SparkField fld() { return _fld; }
        
        private VarNode _dst;
        
        public VarNode dst() { return _dst; }
        
        public Tuple(VarNode _src, SparkField _fld, VarNode _dst) {
            super();
            this._src = _src;
            this._fld = _fld;
            this._dst = _dst;
        }
    }
    
}