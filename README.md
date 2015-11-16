### paripassu ##

Projeto de Apresentação.

Para clonar o projeto execute o seguinte comando em seu prompt de comando
  "git clone https://github.com/navarrojava/paripassu.git "
  
Caso enfrente problemas em clonar siga as instruçoes neste link --> https://help.github.com/articles/importing-a-git-repository-using-the-command-line/


Para build Automatizado através do Maven utilize o seguinte comando:
              " mvn clean install tomcat7:run "  <br/>
Caso enfrente problemas com Maven siga as instruçoes a seguir  neste link -->  https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html               <p/>
              
              
              
Se utilizar a IDE Eclipse vá até a opção:
           Run as -> Maven Build -> e digite: " clean install tomcat7:run " 

O Projeto já está configurado com o plugin do container Tomcat7.
O CORS está habilitado, para integração com arquitetura REST.

<b>Atencão:</b> 
Neste projeto o Cors esta habilitado para aceitar requisiçoes de "qualquer" dominio. <p/>
Caso queira alterar esta configuração por segurança va até a classe CORSFilter,
no pacote filter e modifique : <br/>
response.addHeader("Access-Control-Allow-Origin", "*"); <br/>
para: <br/>
response.addHeader("Access-Control-Allow-Origin", "seudominio.foo.bar"); <p/>

 
                                                                                <b>Navarro Ferreira</b>




