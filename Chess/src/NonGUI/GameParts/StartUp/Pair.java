package NonGUI.GameParts.StartUp;

public class Pair<A,B> {

    private A a;
    private B b;

    /**
     * Holds a pair of items in conjunction
     * @param a
     * @param b
     */
    public Pair(A a, B b){
        this.a = a;
        this.b = b;
    }

    /**
     * @return First Element in pair
     */
    public A getA(){
        A copy = a;
        return a;
    }

    /**
     * @return Second Element in pair
     */
    public B getB(){
        B copy = b;
        return copy;
    }
}
