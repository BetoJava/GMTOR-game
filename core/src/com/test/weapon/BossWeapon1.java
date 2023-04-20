package com.test.weapon;

import com.badlogic.gdx.graphics.Texture;
import com.test.Weapon;

public class BossWeapon1 extends Weapon {

    public BossWeapon1() {
        damage = 200;

        size = 1.2f;

        lifeTime = 0.8f;
        range = 10;

        texture = new Texture("bigBullet.png");
    }
}
