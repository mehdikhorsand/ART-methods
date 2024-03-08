package methods.ART_FT;

import java.util.ArrayList;

public class Cluster {
    ArrayList<FrequencyTransform> testcases = new ArrayList<>();
    FrequencyTransform mean_value;
    int number;
    public Cluster(FrequencyTransform initial_testcase, int number) {
        add(initial_testcase);
        this.number = number;
    }

    public void add(FrequencyTransform testcase) {
        testcases.add(testcase);
        testcase.clustering_number = this.number;
    }

    public FrequencyTransform update_mean_value() {
        return (testcases.isEmpty())? null:testcases.get(0);
    }
}
