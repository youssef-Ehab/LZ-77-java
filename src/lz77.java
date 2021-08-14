import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class lz77 {

    public void compress(String input) {
        int position, length;
        char next;
        Vector<String> ans = new Vector<>();
        for (int i = 0; i < input.length(); i++) {

            if (i == 0) {
                ans.add("0,0," + input.charAt(0));
            }
        }
        System.out.println(ans);
    }


    public void decompress() {
        int j = 0;
        int position, length;
        String next, add, sub;
        Scanner scanner = new Scanner(System.in);
        Vector<String> compressed = new Vector<>();
        //Vector<String>ans=new Vector<>();
        //Vector<String>dic=new Vector<>();
        String ans = new String();
        while (true) {
            add = scanner.nextLine();
            if (add.equals("-1")) break;
            compressed.add(add);
        }
        //System.out.println(compressed);
        for (int i = 0; i < compressed.size(); i++) {
            String temp = compressed.elementAt(i);
            String[] split = temp.split(",", 3);
            position = Integer.parseInt(split[0]);
            length = Integer.parseInt(split[1]);
            next = split[2];
            if (position == 0 && length == 0) {
                ans += next;
            } else {
                if (position == 1 && length > 1) {
                    sub = ans.substring((j - position), (j - position + 1));
                    for (int k = 0; k < length; k++) {
                        ans += sub;
                    }
                    ans += next;
                } else {
                    sub = ans.substring((j - position), (j - position) + length);
                    sub += next;
                    ans += sub;
                }
            }
            split = new String[]{};
            j = ans.length();
            System.out.println(ans);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        lz77 l = new lz77();
        l.compress("aba");

        //  l.decompress();
    }
}
