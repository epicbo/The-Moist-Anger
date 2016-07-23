package com.righteoushatred.moistanger.ui.component;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.episkbo.descend.FontRenderer;

public class MultiLineLabel extends Label {

	private float maxWidth;
	
	public MultiLineLabel(String text, float x, float y, int scale, int spacing, float maxWidth) {
		super(text, x, y, scale, spacing);
		this.maxWidth = maxWidth;
		
		centered = false;
	}


	public void render(SpriteBatch batch, float x, float y) {
		
		if (!visible)
			return;
		
		if (text != null) {
			
			batch.setColor(r, g, b, a);
			float tw = FontRenderer.getTextWidth(text, scale, spacing);
			float th = FontRenderer.getTextHeight(scale);
			if (centered)
				FontRenderer.renderTextMultiLine(batch, text, (int)(x+width/2f-tw/2f), (int)(y+height/2f-th/2f), scale, spacing, maxWidth);
			else
				FontRenderer.renderTextMultiLine(batch, text, x, (int)(y+height/2f-th/2f), scale, spacing, maxWidth);
			
			batch.setColor(1,1,1,1);
		}
	}
}
