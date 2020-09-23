import java.util.Random;

public class Character {
	
	String name;
	int life = 0;
	int life_init = 0;
	int atk = 0;
	int atk_init = 0;
	int gold = 0;
	int exp = 0;

	
	public void setLife (String name, int life, int atk) {
		this.name = name;
		this.life = life;
		this.atk = atk;
		
		this.life_init = this.life;
		this.atk_init = this.atk;

	}
	
	public void status () {
		Terminal.ecrireStringln("Je suis " + this.name + " .");
		Terminal.ecrireStringln("J'ai " + this.life + " point de vie.");
		Terminal.ecrireStringln("J'ai " + this.atk + " point d'attaque.");
	}
	
	public int heal() {
		int life_healed = 2;
		this.life = this.life + 2;
		
		return life_healed;
	}
	
	public int attaque () {
		this.life = (this.life - this.atk);
		
		return this.life;
	}
	
	public int critique() {
		// Coup critique
		int randomMult = new Random().nextInt(10);
		int powerHit = 0;
		
		if (randomMult == 1 || randomMult == 2 || randomMult == 3 || randomMult == 4 || randomMult == 5) {
			powerHit = 1;
		} else if (randomMult == 10) {
			powerHit = 4;
		}else if (randomMult == 9 || randomMult == 8) {
			powerHit = 2;
		} else {
			powerHit = 0;
		}
		
		return powerHit;
	}
}