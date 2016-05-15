package graphics;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Olivér on 2016.05.11..
 */
public class View extends JFrame {

    private JPanel mapPanel;

    public View(){
        this.setSize(500,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void createMap(int row, int column){
        mapPanel = new JPanel();
        mapPanel.setLayout(new GridLayout(row, column));
        mapPanel.add(new JButton());

        this.add(mapPanel);
    }
}
