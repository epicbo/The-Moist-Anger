package com.righteoushatred.moistanger.ui.component;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.episkbo.descend.FontRenderer;
import com.episkbo.descend.resources.Textures;

public class ScrollableList extends UIComponent {

	private String[] texts;

	private float itemHeight;

	private float itemWidth;

	private float scrollBarWidth;
	
	private int visibleItems;
	
	private int startPosition;
	
	public ScrollableList(float x, float y, float width, float itemHeight, int visibleItems) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.itemHeight = itemHeight;
		this.visibleItems = visibleItems;
		texts = new String[10];

		itemWidth = width - borderWidth*2 - scrollBarWidth;
		height = itemHeight * visibleItems + borderWidth*2;
		
	}


	public void render(SpriteBatch batch, float x, float y) {

		if (!visible)
			return;

		batch.draw(Textures.get("ui_component_sw"),x,y,borderWidth,borderWidth);
		batch.draw(Textures.get("ui_component_c"),x+borderWidth, y+borderWidth, width - borderWidth*2, height - borderWidth*2);
		batch.draw(Textures.get("ui_component_ne"),x+width-borderWidth, y + height - borderWidth, borderWidth, borderWidth);
		
		batch.draw(Textures.get("ui_component_e"),x+width-borderWidth, y+borderWidth, borderWidth, height - borderWidth*2);
		batch.draw(Textures.get("ui_component_w"),x, y+borderWidth, borderWidth, height - borderWidth*2);
		batch.draw(Textures.get("ui_component_nw"),x, y + height - borderWidth, borderWidth, borderWidth);
		batch.draw(Textures.get("ui_component_se"),x+width-borderWidth, y, borderWidth, borderWidth);
		batch.draw(Textures.get("ui_component_s"),x+borderWidth, y, width - borderWidth*2, borderWidth);
		batch.draw(Textures.get("ui_component_n"),x+borderWidth, y + height - borderWidth, width - borderWidth*2, borderWidth);

		for (int i = startPosition; i<startPosition+visibleItems; i++) {
			if (i < texts.length && texts[i] != null) {
				
				float tw = FontRenderer.getTextWidth(texts[i], 2, 1);
				float th = FontRenderer.getTextHeight(2);

				FontRenderer.renderText(batch, texts[i], (int)(x+itemWidth/2f-tw/2f), (int) (y + height - (i-startPosition)*itemHeight - itemHeight/2f-th/2f), 2, 1);
			}
		}
		
	}

	public boolean mousePressed(int button, int x, int y) {

		/*
		
		if (!(x > this.x + width || x < this.x || y > this.y + height || y < this.y)) {

			pressed = true;

			return true;
		}*/

		return false;
	}

	public boolean mouseReleased(int button, int x, int y) {

		/*
		if (!(x > this.x + width || x < this.x || y > this.y + height || y < this.y) && pressed) {

			pressed();
		}

		pressed = false;*/

		return false;
	}

	public boolean mouseMoved(int button, int x, int y) {
		return false;
	}

	public void setListData(String[] list) {
		texts = list;
	}
}
