public class PokeTest{
	public static void main(String[] args) {
		Pikachu pika = new Pikachu("",10);
		Treecko tree = new Treecko("",10);
		PocimaAtaque pa = new PocimaAtaque();
		PocimaDefensa pd = new PocimaDefensa();
		PocimaVida pv = new PocimaVida();


		System.out.println(tree.hp);
		pika.ataque1(tree);
		tree.ataque2(pika);
		System.out.println(tree.hp);
		pika.ataque2(tree);
		tree.ataque1(pika);
		
		System.out.println(pika.ataque);
		System.out.println(pika.defensa);
		System.out.println(pika.hp);

		pa.usarPocima(pika);
		pd.usarPocima(pika);
		pv.usarPocima(pika);

		System.out.println(pika.ataque);
		System.out.println(pika.defensa);
		System.out.println(pika.hp);
	}
}