package br.ufu.ml.ia;

import com.sun.istack.internal.NotNull;

import java.util.List;
import java.util.Stack;

public abstract class Agent {

    private Algorithm algorithm;
	private Stack<State> solution;
	private List<State> objective;
	private State initialState;

    public Agent(@NotNull List<State> objective, State initialState) {
        this.objective = objective;
        this.initialState = initialState;
    }

    public abstract List<Action> getActionList();

    // cost methods
	public final int f(State n) {
		return g(n) + h(n);
	}

	public int g(State n){
		return 1;
	}

	public int h(State n) {
		return 0;
	}

	public final void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
		this.algorithm.setAgent(this);
	}

	public final void solve() {
    	if (algorithm == null) {
    		throw new RuntimeException("Can't solve agent's problem with a NULL algorithm!");
		}
		algorithm.setup();
	    solution = algorithm.search();
    }

	public final boolean isSolved() {
	    return solution != null && solution.size() > 0;
	}

	public final Stack<State> getSolution() throws NullPointerException {
		return solution;
	}

	public final void setSolution(Stack<State> solution) {
		this.solution = solution;
	}

	public final List<State> getObjective() {
		return objective;
	}

	public final void setObjective(List<State> objective) {
		this.objective = objective;
	}

	public final State getInitialState() {
		return initialState;
	}

	public final void setInitialState(State initialState) {
		this.initialState = initialState;
	}
}
