package com.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.util.HashMap;

public class FontManager {

    public static final Color red = new Color(0.65f, 0.125f, 0.125f, 1f);
    public static final Color blue = new Color(0.1f,0.2f,0.4f,1f);
    public static final Color gray = new Color(0.4f, 0.4f, 0.4f, 1f);
    public static final Color green = new Color(0.1f, 0.4f, 0.1f, 1f);

    public static HashMap<Integer, BitmapFont> firaFonts = new HashMap<>();

    public static void loadFonts() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/FiraSans-Black.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        for(int i = 16; i < 18; i+=8) {
            parameter.size = i;
            BitmapFont font = generator.generateFont(parameter);
            firaFonts.put(i,font);
        }
        generator.dispose();
    }

    public static BitmapFont firaFont(int size) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/FiraSans-Black.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();
        return font;

    }

    public static BitmapFont firaFont(int size, Color borderColor, int borderWidth) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/FiraSans-Black.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;
        parameter.borderWidth = borderWidth;
        parameter.borderColor = borderColor;
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();
        return font;

    }

}
