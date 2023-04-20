package com.test;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;
import com.test.weapon.Sword;

import java.util.ArrayList;

public class Entity {


    public int maxHealth = 200;
    public int health = 200;


    public BodyDef bodyDef = new BodyDef();
    public Body body;
    public Texture texture = new Texture("royalKnight.png");
    public float size = 1f;
    public Fixture fixture;

    public ArrayList<Bullet> bullets = new ArrayList<>();
    public ArrayList<Bullet> bulletToDestroy = new ArrayList<>();

    public double delaySinceLastShot = 1000000000;
    public double shotPerSecond = 10;

    public Weapon weapon = new Sword();

    public String toDraw = "";


    public void init() {
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(0, 0);

        body = GameEngine.instance.map.world.createBody(bodyDef);

        // Create fixture
        CircleShape shape =  new CircleShape();
        shape.setRadius(size/2 * 32/40f);
        fixture = body.createFixture(shape, 0);
        fixture.setUserData(new ContactData(this));
        fixture.setSensor(true);
        shape.dispose();

    }



    public void draw(SpriteBatch batch) {
        batch.draw(texture, body.getPosition().x - size/2, body.getPosition().y - size/2, size, size);

        for (Bullet b: bullets) {
            b.draw(batch);
        }

    }

    public void update(float delta) {
        delaySinceLastShot += delta;

        for(Bullet b : bulletToDestroy) {
            bullets.remove(b);
            for(Fixture f : b.body.getFixtureList()) {
                b.body.destroyFixture(f);
            }
        }

        ArrayList<Bullet> aliveBullets = new ArrayList<>();
        for(Bullet b : bullets) {
            if(b.update(delta)) {
                aliveBullets.add(b);
            }
        }
        bullets = aliveBullets;
    }

    public void hitBy(Bullet bullet) {
        health -= bullet.shooter.weapon.damage;
        showDamage(bullet.shooter.weapon.damage);

        if(health < 0) {
            dead(bullet.shooter);
        }

        bullet.shooter.bulletToDestroy.add(bullet);
    }

    public void showDamage(int damage) {
        toDraw = "- " + damage;
    }

    public void dead(Entity killer) {

    }

    public void shot() {
        if(delaySinceLastShot > 1/shotPerSecond) {
            delaySinceLastShot = 0;
            bullets.add(new Bullet(this, GameEngine.instance.getMousePosInGameWorld()));
        }
    }


}
