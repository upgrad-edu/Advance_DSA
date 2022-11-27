public class BruteForceString {


    public static void main(String[] args) {


        String s1 = "abc";
        String s2 = "jabcod";

        System.out.println(findSubstring(s1,s2));

    }

    static int findSubstring(String s1, String s2)
    {
        int length_1 = s1.length();
        int length_2 = s2.length();

        for (int i = 0; i <= length_2 - length_1; i++) {
            int j;

            for (j = 0; j < length_1; j++)
                if (s2.charAt(i + j) != s1.charAt(j))
                    break;

            if (j == length_1)
                return i;
        }

        return -1;
    }

}
