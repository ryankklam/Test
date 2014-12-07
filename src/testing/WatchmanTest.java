/**
 *  @Author: 	Ryan K K Lam
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
package testing;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * @ClassName: WatchmanTest
 * @Description: TODO(Override class description here)
 * @date 2014-12-7
 */
public class WatchmanTest extends TestWatcher { //TestWatcher also an implemention of TestRule

		  protected String watchedLog = ""; 
		  
		  @Override
	      protected void starting(Description d) {  
	    	  watchedLog = d.getClassName() + "." + d.getMethodName();  
	          System.out.println("starting: " + watchedLog);  
	      }  

		  @Override
	      protected void succeeded(Description d) {  
	    	  watchedLog = d.getClassName() + " " + d.getMethodName();  
	          System.out.println("succeeded: " + watchedLog);  
	      }  

		  @Override
	      protected void failed(Throwable e, Description d) {  
	    	  watchedLog = d.getClassName() + " " + d.getMethodName();  
	          System.out.println("failed: " + watchedLog);  
	      }  

		  @Override
	      protected void finished(Description d) {  
	    	  watchedLog = d.getClassName() + " " + d.getMethodName();  
	          System.out.println("finished: " + watchedLog);  
	      }  
}
