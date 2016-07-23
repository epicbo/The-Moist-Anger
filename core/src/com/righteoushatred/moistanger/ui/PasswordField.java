package com.righteoushatred.moistanger.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.righteoushatred.moistanger.resources.Textures;

public class PasswordField extends TextField {

	public PasswordField(float x, float y, float width, float height, String text) {
		
		super(x, y, width, height, text);
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
		
		String str = "";

		if (text != null)
			for (int i = 0; i<text.length(); i++)
				str += "*";

		float th = FontRenderer.getTextHeight(2);
		float tw = FontRenderer.getTextWidth(str, 2, 1);

		if (text != null) {
			
			batch.setColor(0.1f,0.1f,0.1f,1);
			FontRenderer.renderText(batch, str, (int) (x + borderWidth*2+5), (int) (y+height/2f-th/2f), 2, 1);
			batch.setColor(1,1,1,1);
		}
		
		if (isSelected() && flashingTimer <= flashingSpeed/2f) {
			
			batch.setColor(0.25f,0.25f,0.25f,1);
			batch.draw(Textures.get("ui_component_c"), x + borderWidth*2+5 + tw + 1, y+height/2f-(th*1.25f)/2f, 2*3, th*1.25f);
			batch.setColor(1,1,1,1);
		}
	}
}