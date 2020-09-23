import java.util.Random;

public class main {
	
	static void trait(int n) {
		for(int i = 0;i<n;i++) {
			System.out.print('*');
		}
		System.out.println(' ');
	}
	
	
	public static boolean in_fight = false;
	public static boolean choose = true;
	

	
	public static void main (String[] args) {
		trait(10);
		System.out.println("Bienvenu");
		System.out.println("  dans");
		System.out.println("Java RPG");
		trait(10);
		
		// Construction du joueur
		Terminal.ecrireStringln("Bonjour à toi joueur, quel est ton nom ?");
		String pl_name = Terminal.lireString();
		Terminal.sautDeLigne();
		Terminal.ecrireStringln("Ravie de te rencontrer " + pl_name + ".");
		Terminal.ecrireStringln("Comme ce jeux est en developpement, on va dire que tu es un chevalier. ;)");
		Character hero = new Character();
		
		hero.setLife(pl_name, 15, 3);
		int default_hero_life = hero.life;
		
		// aventure
		Terminal.ecrireStringln("Que l'aventure commence !");
		Terminal.sautDeLigne();
		
		while(choose == true) {
			Terminal.ecrireStringln("Que veux tu faire ? (aventure/repos)");
			
			String choo_rep = Terminal.lireString();
			
			if(choo_rep.equals("aventure")) {
				trait(30);
				Terminal.ecrireStringln("Oh non un individu hostile apparaît !");
				trait(30);
				
				in_fight = true;
				
				// Création de l'ennemi
				
				Character bad_guy = new Character();
				int randomLife = new Random().nextInt(15);
				int randomAtk = new Random().nextInt(5);
				bad_guy.setLife("un bandit", randomLife, randomAtk);
				bad_guy.status();
				
				
				while(in_fight == true) {
					Terminal.sautDeLigne();
					Terminal.ecrireStringln("Que veux tu faire ? (attaquer/heal)");
					String fight_rep = Terminal.lireString();
					if (fight_rep.equals("attaquer")) {
						
						
						Terminal.sautDeLigne();
						
						int T_atk_hero = hero.atk * hero.critique();
						bad_guy.life = bad_guy.life - T_atk_hero;
						Terminal.ecrireStringln("L'ennemi a perdu -" + T_atk_hero + " points de vie.");
						Terminal.ecrireStringln("Il lui en reste " + bad_guy.life + " points de vie.");
						Terminal.sautDeLigne();
						
					} else if (fight_rep.equalsIgnoreCase("heal")) {
						if(hero.life >= default_hero_life) {
							Terminal.sautDeLigne();
							Terminal.ecrireStringln("Votre santée est déjà au maximum.");
							Terminal.sautDeLigne();
						} else {
							Terminal.sautDeLigne();
							Terminal.ecrireStringln("Vous avez été soigné de " + hero.heal() + " points de vie.");
							Terminal.ecrireStringln("Mais");
						}
						
					}
					
					
					// ennemi phase
					int T_atk_bad_guy = bad_guy.atk * bad_guy.critique();
					hero.life = hero.life - T_atk_bad_guy;
					Terminal.ecrireStringln("Vous avez perdu -" + T_atk_bad_guy + " points de vie.");
					Terminal.ecrireStringln("Il vous en reste "  + hero.life + " points de vie.");
					Terminal.sautDeLigne();
					
					if(bad_guy.life <= 0 || hero.life <= 0) {
						
						if(bad_guy.life <= 0 && hero.life>0) {
							Terminal.sautDeLigne();
							trait(40);
							Terminal.ecrireStringln("Vous avez vaincu l'ennemi ! Félicitation !");
							Terminal.ecrireStringln("Vous gagnez " + bad_guy.atk_init + " points d'expérience.");
							hero.exp = hero.exp + bad_guy.atk_init;
							
							Terminal.ecrireStringln("Vous gagnez " + bad_guy.life_init + " pièces d'or.");
							hero.gold = hero.gold + bad_guy.life_init;
							
							trait(40);
							
						} else if (hero.life<=0 && bad_guy.life>0) {
							Terminal.sautDeLigne();
							trait(40);
							Terminal.ecrireStringln("RIP vous avez mordu la poussière");
							hero.life = hero.life_init;
							trait(40);
						}
						
						
						in_fight = false;
					}
					
					
					
					Terminal.sautDeLigne();
				}
				
				
				
			} else if (choo_rep.equals("repos")) {
				hero.heal();
			}
		}

	}
}

/*	On demande au joueur son nom
 * 	Le joueur entre son nom
 * 	On demande au joueur sa class
 * 
 * 	Le joueur aura:
 *		- un nom
 *		- un niveau + experience
 *		- Dégat
 *		- Défense
 * 	
 * 	Ensuite il a plusieurs choix  soit :
 * 		- Partir à l'aventure:
 * 			-choix de la zone par niveau
 * 				- joueur doit ce battre
 * 				- trouve un trésor
 * 				- Rien de spécial
 * 
 * 			- Dans tous les cas il gagne de l'exp
 * 
 * 		- Commerce
 * 		- S'occuper d'un pet:
 * 			- nourrir
 * 			- caresser
 * 			- jouer
 * 
 * 
 * 
 * 
 * 
 * L'exp permet de gagner en niveau:
 * 		- Permet d'avoir de meilleur stats
 */