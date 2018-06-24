/**
 * Created by lxq on 2018/6/24.
 */
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * 字符串转化为浮点数的工具类
 */
public class StringToNum {

    //输入框中是否是合法数字
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }

    //将合法字符串转化为数字
    public static float stringToNum(String str)
    {
        float a=0;
        if(isNumeric(str))
        {
            a = Float.parseFloat(str);
        }
        return a;
    }
    public static void main(String arsg[])
    {
        String input = "123";
        System.out.println(stringToNum(input));
    }
}
