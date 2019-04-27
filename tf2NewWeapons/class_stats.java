//class that contains all possible weapon stats, each weapon should pull one stat from each "sector"

import java.util.Random;

public class class_stats {

	String[] stats_good = new String[128];
	int[]    value_good = new int[128];
	int[]    weight_gd  = new int[128];
	int sum_weight_good = 0;

	String[] stats_bad  = new String[128];
	int[]    value_bad  = new int[128];
	int[]    weight_bd  = new int[128];
	int sum_weight_bad = 0;

	int weightLimit = 7;

	int classID;
	int weaponID;

	boolean catSuperSpecialG;
	boolean catSuperSpecialB;
	boolean catSpecial;
	boolean catDamage;
	boolean catResist;
	boolean catRage;
	boolean catPhysical;
	boolean catReward;

	int i = 0;

	class_stats() {
		for (int i = 0; i < 128; i++) {

			stats_good[i] = "";
			value_good[i] = 0;
			weight_gd[i] = 0;

			stats_bad[i] = "";
			value_bad[i] = 0;
			weight_bd[i] = 0;
		}
	}
	
	public void initialize() {

		sum_weight_bad = 0;
		sum_weight_good = 0;
		
		catSuperSpecialG = randBoolL(2);
		catSuperSpecialB = randBoolL(2);
		catSpecial = randBoolL(5);
		catDamage = randBoolL(60);
		catResist = randBoolL(10);
		catRage = randBoolL(10);
		catPhysical = randBoolL(20);
		catReward = randBoolL(30);

		classID();
		weaponID();

		value_good(value_good);
		value_bad(value_bad);

		weight_gd(weight_gd, value_good);
		weight_bd(weight_bd, value_bad);

		stats_good(stats_good, value_good);
		stats_bad(stats_bad, value_bad);
	}

	//creates a random integer when called on
	public int randInt(int lower, int upper, int subdiv) { //upper must be >5 of actuall limit
		Random r = new Random();
		return (r.nextInt((upper - lower) / subdiv) + (lower / subdiv)) * subdiv;
	}

	public int randInt(int lower, int upper) { //upper must be >5 of actuall limit, subdiv implied to be 5
		Random r = new Random();
		return (r.nextInt((upper - lower) / 5) + (lower / 5)) * 5;
	}

	public boolean randBoolL(int chance) {
		Random r = new Random();

		if (r.nextInt(99) + 1 < chance) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean randBoolH(int chance) {
		Random r = new Random();

		if (r.nextInt(99) + 1 > chance) {
			return true;
		}
		else {
			return false;
		}
	}

	public void classID() {
		Random r = new Random();
		classID = r.nextInt(8);
	}

	public void weaponID() {
		Random r = new Random();
		weaponID = r.nextInt(3)+1;
	}


	//-------------------------------------------------------------//

	//Text messages for the different stats

	//POSTIVE STATS

	public void stats_good(String[] stat, int[] val) {

		//A single option from each category
		//chances of being used are listed next to the descriptor

		//weapon & damage stats - 60%
		stat[0] = val[0] + "% more damage\n";
		stat[1] = val[1] + "% faster firing speed\n";
		stat[2] = val[2] + "% larger clip size\n";
		stat[3] = val[3] + "% faster switch speed\n";
		stat[3] = val[4] + "% faster reload speed\n";
		
		//resistance stats - 10%
		stat[5] = val[5] + "% resistance to fire damage\n";
		stat[6] = val[6] + "% resistance to bullet damage\n";
		stat[7] = val[7] + "% resistance to explosion damage\n";
		stat[8] = val[8] + "% resistance to all damage sources\n";
		stat[9] = val[9] + "% resistance to sentry guns\n";

		//rage stats - only for soldier secondary weapons - 10%
		stat[10] = "rage provides a minicrit buff for " + val[10] + " seconds\n";
		stat[11] = "rage provides a defensive buff for " + val[11] + " seconds\n";
		stat[12] = "rage provides healing for " + val[12] + " seconds\n";
		stat[13] = "rage provides a speed boost for " + val[13] + " seconds\n";
		stat[14] = "rage causes extra knockback on enemies for " + val[14] + " seconds\n";

		//physical stats - 20%
		stat[15] = val[15] + "% faster movespeed\n";
		stat[16] = val[16] + "% faster movespeed while equipped\n";
		stat[17] = val[17] + "% more max ammo\n";
		stat[18] = val[18] + "% more max ammo\n";
		stat[19] = "+" + val[19] + "% max health\n";

		//reward stats - 30%
		stat[20] = "minicrits on kill for " + val[20] + " seconds\n";
		stat[21] = "crits on kill for " + val[21] + " seconds\n";
		stat[22] = val[22] + " health on kill\n";
		stat[23] = val[23] + " health on hit\n";
		stat[24] = "+" + val[24] + "% max health on kill\n";


		//class unique attribute stats //0 - physical, 1 - primary, 2 - secondary, 3 - melee, 4 - extra weapon
		//these stats have a 5% chance of being used

		//scout
		stat[25] = "";
		stat[26] = "";
		stat[27] = "";
		stat[28] = "";
		stat[29] = "";

		//soldier
		stat[30] = val[30] + "% less self rocket damage\n";
		stat[31] = val[31] + "% faster projectile speed\n";
		stat[32] = "";
		stat[33] = "";
		stat[34] = "";

		//pyro
		stat[35] = "";
		stat[36] = val[36] + "% more afterburn damage\n";
		stat[37] = "Burning enemies recieve minicrits\n";
		stat[38] = "can remove sappers\n";
		stat[39] = "";

		//demoman
		stat[40] = "";
		stat[41] = val[41] + "% faster projectile speed\n";
		stat[42] = val[42] + "% more stickybombs\n";
		stat[43] = "";
		stat[44] = "";

		//heavy
		stat[45] = val[45] + "% faster movespeed while revved\n";
		stat[46] = val[46] + "% faster rev speed\n";
		stat[47] = "";
		stat[48] = "";
		stat[49] = "";

		//engineer
		stat[50] = val[50] + "% more building health\n";
		stat[51] = "";
		stat[52] = "";
		stat[53] = val[53] + "% faster build speed\n";
		stat[54] = "";

		//medic
		stat[55] = val[55] + "% more self healing per second\n";
		stat[56] = "";
		stat[57] = "+" + val[57] + "% healing on paitient\n";
		stat[58] = "";
		stat[59] = "";

		//sniper
		stat[60] = "Headshots on wearer deal " + val[60] + "% less damage\n";
		stat[61] = "";
		stat[62] = "";
		stat[63] = "";
		stat[64] = "";

		//spy
		stat[65] = "";
		stat[66] = val[65] + "% longer charge on invis watch\n";
		stat[67] = "";
		stat[68] = val[69] + "% faster recharge on invis watch\n";
		stat[69] = "";


	}

	//Random values for each stat
	public void value_good(int[] val) {

		//damage values
		for (int i = 0; i < 5; i++) {
			val[i] = randInt(10, 55);
		}

		//resistance values
		for (int i = 5; i < 10; i++) {
			val[i] = randInt(10, 35);
		}

		//rage values - only for secondary weapons
		for (int i = 10; i < 15; i++) {
			val[i] = randInt(8, 16, 1);
		}

		//physical values
		for (int i = 15; i < 20; i++) {
			val[i] = randInt(10, 35);
		}

		//reward values
		for (int i = 20; i < 22; i++) {
			val[i] = randInt(8, 16, 1);
		}
		for (int i = 22; i < 25; i++) {
			val[i] = randInt(5, 15);
		}

		//class special attribute values
		for (int i = 25; i < 70; i++) {
			val[i] = randInt(10, 55);
		}
	}

	public void weight_gd(int[] weight, int[] val) {

		//damage weights
		for (int i = 0; i < 5; i++) {
			weight[i] = val[i] / 5;
		}

		//resistance weights
		for (int i = 5; i < 10; i++) {
			weight[i] = val[i] / 5 * 2;
		}

		//rage weights - only for secondary weapons
		for (int i = 10; i < 15; i++) {
			weight[i] = 2;
		}

		//physical weights
		for (int i = 15; i < 20; i++) {
			weight[i] = val[i] / 5 * 3;
		}

		//reward weights
		for (int i = 20; i < 25; i++) {
			weight[i] = 4;
		}

		//class special attribute weights
		for (int i = 25; i < 70; i++) {
			weight[i] = 0;
		}
	}

	//NEGATIVE STATS

	public void stats_bad(String[] stat, int[] val) {

		//A single option from each category
		//chances of being used are listed next to the descriptor

		//weapon & damage stats - 60%
		stat[0] = val[0] + "% less damage\n";
		stat[1] = val[1] + "% slower firing speed\n";
		stat[2] = val[2] + "% smaller clip size\n";
		stat[3] = val[3] + "% slower switch speed\n";
		stat[3] = val[4] + "% slower reload speed\n";
		
		//resistance stats - 10%
		stat[5] = val[5] + "% vulnerability to fire damage\n";
		stat[6] = val[6] + "% vulnerability to bullet damage\n";
		stat[7] = val[7] + "% vulnerability to explosion damage\n";
		stat[8] = val[8] + "% vulnerability to all damage sources\n";
		stat[9] = val[9] + "% vulnerability to sentry guns\n";

		//rage stats - unused - 0%
		stat[10] = "";
		stat[11] = "";
		stat[12] = "";
		stat[13] = "";
		stat[14] = "";

		//physical stats - 20%
		stat[15] = val[15] + "% slower movespeed\n";
		stat[16] = val[16] + "% slower movespeed while equipped\n";
		stat[17] = val[17] + "% less max ammo\n";
		stat[18] = val[18] + "% less max ammo\n";
		stat[19] = "-" + val[19] + "% max health\n";

		//reward stats - unused - 0%
		stat[20] = "";
		stat[21] = "";
		stat[22] = "";
		stat[23] = "";
		stat[24] = "";


		//class unique attribute stats //0 - physical, 1 - primary, 2 - secondary, 3 - melee, 4 - extra weapon
		//these stats have a 5% chance of being used

		//scout
		stat[25] = "wearer cannot double jump\n";
		stat[26] = "";
		stat[27] = "";
		stat[28] = "";
		stat[29] = "";

		//soldier
		stat[30] = val[30] + "% more self rocket damage\n";
		stat[31] = val[31] + "% slower projectile speed\n";
		stat[32] = "";
		stat[33] = "";
		stat[34] = "";

		//pyro
		stat[35] = "";
		stat[36] = val[36] + "% less afterburn damage\n";
		stat[37] = "";
		stat[38] = "";
		stat[39] = "";

		//demoman
		stat[40] = "";
		stat[41] = val[41] + "% slower projectile speed\n";
		stat[42] = val[42] + "% fewer stickybombs\n";
		stat[43] = "";
		stat[44] = "";

		//heavy
		stat[45] = val[45] + "% slower movespeed while revved\n";
		stat[46] = val[46] + "% slower rev speed\n";
		stat[47] = "";
		stat[48] = "";
		stat[49] = "";

		//engineer
		stat[50] = val[50] + "% less building health\n";
		stat[51] = "";
		stat[52] = "";
		stat[53] = val[53] + "% slower build speed\n";
		stat[54] = "";

		//medic
		stat[55] = val[55] + "% less self healing per second\n";
		stat[56] = "";
		stat[57] = "Medigun has new effect; does not make users invincible.\n";
		stat[58] = "";
		stat[59] = "";

		//sniper
		stat[60] = val[60] + "% more headshot damage on wearer\n";
		stat[61] = "";
		stat[62] = "";
		stat[63] = "";
		stat[64] = "";

		//spy
		stat[65] = "";
		stat[66] = val[65] + "% shorter charge on invis watch\n";
		stat[67] = "";
		stat[68] = val[69] + "% slower recharge on invis watch\n";
		stat[69] = "";
	}

	//Random values for each stat
	public void value_bad(int[] val) {

		//damage values
		for (int i = 0; i < 5; i++) {
			val[i] = randInt(10, 55);
		}

		//resistance values
		for (int i = 5; i < 10; i++) {
			val[i] = randInt(10, 35);
		}

		//rage values - only for secondary weapons
		for (int i = 10; i < 15; i++) {
			val[i] = randInt(8, 16, 1);
		}

		//physical values
		for (int i = 15; i < 20; i++) {
			val[i] = randInt(10, 35);
		}

		//reward values
		for (int i = 20; i < 22; i++) {
			val[i] = randInt(8, 16, 1);
		}
		for (int i = 22; i < 25; i++) {
			val[i] = randInt(5, 15);
		}

		//class special attribute values
		for (int i = 25; i < 70; i++) {
			val[i] = randInt(10, 55);
		}
	}

	public void weight_bd(int[] weight, int[] val) {

		//damage weights
		for (int i = 0; i < 5; i++) {
			weight[i] = val[i] / 5;
		}

		//resistance weights
		for (int i = 5; i < 10; i++) {
			weight[i] = val[i] / 5 * 2;
		}

		//rage weights - only for secondary weapons
		for (int i = 10; i < 15; i++) {
			weight[i] = 2;
		}

		//physical weights
		for (int i = 15; i < 20; i++) {
			weight[i] = val[i] / 5 * 3;
		}

		//reward weights
		for (int i = 20; i < 25; i++) {
			weight[i] = 4;
		}

		//class special attribute weights
		for (int i = 25; i < 70; i++) {
			weight[i] = 0;
		}
		
	}

	public void checkBalance() {
		do {



			initialize();

			if (catSpecial) {
				sum_weight_good += weight_gd[25];
			}
		
			//weapon & damage stats - 60%
			if (catDamage && weaponID != 3 && (classID != 4 && weaponID != 1) && (classID != 6 && weaponID != 2)) {
				sum_weight_good += weight_gd[0];
			}

			//resistance - 10%
			if (catResist) {
				sum_weight_good += weight_gd[5];
			}

			//rage - 10%
			if (catRage && classID == 1 && weaponID == 2) {
				sum_weight_good += weight_gd[10];
			}

			//physical - 20%
			if (catPhysical) {
				sum_weight_good += weight_gd[15];
			}

			//reward - 30%
			if (catReward && (classID != 6 && weaponID != 2)) {
				sum_weight_good += weight_gd[20];
			}

			//-

			//Special attribute - 5%
			if (!catSpecial) {
				sum_weight_bad += weight_bd[25];
			}

			//weapon & damage stats - 60%
			if (catDamage && weaponID != 3 && (classID != 4 && weaponID != 1) && (classID != 6 && weaponID != 2)) {
				sum_weight_bad += weight_bd[0];
			}

			//resistance - 10%
			if (!catResist) {
				sum_weight_bad += weight_bd[5];
			}

			//rage - 0%
			if (false) {
				sum_weight_bad += weight_bd[10];
			}

			//physical - 20%
			if (!catPhysical) {
				sum_weight_bad += weight_bd[15];
			}

			//reward - 0%
			if (false) {
				sum_weight_bad += weight_bd[20];
			}

			if (i > 50) {
				break;
			}

			i++;

		} while ((sum_weight_bad > (sum_weight_good + weightLimit)) || (sum_weight_good > (sum_weight_bad + weightLimit)));

	}

	public void weaponStats(String[] statG, String[] statB) {

		System.out.print("Looking for balanced weapon stats...\n");

		checkBalance();

		System.out.print("\nslot " + (weaponID) + " for ");

		switch(classID) {
			case 0:
				System.out.print("scout\n\n");
				break;
			case 1:
				System.out.print("soldier\n\n");
				break;
			case 2:
				System.out.print("pyro\n\n");
				break;
			case 3:
				System.out.print("demoman\n\n");
				break;
			case 4:
				System.out.print("heavy\n\n");
				break;
			case 5:
				System.out.print("engineer\n\n");
				break;
			case 6:
				System.out.print("medic\n\n");
				break;
			case 7:
				System.out.print("sniper\n\n");
				break;
			case 8:
				System.out.print("spy\n\n");
				break;
		}

		//+

		//Special attribute - 5%
		if (catSpecial) {
			System.out.print(statG[(weaponID + 25) + (classID * 5)]);
		}
		if (catSuperSpecialG) {
			System.out.print(statG[25 + (classID * 5)]);
		}

		//weapon & damage stats - 60%
		if (catDamage && weaponID != 3 && (classID != 4 && weaponID != 1) && (classID != 6 && weaponID != 2)) {
			System.out.print(statG[randInt(0, 5, 1)]);
		}

		//resistance - 10%
		if (catResist) {
			System.out.print(statG[randInt(5, 10, 1)]);
		}

		//rage - 10%
		if (catRage && classID == 1 && weaponID == 2) {
			System.out.print(statG[randInt(10, 15, 1)]);
		}

		//physical - 20%
		if (catPhysical) {
			System.out.print(statG[randInt(15, 20, 1)]);
		}

		//reward - 30%
		if (catReward && (classID != 6 && weaponID != 2)) {
			System.out.print(statG[randInt(20, 25, 1)]);
		}

		//Make the weapon balanced, if it's not.
		if (sum_weight_bad > sum_weight_good + 5) {
			System.out.print("always crits\n");
		}

		//-

		System.out.println("");

		//Special attribute - 5%
		if (!catSpecial) {
			System.out.print(statB[randInt(25, 30, 1) + (classID * 5)]);
		}
		if (catSuperSpecialB) {
			System.out.print(statB[25 + (classID * 5)]);
		}

		//weapon & damage stats - 60%
		if (catDamage && weaponID != 3 && (classID != 4 && weaponID != 1) && (classID != 6 && weaponID != 2)) {
			System.out.print(statB[randInt(0, 5, 1)]);
		}

		//resistance - 10%
		if (!catResist) {
			System.out.print(statB[randInt(5, 10, 1)]);
		}

		//rage - 0%
		if (false) {
			System.out.print(statB[randInt(10, 15, 1)]);
		}

		//physical - 20%
		if (!catPhysical) {
			System.out.print(statB[randInt(15, 20, 1)]);
		}

		//reward - 0%
		if (false) {
			System.out.print(statB[randInt(20, 25, 1)]);
		}

		if (sum_weight_bad + 5 < sum_weight_good) {
			System.out.print("no random crits\n");
		}

		System.out.println("\nWeapon balance rating: " + (sum_weight_good - sum_weight_bad));
	}
}