package com.xiaolingyun.lab6.exception;

public class NonKeySpecifiedException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    public static NonKeySpecifiedException DEFAULT_INSTANCE =
            new NonKeySpecifiedException("At least one key must be specified");

    public NonKeySpecifiedException(String message) {
        super(message);
    }
}
