package com.righteoushatred.moistanger.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;

public abstract class State implements Screen, InputProcessor {

	public abstract void enter();
	
	public abstract void leave();
	
	public abstract void update(float delta);
	
	public abstract void render();

	public State() {
	}
	
	public void show() {
		Gdx.input.setInputProcessor(this);
		enter();
	}

	public void render(float delta) {
		update(delta);
		render();
	}

	public void resize(int width, int height) {
		
	}

	public void pause() {
		
	}

	public void resume() {
		
	}

	public void hide() {
		leave();
	}

	public void dispose() {
		
	}

	public boolean keyDown(int keycode) {
		return false;
	}

	public boolean keyUp(int keycode) {
		return false;
	}

	public boolean keyTyped(char character) {
		return false;
	}

	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	public boolean scrolled(int amount) {
		return false;
	}
}
