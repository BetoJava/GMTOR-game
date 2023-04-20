package com.test;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Body;

public class InputManager  {


    private final KeyboardController controller;



    public InputManager() {
        controller = new KeyboardController();
    }

    public void processInput(Entity entity) {

        if (controller.left) {
            move(entity, -1, 0);

        } if (controller.right) {
            move(entity, 1, 0);

        } if (controller.up) {
            move(entity, 0, 1);

        } if (controller.down) {
            move(entity, 0, -1);
        }
        if(controller.rotationRight) {
            rotation(entity, -1);
        }
        if(controller.rotationLeft) {
            rotation(entity, 1);
        }
        if(controller.shoot) {
            shot(entity);
        }
    }

    public void shot(Entity entity) {
        entity.shot();
    }

    public void move(Entity entity, int x, int y) {
        Body body = entity.body;
        body.setTransform(body.getPosition().x + x*0.1f, body.getPosition().y + y*0.1f, body.getAngle());
        System.out.println(body.getPosition());
    }

    public void rotation(Entity entity, int x) {
        GameEngine.instance.map.camera.rotate(0.2f*x, 1, 0, 1);
        Body body = entity.body;
        body.setTransform(body.getPosition().x, body.getPosition().y, body.getAngle() + 0.2f*x);

    }

    public static void zoom(float x) {
        ((OrthographicCamera)GameEngine.instance.map.camera).zoom += x * 0.2f;
    }

    public KeyboardController getController() {
        return controller;
    }
}
