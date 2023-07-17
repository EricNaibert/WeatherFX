package com.github.ericnaibert.weatherfx.window;

import javafx.scene.Node;

import java.util.ArrayList;

public class NodeStorage {

    private static final ArrayList<Node> nodeStorageList = new ArrayList<>();

    public static ArrayList<Node> getNodeStorageList() {
        return nodeStorageList;
    }

    public static void addToNodeStorageList(Node node) {
        NodeStorage.nodeStorageList.add(node);
    }
}
