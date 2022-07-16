import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import models.Match;
import models.Player;
import service.ChampionnatService;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException {

		Player[] joueurs=	new Player[]  
				{new  Player(1,"Geoffroy"),new  Player(2,"Rémy"),new  Player(3,"Léo"),new  Player(4,"Arthur")
				};
		List<Player> joueursList = new ArrayList<>(Arrays.asList(joueurs));
		ChampionnatService championnatService= new ChampionnatService();
List<Match> mmatchs= championnatService.designeMatchDay(joueursList);
championnatService.displayAllMatch(mmatchs);
	}
}