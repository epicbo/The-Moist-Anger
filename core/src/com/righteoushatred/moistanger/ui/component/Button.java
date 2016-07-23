package com.righteoushatred.moistanger.ui.component;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.episkbo.descend.FontRenderer;
import com.episkbo.descend.resources.Textures;



public class Button extends UIComponent {

	private String text;

	private boolean pressed;


	public Button(float x, float y, float width, float height, String text) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.text = text;
	}


	public void render(SpriteBatch batch, float x, float y) {

		if (!visible)
			return;

		batch.draw(Textures.get("ui_component_sw"),x,y,borderWidth,borderWidth);
		batch.draw(Textures.get("ui_component_c"),x+borderWidth, y+borderWidth, width - borderWidth*2, height - borderWidth*2);
		batch.draw(Textures.get("ui_component_ne"),x+width-borderWidth, y + height - borderWidth, borderWidth, borderWidth);

		if (pressed) {

			batch.draw(Textures.get("ui_component_w"),x+width-borderWidth, y+borderWidth, borderWidth, height - borderWidth*2);
			batch.draw(Textures.get("ui_component_e"),x, y+borderWidth, borderWidth, height - borderWidth*2);
			batch.draw(Textures.get("ui_component_se"),x, y + height - borderWidth, borderWidth, borderWidth);
			batch.draw(Textures.get("ui_component_nw"),x+width-borderWidth, y, borderWidth, borderWidth);
			batch.draw(Textures.get("ui_component_n"),x+borderWidth, y, width - borderWidth*2, borderWidth);
			batch.draw(Textures.get("ui_component_s"),x+borderWidth, y + height - borderWidth, width - borderWidth*2, borderWidth);
		} else {

			batch.draw(Textures.get("ui_component_e"),x+width-borderWidth, y+borderWidth, borderWidth, height - borderWidth*2);
			batch.draw(Textures.get("ui_component_w"),x, y+borderWidth, borderWidth, height - borderWidth*2);
			batch.draw(Textures.get("ui_component_nw"),x, y + height - borderWidth, borderWidth, borderWidth);
			batch.draw(Textures.get("ui_component_se"),x+width-borderWidth, y, borderWidth, borderWidth);
			batch.draw(Textures.get("ui_component_s"),x+borderWidth, y, width - borderWidth*2, borderWidth);
			batch.draw(Textures.get("ui_component_n"),x+borderWidth, y + height - borderWidth, width - borderWidth*2, borderWidth);
		}

		if (text != null) {

			float tw = FontRenderer.getTextWidth(text, 2, 1);
			float th = FontRenderer.getTextHeight(2);
			float offset = 0;

			if (pressed)
				offset = 2;

			FontRenderer.renderText(batch, text, (int)(x+width/2f-tw/2f+offset), (int)(y+height/2f-th/2f-offset), 2, 1);

		}
	}

	public boolean mousePressed(int button, int x, int y) {
		
		if (!(x > this.x + width || x < this.x || y > this.y + height || y < this.y)) {

			pressed = true;

			return true;
		}

		return false;
	}


	public boolean mouseReleased(int button, int x, int y) {

		if (!(x > this.x + width || x < this.x || y > this.y + height || y < this.y) && pressed) {

			pressed();
		}

		pressed = false;

		return false;
	}


	public boolean mouseMoved(int button, int x, int y) {
		return false;
	}

	public void pressed() {
	}

}
