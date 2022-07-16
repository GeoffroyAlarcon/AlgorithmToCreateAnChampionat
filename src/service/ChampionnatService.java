package service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import models.Player;
import models.Match;

public class ChampionnatService {

	public List<Match>designeMatchDay(List<Player> players) throws NoSuchAlgorithmException{
		List<Match> allMatch= getAllMatch(players) ;
		List<Match> matchs = new ArrayList<>();
		int allDayTime = players.size()-1;
		int dayTime =0; 
		while(dayTime< allDayTime) {
			dayTime++;
			 getMatchOfDayTime(allMatch,matchs, dayTime,players);

		}
		return matchs;
	}

	private void getMatchOfDayTime(List<Match> matchsRemaning,List<Match> matchs, int dayTime,List<Player>players) throws NoSuchAlgorithmException{
		List<Match> matchRemaningForDay = new ArrayList<>();
		matchRemaningForDay.addAll(matchsRemaning);
	int x=0;
		while(x < players.size()/2) {
			x++;
			Random random = SecureRandom.getInstanceStrong();
			Match match=matchRemaningForDay.get( random.nextInt(matchRemaningForDay.size())); 
			match.setJournee(dayTime);
			matchs.add(match);
			matchRemaningForDay.removeIf(elt -> elt.getFirstPlayer().getId() == match.getFirstPlayer().getId()  || elt.getFirstPlayer().getId() == match.getSecondPlayer().getId() || elt.getSecondPlayer().getId() == match.getFirstPlayer().getId() || elt.getSecondPlayer().getId() == match.getSecondPlayer().getId() );	
}

		List<Integer>  matchIds= matchs.stream().map(Match::getId).collect(Collectors.toList());
		matchsRemaning.removeIf( elt-> matchIds.contains(elt.getId()) );
	}

	private List< Match> getAllMatch( List<Player>players){
		List<Match> matchs = new ArrayList<>();
		int matchAtribute= 0;
		for(int x = 0;x <players.size();x++) {
			for(int y = x+1;y<players.size();y++) {
				Match match = new Match(players.get(x),players.get(y) );
				matchAtribute++;
				match.setId(matchAtribute);

				matchs.add(match);
			}	
		}
		return matchs;

	}


	public void displayAllMatch(List<Match> matchs) {

		for(Match match: matchs) {
			System.out.println("le prochain match de la journée n° "+match.getJournee()+"  opposera : "+match.getFirstPlayer().getPrenom() +" contre : "+match.getSecondPlayer().getPrenom());
		}
	}
}
