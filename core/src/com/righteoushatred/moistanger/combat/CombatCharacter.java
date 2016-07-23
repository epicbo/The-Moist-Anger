package com.righteoushatred.moistanger.combat;

public class CombatCharacter extends CombatEntity {

	public CombatCharacter(int basePhysique, int baseNimbleness,
			int baseJudgement, int baseGlamour, int baseInitiative,
			int minSanity, int maxSanity) {
		super(basePhysique, baseNimbleness, baseJudgement, baseGlamour,
				baseInitiative);
		this.minSanity = minSanity;
		this.maxSanity = maxSanity;
		sanity = minSanity;
		endurance = 0;
	}
	public int getMinSanity() {
		return minSanity;
	}
	public int getMaxSanity() {
		return maxSanity;
	}
	public int getSanity() {
		return sanity;
	}
	public int getEndurance() {
		return endurance;
	}
	public void modifySanity( int amount ){
		sanity += amount;
		sanity = Math.max(minSanity, Math.min(maxSanity, sanity));
	}
	private int minSanity;
	private int maxSanity;
	private int sanity;
	private int endurance;
}
