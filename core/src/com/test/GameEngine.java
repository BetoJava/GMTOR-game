package com.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class GameEngine {

    public static GameEngine instance = new GameEngine();

    public Map map = new Map();
    public InputManager inputManager = new InputManager();
    public SpriteBatch batch;

    public FontDisplay fontDisplay;

    public Entity player;
    public Boss boss;

    public void init() {
        player = new Entity();
        player.init();
        boss = new Boss();
        boss.body.setTransform(0,0,0);
        batch = new SpriteBatch();
        map.world.setContactListener(new ContactManager());

        FontManager.loadFonts();
        fontDisplay = new FontDisplay();
    }


    public void update(float delta) {
        inputManager.processInput(player);
        map.update(delta);
        player.update(delta);

        map.camera.position.set(player.body.getPosition(), 0);
        map.camera.update();
        boss.update(delta);
    }

    public void render() {
        batch.begin();

        //fontDisplay.draw(batch, player.toDraw, 0,2);


        batch.setProjectionMatrix(map.camera.combined);
        boss.draw(batch);
        player.draw(batch);

        batch.end();
    }

    public Vector2 getMousePosInGameWorld() {
        Vector3 v3 = map.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
        return new Vector2(v3.x, v3.y);
    }

    public static PolygonShape createRectangleShape(float w, float h) {

        PolygonShape shape = new PolygonShape();
        shape.set(new Vector2[]{new Vector2(0,-h/2f), new Vector2(w,-h/2f), new Vector2(w,h/2f), new Vector2(0,h/2f)});
        return shape;
    }


}
