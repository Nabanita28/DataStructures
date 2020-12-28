package dataStructuresPractice.strings.mock.interviews;

public class WendyBobGame {
    public static void main(String[] args) {
        String gameString = "bbbbbbbbbwwwwwwwwwwwwwbbbbbb";
        System.out.println(findGameWinner(gameString));
    }

    private static String findGameWinner(String gameString) {

        int chancesOfWendy = 0;
        int chancesOfBob = 0;

        for (int i=1; i<gameString.length()-1; i++){

            if (gameString.charAt(i) == gameString.charAt(i-1) &&
                gameString.charAt(i) == gameString.charAt(i+1)){

                if (gameString.charAt(i) == 'w'){
                    chancesOfWendy++;
                }else{
                    chancesOfBob++;
                }
            }

        }

        if (chancesOfWendy > chancesOfBob){
            return "Wendy is the winner";
        } else{
            return "Bob is the winner";
        }

    }
}
