package ie.tcd.cs7ns6.node;

import java.util.Objects;

public class Node {
    private final String addr;

    public Node(String addr) {
        this.addr = addr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node self = (Node) o;
        return Objects.equals(addr, self.addr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addr);
    }

    @Override
    public String toString() {
        return "Node{" +
                "addr='" + addr + '\'' +
                '}';
    }
}
