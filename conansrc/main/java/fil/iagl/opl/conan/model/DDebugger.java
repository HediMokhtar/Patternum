package fil.iagl.opl.conan.model;

public interface DDebugger<T> {

    CauseEffectChain debug(Challenge<T> c);

}
