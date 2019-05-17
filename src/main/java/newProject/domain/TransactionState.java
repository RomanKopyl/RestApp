package newProject.domain;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public enum TransactionState {
    OPEN(0),

    CLOSED(1),

    DELETED(2),

    CANCELED(3),

    ONCHECK(4);

    private int state;

    TransactionState(int i) {
        this.state = i;
    }

    public static TransactionState valueOfInteger(int i) {
        switch (i) {
            case 0: return TransactionState.OPEN;

            case 1: return TransactionState.CLOSED;

            case 2: return TransactionState.DELETED;

            case 3: return TransactionState.CANCELED;

            case 4: return TransactionState.ONCHECK;

            default: throw new NotImplementedException();
        }
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
