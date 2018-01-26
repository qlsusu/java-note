package bean.byteinfo;

/**
 * Created by qlong on 17/7/3.
 */
public class FatherBean {
    static {
        System.out.println("father static");
    }

    protected String desc;

    protected void method2() {
        System.out.println("fatherbean.method2");
    }

    public static void fatherStaticMethod() {
        System.out.println("FatherBean.staticMethod");
    }
}
