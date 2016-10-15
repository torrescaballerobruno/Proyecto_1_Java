import java.util.ArrayList; 
import java.util.Scanner;
/**
*@author Davacas
* Clase que contiene el método principal. Sirve de menú para las batallase inicializa las nuevas partidas.
*/
public class Torneo{
	static Contrincante p1 = new Contrincante();
	static Contrincante p2 = new Contrincante();
	static Torneo juego = new Torneo();
	static Scanner sc = new Scanner(System.in);
	static int muertosP1 = 0, muertosP2 = 0;

	/**
	* Método principal. Hace toda la secuencia de métodos para el flujo del juego.
	*/
	public static void main(String args[]){
		boolean meta = false;
		juego.nuevoJuego();
		while (meta == false)
		{
			System.out.println("\nPresiona la tecla 'enter' para continuar...");
			sc.nextLine();
			juego.turno();
			juego.isMuerto();
			meta = juego.isMeta();
		}
	}
	/**
	* Método que se encarga del flujo de los turnos.
	*/
	public void turno(){
		String movimientoP1;
		String movimientoP2;

		juego.cls();
		System.out.println("\nDatos del monstruo actual de "+p1.nombre+": ");
		System.out.println("  Apodo  |  HP  | lvl");
		System.out.println(p1.monstruo_actual.apodo+" | "+p1.monstruo_actual.hp+" | "+p1.monstruo_actual.nivel);
		System.out.println("");
		System.out.println("\nDatos del monstruo actual de "+p2.nombre+": ");
		System.out.println("  Apodo  |  HP  | lvl");
		System.out.println(p2.monstruo_actual.apodo+" | "+p2.monstruo_actual.hp+" | "+p2.monstruo_actual.nivel);
		System.out.println("");
		System.out.println("\t1) Ataque tipo 1.");
		System.out.println("\t2) Ataque tipo 2.");
		System.out.println("\t3) Cambiar monstruo.");
		System.out.println("\t4) Usar pócima\n");
		System.out.print(p1.nombre+", elige un movimiento de la lista anterior: ");
		movimientoP1 = sc.nextLine();
		System.out.print(p2.nombre+", elige un movimiento de la lista anterior: ");
		movimientoP2 = sc.nextLine();

		if (p1.monstruo_actual.velocidad > p2.monstruo_actual.velocidad)
		{
			switch (movimientoP1) 
			{
				case "1":
					p1.monstruo_actual.ataque1(p2.monstruo_actual);
					break;
				case "2":
					p1.monstruo_actual.ataque2(p2.monstruo_actual);
					break;
				case "3":
					p1.guardarMonstruo();
					break;
				case "4":
					p1.usarPocima();
					break;
			}
			switch (movimientoP2) 
			{
				case "1":
					p2.monstruo_actual.ataque1(p1.monstruo_actual);
					break;
				case "2":
					p2.monstruo_actual.ataque2(p1.monstruo_actual);
					break;
				case "3":
					p2.guardarMonstruo();
					break;
				case "4":
					p2.usarPocima();
					break;
			}
		}
		else if (p1.monstruo_actual.velocidad <= p2.monstruo_actual.velocidad)
		{
			switch (movimientoP2) 
			{
				case "1":
					p2.monstruo_actual.ataque1(p1.monstruo_actual);
					break;
				case "2":
					p2.monstruo_actual.ataque2(p1.monstruo_actual);
					break;
				case "3":
					p2.guardarMonstruo();
					break;
				case "4":
					p2.usarPocima();
					break;
			}
			switch (movimientoP1) 
			{
				case "1":
					p1.monstruo_actual.ataque1(p2.monstruo_actual);
					break;
				case "2":
					p1.monstruo_actual.ataque2(p2.monstruo_actual);
					break;
				case "3":
					p1.guardarMonstruo();
					break;
				case "4":
					p1.usarPocima();
					break;
			}
		}
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
		juego.agregarPocimas();
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
			System.out.println("# |  Nombre  | HP | Ataque | Defensa | Velocidad");
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
			System.out.println("# |  Nombre  | HP | Ataque | Defensa | Velocidad");
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
		System.out.println("\n"+p1.nombre+", tienes estos monstruos: ");
		System.out.println("# | Apodo | HP | Ataque | Defensa | Velocidad");
		for (int i = 0; i < (p1.monstruo).size(); i ++)
		{
			m = (p1.monstruo).get(i);
			System.out.println((i+1)+" | "+m.apodo+" | "+m.hp+" | "+m.ataque+" | "+m.defensa+" | "+m.velocidad);
		}
		System.out.println();
		System.out.print("¿Con cuál de ellos quieres iniciar? (Ingresa su número): ");
		eleccion = sc.nextInt();
		p1.monstruo_actual = p1.monstruo.get(eleccion-1);

		juego.cls();
		System.out.println("\n"+p2.nombre+", tienes estos monstruos: ");
		System.out.println("# | Apodo | HP | Ataque | Defensa | Velocidad");
		for (int i = 0; i < (p2.monstruo).size(); i ++)
		{
			m = (p2.monstruo).get(i);
			System.out.println((i+1)+" | "+m.apodo+" | "+m.hp+" | "+m.ataque+" | "+m.defensa+" | "+m.velocidad);
		}
		System.out.println();
		System.out.print("¿Con cuál de ellos quieres iniciar? (Ingresa su número): ");
		eleccion = sc.nextInt();
		p2.monstruo_actual = p2.monstruo.get(eleccion-1);
	}
	/**
	* Método que llena el arreglo de pócimas del usuario.
	*/
	public void agregarPocimas(){
		PocimaVida pos11 = new PocimaVida();	PocimaVida pos21 = new PocimaVida();	PocimaAtaque pos31 = new PocimaAtaque();
		PocimaAtaque pos41 = new PocimaAtaque();PocimaDefensa pos51 = new PocimaDefensa();PocimaDefensa pos61 = new PocimaDefensa();
		PocimaVida pos12 = new PocimaVida();	PocimaVida pos22 = new PocimaVida();	PocimaAtaque pos32 = new PocimaAtaque();
		PocimaAtaque pos42 = new PocimaAtaque();PocimaDefensa pos52 = new PocimaDefensa();PocimaDefensa pos62 = new PocimaDefensa();
		p1.pocima.add(pos11);	p1.pocima.add(pos21);	p1.pocima.add(pos31);
		p1.pocima.add(pos41);	p1.pocima.add(pos51);	p1.pocima.add(pos61);
		p2.pocima.add(pos12);	p2.pocima.add(pos22);	p2.pocima.add(pos32);
		p2.pocima.add(pos42);	p2.pocima.add(pos52);	p2.pocima.add(pos62);

	}
	/**
	*Método que verifica si un monstruo ha muerto, lo cambia si es necesario e incrementa una variable que garantiza un estado de meta.
	*/
	public void isMuerto(){
		if (p1.monstruo_actual.estado.equals("Fuera de combate"))
		{
			muertosP1 ++;
			p1.guardarMonstruo();
		}
		if (p2.monstruo_actual.estado.equals("Fuera de combate"))
		{
			muertosP2 ++;
			p2.guardarMonstruo();
		}
	}
	/**
	* Método que verifica si el estado actual del juego es una meta.
	*/
	public boolean isMeta(){
		if (muertosP1 == 6) 
		{
			juego.cls();
			System.out.println("\n\t\t¡LA BATALLA HA TERMINADO!");
			System.out.println("¡"+p2.nombre+" ganó la partida! ¡Felicidades!");
			return true;
		}
		else if (muertosP2 == 6) 
		{
			juego.cls();
			System.out.println("\n\t\t¡LA BATALLA HA TERMINADO!");
			System.out.println("¡"+p1.nombre+" ganó la partida! ¡Felicidades!");
			return true;
		}
		return false;
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