# Application

Aplicación con quarkus, que compara los tiempos con spring boot.

Se compone de las aplicaciones:
    
    1. app-quarkus
    2. app-service-transaction
    
   POST Con quarkus (iamgen nativa):
   
  ![Screenshot from running application](img/post-quarkus.png?raw=true "POST")
  
   POST Con Spring Boot:
   
   ![Screenshot from running application](img/post-springboot.png?raw=true "POST")
   
    ## Se configuro logback con logstash (APM, ELASTIC SUITE)

   Create file gelf.conf
        
              input {
                      gelf {
                        port => 12201
                      }
                      tcp {
                        type => "cloud"
                        host => "0.0.0.0"
                        port => 9601
                        mode => "server"
                        #codec => "json"
                      }  
                    }
                    output {
                     stdout {
                       id => "normal"
                     }
                      elasticsearch {
                        hosts => ["http://localhost:9200"]
                        manage_template => false
                        index => "technical-%{+yyyy.MM.dd}"
                      }
                    }
                    
   execute start logstash:    
       
        /usr/share/logstash/bin/logstash -f config/gelf.conf

    
    ![Screenshot from running application](img/elk-log.png?raw=true "POST")
    
      
