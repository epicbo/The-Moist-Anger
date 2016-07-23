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
	private int minSanity;
	private int maxSanity;
	private int sanity;
	private int endurance;
}
