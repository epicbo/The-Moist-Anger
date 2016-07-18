package com.righteoushatred.moistanger.state;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.righteoushatred.moistanger.MoistAngerGame;

public class WorldState extends State {


	public MoistAngerGame game;

	public WorldState(MoistAngerGame game) {
		this.game = game;
		
	}

	public void enter() {

	}

	public void leave() {

	}

	public void update(float delta) {
		
		Gdx.graphics.setTitle("FPS: "+Gdx.graphics.getFramesPerSecond());
		
		
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	}

	public void render() {

	
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
