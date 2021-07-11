package com.main;

/**
 * The class to containing and processing an information about a curator.
 * @author Kostenko Roman
 */
public abstract class Curator extends Student {
    @Override
    public String toString() {
        return "Curator " + hashCode();
    }
}
