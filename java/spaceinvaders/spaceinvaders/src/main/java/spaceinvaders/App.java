package spaceinvaders;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
    for(int n = -10; n < 11; n++){
        //System.out.print(5*n + "       |");
    }
    System.out.println();
    for(int n = -10; n < 11; n++){
       // System.out.print(Math.pow(5*n,2) + "    |");
    }
    System.out.println();
    for(int n = -10; n < 11; n++){
       // System.out.print(Math.pow(5*n,3) + " |");
    }
    
    int[] list = {1, 2,3,4,5,6,7,8,9};
    
    //rev(list);
    
    String test = "Welcom to jave";
    for(int i = 0; i < 5; i +=2){
        System.out.println(test.substring(i, i + 4));
    }
    
}
    
    public static void rev (int [] x){
        for(int i = x.length - 1; i > -1; i --){
    System.out.println("Index = " + i + " Value = " + x[i]);
}
    }
    
}
