package com.test;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import javax.swing.*;

public class Map {

    public World world = new World(new Vector2(0, 0), true);
    public Box2DDebugRenderer debugRenderer;

    public Camera camera;

    public Map() {
        camera = new OrthographicCamera(34, 19);
        camera.position.set(0,0, 0f);
        camera.update();

        debugRenderer = new Box2DDebugRenderer();

    }

    public void update(float delta) {
        world.step(delta, 6, 2);
        debugRenderer.render(world, camera.combined);
    }


}
