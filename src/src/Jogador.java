package src;

import java.util.ArrayList;



public class Jogador {
	String nome;
	String date;
	String niverDate;
	int cod;
	ArrayList<Equipe> equipes;
	
	public Jogador() {};
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getniverDate() {
		return niverDate;
	}
	public void setniverDate(String niverDate) {
		this.niverDate = niverDate;
	}

	public ArrayList<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(ArrayList<Equipe> equipes) {
		this.equipes = equipes;
	}
	
}
