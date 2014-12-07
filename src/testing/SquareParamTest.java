/**
 *  @Author: 	Ryan K K Lam
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
package testing;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @ClassName: SquareParamTest
 * @Description: TODO(Override class description here)
 * @date 2014-12-6
 * 
 * JUnit参数化测试的五个步骤：
	(1)为准备使用参数化测试的测试类指定特殊的运行器 org.junit.runners.Parameterized。
	(2)为测试类声明几个变量，分别用于存放期望值和测试所用数据。
	(3)为测试类声明一个带有参数的公共构造函数，并在其中为第二个环节中声明的几个变量赋值。
	(4)为测试类声明一个使用注解 org.junit.runners.Parameterized.Parameters 修饰的，返回值为 java.util.Collection 的公共静态方法，并在此方法中初始化所有需要测试的参数对。
	(5)编写测试方法，使用定义的变量作为参数进行测试。
 */

//(1)步骤一：测试类指定特殊的运行器org.junit.runners.Parameterized 
@RunWith(Parameterized.class)
public class SquareParamTest {
	private static Calculate calculate = new Calculate();

	
	// (2)步骤二：为测试类声明几个变量，分别用于存放期望值和测试所用数据。
	private int param;
	private int result;

	// 构造函数，对变量进行初始化
	// (3)步骤三：为测试类声明一个带有参数的公共构造函数，并在其中为第二个环节中声明的几个变量赋值。  
	public SquareParamTest(int param, int result) {
		this.param = param;
		this.result = result;
	}
	
	// (4)步骤四：为测试类声明一个使用注解 org.junit.runners.Parameterized.Parameters 修饰的，返回值为  
    // java.util.Collection 的公共静态方法，并在此方法中初始化所有需要测试的参数对。  
	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] { { 2, 4 }, { 0, 0 }, { -3, 9 } });
	}
	
	
  //@Rule element must be public	
  @Rule  
  public RepeatRule rule = new RepeatRule();  
  
  @Rule  
  public WatchmanTest wt = new WatchmanTest(); //extends TestWatcher
  
	
	// (5)步骤五：编写测试方法，使用定义的变量作为参数进行测试。  
	@Test   
	@RunCount(count=2)//Run twice
	public void square(){
		System.out.println("SquareParamTest Run!~");
		calculate.square(param);
		assertEquals(result, calculate.getResult()); 
	}
}