package methods.ART_FClustering;

import main.Settings;
import tools.ExecutionAnalysis;
import tools.MyRandom;

import java.util.ArrayList;

public class Clustering {

    public static ArrayList<Cluster> clustering_analysis(ArrayList<FrequencyTransform> originalData) {
        int k = get_suitable_k(originalData.size());
        ArrayList<Cluster> clustering = new ArrayList<>();
        for(int i=0; i<k; i++){
            FrequencyTransform initial_testcase = originalData.get(MyRandom.getInt(0, originalData.size()-1));
            clustering.add(new Cluster(initial_testcase, i));
            originalData.remove(initial_testcase);
        }
        for(FrequencyTransform tc_ft : originalData)
            tc_ft.clustering_number = -1; // no cluster assigned yet for remained testcases
        boolean change = true; // means that the cluster of at least one testcase changed
        for(int i=0; i<Settings.maximum_iteration && change; i++){
            change = false; // nothing has changed yet
            // add remained testcases in originalData to the nearest cluster to them
            for(FrequencyTransform tc_ft : originalData) {
                double minDis = Double.POSITIVE_INFINITY;
                int nearestCluster = -1;
                for(int j=0; j<k; j++) {
                    double distance = FrequencyTransform.get_distance(tc_ft, clustering.get(j).centroid);
                    if(distance < minDis){
                        minDis = distance;
                        nearestCluster = j;
                    }
                }
                if(tc_ft.clustering_number != nearestCluster){
                    // cluster of one testcase has changed
                    ExecutionAnalysis.write(tc_ft + "\nchanging cluster from " + tc_ft.clustering_number + " to " + nearestCluster);
                    change = true;
                    // moving to the new cluster
                    if(tc_ft.clustering_number != -1)
                        clustering.get(tc_ft.clustering_number).remove(tc_ft);
                    clustering.get(nearestCluster).add(tc_ft);
                }
            }
            for(Cluster c : clustering) {
                c.update_centroid();
            }
        }
        return clustering;
    }

    public static int get_suitable_k(int executed_set_size) {
        return Math.max(
                Settings.minimum_clustering_number,
                (int) Math.ceil(((double)executed_set_size * Settings.k_percentage) / 100)
        );
    }
}
