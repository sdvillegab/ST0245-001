/**
 * TestTaller07 sirve para probar listas enlazadas
 */
class TestTaller07{
    public static void main(String args[]){
        ListaEnlazada l0 = new ListaEnlazada();
        ListaEnlazada l1 = new ListaEnlazada();
        for(int i = 0; i < 10000; i++){
            l0.insert(i);
        }
        for(int i = 0; i < 10000; i++){
            l1.insert(i);
        }
        System.out.println(ListaEnlazada.comparar(l0, l1));
        for(int i = 9999; i > 100;i--){
            l0.remove(i);
        }
        for(int i = 9999; i > 5000;i--){
            l1.remove(i);
        }
        System.out.println(ListaEnlazada.comparar(l0, l1));
        l0.clear();
        System.out.println(l0.contains(10));
        System.out.println(l1.containsPos(4999));
        }
}