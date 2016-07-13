package com.zac.bonzoblaster;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Zac on 7/13/2016.
 */
public class AnimatedSprite extends Sprite {
    private final int FRAMES_ROW;
    private final int FRAMES_COL;
    private final Sprite sprite;

    public AnimatedSprite(Sprite sprite, Integer rows, Integer columns) {
        this.sprite = sprite;
        FRAMES_ROW = rows;
        FRAMES_COL = columns;
    }


}
