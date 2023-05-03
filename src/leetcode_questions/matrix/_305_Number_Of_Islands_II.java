package leetcode_questions.matrix;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class _305_Number_Of_Islands_II {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        return null;
    }

    private static class Element<T> {
        public T value;
        public Element(T value) {
            this.value = value;
        }
    }

    public static class UnionFind<T> {
        private HashMap<T, Element<T>> elementMap;
        private HashMap<Element<T>, Element<T>> fatherMap;
        private HashMap<Element<T>, Integer> sizeMap;
        public UnionFind(List<T> list) {
            for (T i : list) {
                Element<T> element = new Element<>(i);
                elementMap.put(i, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }


        private Element<T> findHead(Element<T> element) {
            Stack<Element<T>> stack = new Stack<>();
            while (fatherMap.get(element) != element) {
                stack.push(element);
                element = fatherMap.get(element);
            }
            while (!stack.isEmpty()) {
                fatherMap.put(stack.pop(), element);
            }
            return element;
        }

        public boolean isSameSet(T a, T b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                return fatherMap.get(elementMap.get(a)) == fatherMap.get(elementMap.get(b));
            }
            return false;
        }

        public void union(T a, T b) {
            if (!elementMap.containsKey(a) || !elementMap.containsKey(b)) return;
            Element<T> aH = fatherMap.get(elementMap.get(a));
            Element<T> bH = fatherMap.get(elementMap.get(b));
            Element<T> large = sizeMap.get(aH) > sizeMap.get(bH) ? aH : bH;
            Element<T> small = large == aH ? bH : aH;
            fatherMap.put(small, large);
            sizeMap.put(large, sizeMap.get(large) + sizeMap.get(small));
            sizeMap.remove(small);
        }

    }
}
