

public class HashC {


    private static class Element {
        Register register;
        boolean isAvailable;

        public Element () {
            this.register = null;
            this.isAvailable = true ;
        }
    }

    private Element[] table;
    private int size;

    public HashC(int size){
        table = new Element[size];
        for (int i = 0; i<size; i++) {
            table[i] = new Element();
        }
        this.size= size;
    }

    private int hash(int key){
        return key % size ;
    }

    public void insert(Register reg){
        int index = hash(reg.getKey());
        int startindex = index;

        while(!table[index].isAvailable){
            index = (index + 1) % size;
            if (index==startindex){
                System.out.println("tabla llena. No se pudo insertar" + reg );
                return;
            }
        }
        table[index].register = reg;
        table[index].isAvailable = false;
    }

    public Register search(int key){
        int index=hash(key);
        int startindex= index;

        while(table[index].register != null || !table[index].isAvailable){
            if(!table[index].isAvailable && table[index].register.getKey()==key){
                return table[index].register;
            }

            index = ( index +1 ) % size;
            if(index==startindex)break;
        }
        return null;
    }

    public void delete(int key){
        int index = hash(key);
        int startindex = index;
        
        while (table[index].register!=null || !table[index].isAvailable){
            if(!table[index].isAvailable && table[index].register.getKey()==key){
                table[index].isAvailable = true;
                table[index].register = null;
                System.out.println("Eliminado: " + key );
                return;
            }
            index = (index + 1) % size ;
            if ( index==startindex) break;
        }
        System.out.println("Clave no encontrada: " + key);
    }

    public void printTable(){
        for(int i = 0;i<size;i++){
            if(!table[i].isAvailable && table[i].register != null){
                System.out.println(i + " -> " + table[i].register);
            }
            else{
                System.out.println(i + "-> vacío");
            }
        }
    }
}
