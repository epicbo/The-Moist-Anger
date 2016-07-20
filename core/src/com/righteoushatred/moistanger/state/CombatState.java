package com.righteoushatred.moistanger.state;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.righteoushatred.moistanger.MoistAngerGame;
import com.righteoushatred.moistanger.combat.CombatCharacter;
import com.righteoushatred.moistanger.combat.CombatGrid;
import com.righteoushatred.moistanger.resources.Textures;

public class CombatState extends State {


	public MoistAngerGame game;

	private SpriteBatch batch;

	private CombatGrid grid;

	private CombatCharacter selectedCharacter;
	
	private BitmapFont tempFont;

	public CombatState(MoistAngerGame game) {
		this.game = game;

	}

	public void enter() {
		batch = new SpriteBatch();
		grid = new CombatGrid();
		tempFont = new BitmapFont();
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

		int squareSize = 96;

		batch.begin();


		for (int x = 0; x<grid.getPlayerCharacters().length; x++)
			for (int y = 0; y<grid.getPlayerCharacters()[0].length; y++) {

				batch.setColor(1, 1, 1, 1);

				batch.draw(Textures.get("square"), 111 + (squareSize*3 - squareSize*x), 250 + squareSize*y, squareSize, squareSize);

				if (grid.getPlayerCharacters()[x][y] != null) {

					if (selectedCharacter == grid.getPlayerCharacters()[x][y] && selectedCharacter != null)
						batch.setColor(1, 0.35f, 0.35f, 1);

					batch.draw(Textures.get(grid.getPlayerCharacters()[x][y].getTexture()), 111 + (squareSize*3.15f - squareSize*x), 250 + squareSize*(y + 0.15f), squareSize*0.7f, squareSize*0.7f);

				}
			}

		for (int x = 0; x<grid.getEnemyCharacters().length; x++)
			for (int y = 0; y<grid.getEnemyCharacters()[0].length; y++) {


				batch.setColor(1, 1, 1, 1);

				batch.draw(Textures.get("square"), 111 + (squareSize*5 + squareSize*x), 250 + squareSize*y, squareSize, squareSize);

				if (grid.getEnemyCharacters()[x][y] != null) {

					if (selectedCharacter == grid.getEnemyCharacters()[x][y] && selectedCharacter != null)
						batch.setColor(1, 0.35f, 0.35f, 1);

					batch.draw(Textures.get(grid.getEnemyCharacters()[x][y].getTexture()), 111 + (squareSize*5.15f + squareSize*x), 250 + squareSize*(y + 0.15f), squareSize*0.7f, squareSize*0.7f);

				}
			}
		
		if (selectedCharacter != null) {
			tempFont.draw(batch, "Physique: "+selectedCharacter.getPhysique(), Gdx.graphics.getWidth()-200, 150);
			tempFont.draw(batch, "Nibleness: "+selectedCharacter.getNimbleness(), Gdx.graphics.getWidth()-200, 130);
			tempFont.draw(batch, "Judgement: "+selectedCharacter.getJudgement(), Gdx.graphics.getWidth()-200, 110);
			tempFont.draw(batch, "Glamour: "+selectedCharacter.getGlamour(), Gdx.graphics.getWidth()-200, 90);
			
			tempFont.draw(batch, "Initiative: "+selectedCharacter.getInitiative(), Gdx.graphics.getWidth()-200, 50);
		}
		
		int initiativeListIconSize = 48;
		
		for (int i = 0; i<grid.getCharacters().size(); i++) {
			int index = (i + grid.currentCharacter) % grid.getCharacters().size();
			
			CombatCharacter cc = grid.getCharacters().get(index);
			
			batch.setColor(1,1,1,1);
			
			batch.draw(Textures.get(cc.getTexture()), 
					Gdx.graphics.getWidth()/2f - (initiativeListIconSize*grid.getCharacters().size())/2f + initiativeListIconSize*i,
					Gdx.graphics.getHeight() - 100,
					initiativeListIconSize, 
					initiativeListIconSize);
			
			if (i == 0)
				batch.setColor(0.5f, 1, 0.5f, 1);
			
			batch.draw(Textures.get("square"), 
					Gdx.graphics.getWidth()/2f - (initiativeListIconSize*grid.getCharacters().size())/2f + initiativeListIconSize*i,
					Gdx.graphics.getHeight() - 100,
					initiativeListIconSize, 
					initiativeListIconSize);
			
		}

		batch.end();
	}

	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		screenY = Gdx.graphics.getHeight() - screenY;

		int tileX = (int)((screenX - 111 + 96)/96f);
		int tileY = (int)((screenY - 250)/96f);

		if (tileY < 0 || tileY > 3 || tileX == 5)
			return false;

		if (tileX > 5 && tileX < 11) {
			tileX -= 6;

			selectedCharacter = grid.getEnemyCharacters()[tileX][tileY];

		} else if (tileX >= 0 && tileX <= 4) {
			tileX = 4 - tileX;

			selectedCharacter = grid.getPlayerCharacters()[tileX][tileY];
		}

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
