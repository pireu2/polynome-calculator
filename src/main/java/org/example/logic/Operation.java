package org.example.logic;

import org.example.data.Polynomial;

public interface Operation {
    public default Polynomial performOperation(Polynomial p1, Polynomial p2) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }
    public default Polynomial performOperation(Polynomial p1) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }
}
