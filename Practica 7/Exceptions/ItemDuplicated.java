package Exceptions;

public class ItemDuplicated extends Exception{
    
    //constructor con mensaje personalizado
    public ItemDuplicated(String msg) {
        super(msg);
    }

    //constructor por defecto
    public ItemDuplicated(){
        super("El dato ya existe en el arbol");
    }
}
