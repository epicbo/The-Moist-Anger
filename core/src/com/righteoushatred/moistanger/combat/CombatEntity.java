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
	
	public int Physique() {
		return basePhysique + (int)CalcStat("physique");
	}
	
	public int Nimbleness() {
		return baseNimbleness + (int)CalcStat("nimbleness");
	}
	
	public int Judgement() {
		return baseJudgement + (int)CalcStat("judgement");
	}
	
	public int Glamour() {
		return baseGlamour + (int)CalcStat("glamour");
	}	
	
	public int Initiative(){
		return baseInitiative + (int)CalcStat("initiative");
	}
	
	public CombatBuff HasBuff( CombatBuff buff ) {
		return HasBuff( buff.Type(), buff.Source() );
	}
	
	public CombatBuff HasBuff( String type ){
		return HasBuff( type, "" );
	}
	
	public CombatBuff HasBuff( String type, String Source ){
		for( CombatBuff b : buffs ){
			if( b.Type().equals(type) ){
				if( Source.equals("") ){
					return b;
				}
				else if( b.Source().equals(Source) ){
					return b;
				}
			}
		}
		return null;
	}
	
	private double CalcStat( String type ){
		double temp = 0;
		for( CombatBuff b : buffs ){
			if( b.Type().equals(type) ){
				temp += b.Strength();
			}
		}
		return temp;
	}

	public void AddBuff( CombatBuff buff ){
		AddBuff( buff, false );
	}
	
	public void AddBuff( CombatBuff buff, Boolean stacking ){
		if( stacking ){
			buffs.add(buff);
		}
		else{
			CombatBuff temp = HasBuff( buff );
			if( temp != null ){
				temp.Override( buff );
			}
			else{
				buffs.add(buff);
			}
		}
	}
}
