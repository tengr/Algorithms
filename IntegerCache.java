import java.lang.reflect.Field;
public class IntegerCache{
	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
 
      Class cache = Integer.class.getDeclaredClasses()[0]; //1
      Field myCache = cache.getDeclaredField("cache"); //2
      myCache.setAccessible(true);//3
 
      Integer[] newCache = (Integer[]) myCache.get(cache); //4
      System.out.println(newCache.length + "\t" + newCache[0] + "\t" + newCache[newCache.length-1]);
      System.out.println(newCache[133] + "\t" + newCache[132]);
      newCache[132] = newCache[133]; //5
 
      int a = 2;
      int b = a + a;
      System.out.printf("%d + %d = %d", a, a, b); //
	}
}