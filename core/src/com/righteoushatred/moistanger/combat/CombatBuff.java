package com.righteoushatred.moistanger.combat;

public class CombatBuff {
	private String type;
	private String source;
	private double strength;
	private int duration;

	public String Type() {
		return type;
	}
	
	public double Strength(){
		return strength;
	}
	
	public String Source() {
		return source;
	}
	
	public void Override( CombatBuff buff ){
		Override( buff.strength, buff.duration );
	}
	public void Override( double strength, int duration ){
		if( strength > this.strength ){
			this.strength = strength;
		}
		if( duration > this.duration ){
			this.duration = duration;
		}
	}
}
