package com.righteoushatred.moistanger;

import com.badlogic.gdx.Game;
import com.righteoushatred.moistanger.state.MainGameState;
import com.righteoushatred.moistanger.state.State;




public class MoistAngerGame extends Game {

	public static State STATE_MAIN_GAME;

	private State currentState;

	public void create() {

		STATE_MAIN_GAME = new MainGameState(this);

		setState(STATE_MAIN_GAME);
	}

	public void setState(State state) {

		setScreen(state);
	}

	public void dispose() {
		super.dispose();
	}

	public void render() {
		super.render();
	}

	public void resize(int width, int height) {
		super.resize(width, height);
	}

	public void pause() {
		super.pause();
	}

	public void resume() {
		super.resume();
	}
}
