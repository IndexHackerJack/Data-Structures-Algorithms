/**
 * Created by jackli on 2018-10-23.
 */
public class FizzBuzz
{
    /**
     * Outputs number from 0 to ceiling. Additionally, prints "Fizz" if the number is
     * divisible by 3 and "Buzz" if divisible by 5.
     *
     * @param ceiling highest number (inclusive) to print
     */
    public static void fizzBuzz(int ceiling)
    {
        for (int num = 0; num <= ceiling; num++)
        {
            StringBuilder output = new StringBuilder(num + " ");

            if (num % 3 == 0)
            {
                output.append("Fizz");
            }

            if (num % 5 == 0)
            {
                output.append("Buzz");
            }

            System.out.println(output.toString());
        }
    }

    public static void main(String[] args)
    {
//        fizzBuzz(0);
        fizzBuzz(100);
//        fizzBuzz(-1);
    }
}
