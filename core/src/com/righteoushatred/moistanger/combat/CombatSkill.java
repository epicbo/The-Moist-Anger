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
	CombatSkill(){
		effects = new ArrayList<CombatBuff>();
	}
	public void addEffect( CombatBuff effect ){
		effects.add( effect );
	}
	public Boolean update(){
		if( CurrentCooldown > 1 )
			CurrentCooldown--;
		else
			return true;
		return false;
	}
}
