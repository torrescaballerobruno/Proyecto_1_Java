public abstract class Monstruo{
	public int hp;
	public String apodo;
	public int nivel;
	public float ataque;
	public float defensa;
	public float velocidad;
	public String estado="ok";

	public void recibirDaño(int hp,String estado){
		this.hp -= hp;
		this.estado = estado;
		if(this.hp<=0)
			this.estado="Fuera de combate";
	}

	public void recibirHp(int hp){
		this.hp+=hp;
	}

	public void recibirAtaque(float ataque){
		this.ataque+=ataque;
	}

	public void recibirDefensa(float defensa){
		this.defensa+=defensa;
	}

	public float getAtaque(){
		return this.ataque;
	}

	public void setAtaque(float ataque){
		this.ataque=ataque;
	}

	public float getDefensa(){
		return this.defensa;
	}

	public void setDefensa(float defensa){
		this.defensa=defensa;
	}

	public float getVelocidad(){
		return this.velocidad;
	}

	public void setVelocidad(float velocidad){
		this.velocidad=velocidad;
	}

	public abstract void multiplicadorElemental();

	public abstract void ataque1();

	public abstract void ataque2();
}