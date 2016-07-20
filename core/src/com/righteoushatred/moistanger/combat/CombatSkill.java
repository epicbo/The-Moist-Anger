package com.righteoushatred.moistanger.combat;

import java.util.ArrayList;

public class CombatSkill {
	private String name;
	private ArrayList<CombatBuff> effects;
	private double damageMultiplier;
	private double criticalModifier;
	private double accuracyModifier;
	private BoolGrid ActorPositions;
	private BoolGrid TargetPositions;
	private int Cooldown;
	private int CurrentCooldown;
	
	public CombatSkill(String name, ArrayList<CombatBuff> effects,
			double damageMultiplier, double criticalModifier,
			double accuracyModifier, BoolGrid actorPositions,
			BoolGrid targetPositions, int cooldown) {
		this.name = name;
		this.effects = effects;
		this.damageMultiplier = damageMultiplier;
		this.criticalModifier = criticalModifier;
		this.accuracyModifier = accuracyModifier;
		ActorPositions = actorPositions;
		TargetPositions = targetPositions;
		Cooldown = cooldown;
		
		CurrentCooldown = 0;
		
	}
	public Boolean update(){
		if( CurrentCooldown > 1 )
			CurrentCooldown--;
		else
			return true;
		return false;
	}
	public String getName() {
		return name;
	}
	public ArrayList<CombatBuff> getEffects() {
		return effects;
	}
	public double getDamageMultiplier() {
		return damageMultiplier;
	}
	public double getCriticalModifier() {
		return criticalModifier;
	}
	public double getAccuracyModifier() {
		return accuracyModifier;
	}
	public BoolGrid getActorPositions() {
		return ActorPositions;
	}
	public BoolGrid getTargetPositions() {
		return TargetPositions;
	}
	public int getCooldown() {
		return Cooldown;
	}
}
