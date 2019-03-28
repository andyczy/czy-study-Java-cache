package test;

import com.czy.czycache.CzyCache;
import com.czy.czycache.impl.WeakValueDataStore;
import org.junit.Assert;
import org.junit.Test;

/**
 * Author: Chen zheng you
 * CreateTime: 2019-03-28 16:31
 * Description:
 */
public class WeakValueHolderTest {


    @Test
    public void TestWeakValue() throws InterruptedException {
        CzyCache<String, User> cache = new CzyCache<String, User>(new WeakValueDataStore<String, User>());
        String key = "czy";
        User user = new User();
        user.setName("czy");
        cache.put(key, user);

        /**释放对象强引用，等待GC**/
        user = null;
        Assert.assertEquals("czy", cache.get(key).getName());

        /**  cache.remove(key)  **/

        System.out.println("GC 没回收之前、缓存获取：" + cache.get(key));
        System.gc();
        Thread.sleep(1000);
        /**JVM显式调用GC，get 返回null **/
        System.out.println("GC 没回收之后、缓存获取： " + cache.get(key));
    }


}
