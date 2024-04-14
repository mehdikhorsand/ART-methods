package methods.ART_AutoISP;

import main.SelectionMethod;
import randomTestcase.TestCase;
import tools.AutoISP.*;
import java.util.ArrayList;

public class ART_AutoISP extends SelectionMethod {
    static ArrayList<AutoCharacteristic> isp_coverage_situation = new ArrayList<>();
    @Override
    public TestCase best_candidate(TestCase[] candidate_set) {
        ArrayList<TestCaseRepresentation> testcases_rep = new ArrayList<>();
        for(TestCase c : candidate_set) {
            testcases_rep.add(represent_testcase(c));
        }
        return AutoISPCoverage.get_best_candidate(testcases_rep, get_isp_coverage_situation());
    }

    public TestCaseRepresentation represent_testcase(TestCase tc) {
        return new MethodEdgePairCoverage(tc);
    }

    public ArrayList<AutoCharacteristic> get_isp_coverage_situation() {
        return ART_AutoISP.isp_coverage_situation;
    }

    @Override
    public void reset() {
        ART_AutoISP.isp_coverage_situation = new ArrayList<>();
        if(timer > 0) {
            f_times.add(timer);
            timer = 0;
        }
    }

    public static ArrayList<Integer> f_times = new ArrayList<>();
    public static int timer = 0;

    @Override
    public void add_execution_time(double execution_time) {
        timer += (int) execution_time;
    }

    @Override
    public int get_f_time(int index) {
        return f_times.get(index);
    }
}
