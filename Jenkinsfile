node {
   
   stage('SCM Checkout'){
    // Clone repo
	url: 'https://github.com/sohanbappy/device-monitor'
   
    }
       stage('Mvn Package'){
	   // Build using maven
	   def mvn = tool name: 'maven-3', type: 'maven'
	   sh "${mvn} clean package deploy"
   }
    
   }
