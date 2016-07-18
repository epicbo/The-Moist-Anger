package com.righteoushatred.moistanger.world;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.righteoushatred.moistanger.resources.Textures;

public class World {

	private ArrayList<PointOfInterest> pointOfInterests;

	public World() {
		
		pointOfInterests = new ArrayList<PointOfInterest>();
		
		for (int i = 0; i<10; i++) {
			
			PointOfInterest poi = new PointOfInterest();
			
			poi.setX((int) (Math.random()*2000));
			poi.setY((int) (Math.random()*2000));
			
			pointOfInterests.add(poi);
			
		}
	}
	
	public void render(SpriteBatch batch, float worldOffset) {
		
		batch.draw(Textures.get("world"), 0 - worldOffset, 0);
		batch.draw(Textures.get("world"), 0 - worldOffset + Textures.get("world").getRegionWidth(), 0);
		
		for (int i = 0; i<pointOfInterests.size(); i++) {
			if (pointOfInterests.get(i).getX() > worldOffset && pointOfInterests.get(i).getX() < worldOffset + Gdx.graphics.getWidth()) {
				batch.draw(Textures.get("pointofinterest"), pointOfInterests.get(i).getX() - worldOffset, pointOfInterests.get(i).getY());
			}
		}
	
	}
	
	
}
