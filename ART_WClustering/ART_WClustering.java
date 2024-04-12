package methods.ART_WClustering;

import main.SelectionMethod;
import randomTestcase.TestCase;
import tools.MyRandom;

import java.util.ArrayList;

public class ART_WClustering extends SelectionMethod {
    static ArrayList<WaveletTransform> executed_set = new ArrayList<>();
    static ArrayList<WaveletTransform> executed_representative = new ArrayList<>();
    @Override
    public TestCase best_candidate(TestCase[] candidate_set) {
        update_executive_representative_set();
        WaveletTransform[] candidates_ft = new WaveletTransform[candidate_set.length];
        for(int i=0; i<candidate_set.length; i++)
            candidates_ft[i] = new WaveletTransform(candidate_set[i]);
        WaveletTransform furthest_candidate = candidates_ft[0];
        double max_min_distance = 0;
        for (WaveletTransform tc_ft : candidates_ft) {
            double min_distance = get_tc_min_distance(tc_ft);
            if (max_min_distance < min_distance) {
                max_min_distance = min_distance;
                furthest_candidate = tc_ft;
            }
        }
        executed_set.add(furthest_candidate);
        return furthest_candidate.testcase;
    }

    @Override
    public void reset() {
        executed_set = new ArrayList<>();
        executed_representative = new ArrayList<>();
    }

    public static double get_tc_min_distance(WaveletTransform tc_ft) {
        double min_distance = (int) Double.POSITIVE_INFINITY;
        for(WaveletTransform eft : executed_representative) {
            double distance = WaveletTransform.get_distance(eft, tc_ft);
            if(distance > 0)
                System.out.println();
            if(distance < min_distance){
                min_distance = distance;
            }
        }
        return min_distance;
    }

    public static void update_executive_representative_set() {
        executed_representative = new ArrayList<>();
        if(executed_set.size() <= Clustering.get_suitable_k(executed_set.size())) {
            executed_representative.addAll(executed_set);
        }
        else {
            // todo: cluster executed_set to k clusters
            ArrayList<Cluster> clusters = Clustering.clustering_analysis(new ArrayList<>(executed_set));
            // todo: select a random testcase from each cluster and add it to executed_representative
            for(Cluster cluster : clusters)
                executed_representative.add(cluster.testcases.get(MyRandom.getInt(0, cluster.testcases.size()-1)));
        }
    }
}
