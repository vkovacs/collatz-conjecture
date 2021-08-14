package hu.crs.coalltzconjecture;

import hu.crs.coalltzconjecture.math.SequenceGenerator;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        // Create Chart
        XYChart chart = new XYChartBuilder().width(1920).height(1080).title("Gaussian Blobs").xAxisTitle("X").yAxisTitle("Y").build();

        // Customize Chart
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
        chart.getStyler().setMarkerSize(16);
        chart.getStyler().setCursorEnabled(true);

        var sequenceGenerator = new SequenceGenerator();
        sequenceGenerator.sequences(IntStream.range(1, 20).boxed().collect(Collectors.toList()))
                .forEach(s -> {
                    var xySeries = chart.addSeries(String.format("Series: %d", s.ys().get(0)), s.xs(), s.ys());
                    xySeries.setMarker(SeriesMarkers.NONE);
                });

        new SwingWrapper<>(chart).displayChart();
    }
}
