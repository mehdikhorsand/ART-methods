package methods.ART_FT;

import main.Settings;
import tools.MyRandom;

import java.util.ArrayList;

public class Clustering {
    public static ArrayList<Cluster> clustering_analysis(ArrayList<FrequencyTransform> originalData, int k) {
        ArrayList<Cluster> clustering = new ArrayList<>();
        for(int i=0; i<k; i++){
            FrequencyTransform initial_testcase = originalData.get(MyRandom.getInt(0, originalData.size()-1));
            clustering.add(new Cluster(initial_testcase, i));
//            originalData.remove(initial_testcase);
        }
        for(FrequencyTransform tc_ft : originalData)
            tc_ft.clustering_number = Settings.max_clustering_number;
        boolean change = true;
        while(change) {
            for(FrequencyTransform tc_ft : originalData) {
                double minDis = Double.POSITIVE_INFINITY;
                int nearestCluster = k;
                for(int j=0; j<k; j++) {
                    double distance = FrequencyTransform.get_distance(tc_ft, clustering.get(j).mean_value);
                    if(distance <= minDis){
                        minDis = distance;
                        nearestCluster = j;
                    }
                }
                change = tc_ft.clustering_number == nearestCluster;
                clustering.get(nearestCluster).add(tc_ft);
            }
            for(Cluster c : clustering) {
                c.update_mean_value();
            }
        }
        return clustering;
    }

    public static ArrayList<ArrayList<FrequencyTransform>> clusteringAnalysis(ArrayList<FrequencyTransform> originalData, int k) {
        ArrayList<ArrayList<FrequencyTransform>> clustering = new ArrayList<>();
        ArrayList<FrequencyTransform> meanValue = new ArrayList<>();
        for(int i=1; i<=k; i++) {
            ArrayList<FrequencyTransform> cluster = new ArrayList<>();
            FrequencyTransform initial = originalData.get(MyRandom.getInt(0, originalData.size()-1));
            cluster.add(initial);
            meanValue.add(initial);
            clustering.add(cluster);
        }
        boolean change = true;
        while(change){
            for(FrequencyTransform tc : originalData) {
                double minDis = Double.POSITIVE_INFINITY;
                int nearestCluster;
                for(int j=1; j<=k; j++) {
                    double distance = FrequencyTransform.get_distance(tc, meanValue.get(j-1));
                    if(distance <= minDis){
                        minDis = distance;
                        nearestCluster = j;
                    }
                }
            }
        }
        return clustering;
    }
}
