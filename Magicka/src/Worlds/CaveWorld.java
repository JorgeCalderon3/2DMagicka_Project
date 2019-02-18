package Worlds;
import Game.Entities.Creatures.BossEnemy;
import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.SkelyEnemy;
import Game.Entities.Statics.Rock;
import Game.Entities.Statics.Tree;
import Main.Handler;

/**
 * Created by Elemental on 2/10/2017.
 */
public class CaveWorld extends BaseWorld{
    private Handler handler;
    private Player player;

    public CaveWorld(Handler handler, String path, Player player) {
        super(handler,path,player);
        this.handler = handler;
        this.player=player;
        entityManager.addEntity(new BossEnemy(handler, 704, 1000));
        entityManager.addEntity(new Tree(handler, 64, 320));
        entityManager.addEntity(new Tree(handler, 64, 384));
        entityManager.addEntity(new Tree(handler, 64, 448));
        entityManager.addEntity(new Tree(handler, 64, 512));
        entityManager.addEntity(new Tree(handler, 64, 576));
        entityManager.addEntity(new Tree(handler, 64, 640));
        entityManager.addEntity(new Tree(handler, 64, 704));
        entityManager.addEntity(new Tree(handler, 64, 768));
        entityManager.addEntity(new Tree(handler, 64, 832));
        entityManager.addEntity(new Tree(handler, 64, 896));
        entityManager.addEntity(new Tree(handler, 64, 960));
        entityManager.addEntity(new Tree(handler, 64, 1024));
        entityManager.addEntity(new Tree(handler, 64, 1088));
        entityManager.addEntity(new Tree(handler, 64, 1152));
        entityManager.addEntity(new Tree(handler, 128, 1216));
        
    }
    
    

}