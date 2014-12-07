/**
 *  @Author: 	Ryan K K Lam
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
package testing;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * @ClassName: RepeatRule  
 * @Description:  Define a repeatable Rule.  
 * 				  The repeat times is defined in annotation RunCount(count=X). 
 * @date 2014-12-7 
 */

@Retention(RetentionPolicy.RUNTIME)  
@interface RunCount {  
    int count() default 1;   
}  

class RepeatRule implements TestRule  {  //no MethodRule to use as it's deprecated, TestRule to replace it
   
	/* (non-Javadoc)
	 * @see org.junit.rules.TestRule#apply(org.junit.runners.model.Statement, org.junit.runner.Description)
	 */
	@Override
	public Statement apply(final Statement stmt, final Description des) {
		return new Statement() { 
	        @Override  
	        public void evaluate() throws Throwable {  
	            int count =1;//Default  
	            RunCount rCount=  des.getAnnotation(RunCount.class) ;  
	            if (rCount != null)  
	                count=rCount.count();  
	          
	            while(count-->0){  
	            	stmt.evaluate();  
	            }  
	        } 
			
		};
	} 
}
	