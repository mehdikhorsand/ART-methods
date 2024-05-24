package methods.ART_AutoISP_1p;

import methods.ART_AutoISP.MethodEdgePairCoverage;
import randomTestcase.TestCase;
import tools.activity.Action;
import tools.activity.Activity;

import java.util.ArrayList;

public class MethodAndConditionEdgePairCoverageOnePartition extends MethodEdgePairCoverage {
    public MethodAndConditionEdgePairCoverageOnePartition(TestCase testcase) {
        super(testcase);
    }

    @Override
    public ArrayList<Activity> get_activities() {
        return testcase.method_and_condition_coverage.read_list();
    }

    @Override
    public void add_to_behavior(ArrayList<Action> behavior, Action action){}
}
