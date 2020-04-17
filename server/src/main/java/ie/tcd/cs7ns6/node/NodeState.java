package ie.tcd.cs7ns6.node;

import ie.tcd.cs7ns6.exceptions.UnknownStateException;

public abstract class NodeState implements Runnable {
    public abstract void run();
    public abstract RaftState timeout();
    public abstract RaftState taskCompleted() throws UnknownStateException;

    /**
     * the state code of RAFT node
     */
    public enum RaftState {

        FOLLOWER(0),

        CANDIDATE(1),

        LEADER(2);

        int code;

        RaftState(int code) {
            this.code = code;
        }

        public static RaftState value(int i) {
            for (RaftState value : RaftState.values()) {
                if (value.code == i) {
                    return value;
                }
            }
            return null;
        }
    }
}

