package Game.Entities.Statics;

import Game.Entities.Creatures.Player;
import Game.Items.Item;
import Game.Tiles.Tile;
import Resources.Images;
import Main.Handler;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random; 	

/**
 * Created by Elemental on 1/2/2017.
 */
public class Chest extends StaticEntity {

	 private Rectangle ir = new Rectangle();
	 public Boolean EP = false;
	 private boolean isOpen = false;
	 private int axeItem=0;
	 private int rockItem=0;
	 private Boolean isDoorReady = false;
	

   
	 public Boolean getIsDoorReady() {
		return isDoorReady;
	}

	public void setIsDoorReady(Boolean isDoorReady) {
		this.isDoorReady = isDoorReady;
	}

	public Chest(Handler handler, float x, float y) {
        super(handler, x, y, 64, 100);

        bounds.x=0;
        bounds.y=0;
        bounds.width = 100;
        bounds.height = 64;
        health=10000000;
        
        ir.width = bounds.width;
        ir.height = bounds.height;
        int irx=(int)(x-handler.getGameCamera().getxOffset()+bounds.x-16);
        int iry= (int)(y-handler.getGameCamera().getyOffset()-getHeight()+bounds.height+32);
        ir.y=iry;
        ir.x=irx;
    }

    @Override
    public void tick() {
    	if(isBeinghurt()){
            setHealth(10000000);
    	}
        if(handler.getKeyManager().attbut){
            EP=true;
        }else if(!handler.getKeyManager().attbut){
            EP=false;
        }
    }
   
    @Override
    public void render(Graphics g) {
    	if(!isOpen){
    		g.drawImage(Images.chestC,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
    	}
    	else{
    		g.drawImage(Images.chestO,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
    		g.setColor(Color.WHITE);
    		g.setFont(new Font("Arial", Font.BOLD, 14));
    		if(!this.isDoorReady) {
    			g.drawString("You need to deliver " + (2 - axeItem) + " axe/ Destroy enemies to get them",(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()- 20));
             	g.drawString("You need to deliver " + (3 - rockItem) + " rock",(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()));
          	}
    		else {
    			g.drawString("FIND THE DOOR!",(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()));
    		}
    		
        }
    	checkForPlayer(g, handler.getWorld().getEntityManager().getPlayer());
     }
    
    private void checkForPlayer(Graphics g, Player p) {	
        Rectangle pr = p.getCollisionBounds(0,0);
       
        if(ir.contains(pr) && !EP && !isOpen){
        	g.drawImage(Images.E,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),32,32,null);
      	}else if(ir.contains(pr) && EP){
            isOpen = true; 
        }
        if(ir.contains(pr) && isOpen && axeItem<3 && axeItem>=0) {
        	this.chestItem();
        }
        if(ir.contains(pr) && isOpen && rockItem<3 && rockItem>=0) {
        	this.chestItem();     	
        }
        if(rockItem == 3 && axeItem ==2) {
        	this.isDoorReady = true;
        }
    }
    
    public void chestItem() {
    	for(Item i: handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItems()) {
    		if(i.getName().equals("Axe") && (i.getCount()!=0) && axeItem<2) {
    			axeItem ++;
    			i.setCount(i.getCount()-1);
    		}
    		else {
    			if(i.getName().equals("Rock") && (i.getCount()!=0) && rockItem<3) {
    				rockItem ++;
        			i.setCount(i.getCount()-1);	
    			}
    		}
    	}
    }
    
    @Override
    public void die() {

    }
}
