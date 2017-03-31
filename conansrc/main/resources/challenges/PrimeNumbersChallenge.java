import fil.iagl.opl.conan.model.Challenge;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class PrimeNumbersChallenge implements Challenge<Integer>{

    @Override
    public Class<? extends Integer> getInputFormat() {
        return null;
    }

    @Override
    public List<Integer> getInputs() {
        int numbers[] = new int[]{1,2,3,4,5,6,7,8,9,10, 35, 60};
        List<Integer> inputs = new ArrayList(Arrays.asList(numbers));
        return inputs;
    }

    @Override
    public Object doIt(Integer input) {
        boolean isPrime = true;
        if (input < 0) {
            isPrime = false;
        } else if (input != 0 && input != 1) {
            for (int i = 2; i <= input/2; i++) {
                if (input != i && input % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        if(!isPrime) throw new RuntimeException("Value is not a prime number");
        return input;
    }

    @Override
    public void challenge(Integer input) {
        doIt(input);
    }

}

