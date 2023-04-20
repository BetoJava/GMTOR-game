package com.test.weapon;

import com.badlogic.gdx.graphics.Texture;
import com.test.Weapon;

public class Sword extends Weapon {

    public Sword() {
        damage = 50;

        size = 1f;

        lifeTime = 0.4f;
        range = 12;

        texture = new Texture("bullet.png");
    }
}
