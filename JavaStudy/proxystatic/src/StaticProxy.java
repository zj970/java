import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class StaticProxy {

    public static void main(String[] args) {
        new Thread(()-> System.out.println("我爱你")).start();
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }
}
interface Marry{
    //人间四大喜事 久旱逢甘露 他乡遇故知 洞房花烛夜 金榜题名时
    void HappyMarry();
}

//真实角色 你去结婚
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("你要结婚了，新郎不是我");
    }
}
//代理角色，帮助你结婚
class WeddingCompany implements Marry{

    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚之后收尾款");
    }

    private void before() {
        System.out.println("结婚之前布置现场");
    }
}