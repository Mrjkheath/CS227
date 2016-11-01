/*
 * Suitor class that goes along with the EvesSuitors class.
 */


public class Suitor<E>
{
	E suitor;
	Suitor<E> next, previous;
	
	public Suitor(E e){
		suitor = e;
	}
	
	
}
