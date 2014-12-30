package app;

import java.io.Serializable;

public class Data implements Serializable {
    private int mValue;

    public Data(int value) {
        mValue = value;
    }

    public int getValue() {
        return mValue;
    }

    @Override
    public String toString() {
        return String.format("v=%d", mValue);
    }
}
