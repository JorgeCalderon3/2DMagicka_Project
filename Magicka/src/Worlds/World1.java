package Worlds;

import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.SkelyEnemy;
import Game.Entities.Statics.*;
import Main.Handler;

/**
 * Created by Elemental on 1/2/2017.
 */
public class World1 extends BaseWorld{

    private Handler handler;
    private BaseWorld caveWorld;
  

    public World1(Handler handler, String path, Player player){
        super(handler,path,player);
        this.handler = handler;
        Chest chest = new Chest(handler, 1216, 1400);
        caveWorld = new CaveWorld(handler,"res/Maps/caveMap.map",player);
         
        entityManager.addEntity(new Tree(handler, 1150, 1250));
        entityManager.addEntity(new Tree(handler, 100, 250));
        entityManager.addEntity(new Tree(handler, 1000, 350));
        entityManager.addEntity(new Tree(handler, 980, 1345));
        entityManager.addEntity(new Tree(handler, 765, 888));
        entityManager.addEntity(new Tree(handler, 350, 700));
        entityManager.addEntity(new Tree(handler, 950, 1000));
        entityManager.addEntity(new Tree(handler, 530, 275));
        entityManager.addEntity(new Rock(handler, 100, 450));
        entityManager.addEntity(new Rock(handler, 690, 1370));
        entityManager.addEntity(new Rock(handler, 1280, 1280));  
        entityManager.addEntity(new Rock(handler, 576, 140));
        entityManager.addEntity(new Rock(handler, 640, 256));
        entityManager.addEntity(new Rock(handler, 1216, 1280));
        entityManager.addEntity(new Rock(handler, 1344, 1280));
        entityManager.addEntity(new Rock(handler, 90, 1345));
        entityManager.addEntity(new Rock(handler, 850, 83));
        entityManager.addEntity(new SkelyEnemy(handler, 1250, 500));
        entityManager.addEntity(new SkelyEnemy(handler, 200, 350));
        entityManager.addEntity(new SkelyEnemy(handler, 100, 500));
        entityManager.addEntity(new SkelyEnemy(handler, 1100, 1000));
        entityManager.addEntity(new SkelyEnemy(handler, 150, 1000));
        entityManager.addEntity(new SkelyEnemy(handler, 800, 1280));
        entityManager.addEntity(new Bush(handler, 1280, 704));
        entityManager.addEntity(new Bush(handler, 1280, 768));
        entityManager.addEntity(new Bush(handler, 1344, 704));
        entityManager.addEntity(new Bush(handler, 1344, 768));
        entityManager.addEntity(new Bush(handler, 704, 704));
        entityManager.addEntity(chest);
        entityManager.addEntity(new Door(handler, 927, 0,caveWorld, chest));
       
        
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }

}