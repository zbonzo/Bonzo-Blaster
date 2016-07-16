package com.zac.bonzoblaster;

import com.badlogic.gdx.Gdx;

/**
 * Created by Zac on 7/14/2016.
 */
public enum PlayerType {
    PLAYER_CHARACTER(1,130,7), NON_PLAYER_CHARACTER(-1, Gdx.graphics.getHeight()-130,40);

    protected final int horizontalOffset;
    protected final int verticalOffset;
    protected int horizontalModifier;

    PlayerType(int modifier, int horizontalOffset, int verticalOffset){
        this.horizontalModifier = modifier;
        this.horizontalOffset = horizontalOffset;
        this.verticalOffset = verticalOffset;
    }
}
