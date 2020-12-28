package dataStructuresPractice.strings;

public class StringToInteger {
    public static void main(String[] args) {
        String s = "91283472332";
        System.out.println(atoi(s));
    }

    private static int atoi(String s) {
        int i=0;
        int result = 0;
        int sign = 1;

        if(s.length() == 0){
            return 0;
        }

        while(i<s.length() && s.charAt(i) == ' '){
            i++;
        }

        if (i<s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            sign = 1 - 2 * (s.charAt(i++) == '-' ? 1 : 0);
        }

        while (i<s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){

            if (result > Integer.MAX_VALUE / 10
                    || (result == Integer.MAX_VALUE / 10
                    && s.charAt(i) - '0' > 7))
            {
                if (sign == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }
            result = result * 10 + s.charAt(i) - '0';
            i++;
        }
        return result*sign;
    }

}
