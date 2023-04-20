package com.test.weapon;

import com.badlogic.gdx.graphics.Texture;
import com.test.Weapon;

public class BossWeapon3 extends Weapon {

    public BossWeapon3() {
        damage = 50;

        size = 1f;

        lifeTime = 0.6f;
        range = 15;

        texture = new Texture("cutBullet.png");
    }
}
