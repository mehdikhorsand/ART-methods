package methods.ART_WClustering;

import randomTestcase.TestCase;
import tools.Distance;

public class WaveletTransform extends methods.ART_WT.WaveletTransform{
    public int clustering_number = -1; // this means this has no cluster
    public WaveletTransform(TestCase tc) {
        super(tc);
    }

    public static double get_distance(WaveletTransform a, Centroid centroid) {
        // todo : add ordering difference to this method.
        return Distance.euclidean_distance_with_mean_value(a.A, centroid.A) + Distance.euclidean_distance_with_mean_value(a.B, centroid.B);
    }
}
