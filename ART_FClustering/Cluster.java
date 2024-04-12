package methods.ART_FClustering;

import java.util.ArrayList;

public class Cluster {
    ArrayList<FrequencyTransform> testcases = new ArrayList<>();
    Centroid centroid;
    int number;
    public Cluster(FrequencyTransform initial_testcase, int number) {
        add(initial_testcase);
        this.number = number;
        this.centroid = new Centroid(initial_testcase);
    }

    public void add(FrequencyTransform testcase) {
        testcases.add(testcase);
        testcase.clustering_number = this.number;
    }

    public void remove(FrequencyTransform testcase) {
        testcases.remove(testcase);
        testcase.clustering_number = -1;
    }

    public void update_centroid() {
        centroid.update(testcases);
    }
}
