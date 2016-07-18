package com.righteoushatred.moistanger.state;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.righteoushatred.moistanger.MoistAngerGame;
import com.righteoushatred.moistanger.resources.Textures;
import com.righteoushatred.moistanger.world.World;

public class WorldState extends State {


	public MoistAngerGame game;
	
	private World world;

	private float worldOffset;
	
	private SpriteBatch batch;
	
	public WorldState(MoistAngerGame game) {
		this.game = game;
		
	}

	public void enter() {

		//TODO: Add world gen
		world = new World();
		batch = new SpriteBatch();
	}

	public void leave() {

	}

	public void update(float delta) {
		
		Gdx.graphics.setTitle("FPS: "+Gdx.graphics.getFramesPerSecond());
		
		
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			worldOffset += 15f;
			worldOffset %= Textures.get("world").getRegionWidth();
		}

	}

	public void render() {


		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		batch.begin();
		
		world.render(batch, worldOffset);
			
		batch.end();
	
	}

	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		return false;
	}

	public boolean touchUp(int screenX, int screenY, int pointer, int button) {

		if (super.touchUp(screenX, screenY, pointer, button))
			return true;


		return false;
	}

	public boolean keyDown(int keycode) {
		
		
		
		return false;
	}


	public boolean keyTyped(char character) {

		return false;
	}

	public boolean keyUp(int keycode) {
		
		return false;
	}


}
