import java.util.ArrayList; 
import java.util.Scanner;
/**
*@author Davacas
* Clase que contiene el método principal. Sirve de menú para las batallase inicializa las nuevas partidas.
*/
public class Torneo{
	Contrincante p1 = new Contrincante();
	Contrincante p2 = new Contrincante();
	static Torneo juego = new Torneo();
	Scanner sc = new Scanner(System.in);

	/**
	* Método principal. Hace toda la secuencia de métodos para el flujo del juego.
	*/
	public static void main(String args[]){
		juego.nuevoJuego();

	}
	/**
	* Método que inicializa todo lo necesario para un nuevo juego.
	*/
	public void nuevoJuego(){
		juego.cls();
		System.out.println("\t   (Antes de empezar, te recomendamos leer el manual del juego)\n");
		System.out.println("\t\t\t\t¡BIENVENIDOS!\n");
		System.out.print("Ingresa el nombre del jugador 1: ");
		p1.nombre = sc.nextLine();	
		System.out.print("Ingresa el nombre del jugador 2: ");
		p2.nombre = sc.nextLine();
		juego.elegirMonstruos();
	}
	/**
	* Método que permite elegir los monstruos que utilizará cada jugador. Es llamado por "nuevoJuego".
	*/
	public void elegirMonstruos(){
		ArrayList<Monstruo> monstruo = new ArrayList<Monstruo>();
		Bulbasaur m1 = new Bulbasaur("", 1); Charmander m2 = new Charmander("", 1); Chikorita m3 = new Chikorita("", 1); 
		Cyndaquil m4 = new Cyndaquil("", 1); Flaaffy m5 = new Flaaffy("", 1); 	 	Jolteon m6 = new Jolteon("", 1);
		Pikachu m7 = new Pikachu("", 1); 	 Poliwag m8 = new Poliwag("", 1); 	  	Ponyta m9 = new Ponyta("", 1); 
		Squirtle m10 = new Squirtle("", 1);  Totodile m11 = new Totodile("", 1); 	Treecko m12 = new Treecko("", 1);
		monstruo.add(m1); monstruo.add(m2); monstruo.add(m3); monstruo.add(m4); monstruo.add(m5); monstruo.add(m6);
		monstruo.add(m7); monstruo.add(m8); monstruo.add(m9); monstruo.add(m10); monstruo.add(m11); monstruo.add(m12);
		int eleccion, nivel;
		String apodo;
		Monstruo m;

		while (!monstruo.isEmpty())
		{
			juego.cls();
			System.out.println("\nEstos son los monstruos disponibles: ");
			System.out.println("# |  Nombre  | HP | Ataque | Defensa | Velocidad\n");
			for (int i = 0; i < monstruo.size(); i ++)
			{
				m = monstruo.get(i);
				System.out.println((i+1)+" | "+m.apodo+" | "+m.hp+" | "+m.ataque+" | "+m.defensa+" | "+m.velocidad);
			}
			System.out.println("");
			System.out.print(p2.nombre+", ingresa el número del monstruo que quieres añadir a tu equipo: ");
			eleccion = sc.nextInt();
			m = monstruo.get(eleccion-1);
			monstruo.remove(eleccion-1);
			System.out.print(p2.nombre+", (opcional) ingresa un apodo para el monstruo que acabas de elegir: ");
			sc.nextLine();
			m.apodo = sc.nextLine();
			System.out.print(p2.nombre+", ingresa el nivel del monstruo que acabas de elegir: ");
			m.nivel = sc.nextInt();
			p1.monstruo.add(m);

			juego.cls();
			System.out.println("\nEstos son los monstruos disponibles: ");
			System.out.println("# |  Nombre  | HP | Ataque | Defensa | Velocidad\n");
			for (int i = 0; i < monstruo.size(); i ++)
			{
				m = monstruo.get(i);
				System.out.println((i+1)+" | "+m.apodo+" | "+m.hp+" | "+m.ataque+" | "+m.defensa+" | "+m.velocidad);
			}
			System.out.println("");
			System.out.print(p1.nombre+", ingresa el número del monstruo que quieres añadir a tu equipo: ");
			eleccion = sc.nextInt();
			m = monstruo.get(eleccion-1);
			monstruo.remove(eleccion-1);
			System.out.print(p1.nombre+", (opcional) ingresa un apodo para el monstruo que acabas de elegir: ");
			sc.nextLine();
			m.apodo = sc.nextLine();
			System.out.print(p1.nombre+", ingresa el nivel del monstruo que acabas de elegir: ");
			m.nivel = sc.nextInt();
			p2.monstruo.add(m);
		}

		juego.cls();
		System.out.println(p1.nombre+", tienes estos monstruos: ");
		for (int i = 0; i < (p1.monstruo).size(); i ++)
		{
			m = (p1.monstruo).get(i);
			System.out.println((i+1)+" | "+m.apodo+" | "+m.hp+" | "+m.ataque+" | "+m.defensa+" | "+m.velocidad);
		}
		System.out.println();
		System.out.print("¿Con cuál de ellos quieres iniciar? (Ingresa su número): ");
		eleccion = sc.nextInt();
		p1.monstruo_actual = p1.monstruo.get(eleccion-1);
		p1.monstruo_actual.estado = "En combate.";
		System.out.println("¡"+p1.monstruo_actual.apodo+" entra al combate!");

		juego.cls();
		System.out.println(p2.nombre+", tienes estos monstruos: ");
		for (int i = 0; i < (p2.monstruo).size(); i ++)
		{
			m = (p2.monstruo).get(i);
			System.out.println((i+1)+" | "+m.apodo+" | "+m.hp+" | "+m.ataque+" | "+m.defensa+" | "+m.velocidad);
		}
		System.out.println();
		System.out.print("¿Con cuál de ellos quieres iniciar? (Ingresa su número): ");
		eleccion = sc.nextInt();
		p2.monstruo_actual = p2.monstruo.get(eleccion-1);
		p2.monstruo_actual.estado = "En combate.";
		System.out.println("¡"+p2.monstruo_actual.apodo+" entra al combate!");
	}
	/**
	* Método que borra lo que hay en pantalla e imprime el banner del juego.
	*/
	public void cls(){
		System.out.print("\033[H\033[2J");  
    	System.out.flush();  
    	System.out.println("\t\t____________ ___________ ________  ________ _   _"); 
		System.out.println("\t\t| ___ \\ ___ \\  ___| ___ \\  ___|  \\/  |  _  | \\ | |");
		System.out.println("\t\t| |_/ / |_/ / |__ | |_/ / |__ | .  . | | | |  \\| |");
		System.out.println("\t\t|  __/|    /|  __|| ___ \\  __|| |\\/| | | | | . ` |");
		System.out.println("\t\t| |   | |\\ \\| |___| |_/ / |___| |  | \\ \\_/ / |\\  |");
		System.out.println("\t\t\\_|   \\_| \\_\\____/\\____/\\____/\\_|  |_/\\___/\\_| \\_/");
	}
}