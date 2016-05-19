package graphics;

<<<<<<< HEAD
import game.cellelements.ShootableWall;
import game.map.Cell;
import game.map.MapManager;
import game.map.Quarter;
import game.roles.CellElement;
import game.roles.Projectile;
import graphics.uielement.UiAbyss;
import graphics.uielement.UiBox;
import graphics.uielement.UiShootableWall;
import graphics.uielement.UiWall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
=======
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
>>>>>>> 711f6bff60e45588e2677dd86c802175f9aff5e0

/**
 * Created by Olivér on 2016.05.11..
 */
public class Controller extends KeyAdapter {

    private View view;

<<<<<<< HEAD
    public Controller(View view) {
        this.view = view;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (MapManager.INSTANCE.playerAlive("oneill"))
            switch (e.getKeyCode()) {
                //O'Neill irányítása
                case KeyEvent.VK_W:
                    MapManager.INSTANCE.getPlayer("oneill").moveTo(Quarter.NORTH);
                    System.out.printf("w");
                    break;
                case KeyEvent.VK_A:
                    MapManager.INSTANCE.getPlayer("oneill").moveTo(Quarter.WEST);
                    System.out.printf("a");
                    break;
                case KeyEvent.VK_S:
                    MapManager.INSTANCE.getPlayer("oneill").moveTo(Quarter.SOUTH);
                    System.out.printf("s");
                    break;
                case KeyEvent.VK_D:
                    MapManager.INSTANCE.getPlayer("oneill").moveTo(Quarter.EAST);
                    System.out.printf("d");
                    break;
                case KeyEvent.VK_Q:
                    //felvétel vagy lerakás
                    if (MapManager.INSTANCE.getPlayer("oneill").hasBox())
                        MapManager.INSTANCE.getPlayer("oneill").boxDown();
                    else
                        MapManager.INSTANCE.getPlayer("oneill").boxUp();

                    System.out.printf("q");
                    break;
                case KeyEvent.VK_E:
                    //lövés
                    MapManager.INSTANCE.getPlayer("oneill").shoot();
                    System.out.printf("e");
                    break;
                case KeyEvent.VK_R:
                    //színváltás
                    MapManager.INSTANCE.getPlayer("oneill").changeColor();
                    System.out.printf("e");
                    break;


            }
        if (MapManager.INSTANCE.playerAlive("jaffa"))
            switch (e.getKeyCode()) {
                //Jaffa irányítása
                case KeyEvent.VK_I:
                    MapManager.INSTANCE.getPlayer("jaffa").moveTo(Quarter.NORTH);
                    System.out.printf("i");
                    break;
                case KeyEvent.VK_J:
                    MapManager.INSTANCE.getPlayer("jaffa").moveTo(Quarter.WEST);
                    System.out.printf("j");
                    break;
                case KeyEvent.VK_K:
                    MapManager.INSTANCE.getPlayer("jaffa").moveTo(Quarter.SOUTH);
                    System.out.printf("k");
                    break;
                case KeyEvent.VK_L:
                    MapManager.INSTANCE.getPlayer("jaffa").moveTo(Quarter.EAST);
                    System.out.printf("l");
                    break;
                case KeyEvent.VK_U:
                    //felvétel vagy lerakás
                    if (MapManager.INSTANCE.getPlayer("jaffa").hasBox())
                        MapManager.INSTANCE.getPlayer("jaffa").boxDown();
                    else
                        MapManager.INSTANCE.getPlayer("jaffa").boxUp();
                    System.out.printf("u");
                    break;
                case KeyEvent.VK_O:
                    //lövés
                    MapManager.INSTANCE.getPlayer("jaffa").shoot();
                    System.out.printf("o");
                    break;
                case KeyEvent.VK_P:
                    //színváltás
                    MapManager.INSTANCE.getPlayer("jaffa").changeColor();
                    System.out.printf("p");
                    break;
            }
        if (!MapManager.INSTANCE.playerAlive("oneill") && !MapManager.INSTANCE.playerAlive("jaffa")) {
            view.add(new JButton("Game over!"), BorderLayout.NORTH);
        }
        update();
    }

    public void update() {
        view.clear();

        List<Cell> cells = MapManager.INSTANCE.getCellList();
        for (int i = 0; i < cells.size(); i++) {
            List<CellElement> elements = cells.get(i).getElementList();
            for (int j = 0; j < elements.size(); j++) {
                elements.get(j).update();
                view.add(elements.get(j).getUiElement(), i);
                System.out.println(elements.get(j).getUiElement().toString());

            }

            if (MapManager.INSTANCE.playerAlive("oneill"))
                if (MapManager.INSTANCE.getPlayer("oneill").getActualCell().equals(cells.get(i))) {
                    view.add(MapManager.INSTANCE.getPlayer("oneill").getUiElement(), i);
                    MapManager.INSTANCE.getPlayer("oneill").getUiElement().update();
                }
            if (MapManager.INSTANCE.playerAlive("jaffa"))
                if (MapManager.INSTANCE.getPlayer("jaffa").getActualCell().equals(cells.get(i))) {
                    view.add(MapManager.INSTANCE.getPlayer("jaffa").getUiElement(), i);
                    MapManager.INSTANCE.getPlayer("jaffa").getUiElement().update();
                }


            if (ShootableWall.portalActive(Projectile.Color.BLUE))
                if (ShootableWall.getPORTALS().get(Projectile.Color.BLUE).getCell().equals(cells.get(i))) {
                    view.add(ShootableWall.getPORTALS().get(Projectile.Color.BLUE).getUiElement(), i);
                    ShootableWall.getPORTALS().get(Projectile.Color.BLUE).getUiElement().update();
                }
            if (ShootableWall.portalActive(Projectile.Color.RED))
                if (ShootableWall.getPORTALS().get(Projectile.Color.RED).getCell().equals(cells.get(i))) {
                    view.add(ShootableWall.getPORTALS().get(Projectile.Color.RED).getUiElement(), i);
                    ShootableWall.getPORTALS().get(Projectile.Color.RED).getUiElement().update();
                }
            if (ShootableWall.portalActive(Projectile.Color.GREEN))
                if (ShootableWall.getPORTALS().get(Projectile.Color.GREEN).getCell().equals(cells.get(i))) {
                    view.add(ShootableWall.getPORTALS().get(Projectile.Color.GREEN).getUiElement(), i);
                    ShootableWall.getPORTALS().get(Projectile.Color.GREEN).getUiElement().update();
                }
            if (ShootableWall.portalActive(Projectile.Color.YELLOW))
                if (ShootableWall.getPORTALS().get(Projectile.Color.YELLOW).getCell().equals(cells.get(i))) {
                    view.add(ShootableWall.getPORTALS().get(Projectile.Color.YELLOW).getUiElement(), i);
                    ShootableWall.getPORTALS().get(Projectile.Color.YELLOW).getUiElement().update();
                }
        }

        view.paint();
    }


=======
    public Controller(View view){
        this.view = view;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

>>>>>>> 711f6bff60e45588e2677dd86c802175f9aff5e0
}
