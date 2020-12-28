package dataStructuresPractice.stack.mustDo.LRU;

public class TestLRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(1, 10);
        cache.set(2, 20);
        //  20 -> 10
        System.out.println(cache.get(1)); // 10 -> 20

        cache.set(3, 30); // 30 -> 10
        System.out.println(cache.get(2)); // will print -1 as no such key is present
        System.out.println(cache.get(3));
    }
}
