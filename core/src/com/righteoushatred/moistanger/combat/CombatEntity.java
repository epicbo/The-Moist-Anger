package com.righteoushatred.moistanger.combat;

import java.util.ArrayList;

public abstract class CombatEntity {
	private int basePhysique;
	private int baseNimbleness;
	private int baseJudgement;
	private int baseGlamour;
	
	private int minSanity;
	private int maxSanity;
	private int sanity;
	
	private int baseInitiative;
	private int endurance;
	
	private ArrayList<CombatBuff> buffs;
	
	public CombatEntity(){
		this(1,1,1,1,1);
	}
	
	public CombatEntity(int basePhysique, int baseNimbleness,
			int baseJudgement, int baseGlamour,
			int baseInitiative) {
		buffs = new ArrayList<CombatBuff>();
		this.basePhysique = basePhysique;
		this.baseNimbleness = baseNimbleness;
		this.baseJudgement = baseJudgement;
		this.baseGlamour = baseGlamour;
		this.baseInitiative = baseInitiative;
	}
	
	public int physique() {
		return basePhysique + (int)calcStat("physique");
	}
	public int nimbleness() {
		return baseNimbleness + (int)calcStat("nimbleness");
	}
	public int judgement() {
		return baseJudgement + (int)calcStat("judgement");
	}
	public int glamour() {
		return baseGlamour + (int)calcStat("glamour");
	}	
	
	public int initiative(){
		return baseInitiative + (int)calcStat("initiative");
	}
	
	public CombatBuff hasBuff( CombatBuff buff ) {
		return hasBuff( buff.type(), buff.source() );
	}
	public CombatBuff hasBuff( String type ){
		return hasBuff( type, "" );
	}
	public CombatBuff hasBuff( String type, String Source ){
		for( CombatBuff b : buffs ){
			if( b.type().equals(type) ){
				if( Source.equals("") ){
					return b;
				}
				else if( b.source().equals(Source) ){
					return b;
				}
			}
		}
		return null;
	}
	
	private double calcStat( String type ){
		double temp = 0;
		for( CombatBuff b : buffs ){
			if( b.type().equals(type) ){
				temp += b.strength();
			}
		}
		return temp;
	}
	
	public void addBuff( CombatBuff buff ){
		if( buff.stacking() ){
			buffs.add(buff);
		}
		else{
			CombatBuff temp = hasBuff( buff );
			if( temp != null ){
				temp.override( buff );
			}
			else{
				buffs.add(buff);
			}
		}
	}
}
