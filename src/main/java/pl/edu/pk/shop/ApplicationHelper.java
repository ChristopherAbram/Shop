package pl.edu.pk.shop;

public class ApplicationHelper {
	// vars {
		
		private static ApplicationHelper __ah = null;
		
	// } methods {
		// public {
			
			/**
			 **/
			public static ApplicationHelper getInstance(){
				if(__ah == null)
					__ah = new ApplicationHelper();
				return __ah;
			}// end getInstance
			
			/**
			 **/
			public void init(){
				
				return;
			}// end init
			
		// } protected {
			
			
			
		// } private {
				
			private ApplicationHelper(){}
			
		// }
	// }
}
