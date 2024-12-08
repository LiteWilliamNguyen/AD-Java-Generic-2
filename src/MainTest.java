import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MainTest {
    @Test
    public void testAddAndGet() {
        Cache<String> cache = new Cache<>();
        cache.add("key1", "value1");
        assertEquals("value1", cache.get("key1"));// Verify that the value is added.
    }

    @Test
    public void testClear() {
        Cache<Integer> cache = new Cache<>();
        cache.add("key1", 1);
        cache.clear();
        assertNull(cache.get("key1"));
    }

    @Test
    public void testAddAll() {
        Cache<Number> numberCache = new Cache<>();
        Cache<Integer> intCache = new Cache<>();
        intCache.add("key1", 10);
        numberCache.addAll(intCache);
        assertEquals(10, numberCache.get("key1"));
    }

    @Test
    public void testAddAndRetrieve() {
        Cache<String> cache = new Cache<>();
        cache.add("key1", "value1");
        assertEquals("value1", cache.get("key1")); // Verify correct value is retrieved.
    }

    //edge case
    @Test
    public void testOverwriteWithSameKey() {
        Cache<String> cache = new Cache<>();
        cache.add("key1", "value1");
        cache.add("key1", "value2"); // Adding a new value with the same key.
        assertEquals("value2", cache.get("key1")); // Verify that the old value is replaced.
    }

    @Test
    public void testAddDuplicateKeys() {
        Cache<String> cache = new Cache<>();
        cache.add("key1", "value1");
        cache.add("key1", "value2");
        assertEquals("value2", cache.get("key1"));// Verify the value is the same in key1 and key2
    }

    @Test
    public void testAddAllEdgeCaseEmpty() {
        Cache<Integer> intCache = new Cache<>();
        Cache<Integer> emptyCache = new Cache<>();
        intCache.addAll(emptyCache);
        assertTrue(intCache.get("key1") == null);
    }
}