package methods.ART_TFClustering;

import java.util.ArrayList;

public class Cluster {
    ArrayList<TrisectionFrequencyConversion> testcases = new ArrayList<>();
    Centroid centroid;
    int number;
    public Cluster(TrisectionFrequencyConversion initial_testcase, int number) {
        add(initial_testcase);
        this.number = number;
        this.centroid = new Centroid(initial_testcase);
    }

    public void add(TrisectionFrequencyConversion testcase) {
        testcases.add(testcase);
        testcase.clustering_number = this.number;
    }

    public void remove(TrisectionFrequencyConversion testcase) {
        testcases.remove(testcase);
        testcase.clustering_number = -1;
    }

    public void update_centroid() {
        centroid.update(testcases);
    }
}
