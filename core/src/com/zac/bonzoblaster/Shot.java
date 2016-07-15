package com.zac.bonzoblaster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Zac on 7/13/2016.
 */
public class Shot {


    protected static final int SHOT_SPEED = 150;
    protected final AnimatedSprite sprite;
    private Vector2 velocity;


    public Shot(AnimatedSprite shot){
        this.sprite = shot;
        System.out.println("x " + sprite.getX() + "y " + sprite.getY());


    }




}
