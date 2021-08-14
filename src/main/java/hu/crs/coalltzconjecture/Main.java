package hu.crs.coalltzconjecture;

import hu.crs.coalltzconjecture.math.Sequence;
import hu.crs.coalltzconjecture.math.SequenceGenerator;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.internal.chartpart.Chart;

public class Main {
    public static void main(String[] args) {

        var sequenceGenerator = new SequenceGenerator();
        var sequence1 = sequenceGenerator.generate(1);
        var sequence2 = sequenceGenerator.generate(2);



        // Show it
        new SwingWrapper(chart(sequenceGenerator.generate(3))).displayChart();
    }

    private static Chart chart(Sequence sequence) {
        return QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", sequence.xs(), sequence.ys());
    }

}
