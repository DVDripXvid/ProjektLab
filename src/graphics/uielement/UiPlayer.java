package graphics.uielement;

<<<<<<< HEAD
import game.map.Quarter;
import game.roles.Player;
import graphics.ImageHandler;
import graphics.UiElement;

import java.awt.*;
import java.io.File;

/**
 * Created by Olivér on 2016.05.11..
 */
public class UiPlayer extends UiElement {
    String name;
    Player player;

    public UiPlayer(String name, Player player) {
        this.name = name;
        this.player = player;

        try {
            if (name.equals("oneill"))
                image = ImageHandler.getImage("src/graphics/img/players/Oneill/oneil_stand_east.png");

            else if (name.equals("jaffa"))
                image = ImageHandler.getImage("src/graphics/img/players/Jaffa/jaffa_stand_east.png");
        } catch (Exception e) {
            System.out.println("Error loading player image.");
        }
    }

    public void update() {
        if (player.hasBox()) {
            if (name.equals("oneill")) {
                if (player.getDir() == Quarter.EAST)
                    image = ImageHandler.getImage("src/graphics/img/players/Oneill/oneil_box_east.png");
                if (player.getDir() == Quarter.WEST)
                    image = ImageHandler.getImage("src/graphics/img/players/Oneill/oneil_box_west.png");
                if (player.getDir() == Quarter.NORTH)
                    image = ImageHandler.getImage("src/graphics/img/players/Oneill/oneil_box_north.png");
                if (player.getDir() == Quarter.SOUTH)
                    image = ImageHandler.getImage("src/graphics/img/players/Oneill/oneil_box_south.png");
            } else if (name.equals("jaffa")) {
                if (player.getDir() == Quarter.EAST)
                    image = ImageHandler.getImage("src/graphics/img/players/Jaffa/jaffa_box_east.png");
                if (player.getDir() == Quarter.WEST)
                    image = ImageHandler.getImage("src/graphics/img/players/Jaffa/jaffa_box_west.png");
                if (player.getDir() == Quarter.NORTH)
                    image = ImageHandler.getImage("src/graphics/img/players/Jaffa/jaffa_box_north.png");
                if (player.getDir() == Quarter.SOUTH)
                    image = ImageHandler.getImage("src/graphics/img/players/Jaffa/jaffa_box_south.png");
            }
        } else {
            if (name.equals("oneill")) {
                if (player.getDir() == Quarter.EAST)
                    image = ImageHandler.getImage("src/graphics/img/players/Oneill/oneil_stand_east.png");
                if (player.getDir() == Quarter.WEST)
                    image = ImageHandler.getImage("src/graphics/img/players/Oneill/oneil_stand_west.png");
                if (player.getDir() == Quarter.NORTH)
                    image = ImageHandler.getImage("src/graphics/img/players/Oneill/oneil_stand_north.png");
                if (player.getDir() == Quarter.SOUTH)
                    image = ImageHandler.getImage("src/graphics/img/players/Oneill/oneil_stand_south.png");
            } else if (name.equals("jaffa")) {
                if (player.getDir() == Quarter.EAST)
                    image = ImageHandler.getImage("src/graphics/img/players/Jaffa/jaffa_stand_east.png");
                if (player.getDir() == Quarter.WEST)
                    image = ImageHandler.getImage("src/graphics/img/players/Jaffa/jaffa_stand_west.png");
                if (player.getDir() == Quarter.NORTH)
                    image = ImageHandler.getImage("src/graphics/img/players/Jaffa/jaffa_stand_north.png");
                if (player.getDir() == Quarter.SOUTH)
                    image = ImageHandler.getImage("src/graphics/img/players/Jaffa/jaffa_stand_south.png");
            }
        }
    }


=======
import graphics.UiElement;

/**
 * Created by Olivér on 2016.05.11..
 */
public class UiPlayer extends UiElement{
>>>>>>> 711f6bff60e45588e2677dd86c802175f9aff5e0
}
