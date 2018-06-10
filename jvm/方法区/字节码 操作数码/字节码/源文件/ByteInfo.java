package bean.byteinfo;

/**
 * Created by qlong on 17/7/3.
 */
public class ByteInfo extends FatherBean {
    private final static int staticFinalAge = 2;
    private static int staticAge = 1;

    private static final String TAG1 = "tag1";
    private static final String TAG2 = TAG1 + "_tag2";
    private static final String TAG3 = TAG2 + "_tag3";

    static {
        staticAge = 1000;
        System.out.println("byte info static");
    }

    private int age = 1;

    private FatherBean fatherBean = new FatherBean();
    private static FatherBean staticFatherBean = new FatherBean();
    private static final FatherBean staticFinalFatherBean = new FatherBean();
    //    private Bean4 bean4;
    private volatile int volatileAge;

    public ByteInfo() {
    }

    public ByteInfo(int age) {
        this.age = age;
    }

    private int age2 = 2;

    public void method1() {
        int i = 2;
        System.out.println("i:" + i);
        System.out.println("hello");
        System.out.println(age);
        System.out.println(desc);
//        new Bean2().method();

        //+对应的字节码
        i = i + 2;
        int k = 2;
        i = i + k;

        //new对应的字节码
        ByteInfo byteInfo = new ByteInfo(2);

        //字符串+对应的字节码
        String a = "hello ";
        String b = "world ";
        String c = "there ";
        for (int j = 0; j < 10; j++) {
            String d = a + b + c + "here";
            System.out.println(a + d);
        }

        //调用普通方法的字节码
        sub(i, k, 1000l, "abc");

        //调用sync方法
        syncSub(1, 2);

        //调用方法（其中有sync代码块，针对于this）
        subContainsSync(1, 2);

        //调用方法（其中有sync代码块，针对于fatherbean）
        subContainsSync2(1, 2);

        int some = volatileAge;
        volatileAge = 3;
        some = volatileAge;
        volatileAge = 4;
        volatileAge += 1;
        volatileAge = volatileAge + 2;
        System.out.println("volatileAge:" + volatileAge);

        method2();
        method3();

        method4().method3();

        staticMethod();
        FatherBean.fatherStaticMethod();

        String str = TAG3;
        System.out.println(str);

        boolean isSame = 1 == 1;
        isSame = volatileAge == age;
        ByteInfo byteInfo1 = new ByteInfo();
        ByteInfo byteInfo2 = new ByteInfo();
        isSame = byteInfo1 == byteInfo2;
    }

    private void sub(int a, int b, long c, String str) {
        long d = a + b + c;
    }

    private synchronized void syncSub(int a, int b) {
        int c = a + b;
    }

    private void subContainsSync(int a, int b) {
        synchronized (this) {
            int c = a + b;
        }
    }

    private void subContainsSync2(int a, int b) {
        int c;
        synchronized (fatherBean) {
            c = a + b;
        }
        System.out.println(c);
    }

    @Override
    protected void method2() {
        super.method2();
        System.out.println("byteinfo.method2");
    }

    private void method3() {
        System.out.println("byteinfo.method3");
    }

    private ByteInfo method4() {
        System.out.println("byteinfo.method4");
        return this;
    }

    private static void staticMethod() {
        System.out.println("ByteInfo.staticMethod");
    }
}
