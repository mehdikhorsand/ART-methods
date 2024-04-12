package methods.ART_WClustering;

import java.util.ArrayList;

public class Cluster {
    ArrayList<WaveletTransform> testcases = new ArrayList<>();
    Centroid centroid;
    int number;
    public Cluster(WaveletTransform initial_testcase, int number) {
        add(initial_testcase);
        this.number = number;
        this.centroid = new Centroid(initial_testcase);
    }

    public void add(WaveletTransform testcase) {
        testcases.add(testcase);
        testcase.clustering_number = this.number;
    }

    public void remove(WaveletTransform testcase) {
        testcases.remove(testcase);
        testcase.clustering_number = -1;
    }

    public void update_centroid() {
        centroid.update(testcases);
    }
}
