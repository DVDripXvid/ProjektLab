package graphics;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Olivér on 2016.05.11..
 */
public class Controller extends KeyAdapter {

    private View view;

    public Controller(View view){
        this.view = view;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
