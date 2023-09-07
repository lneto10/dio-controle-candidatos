import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};
        
        for (String candidato: candidatos){
            entrandoEmContato(candidato);
            int tentativasRealizadas = 1;
            boolean continuarTentando = true;
            boolean atendeu=false;

            do {
                atendeu = atender();
                continuarTentando = !atendeu;

                if(continuarTentando)
                    tentativasRealizadas++;
                else
                    System.out.println("Contato realizado com sucesso");
                

            }while(continuarTentando && tentativasRealizadas<3);

            if(atendeu)
                System.out.println("Conseguimos contato com o "+candidato+" na "+tentativasRealizadas+" tentativa realizada");
            else
                System.out.println("Não Conseguimos contato com o "+candidato+" na "+tentativasRealizadas+" tentativa realizada");

        }

        
    }

    	static void entrandoEmContato(String candidato) {

        }
    //método auxiliar
	static boolean atender() {
		return new Random().nextInt(3)==1;	
	}

    static void imprimirSelecionados(){
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};

        System.out.println("Imprimindo lista de candidatos");

        for (int indice=0;indice < candidatos.length;indice++){
            System.out.println("O candidato de n° "+(indice+1)+" é "+candidatos[indice]);

        }

    }

    static void selecaoCandidatos(){
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato "+candidato+" solicitou este valor de salario "+salarioPretendido);
            if (salarioBase >= salarioPretendido){
                System.out.println("O candidato "+candidato+ " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
   }


    static void analisarCandidato(double SalarioPretendido){
        double salarioBase = 2000.0;

        if (salarioBase > SalarioPretendido){
            System.out.println("Ligar para o candidato");

        }else if(salarioBase==SalarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO, COM CONTRA PROPOSTA;");
        }else{
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS.");
        }


    }
}