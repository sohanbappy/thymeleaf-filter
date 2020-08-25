node {
   
   stage('SCM Checkout'){
    // Clone repo
	url: 'https://github.com/sohanbappy/thymeleaf-filter-pagination'
   
    }
       stage('Mvn Package'){
	   // Build using maven
	   def mvnHome = tool name: 'maven-3', type: 'maven'
	 //  sh "${mvnHome}/bin/mvn package"
	       sh "clean package"
   }
    
   }
