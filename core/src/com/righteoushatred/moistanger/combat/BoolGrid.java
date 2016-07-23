package com.righteoushatred.moistanger.combat;

import com.righteoushatred.moistanger.Constants;

public class BoolGrid {
	private Boolean[][] grid;
	
	BoolGrid(){
		grid = new Boolean[Constants.gridx][Constants.gridy];
	}
	
	Boolean check( int x, int y ){
		if( x >= 0 && x < Constants.gridx &&
			y >= 0 && y < Constants.gridy ){
			return grid[x][y];
		}
		return false;
	}
	void set( int x, int y, Boolean value ){
		if( x >= 0 && x < Constants.gridx &&
			y >= 0 && y < Constants.gridy ){
			grid[x][y] = value;
		}
	}
}
