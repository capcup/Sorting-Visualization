package Sorting.Visualizer;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author rick
 */
public class VisualizerFrame extends JPanel{

    private JFrame window;
    private SortArray sortarray;

    public VisualizerFrame() { 
        
        window = new JFrame("Sorting Visualizer");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        sortarray = new SortArray();
        window.add(sortarray);
        //sortarray.repaint();
        
        window.pack();
        window.setVisible(true);
        
        sortarray.run();
    }   

}
