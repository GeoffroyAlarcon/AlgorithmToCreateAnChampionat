package models;

public class Player {
private int id;
private String prenom;
public Player(int id, String prenom) {
	super();
	this.id = id;
	this.prenom = prenom;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}

}
