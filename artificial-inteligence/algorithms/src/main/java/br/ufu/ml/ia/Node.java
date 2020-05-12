package br.ufu.ml.ia;

import java.util.LinkedList;
import java.util.List;

public final class Node<T extends Comparable> implements Comparable<Node<? extends Comparable>> {

    private List<Node<T>> children = new LinkedList<>();
    private Node<T> parent = null;
    private T data;
    private boolean visited = false;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> parent) {
        this.data = data;
        this.parent = parent;
        this.parent.addChild(this);
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void addChild(T data) {
        Node<T> child = new Node<>(data);
        child.parent = this;
        this.children.add(child);
    }

    public void addChild(Node<T> child) {
        child.parent = this;
        this.children.add(child);
    }

    public Node<T> getParent() {
        return parent;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        return this.children.size() == 0;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void removeParent() {
        this.parent = null;
    }

    public int getHeight() {
        if (this.isRoot()) {
            return 0    ;
        } else {
            return 1 + this.parent.getHeight();
        }
    }

    @Override
    public int compareTo(Node<? extends Comparable> o) {
        return data.compareTo(o.data);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Node)) return false;
        Node data = (Node) obj;
        return data.getData().equals(this.data);
    }
}