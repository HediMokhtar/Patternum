import fil.iagl.opl.conan.model.Challenge;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NewYearChallenge implements Challenge<Integer>{

    @Override
    public Class<? extends Integer> getInputFormat() {
        return null;
    }

    @Override
    public List<Integer> getInputs() {
        List<Integer> inputs = new ArrayList<Integer>();
        inputs.add(Calendar.getInstance().getWeekYear()); // success
        inputs.add(Calendar.getInstance().getWeekYear()-1); // fail
        return inputs;
    }

    @Override
    public Object doIt(Integer input) {
        assert input.equals(Calendar.getInstance().getWeekYear());
        return input;
    }

    @Override
    public void challenge(Integer input) {
        int currentYear = 0;
        assert input.equals(Calendar.getInstance().getWeekYear());
        currentYear = input;
    }

}
