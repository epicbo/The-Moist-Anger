package com.righteoushatred.moistanger.combat;

import java.util.ArrayList;

public abstract class CombatEntity {
	private int basePhysique;
	private int baseNimbleness;
	private int baseJudgement;
	private int baseGlamour;
	private int baseInitiative;
	
	private ArrayList<CombatBuff> buffs;
	
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
	
	public int getPhysique() {
		return basePhysique + (int)calcStat("physique");
	}
	public int getNimbleness() {
		return baseNimbleness + (int)calcStat("nimbleness");
	}
	public int getJudgement() {
		return baseJudgement + (int)calcStat("judgement");
	}
	public int getGlamour() {
		return baseGlamour + (int)calcStat("glamour");
	}	
	
	public int getInitiative(){
		return baseInitiative + (int)calcStat("initiative");
	}
	
	public CombatBuff hasBuff( CombatBuff buff ) {
		return hasBuff( buff.getType(), buff.getSource() );
	}
	public CombatBuff hasBuff( String type ){
		return hasBuff( type, "" );
	}
	public CombatBuff hasBuff( String type, String Source ){
		for( CombatBuff b : buffs ){
			if( b.getType().equals(type) ){
				if( Source.equals("") ){
					return b;
				}
				else if( b.getSource().equals(Source) ){
					return b;
				}
			}
		}
		return null;
	}
	
	private double calcStat( String type ){
		double temp = 0;
		for( CombatBuff b : buffs ){
			if( b.getType().equals(type) ){
				temp += b.getStrength();
			}
		}
		return temp;
	}
	
	public void addBuff( CombatBuff buff ){
		if( buff.getStacking() ){
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
