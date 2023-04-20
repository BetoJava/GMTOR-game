package com.test.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.test.TestScript;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		configure(config);
		new LwjglApplication(new TestScript(), config);
	}

	private static void configure(LwjglApplicationConfiguration config) {
		config.title = "GMTOR";
		config.width = 1700;
		config.height = 950;
		config.x = 80;
		config.y = 0;
	}
}
