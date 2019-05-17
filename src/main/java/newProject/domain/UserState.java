package newProject.domain;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public enum UserState {
    ONLINE(0),

    OFFLINE(1);

    private int state;

    UserState(int i) {
        this.state = 1;
    }

    public static UserState valueOfInteger(int i) {
        switch (i) {
            case 0: return UserState.ONLINE;

            case 1: return UserState.OFFLINE;

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
