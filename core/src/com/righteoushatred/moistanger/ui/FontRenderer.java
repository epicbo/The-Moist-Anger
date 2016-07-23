package com.righteoushatred.moistanger.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FontRenderer {

	private static BitmapFont font = new BitmapFont();
	
	private static GlyphLayout glyphLayout = new GlyphLayout();
	
	
	
	public static float getTextWidth(String text) {
		glyphLayout.setText(font, text);
		return glyphLayout.width;
	}
	
	public static float getTextHeight(String text) {
		glyphLayout.setText(font, text);
		return glyphLayout.height;
	}
	
	public static void draw(SpriteBatch batch, String text, float x, float y) {
		draw(batch, text, x, y, false, 0);
	}
	
	public static void draw(SpriteBatch batch, String text, float x, float y, boolean centered) {
		draw(batch, text, x, y, centered, 0);
	}
	
	public static void draw(SpriteBatch batch, String text, float x, float y, boolean centered, float maxWidth) {
		font.draw(batch, text, x, y, maxWidth, centered ? 1 : -1, maxWidth != 0);
	}
}
