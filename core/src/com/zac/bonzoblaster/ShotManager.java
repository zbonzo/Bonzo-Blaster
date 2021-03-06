package com.zac.bonzoblaster;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Zac on 7/13/2016.
 */
public class ShotManager {
    private static final float MINIMUM_TIME_BETWEEN_SHOTS = .5f;
    private final Texture shotTexture;
    protected float timeSinceLastShot = 0f;
    private List<Shot> shots = new ArrayList<>();

    public ShotManager(AnimatedSprite spaceshipShotSprite) {
        this.shotTexture = spaceshipShotSprite.getTexture();
    }

    public boolean canFireShot() {

        return timeSinceLastShot > MINIMUM_TIME_BETWEEN_SHOTS;
    }


    public void add(Shot shot) {
//        Shot newShot = new Shot(shot);
        shots.add(shot);

        timeSinceLastShot = 0f;
    }

    public void update(){
        Iterator<Shot> i = shots.iterator();
        while(i.hasNext()){
            Shot shot = i.next();
            shot.sprite.move(0,150,2);
            if(shot.sprite.getY() > Gdx.graphics.getHeight()){
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

    public List<Shot> getShots(){

        return shots;

    }

}
