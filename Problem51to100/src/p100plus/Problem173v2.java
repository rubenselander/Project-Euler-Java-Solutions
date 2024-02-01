package p100plus;

public class Problem173v2 {
    public static void main(String[] args) {
        System.out.println(countLamina(1000000));
    }

    private static int countLamina(int totalTiles) {
        int count = 0;
        for (int outerSquare = 3; outerSquare <= totalTiles / 4 + 1; outerSquare++) {
            for (int innerSquare = outerSquare - 2; innerSquare >= 1; innerSquare -= 2) {
                int tilesNeeded = outerSquare * outerSquare - innerSquare * innerSquare;
                if (tilesNeeded <= totalTiles) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}



//We shall define a square lamina to be a square outline with a square "hole" so 
//that the shape possesses vertical and horizontal symmetry. 
//For example, using exactly thirty-two square tiles we can 
//form two different square laminae:

//With one-hundred tiles, and not necessarily using all of the tiles at one time,
//it is possible to form forty-one different square laminae.

//Using up to one million tiles how many different square laminae can be formed?
//The number of soltions for x^2 - y^2 <= 1 000 000, x > y, y > = 4



//X: 50, 51, 52
//Y: 49, 50, 51
//51, 50 = 101

//X = 500 000, Y = 499999
//891896832 = x*x
//890896833 = y*y
//999999 = x^2 - y^2
//X = 500001, Y = 500000
//X^2 - Y^2 = 1000001
