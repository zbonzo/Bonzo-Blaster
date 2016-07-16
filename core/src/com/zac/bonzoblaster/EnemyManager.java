package com.zac.bonzoblaster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Zac on 7/16/2016.
 */
public class EnemyManager {

    private List<Spaceship> enemies = new ArrayList<>();

    public EnemyManager(AnimatedSprite enemySprite, AnimatedSprite enemyShotSprite) {

        for(int i =0;i<3;i++) {
            Spaceship enemy = new Spaceship(enemySprite, enemyShotSprite, PlayerType.NON_PLAYER_CHARACTER);
            enemy.spaceshipSprite.setPosition(Gdx.graphics.getWidth() / (enemies.size() + 1), Gdx.graphics.getHeight() - enemy.spaceshipSprite.getHeight());
            add(enemy);
        }
    }

    public void add(Spaceship enemy){
        enemies.add(enemy);

    }


    public void update(){

        Iterator<Spaceship> i = enemies.iterator();

        while(i.hasNext()){

            Spaceship enemy = i.next();
            enemy.enemyAI.takeAction();
            enemy.shotManager.update();
//            enemy.spaceshipSprite.move(0,150,2);
//            if(shot.sprite.getY() > Gdx.graphics.getHeight()){
//                System.out.println("x " + shot.sprite.getX() + "y " + shot.sprite.getY());
//                i.remove();
//            }else if(shot.sprite.getY() < 0){
//                i.remove();
//            }

        }

    }

    public void draw(SpriteBatch batch){
        for (Spaceship enemy:enemies){
            enemy.spaceshipSprite.draw(batch);
            enemy.shotManager.draw(batch);
        }
    }
}
