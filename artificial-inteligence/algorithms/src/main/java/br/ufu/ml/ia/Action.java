package br.ufu.ml.ia;

@FunctionalInterface
public interface Action {
	State execute(State state) throws ActionException;
}
