package model;

public class Userposjava {
	
	private String nome;
	private String email;
	
	@Override
	public String toString() {
		return "Userposjava [nome=" + nome + ", email=" + email + "]";
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
