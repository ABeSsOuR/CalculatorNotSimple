import bsh.Interpreter;
import bsh.EvalError;

public class MyBSH {
    public Object result;
    public Interpreter interpreter = new Interpreter();

    public MyBSH(String cal) throws EvalError
    {
        interpreter.eval("result = "+cal);
        result = interpreter.get("result");
    }
}
