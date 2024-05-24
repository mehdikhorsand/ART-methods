package methods.ART_AutoISP_MC;

import methods.ART_AutoISP.MethodEdgePairCoverage;
import randomTestcase.TestCase;
import tools.activity.Activity;

import java.util.ArrayList;

public class MethodAndConditionEdgePairCoverage extends MethodEdgePairCoverage {
    public MethodAndConditionEdgePairCoverage(TestCase testcase) {
        super(testcase);
    }

    @Override
    public ArrayList<Activity> get_activities() {
        return testcase.method_and_condition_coverage.read_list();
    }
}
