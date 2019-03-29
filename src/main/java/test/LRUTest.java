package test;

import com.czy.czycache.CzyCache;
import com.czy.czycache.impl.LRUDataStore;
import org.junit.Assert;
import org.junit.Test;

/**
 * Author: Chen zheng you
 * CreateTime: 2019-03-29 14:31
 * Description:
 */
public class LRUTest {

    @Test
    public void TestLRU() {
        CzyCache<String, User> cache = new CzyCache<String, User>(new LRUDataStore<>(2));
        String key = "czy";
        User user = new User();
        user.setName("czy");

        String key1 = "test";
        User user1 = new User();
        user1.setName("test");

        String key2 = "abc";
        User user2 = new User();
        user2.setName("abc");

        cache.put(key, user);
        cache.put(key1, user1);
        cache.get(key1);
        cache.put(key2, user2);

        System.out.println(cache.get(key1).getName());

        if (cache.get(key) != null) {
            Assert.assertEquals("czy", cache.get(key).getName());
        }
        if (cache.get(key1) != null) {
            Assert.assertEquals("test", cache.get(key1).getName());
        }
        if (cache.get(key2) != null) {
            Assert.assertEquals("abc", cache.get(key2).getName());
        }
    }


}
