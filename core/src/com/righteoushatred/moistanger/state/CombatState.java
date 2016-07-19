package com.righteoushatred.moistanger.state;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.righteoushatred.moistanger.MoistAngerGame;
import com.righteoushatred.moistanger.combat.CombatGrid;

public class CombatState extends State {


	public MoistAngerGame game;
	
	private SpriteBatch batch;
	
	private ShapeRenderer shapeRenderer;
	
	private CombatGrid grid;

	public CombatState(MoistAngerGame game) {
		this.game = game;
		
	}

	public void enter() {
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
	}

	public void leave() {

	}

	public void update(float delta) {
		
		Gdx.graphics.setTitle("FPS: "+Gdx.graphics.getFramesPerSecond());
		
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//Draw background
		//Draw static-ui
		//Draw gridmap
			//Draw area textures
			//Draw ground effects
			//Draw entities
				//Hoovered Buff/Debuff list 
		//Draw initiative list
		//Draw active/next PLAYER unit UI
			//Portrait
			//Skill icons
				//Hoovered skill cards
			//Stats/Wounds/Etc
			
		
	}

	public void render() {
		
		int squareSize = 100;
		
		shapeRenderer.setAutoShapeType(true);
		shapeRenderer.begin();
		
		shapeRenderer.rect(50, 50, squareSize*4, squareSize*5);
		shapeRenderer.rect(50 + squareSize*5, 50, squareSize*4, squareSize*5);
		
		for (int i = 1; i<4; i++) {
			shapeRenderer.line(50 + squareSize*i, 50, 50 + squareSize*i, 50 + squareSize*5);
			shapeRenderer.line(50 + squareSize*(i+5), 50, 50 + squareSize*(i+5), 50 + squareSize*5);
		}
		
		for (int i = 1; i<5; i++) {
			shapeRenderer.line(50, 50 + squareSize*i, 50 + squareSize*4, 50 + squareSize*i);
			shapeRenderer.line(50 + squareSize*5, 50 + squareSize*i, 50 + squareSize*9, 50 + squareSize*i);
		}
		
		shapeRenderer.end();
		
		/*
		for (int x = 0; x<grid.getPlayerCharacters().length; x++)
			for (int y = 0; y<grid.getPlayerCharacters()[0].length; y++)
				;
		
		*/
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
