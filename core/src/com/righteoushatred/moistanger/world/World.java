package com.righteoushatred.moistanger.world;

import java.awt.Font;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.righteoushatred.moistanger.resources.Textures;

public class World {

	private ArrayList<PointOfInterest> pointOfInterests;
	
	private BitmapFont tempFont;

	public World() {
		
		pointOfInterests = new ArrayList<PointOfInterest>();
		
		for (int i = 0; i<10; i++) {
			
			PointOfInterest poi = new PointOfInterest();
			
			poi.setX((int) (Math.random()*2000));
			poi.setY((int) (Math.random()*2000));
			
			pointOfInterests.add(poi);
			
		}
		
		tempFont = new BitmapFont();
	}
	
	public void render(SpriteBatch batch, float worldOffset) {
		
		batch.draw(Textures.get("world"), 0 - worldOffset, 0);
		batch.draw(Textures.get("world"), 0 - worldOffset + Textures.get("world").getRegionWidth(), 0);
		
		PointOfInterest hoveredPOI = null;
		
		for (int i = 0; i<pointOfInterests.size(); i++) {
			if (pointOfInterests.get(i).getX() > worldOffset && pointOfInterests.get(i).getX() < worldOffset + Gdx.graphics.getWidth()) {
				batch.draw(Textures.get("pointofinterest"), pointOfInterests.get(i).getX() - worldOffset, pointOfInterests.get(i).getY());
			
				if ((Gdx.input.getX() + worldOffset) > pointOfInterests.get(i).getX()
						&& (Gdx.input.getX() + worldOffset) < pointOfInterests.get(i).getX() + Textures.get("pointofinterest").getRegionWidth()
						&& (Gdx.graphics.getHeight() - Gdx.input.getY()) > pointOfInterests.get(i).getY()
						&& (Gdx.graphics.getHeight() - Gdx.input.getY()) < pointOfInterests.get(i).getY() + Textures.get("pointofinterest").getRegionHeight())
					hoveredPOI = pointOfInterests.get(i);
			}
		}
		
		if (hoveredPOI != null) {
			batch.setColor(0,0,0,1);
			batch.draw(Textures.get("blank"), 0,0, 200, 300);
			
			batch.setColor(1,1,1,1);
			
			tempFont.draw(batch, hoveredPOI.getName(), 5, 290);
			tempFont.draw(batch, hoveredPOI.getDescription(), 5, 250, 200, -1, true);
		}
	
	}
	
	
}
