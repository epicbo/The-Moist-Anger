package com.righteoushatred.moistanger.ui.component;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.episkbo.descend.FontRenderer;
import com.episkbo.descend.resources.Textures;


public class DropdownList extends UIComponent {

	private boolean pressed;

	private boolean listVisible;

	private String[] listOptions;

	private int selectedOption;

	private int hoveredOption = -1;

	public DropdownList(float x, float y, float width, float height, String[] text) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.listOptions = text;
	}


	@Override
	public void render(SpriteBatch batch, float x, float y) {

		if (!visible)
			return;

		batch.draw(Textures.get("ui_component_sw"), x, y, borderWidth, borderWidth);
		batch.draw(Textures.get("ui_component_c"), x+borderWidth, y+borderWidth, width - borderWidth*2, height - borderWidth*2);
		batch.draw(Textures.get("ui_component_ne"), x+width-borderWidth, y + height - borderWidth, borderWidth, borderWidth);

		if (pressed) {

			batch.draw(Textures.get("ui_component_w"), x + width - borderWidth, y + borderWidth, borderWidth, height - borderWidth*2);
			batch.draw(Textures.get("ui_component_e"), x, y + borderWidth, borderWidth, height - borderWidth*2);
			batch.draw(Textures.get("ui_component_se"), x, y + height - borderWidth, borderWidth, borderWidth);
			batch.draw(Textures.get("ui_component_nw"), x + width-borderWidth, y, borderWidth, borderWidth);
			batch.draw(Textures.get("ui_component_n"), x + borderWidth, y, width - borderWidth*2, borderWidth);
			batch.draw(Textures.get("ui_component_s"), x + borderWidth, y + height - borderWidth, width - borderWidth*2, borderWidth);
			
		} else {

			batch.draw(Textures.get("ui_component_e"), x + width - borderWidth, y + borderWidth, borderWidth, height - borderWidth*2);
			batch.draw(Textures.get("ui_component_w"), x, y + borderWidth, borderWidth, height - borderWidth*2);
			batch.draw(Textures.get("ui_component_nw"), x, y + height - borderWidth, borderWidth, borderWidth);
			batch.draw(Textures.get("ui_component_se"), x + width-borderWidth, y, borderWidth, borderWidth);
			batch.draw(Textures.get("ui_component_s"), x + borderWidth, y, width - borderWidth*2, borderWidth);
			batch.draw(Textures.get("ui_component_n"), x + borderWidth, y + height - borderWidth, width - borderWidth*2, borderWidth);
		}


		float tw = FontRenderer.getTextWidth(listOptions[selectedOption], 2, 1);
		float th = FontRenderer.getTextHeight(2);
		
		FontRenderer.renderText(batch, listOptions[selectedOption], x+width/2f-tw/2f, y+height/2f-th/2f, 2, 1);

		if (listVisible)
			for (int i = 0; i<listOptions.length; i++) {
				tw = FontRenderer.getTextWidth(listOptions[i], 2, 1);

				if (i == hoveredOption)
					batch.draw(Textures.get("ui_component_n"), x, y - height*(i+1), width, height);
				else
					batch.draw(Textures.get("ui_component_c2"), x, y - height*(i+1), width, height);

				FontRenderer.renderText(batch, listOptions[i], x + width/2f - tw/2f, y + height/2f - th/2f - (i+1)*height, 2, 1);
			}


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

		if (listVisible) {
			listVisible = false;
			pressed = false;


			for (int i = 0; i<listOptions.length; i++) {

				if (x >= this.x && x <= this.x + width && y >= this.y - height*(i+1) && y < this.y - height*i)
					selectedOption = i;
			}
		}	

		if (!(x > this.x + width || x < this.x || y > this.y + height || y < this.y) && pressed) {

			listVisible = true;
		}
		else
			pressed = false;



		return false;
	}


	@Override
	public boolean mouseMoved(int button, int x, int y) {

		hoveredOption = -1;

		for (int i = 0; i<listOptions.length; i++) {

			if (x >= this.x && x <= this.x + width && y >= this.y - height*(i+1) && y < this.y - height*i)
				hoveredOption = i;
		}

		return false;
	}
	
	public int getSelectedOptionID() {
		return selectedOption;
	}

	
	public void pressed() {
	}


}
