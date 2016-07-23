package com.righteoushatred.moistanger.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Label extends UIComponent {

	protected String text;
	
	protected float r, g, b, a;
	
	protected boolean centered;
	
	public Label(String text, float x, float y) {
		this.x = x;
		this.y = y;
		this.text = text;
		r = g = b = 0.1f;
		a = 1;
		centered = true;
	}


	public void render(SpriteBatch batch, float x, float y) {
		
		if (!visible)
			return;
		
		if (text != null) {
			
			batch.setColor(r, g, b, a);
			float tw = FontRenderer.getTextWidth(text);
			float th = FontRenderer.getTextHeight(text);
			if (centered)
				FontRenderer.draw(batch, text, (int)(x+width/2f-tw/2f), (int)(y+height/2f-th/2f));
			else
				FontRenderer.draw(batch, text, x, (int)(y+height/2f-th/2f));
			batch.setColor(1,1,1,1);
		}
	}


	@Override
	public boolean mousePressed(int button, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean mouseReleased(int button, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean mouseMoved(int button, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}


	public void setColor(float r, float g, float b, int a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	public void setColor(Color color) {
		this.r = color.r;
		this.g = color.g;
		this.b = color.b;
		this.a = color.a;
	}


	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public boolean isCentered() {
		return centered;
	}

	public void setCentered(boolean centered) {
		this.centered = centered;
	}
}
