package environment;
import environment.TypeCaseSpeciale;
import util.Case;

class CaseSpeciale extends Case {
    public TypeCaseSpeciale tcs;

    public CaseSpeciale(int absc, int ord, TypeCaseSpeciale tcs) {
        super(absc, ord);
        this.tcs = tcs;
    }
}

