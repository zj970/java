package Demo09;
//interface关键字,接口都需要要有实现类
public interface UserService {
    //接口中的所有定义都是抽象的public abstract
    void add(String name);
    void delete(String name);
    void update(String name);
    void query(String name);

}
