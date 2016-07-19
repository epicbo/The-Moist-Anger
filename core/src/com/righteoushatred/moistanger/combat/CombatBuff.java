package com.righteoushatred.moistanger.combat;

public class CombatBuff {
	public CombatBuff(String type, String source, double strength, int duration, Boolean stacking ) {
		this.type = type;
		this.source = source;
		this.strength = strength;
		this.duration = duration;
		this.stacking = stacking;
	}
	
	private String type;
	private String source;
	private double strength;
	private int duration;
	private Boolean stacking;
	
	public void SetSource( String source ){
		this.source = source;
	}
	public Boolean Stacking(){
		return stacking;
	}
	
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
