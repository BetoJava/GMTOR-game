package com.test;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;


public class KeyboardController implements InputProcessor {

    public boolean up, down, left, right, shoot, ability;
    public boolean rotationLeft, rotationRight;
    public boolean isMouse1Down, isMouse2Down, isMouse3Down;
    public boolean isDragged;
    public float scrolled;
    public boolean scrolling;
    public Vector2 mouseLocation = new Vector2(0, 0);

    public KeyboardController() {
    }


    public boolean keyDown(int keycode) {
        boolean keyProcessed = false;

        if(keycode == Keys.Z) {
            up = true;
            keyProcessed = true;
        }

        if(keycode == Keys.S) {
            down = true;
            keyProcessed = true;
        }

        if(keycode == Keys.Q) {
            left = true;
            keyProcessed = true;
        }

        if(keycode == Keys.D) {
            right = true;
            keyProcessed = true;
        }

        if(keycode == Keys.SPACE) {
            ability = true;
            keyProcessed = true;
        }

        if(keycode == Keys.O) {

        }

        if(keycode == Keys.A) {
            rotationLeft = true;
            keyProcessed = true;
        }

        if(keycode == Keys.E) {
            rotationRight = true;
            keyProcessed = true;
        }

        return keyProcessed;
    }

    @Override
    public boolean keyUp(int keycode) {
        boolean keyProcessed = false;
        if(keycode == Keys.Z) {
            up = false;
            keyProcessed = true;
        }

        if(keycode == Keys.S) {
            down = false;
            keyProcessed = true;
        }

        if(keycode == Keys.Q) {
            left = false;
            keyProcessed = true;
        }

        if(keycode == Keys.D) {
            right = false;
            keyProcessed = true;
        }

        if(keycode == Keys.SPACE) {
            ability = false;

            keyProcessed = true;
        }

        if(keycode == Keys.A) {
            rotationLeft = false;
            keyProcessed = true;
        }

        if(keycode == Keys.E) {
            rotationRight = false;
            keyProcessed = true;
        }

        return keyProcessed;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button == 0) {
            isMouse1Down = true;
            shoot = true;
            mouseLocation = new Vector2(screenX, screenY);
        } else if (button == 1) {
            GameEngine.instance.player.shotPerSecond += 1;
            isMouse2Down = true;
        } else if (button == 2) {
            isMouse3Down = true;
        }
        mouseLocation.x = screenX;
        mouseLocation.y = screenY;

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        isDragged = false;
        if (button == 0) {
            isMouse1Down = false;
            shoot = false;
        } else if (button == 1) {
            isMouse2Down = false;
        } else if (button == 2) {
            isMouse3Down = false;
        }
        mouseLocation.x = screenX;
        mouseLocation.y = screenY;
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        isDragged = true;
        mouseLocation.x = screenX;
        mouseLocation.y = screenY;
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        mouseLocation.x = screenX;
        mouseLocation.y = screenY;
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {

        InputManager.zoom(amountY);
        return false;
    }


}