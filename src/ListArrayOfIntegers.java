public class ListArrayOfIntegers {

    private Integer[] array;
    private int count;

    public ListArrayOfIntegers(int size){
        array = new Integer[size];
        count = 0;
    }

    public ListArrayOfIntegers(){
        array = new Integer[5000];
        for(int i=0;i<5000;i++){
            array[i]=i;
        }
        count = 5000;
    }
    
    void add(int element){
        if(count == array.length){
            Integer[] auxArray = new Integer[array.length+1];
            for (int i = 0; i < array.length; i++) {
                auxArray[i] = array[i];
            }
            array = auxArray;
        }
        array[count]= element;
        count++;
    }
    void add(int index, int element){
        if(index==count){
            add(element);
        }else if(index<count){
            if(count == array.length){
                Integer[] auxArray = new Integer[array.length+1];
                for (int i = 0; i < array.length; i++) {
                    auxArray[i] = array[i];
                }
                array = auxArray;

            }

            Integer[] auxArray = new Integer[array.length];

            for (int i = 0; i < array.length; i++) {
                if(i<index){
                    auxArray[i]=array[i];
                }else if(i>index){
                    auxArray[i] = array[i-1];
                }
            }
            array = auxArray;
            count++;
        }else{//index>count

            Integer[] auxArray = new Integer[array.length+(index-count)+1];
            for (int i = 0; i < array.length; i++) {
                auxArray[i] = array[i];
            }
            array = auxArray;
            count = index+1;
        }
        array[index] = element;
    }
    int get(int index){
        return array[index];
    }

    int set(int index, int element){
        int antigo = array[index];
        array[index] = element;
        return antigo;
    }

    boolean remove(int element){
        for(int i = 0;i<count;i++){
            if(array[i]==element){
                for(int j=i; j<count-1; j++) {
                    array[j] = array[j+1];
                }
                array[count-1] = null;
                count--;
                return true;
            }
        }
        return false;
    }

    boolean removeAll(int element){
        int h=0;
        for(int i = 0;i<count;i++){
            if(array[i]==element){
                for(int j=i; j<count-1; j++) {
                    array[j] = array[j+1];
                }
                array[count-1] = null;
                count--;
                h++;
            }
        }
        if(h==0){
            return false;
        }else{
            return true;
        }
    }

    int removeByIndex (int index ){
        int a = array[index];
        array[index] = null;
        for(int i = index; i<count-1; i++){
            array[i] = array[i+1];
        }
        array[count-1] = null;
        count--;
        return a;
    }

    boolean isEmpty(){
        return count==0;
    }

    int getSize() {
        return count;
    }

    boolean contains(int element){
        for(int i=0;i<count;i++){
            if(array[i]==element){
                return true;
            }
        }
        return false;
    }

    int indexOf (int element){
        for(int i=0;i<count;i++){
            if(array[i]==element){
                return i;
            }
        }
        return -1;
    }

    void clear (){
        array = new Integer[array.length];
    }

    void sort(){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    void reverse(){
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    ListArrayOfIntegers getSubset(int start, int end){
        if (start < 0 || start >= count || end < start || end > count) {
            throw new IllegalArgumentException("Índices de intervalo inválidos");
        }
        ListArrayOfIntegers subset = new ListArrayOfIntegers(end - start);
        for (int i = start; i < end; i++) {
            subset.add(array[i]);
        }
        return subset;
    }



}
