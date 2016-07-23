package com.righteoushatred.moistanger.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.righteoushatred.moistanger.resources.Textures;



public class Window extends UIComponent {

	public Window(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}


	public void render(SpriteBatch batch, float x, float y) {

		if (!visible)
			return;

		batch.draw(Textures.get("ui_component_sw"),x,y,borderWidth,borderWidth);
		batch.draw(Textures.get("ui_component_c"),x+borderWidth, y+borderWidth, width - borderWidth*2, height - borderWidth*2);
		batch.draw(Textures.get("ui_component_ne"),x+width-borderWidth, y + height - borderWidth, borderWidth, borderWidth);


		/*
		batch.draw(Textures.get("ui_component_w"),x+width-borderWidth, y+borderWidth, borderWidth, height - borderWidth*2);
		batch.draw(Textures.get("ui_component_e"),x, y+borderWidth, borderWidth, height - borderWidth*2);
		batch.draw(Textures.get("ui_component_se"),x, y + height - borderWidth, borderWidth, borderWidth);
		batch.draw(Textures.get("ui_component_nw"),x+width-borderWidth, y, borderWidth, borderWidth);
		batch.draw(Textures.get("ui_component_n"),x+borderWidth, y, width - borderWidth*2, borderWidth);
		batch.draw(Textures.get("ui_component_s"),x+borderWidth, y + height - borderWidth, width - borderWidth*2, borderWidth);
		*/

		
		batch.draw(Textures.get("ui_component_e"),x + width - borderWidth, y + borderWidth, borderWidth, height - borderWidth*2);
		batch.draw(Textures.get("ui_component_w"),x, y+borderWidth, borderWidth, height - borderWidth*2);
		batch.draw(Textures.get("ui_component_nw"),x, y + height - borderWidth, borderWidth, borderWidth);
		batch.draw(Textures.get("ui_component_se"),x+width-borderWidth, y, borderWidth, borderWidth);
		batch.draw(Textures.get("ui_component_s"),x + borderWidth, y, width - borderWidth*2, borderWidth);
		batch.draw(Textures.get("ui_component_n"),x + borderWidth, y + height - borderWidth, width - borderWidth*2, borderWidth);

	}

	public boolean mousePressed(int button, int x, int y) {

		return false;
	}

	public boolean mouseReleased(int button, int x, int y) {

		return false;
	}

	public boolean mouseMoved(int button, int x, int y) {
		return false;
	}
}
