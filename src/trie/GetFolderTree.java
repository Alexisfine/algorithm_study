package trie;

import java.util.TreeMap;

public class GetFolderTree {
    private static class Node {
        String name;
        TreeMap<String, Node> nextMap;

        public Node(String name) {
            this.name = name;
            nextMap = new TreeMap<>();
        }
    }

    public static void print(String[] folderPaths) {
        if (folderPaths == null || folderPaths.length < 1) return;
        Node root = generateFolderTree(folderPaths);
        printProcess(root, 0);
    }

    public static Node generateFolderTree(String[] folderPaths) {
        Node root = new Node("");
        for (String folderPath : folderPaths) {
            String[] path = folderPath.split("\\\\");
            Node cur = root;
            for (int i = 0; i < path.length; i++) {
                if (!cur.nextMap.containsKey(path[i])) {
                    cur.nextMap.put(path[i], new Node(path[i]));
                }
                cur = cur.nextMap.get(path[i]);
            }
        }
        return root;
    }

    public static void printProcess(Node root, int level) {
        StringBuilder sb = new StringBuilder();
        if (level != 0) {
            for (int i = 0; i < level; i++) sb.append(" ");
            sb.append(root.name);
            System.out.println(sb);
        }
        for (Node next : root.nextMap.values()) {
            printProcess(next, level + 1);
        }
    }

    public static void main(String[] args) {
        String test = "a\\b\\c";
        System.out.println(test);
        String[] arr = test.split("\\\\");
        for (String str : arr) System.out.println(str);
    }
}
