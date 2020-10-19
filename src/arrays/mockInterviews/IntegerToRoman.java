package arrays.mockInterviews;

public class IntegerToRoman {
    public static void main(String []args)
    {
        int number = 3549;
        System.out.println(integerToRoman(number));

    }

    private static String integerToRoman(int number) {
        String[] romanLiterals = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        StringBuilder roman = new StringBuilder();
        for (int i=0; i<values.length; i++){
            while(number >= values[i]){
                number = number - values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman.toString();
    }
}
