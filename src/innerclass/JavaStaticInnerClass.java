package innerclass;

public class JavaStaticInnerClass {

    private int innerClassVariable = 2;

	//Static inner class can be private, protected, default, public
    private static class PrivateStaticInnerClass {}
    public static class PublicStaticInnerClass {}
    protected static class ProtectedStaticInnerClass {}
    static class DefaultStaticInnerClass {
    	private int var = 10;
    	
    	public void method() {
    		//System.out.println(innerClassVariable);
    	}
    }
    public static void main(String[] args) {
    	//Static inner class can be initiated without the enclosing class object
    	DefaultStaticInnerClass defaultStaticInnerClass = new DefaultStaticInnerClass();
        System.out.println(defaultStaticInnerClass.var);
	}

}
