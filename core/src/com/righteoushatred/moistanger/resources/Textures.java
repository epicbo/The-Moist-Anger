package com.righteoushatred.moistanger.resources;

import java.util.Hashtable;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Textures {

	private static Hashtable<String, TextureRegion> textures = new Hashtable<String, TextureRegion>(); 

	private static final String path = "";
	
	private static boolean initialized;

	public static TextureRegion get(String id) {

		if (!initialized) {
			init();
			initialized = true;
		}
		
		if (id == null || textures.get(id) == null) {
			System.out.println("Could not load texture: "+id);
			id = "error";
		}

		return textures.get(id);
	}

	public static void load(String id, String fileName) {
		load(id, fileName, 0,0,1,1);
	}
	
	public static void save(String id, TextureRegion region) {
		textures.put(id, region);
	}

	public static void load(String id, String fileName, float u1,float v1,float u2,float v2) {
		String filePath = path + fileName;
		Texture tex = new Texture(filePath);
		TextureRegion reg = new TextureRegion(tex, u1, v1, u2, v2);
		textures.put(id, reg);
	}

	public static void loadSpritesheet(String pref, String fileName, int spriteWidth, int spriteHeight, int width, int height) {
		String filePath = path + fileName;
		Texture texture = new Texture(filePath);


		for (int y = 0; y<height; y++) {
			for (int x = 0; x<width; x++) {

				textures.put(pref+Integer.toString(x)+","+Integer.toString(y), new TextureRegion(texture,
						x*spriteWidth/(float)texture.getWidth(), 
						y*spriteHeight/(float)texture.getHeight(),
						(x+1)*spriteWidth/(float)texture.getWidth(),
						(y+1)*spriteHeight/(float)texture.getHeight()
						));
			}
		}
	}
	
	public static void init() {

		load("error", "error.png");

		load("blank", "blank.png");
		
		load("pointofinterest", "pointofinterest.png");
		load("world_background", "world_background.png");
		
		load("square", "square.png");
		
		loadSpritesheet("creature","creatures.png",24,24,18,22);
		loadSpritesheet("world","world.png",24,24,55,39);
		loadSpritesheet("item","items.png",16,16,22,16);
		loadSpritesheet("fxs","fx24.png",24,24,10,20);
		loadSpritesheet("fxl","fx32.png",32,32,8,11);
	}
}
