package com.test;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class FontDisplay {

    public BitmapFont font;
    float scale = 0.01f;
    public static final String FONT_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789éèàïîöôüûäâëê][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";


    public FontDisplay() {
        font = FontManager.firaFont(150);
        font.setUseIntegerPositions(false);
        font.setColor(1f, 0f, 0f, 1f);

        font.getData().setScale(scale, scale);
        font.setColor(Color.BLACK);
    }

    public void draw(SpriteBatch batch, String text, float x, float y) {
        font.draw(batch, text, x, y);
    }

}
