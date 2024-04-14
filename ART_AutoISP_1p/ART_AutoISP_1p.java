package methods.ART_AutoISP_1p;

import methods.ART_AutoISP.ART_AutoISP;
import randomTestcase.TestCase;
import tools.AutoISP.*;

import java.util.ArrayList;

public class ART_AutoISP_1p extends ART_AutoISP {
    static ArrayList<AutoCharacteristic> isp_coverage_situation = new ArrayList<>();

    @Override
    public TestCaseRepresentation represent_testcase(TestCase tc) {
        return new MethodAndConditionEdgePairCoverageOnePartition(tc);
    }

    @Override
    public ArrayList<AutoCharacteristic> get_isp_coverage_situation() {
        return ART_AutoISP_1p.isp_coverage_situation;
    }

    @Override
    public void reset() {
        ART_AutoISP_1p.isp_coverage_situation = new ArrayList<>();
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
