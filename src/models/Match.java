package models;

public class Match {
private int id;
private Player firstPlayer;
private Player SecondPlayer;
private int journee;
public Player getFirstPlayer() {
	return firstPlayer;
}
public void setFirstPlayer(Player firstPlayer) {
	this.firstPlayer = firstPlayer;
}
public Player getSecondPlayer() {
	return SecondPlayer;
}
public void setSecondPlayer(Player secondPlayer) {
	SecondPlayer = secondPlayer;
}
public Match(Player firstPlayer,Player secondPlayer) {
	super();
	this.firstPlayer = firstPlayer;
this.SecondPlayer= secondPlayer;
}
public int getJournee() {
	return journee;
}
public void setJournee(int journee) {
	this.journee = journee;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

}
