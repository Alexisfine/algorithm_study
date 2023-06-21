package leetcode_questions.linked_list;

public class _1472_Design_Browser_History {
    class Node {
        String url;
        Node prev;
        Node next;
        public Node(String url) {
            this.url = url;
        }
    }
    class BrowserHistory {
        Node curNode;
        Node homeNode;


        public BrowserHistory(String homepage) {
            this.homeNode = new Node(homepage);
            this.curNode = homeNode;
        }

        public void visit(String url) {
            Node newCurNode = new Node(url);
            curNode.next = newCurNode;
            newCurNode.prev = curNode;
            curNode = newCurNode;
        }

        public String back(int steps) {
            for (int i = 0; i < steps && curNode.prev != null; i++) {
                curNode = curNode.prev;
            }
            return curNode.url;
        }

        public String forward(int steps) {
            for (int i = 0; i < steps && curNode.next != null; i++) {
                curNode = curNode.next;
            }
            return curNode.url;
        }
    }
}
