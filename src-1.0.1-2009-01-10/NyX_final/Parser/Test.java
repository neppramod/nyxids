/**
 * 
 */
import java.util.regex.*;
/**
 * @author root
 *
 */
public class Test {
	
	
	private static	String testRule="alert tcp !192.168.1.0/24 1000:2000 -> 192.160.2.0/24 111(content:|00 01 86 a5|; msg: external mountd access;)";
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

			Parser parser=new Parser();
			Rules rules;
			rules=parser.getRules(testRule);
			
			System.out.println(rules.getRuleOption().getGeneralOption().getMsg());
		}
}
