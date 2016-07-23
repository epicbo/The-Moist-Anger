package com.righteoushatred.moistanger.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.righteoushatred.moistanger.resources.Textures;


public class TextField extends UIComponent {

	protected String text;

	protected float flashingSpeed;

	protected float flashingTimer;

	protected int maxTextLength;

	protected char pressedChar;


	public TextField(float x, float y, float width, float height, String text) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.text = text;

		flashingSpeed = 1;
		maxTextLength = 18;
	}


	public void update(float delta) {
		flashingTimer += delta;

		if (flashingTimer > flashingSpeed)
			flashingTimer -= flashingSpeed;

	}

	public void render(SpriteBatch batch, float x, float y) {

		if (!visible)
			return;

		batch.draw(Textures.get("ui_component_sw"),x, y, borderWidth, borderWidth);
		batch.draw(Textures.get("ui_component_n"),x+borderWidth, y, width - borderWidth*2, borderWidth);
		batch.draw(Textures.get("ui_component_nw"),x+width-borderWidth, y, borderWidth, borderWidth);
		batch.draw(Textures.get("ui_component_e"),x, y+borderWidth, borderWidth, height - borderWidth*2);
		batch.draw(Textures.get("ui_component_c2"),x+borderWidth, y+borderWidth, width - borderWidth*2, height - borderWidth*2);
		batch.draw(Textures.get("ui_component_w"),x+width-borderWidth, y+borderWidth, borderWidth, height - borderWidth*2);
		batch.draw(Textures.get("ui_component_se"),x, y + height - borderWidth, borderWidth, borderWidth);
		batch.draw(Textures.get("ui_component_s"),x+borderWidth, y + height - borderWidth, width - borderWidth*2, borderWidth);
		batch.draw(Textures.get("ui_component_ne"),x+width-borderWidth, y + height - borderWidth, borderWidth, borderWidth);

		float th = FontRenderer.getTextHeight(2);
		float tw = FontRenderer.getTextWidth(text, 2, 1);

		if (text != null) {

			batch.setColor(0.1f,0.1f,0.1f,1);
			FontRenderer.renderText(batch, text, (int) (x + borderWidth*2+5), (int) (y+height/2f-th/2f), 2, 1);
			batch.setColor(1,1,1,1);
		}

		if (isSelected() && flashingTimer <= flashingSpeed/2f) {

			batch.setColor(0.25f,0.25f,0.25f,1);
			batch.draw(Textures.get("ui_component_c"), x + borderWidth*2+5 + tw + 1, y+height/2f-(th*1.25f)/2f, 2*3, th*1.25f);
			batch.setColor(1,1,1,1);
		}
	}


	public boolean mousePressed(int button, int x, int y) {



		if (!(x > this.x + width || x < this.x || y > this.y + height || y < this.y)) {
			uiManager.setSelectedComponent(this);

			return true;
		}

		return false;
	}
	
	@Override
	public boolean keyTyped(char c) {

		if (isSelected()) {
			pressedChar = c;

			if (c == 8) { //Backspace
				if (text.length() > 0 ) {

					text = text.substring(0, text.length()-1);
				} 

			} else if (c >= 32 && c <= 122 && text.length() < maxTextLength) {

				text = text + Character.toString(c);
			}
		}

		return false;
	}

	public boolean mouseReleased(int button, int x, int y) {

		if (isSelected() && (x > this.x + width || x < this.x || y > this.y + height || y < this.y)) {
			uiManager.setSelectedComponent(null);
		}

		return false;
	}


	@Override
	public boolean mouseMoved(int button, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}


	public String getText() {
		return text;
	}
}
