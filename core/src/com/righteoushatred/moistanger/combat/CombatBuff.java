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
	
	public void setSource( String source ){
		this.source = source;
	}
	public Boolean getStacking(){
		return stacking;
	}
	
	public String getType() {
		return type;
	}
	
	public double getStrength(){
		return strength;
	}
	
	public String getSource() {
		return source;
	}
	
	public void override( CombatBuff buff ){
		override( buff.strength, buff.duration );
	}
	public void override( double strength, int duration ){
		if( strength > this.strength ){
			this.strength = strength;
		}
		if( duration > this.duration ){
			this.duration = duration;
		}
	}
}
