package graphics.uielement;

import game.cellelements.ShootableWall;
import game.map.Quarter;
import game.roles.Projectile;
import graphics.ImageHandler;
import graphics.UiElement;

/**
 * Created by Ádám on 17/05/2016.
 */
public class UiPortal extends UiElement {
    Quarter dir;
    ShootableWall.Portal portal;
    Projectile.Color color;

    public UiPortal(Quarter dir, ShootableWall.Portal portal, Projectile.Color color) {
        this.dir = dir;
        this.portal = portal;
        this.color = color;
        image = ImageHandler.getImage("src/graphics/img/Portal/portal_blueWall_east.png");
    }

    public void update() {
        if (dir.equals(Quarter.WEST)) {
            if (color.equals(Projectile.Color.BLUE))
                image = ImageHandler.getImage("src/graphics/img/Portal/portal_blueWall_east.png");
            if (color.equals(Projectile.Color.RED))
                image = ImageHandler.getImage("src/graphics/img/Portal/portal_redWall_east.png");
            if (color.equals(Projectile.Color.GREEN))
                image = ImageHandler.getImage("src/graphics/img/Portal/portal_greenWall_east.png");
            if (color.equals(Projectile.Color.YELLOW))
                image = ImageHandler.getImage("src/graphics/img/Portal/portal_yellowWall_east.png");
        }
        if (dir.equals(Quarter.EAST)) {
            if (color.equals(Projectile.Color.BLUE))
                image = ImageHandler.getImage("src/graphics/img/Portal/portal_blueWall_west.png");
            if (color.equals(Projectile.Color.RED))
                image = ImageHandler.getImage("src/graphics/img/Portal/portal_redWall_west.png");
            if (color.equals(Projectile.Color.GREEN))
                image = ImageHandler.getImage("src/graphics/img/Portal/portal_greenWall_west.png");
            if (color.equals(Projectile.Color.YELLOW))
                image = ImageHandler.getImage("src/graphics/img/Portal/portal_yellowWall_west.png");
        }
        if (dir.equals(Quarter.SOUTH)) {
            if (color.equals(Projectile.Color.BLUE))
                image = ImageHandler.getImage("src/graphics/img/Portal/portal_blueWall_north.png");
            if (color.equals(Projectile.Color.RED))
                image = ImageHandler.getImage("src/graphics/img/Portal/portal_redWall_north.png");
            if (color.equals(Projectile.Color.GREEN))
                image = ImageHandler.getImage("src/graphics/img/Portal/portal_greenWall_north.png");
            if (color.equals(Projectile.Color.YELLOW))
                image = ImageHandler.getImage("src/graphics/img/Portal/portal_yellowWall_north.png");
        }
        if (dir.equals(Quarter.NORTH)) {
            if (color.equals(Projectile.Color.BLUE))
                image = ImageHandler.getImage("src/graphics/img/Portal/portal_blueWall_south.png");
            if (color.equals(Projectile.Color.RED))
                image = ImageHandler.getImage("src/graphics/img/Portal/portal_redWall_south.png");
            if (color.equals(Projectile.Color.GREEN))
                image = ImageHandler.getImage("src/graphics/img/Portal/portal_greenWall_south.png");
            if (color.equals(Projectile.Color.YELLOW))
                image = ImageHandler.getImage("src/graphics/img/Portal/portal_yellowWall_south.png");
        }
    }
}
