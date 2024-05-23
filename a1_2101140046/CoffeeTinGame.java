package a1_2101140046;
import java.util.*;
/**
 * @Overview A program that performs the coffee tin game on a
 *    tin of beans and display result on the standard output.
 *
 */
public class CoffeeTinGame {
    /** constant value for the green bean*/
    private static final char GREEN = 'G';
    /** constant value for the blue bean*/
    private static final char BLUE = 'B';
    /** constant for removed beans */
    private static final char REMOVED = '-';
    /** the null character*/
    private static final char NULL = '\u0000';
    /** create the bag with no static or other class 14 blue, 13 green,11 removed*/
    private static final char[] BeansBag = new char[] {BLUE,BLUE, BLUE, GREEN, GREEN, GREEN, REMOVED, GREEN, REMOVED, REMOVED,
            GREEN, BLUE, GREEN, BLUE, BLUE, GREEN, GREEN, GREEN,BLUE, REMOVED, GREEN, REMOVED, GREEN, BLUE, BLUE, BLUE,
            BLUE,REMOVED, GREEN, GREEN, BLUE, GREEN, BLUE, BLUE, REMOVED,REMOVED,REMOVED,REMOVED,REMOVED,};


    /**
     * the main procedure
     * @effects
     *    initialise a coffee tin
     *    {@link TextIO#putf(String, Object...)}: print the tin content
     *    {@link @tinGame(char[])}: perform the coffee tin game on tin
     *    {@link TextIO#putf(String, Object...)}: print the tin content again
     *    if last bean is correct
     *      {@link TextIO#putf(String, Object...)}: print its colour
     *    else
     *      {@link TextIO#putf(String, Object...)}: print an error message
     */
    public static void main(String[] args) {
        // initialise some beans
        char[][] tins = {
                {BLUE, BLUE, BLUE, GREEN, GREEN},
                {BLUE, BLUE, BLUE, GREEN, GREEN, GREEN},
                {GREEN},
                {BLUE},
                {BLUE, GREEN}
        };

        for (int i = 0; i < tins.length; i++) {
            char[] tin = tins[i];

            // expected last bean
            // p0 = green parity /\
            // (p0=1 -> last=GREEN) /\ (p0=0 -> last=BLUE)
            // count number of greens
            int greens = 0;
            for (char bean : tin) {
                if (bean == GREEN)
                    greens++;
            }
            // expected last bean
            final char last = (greens % 2 == 1) ? GREEN : BLUE;

            // print the content of tin before the game
            System.out.printf("%nTIN (%d Gs): %s %n", greens, Arrays.toString(tin));

            // perform the game
            // get actual last bean
            char lastBean = tinGame(tin);
            // lastBean = last \/ lastBean != last

            // print the content of tin and last bean
            System.out.printf("tin after: %s %n", Arrays.toString(tin));

            // check if last bean as expected and print
            if (lastBean == last) {
                System.out.printf("last bean: %c%n", lastBean);
            } else {
                System.out.printf("Oops, wrong last bean: %c (expected: %c)%n", lastBean, last);
            }
        }
    }


    /**
     * Performs the coffee tin game to determine the colour of the last bean
     *
     * @requires tin is not null /\ tin.length > 0
     * @modifies tin
     * @effects <pre>
     *   take out two beans from tin
     *   if same colour
     *     throw both away, put one blue bean back
     *   else
     *     put green bean back
     *   let p0 = initial number of green beans
     *   if p0 = 1
     *     result = `G'
     *   else
     *     result = `B'
     *   </pre>
     */
    private static char tinGame(char[] tin) {//change use updateTin
        while (hasAtLeastTwoBeans(tin)) {
            // Take two beans and put them into right position and update it
            char[] twoBeans = takeTwo(tin);
            char b1 = twoBeans[0];
            char b2 = twoBeans[1];
            updateTin(tin, b1, b2);
        }
        return anyBean(tin);
    }

    /**
     * @effects
     *  if tin has at least two beans
     *    return true
     *  else
     *    return false
     */
    private static boolean hasAtLeastTwoBeans(char[] tin) { // not change this method
        int count = 0;
        for (char bean : tin) {
            if (bean != REMOVED) {
                count++;
            }
            if (count >= 2) // enough beans
                return true;
        }
        // not enough beans
        return false;
    }

    /**
     * @requires tin has at least 2 beans left
     * @modifies tin
     * @effects
     *  remove any two beans from tin and return them
     */
    private static char[] takeTwo(char[] tin) {//not change thís method
        char first = takeOne(tin);
        char second = takeOne(tin);
        return new char[]{first, second};
    }

    /**
     * @requires tin has at least one bean
     * @modifies tin
     * @effects
     *   remove any bean from tin and return it
     */
    private static char takeOne(char[] tin) { // change use randInt
        int numberBean = randInt(tin.length);
        char bean = tin[numberBean];

        // Loop until a non-removed bean is found
        while (bean == REMOVED) {
            numberBean = randInt(tin.length);
            bean = tin[numberBean];
        }

        // Remove the chosen bean and return it
        tin[numberBean] = REMOVED;
        return bean;
    }

    private static void updateTin(char[] tin, char beanOne, char beanTwo) {
        if (beanOne == beanTwo) {
            char blueB = getBean(BeansBag, BLUE); // Get blue bean from bag
            putIn(tin, blueB);
        } else {
            char greenB = getBean(BeansBag, GREEN); // Get green bean from bag
            putIn(tin, greenB);
        }
    }


    /**
     * @require array of bean and a bean type
     * @modifes find a random bean matches with bean type => removed it from array(deleted)
     * @effects returm that randomly-selected bean
     */
    public static char getBean(char[] beansBag, char beanType){
        char[] specifiedArr = new char[beansBag.length];
        int i = 0;
        // Generate an array containing only beans of the specified type
        while (i < specifiedArr.length) {
            if (beansBag[i] == beanType) {
                specifiedArr[i] = beansBag[i];
            } else {
                specifiedArr[i] = REMOVED;
            }
            i++;
        }
        // take a randomOne by takeOne function
        char selectOne = takeOne(specifiedArr);
        i = 0;
        while (i < beansBag.length) {
            if (specifiedArr[i] == REMOVED && beansBag[i] != REMOVED && beansBag[i] == beanType) {
                beansBag[i] = REMOVED;
            }
            i++;
        }
        return selectOne;
    }


/**
 * @param n positive integer numbers
 * @require n > 0
 * @effects create a range[0,n] or [1, n-1] for an int random number
 * @return result
  */
   public static int randInt(int n){
          int outcome = (int)(Math.random()*n);
          return outcome;
   }
    /**
     * @requires tin has vacant positions for new beans
     * @modifies tin
     * @effects
     *   place bean into any vacant position in tin
     */
    private static void putIn(char[] tin, char bean) {//keep
        for (int i = 0; i < tin.length; i++) {
            if (tin[i] == REMOVED) { // vacant position
                tin[i] = bean;
                break;
            }
        }
    }

    /**
     * @effects
     *  if there are beans in tin
     *    return any such bean
     *  else
     *    return '\u0000' (null character)
     */
    private static char anyBean(char[] tin) {//keep
        for (char bean : tin) {
            if (bean != REMOVED) {
                return bean;
            }
        }
        // no beans left
        return NULL;
    }
}
