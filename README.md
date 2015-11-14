### paripassu ##

Projeto de Apresentação.

Para build Automatizado através do Mavem utilize o seguinte comando:

 " mvn clean install tomcat7:run " <p/>
Se utilizar a IDE Eclipse vá até a opção  Run as -> Mavem Build -> e digite:  " clean intsall tomcat7:run " 


O Projeto já está configurado com o plugin do container Tomcat7.

O CORS está habilitado, para integração com arquitetura REST.

<b>Atencão:</b> 
Neste projeto o Cors esta habilitado para aceitar requisiçoes de "qualquer" dominio. <p/>
Caso queira alterar esta configuração por segurança va até a classe CORSFilter,
no pacote filter e modifique : <p/>
response.addHeader("Access-Control-Allow-Origin", "*"); <p/>
para: <p/>
response.addHeader("Access-Control-Allow-Origin", "seudominio.foo.bar");




