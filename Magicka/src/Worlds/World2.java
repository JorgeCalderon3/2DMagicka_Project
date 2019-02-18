package Worlds;

import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.SkelyEnemy;
import Game.Entities.Statics.*;
import Main.Handler;

/**
 * Created by Elemental on 1/2/2017.
 */
public class World2 extends BaseWorld{

    private Handler handler;
    private BaseWorld caveWorld;
    private BaseWorld world1;

    public World2(Handler handler, String path, Player player){
        super(handler,path,player);
        this.handler = handler;
        caveWorld = new CaveWorld(handler,"res/Maps/caveMap.map",player);
        world1 = new World1(handler,"res/Maps/map1.map",player);
        Chest chest = new Chest(handler, 768,1280);
        entityManager.addEntity(new Bush(handler, 1216,640));
        entityManager.addEntity(new Bush(handler, 384,50));
        entityManager.addEntity(new Bush(handler, 1230,700));
        entityManager.addEntity(new Bush(handler, 384,128));
        entityManager.addEntity(new Bush(handler, 600,1100));
        entityManager.addEntity(chest);
        entityManager.addEntity(new Tree(handler, 200, 250));
        entityManager.addEntity(new Tree(handler, 704, 704));
        entityManager.addEntity(new Tree(handler, 900, 888));
        entityManager.addEntity(new Tree(handler, 77, 600));
        entityManager.addEntity(new Tree(handler, 1110, 888));
        entityManager.addEntity(new Tree(handler, 130, 128));
        entityManager.addEntity(new Rock(handler, 150, 450));
        entityManager.addEntity(new Rock(handler, 200, 1200));
        entityManager.addEntity(new Rock(handler, 88, 900));
        entityManager.addEntity(new Rock(handler, 700, 83));
        entityManager.addEntity(new SkelyEnemy(handler, 1250, 500));
        entityManager.addEntity(new SkelyEnemy(handler, 1250, 1000));
        entityManager.addEntity(new SkelyEnemy(handler, 704, 1000));
		entityManager.addEntity(new Door(handler, 1375, 0,world1, chest));

        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }

}