package com.zac.bonzoblaster;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Zac on 7/13/2016.
 */
public class Shot {


    protected static final int SHOT_SPEED = 150;
    protected final AnimatedSprite sprite;



    public Shot(AnimatedSprite shot){
        this.sprite = shot;



    }

    public boolean touches(Rectangle boundingBox){
        if(Intersector.intersectRectangles(sprite.getBoundingBox(),boundingBox,new Rectangle())){
            return true;
        }
        return false;
    }




}
