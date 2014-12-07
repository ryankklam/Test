/**
 *  @Author: 	Ryan K K Lam
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
package testing;

/**
 * @ClassName: Calcuate
 * @Description: TODO(Override class description here)
 * @date 2014-12-5
 */
public class Calculate {

	private static int result;

	public void add(int n) {
		result = result + n;
	}

	public void minus(int n) {
		result = result - 1; // Bug: 正确的应该是 result =result-n
	}

	public void divide(int n) {
		result = result / n;
	}

	public void mul(int n) {
		// 此方法尚未写好
	}

	public void square(int n) {
		result = n * n;
	}

	public void squareRoot(int n) {
		while (1 == 1) {
			// Bug : 死循环 }
		}
	}

	public void clear() {
		// 将结果清零
		result = 0;
	}

	public int getResult() {
		return result;
	}

}