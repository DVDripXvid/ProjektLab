package graphics;

import javax.swing.*;
import java.awt.*;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashMap;

=======
>>>>>>> 711f6bff60e45588e2677dd86c802175f9aff5e0
/**
 * Created by Olivér on 2016.05.11..
 */
public class View extends JFrame {

    private JPanel mapPanel;
<<<<<<< HEAD
    private int rows;
    private int columns;
    private HashMap<Integer, ArrayList<UiElement>> panels = new HashMap<>();

    public View() {
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


    public void createMap(int row, int column) {
        this.setSize(row * 100, column * 100);
        mapPanel = new JPanel();
        mapPanel.setLayout(new GridLayout(row, column));
        rows = row;
        columns = column;

        for (int i = 0; i < row * column; i++) {
            panels.put(i, new ArrayList<>());
        }
        paint();
        this.add(mapPanel);
    }

    public void add(UiElement uiElement, int pos) {
        if (uiElement != null)
            panels.get(pos).add(uiElement);
    }

    public void clear() {

        mapPanel.removeAll();
        mapPanel.invalidate();
        for (int i = 0; i < rows * columns; i++) {
            panels.get(i).clear();
        }
    }

    public void paint() {

        for (int i = 0; i < rows * columns; i++) {
            ArrayList<UiElement> recentUis = panels.get(i);
            mapPanel.add(new JPanel() {

                @Override
                protected void paintComponent(Graphics g) {
                    Image image = ImageHandler.getImage("src/graphics/img/floor.jpg");
                    g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);

                    if (!recentUis.isEmpty()) {
                        for (int j = 0; j < recentUis.size(); j++) {
                            if (recentUis.get(j).image != null) {
                                g.drawImage(recentUis.get(j).image, 0, 0, this.getWidth(), this.getHeight(), this);
                            }
                            if (recentUis.get(j).label != null) {
                                g.setColor(Color.WHITE);
                                g.drawString(recentUis.get(j).label, 60, 32);
                            }

                        }
                    }
                }
            });
        }

        this.setVisible(true);
    }


=======

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
>>>>>>> 711f6bff60e45588e2677dd86c802175f9aff5e0
}
