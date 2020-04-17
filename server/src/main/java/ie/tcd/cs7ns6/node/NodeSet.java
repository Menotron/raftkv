package ie.tcd.cs7ns6.node;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NodeSet implements Serializable {
    private List<Node> peerList = Collections.synchronizedList(new ArrayList<>());
    private volatile  Node leader;
    private volatile Node self;

    private NodeSet(){}

    public static NodeSet getInstance() {
        return NodeSetLazyHolder.INSTANCE;
    }

    private static class NodeSetLazyHolder {
        private static final NodeSet INSTANCE = new NodeSet();
    }

    public void setSelf(Node peer) {
        self = peer;
    }

    public Node getSelf() {
        return self;
    }

    public void addPeer(Node peer) {
        peerList.add(peer);
    }

    public void removePeer(Node peer) {
        peerList.remove(peer);
    }

    public List<Node> getPeers() {
        return peerList;
    }

    public Node getLeader() {
        return leader;
    }

    public void setLeader(Node peer) {
        leader = peer;
    }

    public List<Node> getPeersWithOutSelf() {
        List<Node> list2 = new ArrayList<>(peerList);
        list2.remove(self);
        return list2;
    }


    @Override
    public String toString() {

        return "NodeSet{" +
                "list=" + peerList +
                ", leader=" + leader +
                ", self=" + self +
                '}';
    }
}
