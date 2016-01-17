/**
 * Simple Map interface to experiment with 
 * tradeoffs in low-level implementations
 * of Maps in Java as part of Compsci 100. 
 * @author ola
 *
 */

public interface IMapper {

    public abstract boolean containsKey(String key);

    public abstract int get(String key);

    public abstract void put(String key, int value);

    public abstract void printAll();
    
    public abstract int size();

}