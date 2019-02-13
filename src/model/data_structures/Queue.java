package model.data_structures;

/** Clase que permite el almacenamiento de nodos genericos en colas
 */
public class Queue<T> 
{
	//Atributos

	/**
	 * Primer nodo para operación
	 */
	private Nodo<T> primero;
	
	/**
	 * Último nodo para operación
	 */
	private Nodo<T> ultimo;
	
	/**
	 * tamaño de la cola
	 */
	private int cantidad;
	
	//Método Constructor
	public Queue ()
	{
		//Inicializa el primer y último nodo como vacío, y la cantidad como 0.
		primero= null;
		ultimo = null;
		cantidad= 0;
	}

	//Métodos del Queue

	/**
	 * método para enqueue un nuevo elemento estando en el último nodo. 
	 *@param  nuevoUltimo tiene inicializacion primero= false, ultimo =true
	 */
	public void enqueue(T elemento)
	{
		Nodo<T> nuevoUltimo= new Nodo(elemento);
		if(ultimo!=null)
		{
			nuevoUltimo.setSiguiente(primero); //el siguiente nodo al nuevo último es el primero.
			nuevoUltimo.setAnterior(ultimo); //el nodo anterior al nuevo último es el último.
			ultimo.setSiguiente(nuevoUltimo); //se actualiza el siguiente del antiguo último.
			primero.setAnterior(nuevoUltimo); //se actualiza el nodo anterior del primer nodo.
			ultimo = nuevoUltimo; //se actualiza el último nodo. 
		}
		else
		{
			nuevoUltimo.setSiguiente(nuevoUltimo); //el nodo se asocia a él mismo para poder operarse
			nuevoUltimo.setAnterior(nuevoUltimo);
			primero = nuevoUltimo;
			ultimo = nuevoPrimero;
		}
		cantidad++;
	}

	/**
	 * método para dequeue el primer elemento. La lista tiene al menos un elemento 
	 *@return elemento retorna el elemento T del nodo eliminado.
	 */
	public T dequeue()
	{
		T elElemento = primero.darElemento(); //se obtiene el elemento del primer nodo.
		if(primero!=ultimo) //caso cantidad>1
		{	
			ultimo.setSiguiente(primero.darSiguiente()); //se elimina la relación del último con el antiguo primero.
			primero.darSiguiente().setAnterior(ultimo); //se actualiza el nodo anterior del segundo nodo
			primero= primero.darSiguiente(); //se asigna el segundo nodo como nuevo primer nodo.	
		}
		else
		{
			primero= null;
			ultimo= null;
		}
		cantidad--;
		return elElemento;
		
	}




}
