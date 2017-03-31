import fil.iagl.opl.conan.model.Challenge;
import java.util.ArrayList;
import java.util.List;

public class NullChallenge implements Challenge<Integer> {

	@Override
	public Class<? extends Integer> getInputFormat() {
		return Integer.class;
	}

	@Override
	public List<Integer> getInputs() {
		List<Integer> inputs = new ArrayList<Integer>();
		inputs.add(5); // Success
		inputs.add(3); // Fail
		return inputs;
	}

	@Override
	public Object doIt(Integer input) {
		Integer j = null;
		if (input > 3) {
			j = 0;
		}
		return j;
	}

	@Override
	public void challenge(Integer input) {
		doIt(input);
	}

}