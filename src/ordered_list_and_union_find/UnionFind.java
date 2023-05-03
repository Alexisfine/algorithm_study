package ordered_list_and_union_find;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFind {
    private static class Element<T> {
        T value;
        public Element(T value) {
            this.value = value;
        }
    }

    public static class UnionFindSet<T> {
        private HashMap<T, Element<T>> elementMap;
        private HashMap<Element<T>, Element<T>> fatherMap;
        private HashMap<Element<T>, Integer> sizeMap;
        public UnionFindSet(List<T> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (T value : list) {
                Element<T> element = new Element<>(value);
                elementMap.put(value, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }

        private Element<T> findHead(Element<T> element) {
            Stack<Element<T>> stack = new Stack<>();
            while (element != fatherMap.get(element)) {
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
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }

        public void union(T a, T b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<T> aE = findHead(elementMap.get(a));
                Element<T> bE = findHead(elementMap.get(b));
                if (aE != bE) {
                    Element<T> big = sizeMap.get(aE) >= sizeMap.get(bE) ? aE : bE;
                    Element<T> small = big == aE ? bE : aE;
                    fatherMap.put(small, big);
                    sizeMap.put(big, sizeMap.get(big) + sizeMap.get(small));
                    sizeMap.remove(small);
                }
            }
        }
    }
}
