package soot.jimple.spark.queue;

import soot.util.*;
import soot.jimple.spark.bdddomains.*;
import soot.jimple.spark.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qsrcc_srcm_stmt_kind_tgtc_tgtmTrad extends Qsrcc_srcm_stmt_kind_tgtc_tgtm {
    private ChunkedQueue q = new ChunkedQueue();
    
    public void add(Context _srcc, SootMethod _srcm, Unit _stmt, Kind _kind, Context _tgtc, SootMethod _tgtm) {
        q.add(_srcc);
        q.add(_srcm);
        q.add(_stmt);
        q.add(_kind);
        q.add(_tgtc);
        q.add(_tgtm);
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { srcc.v(), tgtc.v(), tgtm.v(), kind.v(), stmt.v(), srcm.v() },
                                              new PhysicalDomain[] { V1.v(), V2.v(), T2.v(), FD.v(), ST.v(), T1.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at /home/olhotak/soot-2" +
                                               "-jedd/src/soot/jimple/spark/queue/Qsrcc_srcm_stmt_kind_tgtc_" +
                                               "tgtmTrad.jedd:41,22"),
                                              in).iterator(new Attribute[] { srcc.v(), srcm.v(), stmt.v(), kind.v(), tgtc.v(), tgtm.v() });
        while (it.hasNext()) {
            Object[] tuple = (Object[]) it.next();
            for (int i = 0; i < 6; i++) { q.add(tuple[i]); }
        }
    }
    
    public Rsrcc_srcm_stmt_kind_tgtc_tgtm reader() { return new Rsrcc_srcm_stmt_kind_tgtc_tgtmTrad(q.reader()); }
    
    public Qsrcc_srcm_stmt_kind_tgtc_tgtmTrad() { super(); }
}