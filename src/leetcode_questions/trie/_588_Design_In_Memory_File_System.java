package leetcode_questions.trie;

import java.util.*;

public class _588_Design_In_Memory_File_System {
    class FileSystem {
        private class Node {
            TreeMap<String, Node> childrenMap;
            boolean isFile;
            public Node() {
                childrenMap = new TreeMap<>();
                isFile = false;
            }
        }

        Node root;
        Map<String, String> fileContents;

        public FileSystem() {
            root = new Node();
            fileContents = new HashMap<>();
        }

        public List<String> ls(String path) {
            Node curNode = root;
            String str = null;
            for (int i = 1; i < path.length(); i++) {
                int j = i;
                while (j < path.length() && path.charAt(j) != '/') j++;
                str = path.substring(i, j);
                curNode = curNode.childrenMap.get(str);
                i = j;
            }
            if (curNode.isFile) return List.of(str);
            List<String> res = new ArrayList<>();
            for (String s : curNode.childrenMap.keySet()) {
                res.add(s);
            }
            return res;
        }

        public void mkdir(String path) {
            Node curNode = root;
            String str = null;
            for (int i = 1; i < path.length(); i++) {
                int j = i;
                while (j < path.length() && path.charAt(j) != '/') j++;
                str = path.substring(i, j);
                if (!curNode.childrenMap.containsKey(str)) {
                    curNode.childrenMap.put(str, new Node());
                }
                curNode = curNode.childrenMap.get(str);
                i = j;
            }
        }

        public void addContentToFile(String filePath, String content) {
            Node curNode = root;
            String str = null;
            for (int i = 1; i < filePath.length(); i++) {
                int j = i;
                while (j < filePath.length() && filePath.charAt(j) != '/') j++;
                str = filePath.substring(i, j);
                if (!curNode.childrenMap.containsKey(str)) {
                    curNode.childrenMap.put(str, new Node());
                }
                curNode = curNode.childrenMap.get(str);
                i = j;
            }
            curNode.isFile = true;
            fileContents.put(filePath, fileContents.getOrDefault(filePath, "") + content);
        }

        public String readContentFromFile(String filePath) {
            return fileContents.get(filePath);
        }
    }
}
