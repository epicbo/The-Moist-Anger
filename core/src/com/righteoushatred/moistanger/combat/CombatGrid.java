package com.righteoushatred.moistanger.combat;

import java.util.ArrayList;
import java.util.Comparator;

import com.righteoushatred.moistanger.Constants;

public class CombatGrid {
	
	/**
	 * Stores which player-owned characters are currently occupying which tile. 
	 * The format is Tile[x][y], where x is which row the character is on, 0 being the front row closest to the enemy. 
	 * y is which position on the row the character is on.
	 */
	CombatCharacter[][] playerCharacters; 
	
	/**
	 * Stores which computer-owned characters are currently occupying which tile. 
	 * The format is Tile[x][y], where x is which row the character is on, 0 being the front row closest to the enemy. 
	 * y is which position on the row the character is on.
	 */
	CombatCharacter[][] enemyCharacters; 
	
	private ArrayList<CombatCharacter> characters;
	
	Comparator<CombatCharacter> initiativeSorter;
	
	//TODO make private
	public int currentCharacter;
	
	public CombatGrid() {
		
		playerCharacters = new CombatCharacter[Constants.gridx][Constants.gridy];
		enemyCharacters = new CombatCharacter[Constants.gridx][Constants.gridy];
		
		playerCharacters[0][0] = new CombatCharacter(1,1,1,1,1,1,1);
		playerCharacters[1][1] = new CombatCharacter(1,1,1,1,1,1,1);
		playerCharacters[2][2] = new CombatCharacter(1,1,1,1,1,1,1);
		playerCharacters[3][3] = new CombatCharacter(1,1,1,1,1,1,1);
		

		enemyCharacters[0][0] = new CombatCharacter(1,1,1,1,1,1,1);
		enemyCharacters[1][1] = new CombatCharacter(1,1,1,1,1,1,1);
		enemyCharacters[2][2] = new CombatCharacter(1,1,1,1,1,1,1);
		enemyCharacters[3][3] = new CombatCharacter(1,1,1,1,1,1,1);
		
		characters = new ArrayList<CombatCharacter>();
		
		characters.add(playerCharacters[0][0]);
		characters.add(playerCharacters[1][1]);
		characters.add(playerCharacters[2][2]);
		characters.add(playerCharacters[3][3]);

		characters.add(playerCharacters[0][0]);
		characters.add(playerCharacters[1][1]);
		characters.add(playerCharacters[2][2]);
		characters.add(playerCharacters[3][3]);
		
		initiativeSorter = new Comparator<CombatCharacter>() {
			
			@Override
			public int compare(CombatCharacter o1, CombatCharacter o2) {
				if (o1.getInitiative() > o2.getInitiative())
					return -1;
				else if (o1.getInitiative() < o2.getInitiative())
					return 1;
				else
					return 0;
			}
		};
		
		characters.sort(initiativeSorter);
		
		
	}

	public CombatCharacter[][] getPlayerCharacters() {
		return playerCharacters;
	}
	
	public CombatCharacter[][] getEnemyCharacters() {
		return enemyCharacters;
	}

	public ArrayList<CombatCharacter> getCharacters() {
		return characters;
	}
}
