package com.test;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.test.weapon.BossWeapon1;
import com.test.weapon.BossWeapon2;
import com.test.weapon.BossWeapon3;

public class Boss extends Entity {

    public Weapon weapon1 = new BossWeapon1();
    public Weapon weapon2 = new BossWeapon2();
    public Weapon weapon3 = new BossWeapon3();

    public int phase;

    public float rotation = 0;
    public int boost = 0;

    public Boss() {
        texture = new Texture("boneSnake.png");
        maxHealth = 1500;
        health = 1500;
        size = 4f;
        firstPhase();
        init();
    }

    public void firstPhase() {
        weapon = weapon3;
        shotPerSecond = 20 + boost/2f;
        phase = 1;
        delaySinceLastShot = -1;
    }

    public void secondPhase() {
        weapon = weapon1;
        shotPerSecond = 7 + boost/2f;
        phase = 2;
        delaySinceLastShot = -1;
    }

    public void thirdPhase() {
        weapon = weapon2;
        shotPerSecond = 6 + boost/2f;
        phase = 3;
        delaySinceLastShot = -0.5f;
    }

    @Override
    public void hitBy(Bullet bullet) {
        super.hitBy(bullet);


        if(health < 0 && phase != 1) {
            health = maxHealth;
            firstPhase();
            boost += 6;
            weapon1.range += 2;
            weapon2.range += 2;
            weapon3.range += 2;
        }

        if(health < maxHealth*2/3 && health > maxHealth/3 && phase != 2) {
            secondPhase();
        }

        if(health < maxHealth/3 && health > 0&& phase != 3) {
            thirdPhase();
        }


    }

    @Override
    public void update(float delta) {
        super.update(delta);
        shot();
    }

    @Override
    public void shot() {
        if(delaySinceLastShot > 1/shotPerSecond) {
            delaySinceLastShot = 0;

            switch (phase) {
                case 1:
                    rotation += 2 + boost/3f;
                    for(int i = 0; i < 10; i++) {
                        Vector2 direction = new Vector2(1,0);
                        direction.rotateDeg(360*i/10f + rotation);
                        bullets.add(new Bullet(direction, this));
                    }
                    break;
                case 2:
                    rotation -= 15+ boost/2f;
                    for(int i = 0; i < 8; i++) {
                        Vector2 direction = new Vector2(1,0);
                        direction.rotateDeg(360*i/8f + rotation);
                        bullets.add(new Bullet(direction, this));
                    }
                    break;
                case 3:
                    rotation += 10+ boost/2f;
                    for(int i = 0; i < 6; i++) {
                        Vector2 direction = new Vector2(1,0);
                        direction.rotateDeg(360*i/6f + rotation);
                        bullets.add(new Bullet(direction, this));
                    }
                    break;
            }



        }
    }


}
