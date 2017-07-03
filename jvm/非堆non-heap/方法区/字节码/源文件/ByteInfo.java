package bean.byteinfo;

/**
 * Created by qlong on 17/7/3.
 */
public class ByteInfo extends FatherBean {
    private final static int staticFinalAge = 2;
    private static int staticAge = 1;
    private int age = 1;

    private FatherBean fatherBean = new FatherBean();
    private static FatherBean staticFatherBean = new FatherBean();
    private static final FatherBean staticFinalFatherBean = new FatherBean();

    public void method1() {
        int i = 2;
        System.out.println("i:" + i);
        System.out.println("hello");
        System.out.println(age);
        System.out.println(desc);
    }
}
