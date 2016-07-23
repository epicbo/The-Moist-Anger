package com.righteoushatred.moistanger.ui.component;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.episkbo.descend.resources.Textures;

public class Checkbox extends UIComponent {


	private boolean pressed;

	private boolean checked;

	public Checkbox(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		borderWidth = 2;
	}


	@Override
	public void render(SpriteBatch batch, float x, float y) {

		if (!visible)
			return;

		batch.draw(Textures.get("ui_component_sw"), x, y, borderWidth, borderWidth);
		batch.draw(Textures.get("ui_component_c"), x + borderWidth, y + borderWidth, width - borderWidth*2, height - borderWidth*2);
		batch.draw(Textures.get("ui_component_ne"), x+width-borderWidth, y + height - borderWidth, borderWidth, borderWidth);
		
		batch.draw(Textures.get("ui_component_e"), x + width - borderWidth, y + borderWidth, borderWidth, height - borderWidth*2);
		batch.draw(Textures.get("ui_component_w"), x, y + borderWidth, borderWidth, height - borderWidth*2);
		batch.draw(Textures.get("ui_component_nw"), x, y + height - borderWidth, borderWidth, borderWidth);
		batch.draw(Textures.get("ui_component_se"), x + width - borderWidth, y, borderWidth, borderWidth);
		batch.draw(Textures.get("ui_component_s"), x + borderWidth, y, width - borderWidth*2, borderWidth);
		batch.draw(Textures.get("ui_component_n"), x + borderWidth, y + height - borderWidth, width - borderWidth*2, borderWidth);

		batch.draw(Textures.get("ui_component_c"), x + borderWidth, y + borderWidth, width - borderWidth*2, height - borderWidth*2);
		
		
		if (checked) 
			batch.draw(Textures.get("ui_component_c2"), x + borderWidth*2, y + borderWidth*2, width - borderWidth*4, height - borderWidth*4);
			
		
	}

	@Override
	public boolean mousePressed(int button, int x, int y) {

		if (!(x > this.x + width || x < this.x || y > this.y + height || y < this.y)) {

			pressed = true;

			return true;
		}

		return false;
	}


	@Override
	public boolean mouseReleased(int button, int x, int y) {

		if (!(x > this.x + width || x < this.x || y > this.y + height || y < this.y) && pressed) {

			checked = !checked;
			pressed();
		}

		pressed = false;

		return false;
	}


	@Override
	public boolean mouseMoved(int button, int x, int y) {
		return false;
	}

	public void pressed() {
	}


	public boolean isChecked() {
		return checked;
	}

}
