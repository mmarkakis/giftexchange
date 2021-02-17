public class GiftExchange{

// Returns an int array a of size n where each entry a[i] is
// an integer [0,n) different than i
public static int[] permutation(int n){
    int[] perm = new int[n];
    boolean[] check = new boolean[n];
    boolean assigned;

    for (int i = 0; i < n; i++) {
        do {
            assigned = false;
            int pos = StdRandom.uniform(n);

            // if not himself & not sb taken
            if(pos != i && !check[pos]) {
                perm[i] = pos; 
                check[pos] = true;
                assigned = true;
            }
        } while (!assigned);
    }
    return perm;
}


// Given an array of Strings, returns an array of equal size
// where each original String is in a different position.
public static String[] shuffle(String[] given){
    int n = given.length;
    String[] shuffled = new String[n];
    int[] assign = permutation(n);

    for (int i = 0; i < n; i++) shuffled[i] = given[assign[i]]; 
    return shuffled;
}


// Given an integer, returns its 8-bit binary representation
public static String binary(int a){
    int power = 128;
    String number = "";
    while (power > 0) {
        if (a < power) number += '0';
        else {
            number += "1";
            a-=power;
        }
        power /= 2;
    }
    return number;
}


// Encodes a String in ASCII
public static String encodeASCII(String s){
    String r = "";
    for (int i = 0; i < s.length(); i++) r += binary(s.charAt(i));
    return r;
}




public static void main (String[] args){
    int people = StdIn.readInt();
    String[] givers = new String[people];
    for (int i = 0; i < people; i++) givers[i] = StdIn.readString();
    

    String[] takers = shuffle(givers);
    String[] takers_ASCII = new String[people];
    for (int i = 0; i < people; i++) {
        takers_ASCII[i] = encodeASCII(takers[i]);
        StdOut.printf("%s \n%s \n%s \n \n", givers[i], takers_ASCII[i], takers[i]);
    }
}

}