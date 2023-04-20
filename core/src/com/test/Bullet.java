package com.test;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Bullet {

    public Entity shooter;

    public BodyDef bodyDef = new BodyDef();
    public Body body;
    public Sprite sprite;


    public float currentLifeTime = 0;

    public float size = 1f;
    public float lifeTime;
    public float range ;


    public Vector2 direction;

    public Bullet(Entity shooter, Vector2 mousePosition) {
        this.shooter = shooter;
        sprite = new Sprite(shooter.weapon.texture);

        direction = new Vector2(mousePosition.x -shooter.body.getPosition().x, mousePosition.y -shooter.body.getPosition().y);
        direction = direction.nor();
        init();
    }

    public Bullet(Vector2 direction, Entity shooter) {
        this.shooter = shooter;
        sprite = new Sprite(shooter.weapon.texture);
        this.direction = direction;
        init();
    }

    public void init() {
        this.size = shooter.weapon.size;
        this.lifeTime = shooter.weapon.lifeTime;
        this.range = shooter.weapon.range;

        bodyDef.type = BodyDef.BodyType.DynamicBody;
        Vector2 initialPosition = new Vector2(shooter.body.getPosition().x + 0.5f * direction.x, shooter.body.getPosition().y + 0.5f * direction.y);
        bodyDef.position.set(initialPosition);

        body = GameEngine.instance.map.world.createBody(bodyDef);

        // Create fixture
        PolygonShape shape = GameEngine.createRectangleShape(size,size/4);
        Fixture fixture = body.createFixture(shape, 0);
        fixture.setSensor(true);
        fixture.setUserData(new ContactData(this));
        shape.dispose();

        body.setTransform(initialPosition,(float) (Math.PI/180*(direction.angleDeg())));
        sprite.setRotation((float) (direction.angleDeg()*Math.PI/180 - 45));

    }

    public boolean update(float delta) {
        currentLifeTime += delta;
        if(currentLifeTime > lifeTime) {
            for(Fixture f : body.getFixtureList()) {
                body.destroyFixture(f);
            }
            return false;
        }
        float x = body.getPosition().x;
        float y = body.getPosition().y;
        body.setTransform(new Vector2(x+direction.x * range/lifeTime * delta, y+direction.y * range/lifeTime * delta) , (float) (Math.PI/180*(direction.angleDeg())));
        return true;
    }

    public void draw(SpriteBatch batch) {
        float sqrt2 = (float) Math.sqrt(2);
        batch.draw(sprite,

                (float) (body.getPosition().x - 1/sqrt2*size/2f*Math.cos(sprite.getRotation())) + direction.y * 0.25f,
                (float) (body.getPosition().y - 1/sqrt2*size/2f*Math.sin(sprite.getRotation())) - direction.x * 0.25f,

                0, 0, size, size, 1, 1, (float) (body.getAngle()/Math.PI*180) - 45);
    }

}
