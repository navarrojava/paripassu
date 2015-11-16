<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Oraculo</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" /> " />
<link rel="stylesheet"
	href="<c:url value="/resources/css/estilo.css"/> " />

<script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"
	type="text/javascript"></script>
</head>
<body>

	<div class="container">

		<script type="text/javascript">

    var ws = new WebSocket("ws://localhost:8080/navarro/websocket");
        
      ws.onopen = function()
       {
          // Web Socket is connected, send data using send()
          var stringJson = {

          }
         // ws.send("Message to send");
          //alert("Message is sent...");
       };

       ws.onmessage = function (evt) 
       { 

         //alert("Message is received..."+evt.data);
          var msgRecebida = JSON.parse(evt.data);
          $(".classParaRemover"+ msgRecebida.id).remove();
          montaBtEvento(msgRecebida.onde, msgRecebida.id, msgRecebida.texto,msgRecebida.id);


          //alert("Message is received..."+received_msg);
       };

       ws.onclose = function()
       { 
          // websocket is closed.
          //alert("Connection is closed..."); 
       };

 

function start() {

      var nAleatorio = Math.floor((Math.random() * 1000) + 1);
      var msg = {
          
            onde: localRandom(),
            id: nAleatorio,
            texto:   "texto",
            date: "Date()"
          };

        ws.send(JSON.stringify(msg));
      //webSocket.send('hello');
      return false;
    }

    function localRandom(){
var r_text = new Array();
r_text[0] = "hall";
r_text[1] = "atendimento";
r_text[2] = "deslocamento";

var i = Math.floor(3*Math.random())
return(r_text[i]);
}



function habBtParaInteracao(){

    // QUando clinca no evento recebido envia para evento atendimento
  $(".eventohall").on("click", function(){
    var id_evento = $(this).data("id-evento");
    $("#btEnviaAtendimento").attr("onclick","enviaParaAtendimento("+id_evento+");");
    $("#badgeEnviaAtendimento").html(id_evento);

    // remove este evento atual da div

  });
     // QUando clinca no evento recebido envia para evento atendimento
  $(".eventoatendimento").on("click", function(){
    var id_evento = $(this).data("id-evento");
    $("#btEnviaDeslocamento").attr("onclick","enviaParaDeslocamento("+id_evento+");");
    $("#badgeEnviaDeslocamento").html(id_evento);

    // remove este evento atual da div

  });

   $(".eventodeslocamento").on("click", function(){
    var id_evento = $(this).data("id-evento");
    $("#btEnviaObservacao").attr("onclick","enviaParaObservacao("+id_evento+");");
    $("#badgeEnviaObservacao").html(id_evento);

    // remove este evento atual da div

  });

      $(".eventoobservacao").on("click", function(){
    
      //start();
    //var id_evento = $(this).data("id-evento");
    $("#btGeraEvento").attr("onclick","start();");
    //$("#badgeEnviaObservacao").html(id_evento);

    // remove este evento atual da div

  });

}




  function montaBtEvento(_onde, _id, _string, _badge){
     var bt = '';
         bt += '<div class="row evento'+_onde+' classParaRemover'+_id+'" data-id-evento="'+_id+'" >';
         bt += '       <button class="btn btn-primary" type="button"  style="height:50px;width:100%">';
         bt += '           '+_string+' <span class="badge">'+_badge+'</span>';
         bt += '       </button>';
         bt += '   </div>';
         $("#"+_onde).append(bt);

         habBtParaInteracao();
  }
 
           
        

  function enviaSocket(_deOnde, _paraOnde, _id_evento_recebido){

       var variavelJson = {

                onde : _paraOnde,
                    id : _id_evento_recebido,
                 texto : _id_evento_recebido
                       
                          };

     
       ws.send(JSON.stringify(variavelJson));
  }


    // função que chama socket e atualiza div atendimento
  function enviaParaHall(_id_evento){
    enviaSocket('hall', 'hall', _id_evento);
   // $(".classParaRemover"+_id_evento).remove();

  }
    // função que chama socket e atualiza div atendimento
  function enviaParaAtendimento(_id_evento){
    enviaSocket('atendimento', 'atendimento', _id_evento);
   // $(".classParaRemover"+_id_evento).remove();

  }

      // função que chama socket e atualiza div deslocamento
  function enviaParaDeslocamento(_id_evento){
    enviaSocket('deslocamento', 'deslocamento', _id_evento);
   // $(".classParaRemover"+_id_evento).remove();

  }

  function enviaParaObservacao(_id_evento){
    enviaSocket('observacao', 'observacao', _id_evento);
    //$(".classParaRemover"+_id_evento).remove();

  }

 $(function() {

  habBtParaInteracao();

 
  // Quando a pessoa clica fora do tira o onclick do envia para atendimento
  $("body").on("click", function(){
    //$("#btEnviaAtendimento").removeAttr("onclick");
    //$("#badgeEnviaAtendimento").html("-");
  });



});
</script>

		<div class="panel-group  ">

			<div class="col-xs-12 col-sm-3 col-lg-3">

				<div class="panel panel-default">

					<div class="panel-body" style="height: 620px" id="hall">

						<div class="row eventohall classParaRemover1" data-id-evento="1">
							<button class="btn btn-primary" type="button"
								style="height: 50px; width: 100%">
								-- TESTE1--- <span class="badge">1</span>
							</button>
						</div>

						<div class="row eventohall classParaRemover2" data-id-evento="2">
							<button class="btn btn-danger" type="button"
								style="height: 50px; width: 100%">
								-- TESTE2--- <span class="badge">2</span>
							</button>
						</div>

						<div class="row eventohall classParaRemover3" data-id-evento="3">
							<button class="btn btn-success" type="button"
								style="height: 50px; width: 100%">
								-- TESTE3--- <span class="badge">3</span>
							</button>
						</div>

						<div class="row eventohall classParaRemover4" data-id-evento="4">
							<button class="btn btn-warning" type="button"
								style="height: 50px; width: 100%">
								-- TESTE4--- <span class="badge">4</span>
							</button>
						</div>

					</div>
					<div class="panel-footer">
						<button class="btn btn-primar" type="button"
							style="height: 50px; width: 100%" id="btEnviaAtendimento">
							EVNIA PARA DIR <span class="badge" id="badgeEnviaAtendimento">0</span>
						</button>
					</div>
				</div>
			</div>

			<div class="col-xs-12 col-sm-3 col-lg-3">
				<div class="panel panel-default">

					<div class="panel-body" id="atendimento" style="height: 620px">



					</div>


					<div class="panel-footer">
						<button class="btn btn-primar" type="button"
							style="height: 50px; width: 100%" id="btEnviaDeslocamento">
							EVNIA PARA DIR <span class="badge" id="badgeEnviaDeslocamento">0</span>
						</button>
					</div>


				</div>
			</div>







			<div class="col-xs-12 col-sm-3 col-lg-3">
				<div class="panel panel-default">

					<div class="panel-body" id="deslocamento" style="height: 620px">



					</div>


					<div class="panel-footer">
						<button class="btn btn-primar" type="button"
							style="height: 50px; width: 100%" id="btEnviaObservacao">
							EVNIA PARA DIR <span class="badge" id="badgeEnviaObservacao">0</span>
						</button>
					</div>


				</div>
			</div>



			<div class="col-xs-12 col-sm-3 col-lg-3">
				<div class="panel panel-default">

					<div class="panel-body" id="observacao" style="height: 620px">


					</div>



					<div class="panel-footer">
						<button class="btn btn-primar" type="button"
							style="height: 50px; width: 100%" id="btGeraEvento"
							onclick="start()">
							GERA EVENTO<span class="badge" id="badgeEnviaObservacao">0</span>
						</button>
					</div>





				</div>
			</div>
</body>
</html>
