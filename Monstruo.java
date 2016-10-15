/** 
 * Clase Monstruo que es la superclase de los tipos de Monstruo
 * @author  Bruno Torres
 */
public abstract class Monstruo{
	public int hp;
	public String apodo;
	public int nivel;
	public float ataque;
	public float defensa;
	public float velocidad;
	public String estado;
	public int contParalizado=0;
	/**
	 *Metodo que baja los hp del monstruo y asigna un estado
	 *@param hp int
	 *@param estado String
	 */
	public void recibirDaño(int hp){
		this.hp -= hp;
		if(this.hp<=0)
			this.estado="Fuera de combate";
	}
	/**
	 *Clase usada por pocima para aumentar los Hp
	 *@param hp int
	*/
	public void recibirHp(int hp){
		System.out.println(this.apodo + " recibio "+hp+" puntos de Hp.");
		this.hp+=hp;
	}

	/**
	 *Clase usada por pocima para aumentar el ataque
	 *@param ataque float
	*/
	public void recibirAtaque(float ataque){
		System.out.println(this.apodo+" recibio "+ataque+" puntos de ataque.");
		this.ataque+=ataque;
	}

	/**
	 *Clase usada por pocima para aumentar la defensa
	 *@param defensa float
	*/
	public void recibirDefensa(float defensa){
		System.out.println(this.apodo + " recibio "+ defensa +" puntos de defensa.");
		this.defensa+=defensa;
	}
	/**
	 *Metodo que regresa el ataque
	 *@return ataque
	*/
	public float getAtaque(){
		return this.ataque;
	}
	/**
  	 *Metodo que asigna un valor a ataque
  	 *@param ataque float
	*/
	public void setAtaque(float ataque){
		this.ataque=ataque;
	}
	/**
	 *Metodo que regresa la defensa
	 *@return defensa
	*/
	public float getDefensa(){
		return this.defensa;
	}
	/**
  	 *Metodo que asigna un valor a defensa
  	 *@param defensa float
	*/
	public void setDefensa(float defensa){
		this.defensa=defensa;
	}
	/**
	 *Metodo que regresa la velocidad
	 *@return velocidad
	*/
	public float getVelocidad(){
		return this.velocidad;
	}
	/**
  	 *Metodo que asigna un valor a velocidad
  	 *@param velocidad float
	*/
	public void setVelocidad(float velocidad){
		this.velocidad=velocidad;
	}
	/**
	 *Metodo abstracto que se definira en las clases herederas
	 *@param elemento Monstruo
	 */
	public abstract float multiplicadorElemental(Monstruo elemento);
	/**
	 *Metodo abstracto que se definira en las clases herederas
	 *@param enemigo Monstruo
	 */
	public abstract void ataque1(Monstruo enemigo);
	/**
	 *Metodo abstracto que se definira en las clases herederas
	 *@param enemigo Monstruo
	 */
	public abstract void ataque2(Monstruo enemigo);
}