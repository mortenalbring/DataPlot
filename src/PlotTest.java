import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

public class PlotTest {

	private XYSeriesCollection dataset;
	
	public static void main (String[] args) {
        new PlotTest();
    }
	
	public PlotTest () {
		dataset = new XYSeriesCollection();
		XYSeries data = new XYSeries("data");
		data.add(3,2);
		data.add(7,12);
		data.add(1,1);
		
		dataset.addSeries(data);
		showGraph();
	}
	
	
	private void showGraph() {
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        final ApplicationFrame frame = new ApplicationFrame("Title");
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setVisible(true);
	}
	
	
	 private JFreeChart createChart(final XYDataset dataset) {
	        final JFreeChart chart = ChartFactory.createScatterPlot(
	            "Title",                  // chart title
	            "X",                      // x axis label
	            "Y",                      // y axis label
	            dataset,                  // data
	            PlotOrientation.VERTICAL,
	            true,                     // include legend
	            true,                     // tooltips
	            false                     // urls
	        );
	        XYPlot plot = (XYPlot) chart.getPlot();
	        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
	        renderer.setSeriesLinesVisible(0, true);
	        plot.setRenderer(renderer);
	        return chart;
	    }
}
