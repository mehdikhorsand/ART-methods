package methods.ART_TFClustering;

import randomTestcase.TestCase;
import tools.Distance;

public class TrisectionFrequencyConversion extends methods.ART_TFC.TrisectionFrequencyConversion{
    public int clustering_number = -1; // this means this has no cluster
    public TrisectionFrequencyConversion(TestCase tc) {
        super(tc);
    }

    public static double get_distance(TrisectionFrequencyConversion a, Centroid centroid) {
        // todo : add ordering difference to this method.
        return Distance.euclidean_distance_with_mean_value(a.A, centroid.A) + Distance.euclidean_distance_with_mean_value(a.B, centroid.B) +
                Distance.euclidean_distance_with_mean_value(a.C, centroid.C);
    }
}
