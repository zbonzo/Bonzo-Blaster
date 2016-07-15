package com.zac.bonzoblaster;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Zac on 7/13/2016.
 */
public class ShotManager {
    private static final float MINIMUM_TIME_BETWEEN_SHOTS = .5f;
    private final Texture shotTexture;
    private float timeSinceLastShot = 0f;
    private List<Shot> shots = new ArrayList<>();

    public ShotManager(AnimatedSprite spaceshipShotSprite) {
        this.shotTexture = spaceshipShotSprite.getTexture();
    }

    public boolean canFireShot() {
        System.out.println(" " + timeSinceLastShot + " " + MINIMUM_TIME_BETWEEN_SHOTS);

        return timeSinceLastShot > MINIMUM_TIME_BETWEEN_SHOTS;
    }


    public void add(Shot shot) {
//        Shot newShot = new Shot(shot);
        shots.add(shot);
        System.out.println("I have been added to the shot Manager");
        timeSinceLastShot = 0f;
    }

    public void update(){
        Iterator<Shot> i = shots.iterator();
        while(i.hasNext()){
            Shot shot = i.next();
            shot.sprite.move(0,150,2);
            if(shot.sprite.getY() > Gdx.graphics.getHeight()){
                System.out.println("x " + shot.sprite.getX() + "y " + shot.sprite.getY());
                i.remove();
            }else if(shot.sprite.getY() < 0){
                i.remove();
            }

        }
        timeSinceLastShot += Gdx.graphics.getDeltaTime();
    }

    public void draw(SpriteBatch batch){
        for (Shot shot:shots){
            shot.sprite.draw(batch);
        }
    }

}
