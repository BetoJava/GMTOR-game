package com.test.weapon;

import com.badlogic.gdx.graphics.Texture;
import com.test.Weapon;

public class BossWeapon2 extends Weapon {

    public BossWeapon2() {
        damage = 150;

        size = 1.2f;

        lifeTime = 2.3f;
        range = 8;

        texture = new Texture("starBullet.png");
    }
}
