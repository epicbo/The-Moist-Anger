package com.righteoushatred.moistanger.combat;

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
	
	public CombatGrid() {
		playerCharacters = new CombatCharacter[Constants.gridx][Constants.gridy];
		enemyCharacters = new CombatCharacter[Constants.gridx][Constants.gridy];
	}

	public CombatCharacter[][] getPlayerCharacters() {
		return playerCharacters;
	}
}
