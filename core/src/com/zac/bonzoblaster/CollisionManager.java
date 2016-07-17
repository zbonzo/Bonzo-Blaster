package com.zac.bonzoblaster;

import com.badlogic.gdx.math.Rectangle;

import java.util.List;

/**
 * Created by Zac on 7/16/2016.
 */
public class CollisionManager {

    private final Spaceship playerSpaceship;
    private final EnemyManager enemyManager;

    public CollisionManager(Spaceship playerSpaceship, EnemyManager enemyManager) {
        this.playerSpaceship = playerSpaceship;
        this.enemyManager = enemyManager;

    }

    public void handleCollisions() {
        handleEnemyShot();
        handlePlayerShot();

    }

    private void handlePlayerShot() {
        List<Spaceship> enemies = enemyManager.getEnemies();
        for(Spaceship enemy : enemies) {
            List<Shot> shotBoundingBoxes = enemy.shotManager.getShots();

                for (Shot shot : shotBoundingBoxes) {
                    if (shot.touches(playerSpaceship.spaceshipSprite.getBoundingBox())) {
                        System.out.println("Human down!");
                    }
                }

        }
    }

    private void handleEnemyShot() {
        List<Spaceship> enemies = enemyManager.getEnemies();
        List<Shot> shotBoundingBoxes = playerSpaceship.shotManager.getShots();
        for(Spaceship enemy : enemies){
            for(Shot shot : shotBoundingBoxes){
                if(shot.touches(enemy.spaceshipSprite.getBoundingBox())){
                    enemy.hit(enemy);
                    return;
                }

            }
        }

    }
}
