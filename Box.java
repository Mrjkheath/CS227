
public class Box<T>
{
	private T t;
	
	public void add(T t){
		this.t = t;
	}
	
	public T get(){
		return t;
	}

	public static void main(String[] args)
	{
		Box<String> stringBox = new Box<>();
		Box<Integer> integerBox = new Box<Integer>();
		
		stringBox.add("This is a Box.");
		integerBox.add(21);
		
		System.out.println(stringBox.get());
		System.out.println();
		System.out.println(integerBox.get());

	}

}
