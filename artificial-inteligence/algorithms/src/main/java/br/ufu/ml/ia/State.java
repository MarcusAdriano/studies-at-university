package br.ufu.ml.ia;

/**
 * Subclasses of this can do any operation
 */
public interface State {

	boolean equals(State s1);
	State clone();
}
