import javax.swing.*;
import java.math.*;

public class GaussElimination {
    public static void main(String[] args) {
        int proporcao;
        int k=0;
        int i;
        int j=0;
        

        proporcao= Integer.parseInt(JOptionPane.showInputDialog(null, "ÁLGEBRA LINEAR\n" +
                                 "Método de Gauss\n\nInforme a proporção da matriz: "));
        double matriz[][]= new double[proporcao][proporcao+1]; //Matriz que será utilizada no programa


        //Processo de obtenção dos dados da matriz
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                if (coluna==proporcao) {
                    matriz[linha][coluna]= Double.parseDouble(JOptionPane.showInputDialog("MATRIZ(" + proporcao +"x" + proporcao+")"+
                    "\n\nInsira o resultado da equação da linha " + (linha + 1) + ": "));
                }
                else {
                    matriz[linha][coluna]= Double.parseDouble(JOptionPane.showInputDialog("MATRIZ(" + proporcao +"x" + proporcao+")"+ 
                    "\n\nInsira o termo da linha " + (linha + 1) + " e coluna " + (coluna + 1) + ": "));
                }
            }
        }

        //Imprimindo Matriz Inicial
        String imprimeMatriz="";
        for (i=0;i<proporcao;i++){
            for (j=0;j<=proporcao;j++){
                imprimeMatriz+=matriz[i][j];
                imprimeMatriz+="    ";
            }
            imprimeMatriz+="\n";
        }
        JOptionPane.showMessageDialog(null, "MATRIZ INICIAL:\n" +imprimeMatriz);

    
        //Transformando matriz inicial em matriz pivô
        /*for (i=0;i<prop;i++){               
            for (k=1;k<prop;k++){
                if (matriz[i][i]==0){ //realiza a troca das linhas caso o primeiro termo seja igual a zero
                    for (j=0;j<=prop;j++){
                        double pivo=matriz[i][j];
                        matriz[i][j]=matriz[k][j]; 
                        matriz[k][j]=pivo;
                    }
                }
                else if(matriz[i][i]>matriz[k][i] && matriz[k][i]>=1){ //Verifica se há algum termo amxn menor que o a11 para realizar a troca de linha
                    for (j=0;j<=prop;j++){                             //pois o ideal é que o elemento a11 seja igual a 1.
                        double pivo=matriz[i][j];
                        matriz[i][j]=matriz[k][j]; 
                        matriz[k][j]=pivo;
                    }
                }    
            }
        }*/
        /*for (i=0;i<prop;i++){                       //processo de pivorizacao
        for (k=i+1;k<prop;k++){
            if ((matriz[i][i])<(matriz[k][i])){
                for (j=0;j<=prop;j++){
                    double temp=matriz[i][j];
                    matriz[i][j]=matriz[k][j];
                    matriz[k][j]=temp;
                }
            }
        }   
        }*/
        /*for(j=0; j<prop-2;j++){
            for(i=j;i<prop;i++){
                if(matriz[i][j]!=0){
                    if(i!=j){
                        double troca;
                        for(k=0;k<prop;k++){
                            troca= matriz[i][k];
                            matriz[i][k]=matriz[j][k];
                            matriz[j][k]=troca;
                        }
                    }
                }
                for(int m=j+1;m<prop;m++){
                    double a= -matriz[m][j]/matriz[j][j];
                    for(int n=j;n<prop;n++){
                        matriz[m][k]+=a*matriz[j][n];
                    }
                }
            }
        }
        for(j=0;j<prop-2;j++){
            for(i=j;i<prop;i++){
                if(matriz[i][j]!=0){ 
                    if(i!=j){
                        for(k=0;k<prop;k++){
                            double troca=matriz[i][k];
                            matriz[i][k]=matriz[j][j];
                            matriz[j][k] = troca;
                        }
                    }
                    for(int m=j+1;m<prop;m++){
                        double aux= -matriz[m][j]/matriz[j][j];
                        for(int n=j;n<prop;n++){
                            matriz[m][n]+=aux*matriz[j][n];
                        }
                    }
                }
            }
        }*/
        
        for (i=0;i<proporcao;i++){  
            for (k=i+1;k<proporcao;k++){
                for (j=0;j<=proporcao;j++){
                    double troca=matriz[i][j];
                    matriz[i][j]=matriz[k][j];
                    matriz[k][j]=troca;
                }
            }  
        }
    
        //Imprimindo Matriz Pivô
        String imprimeMatrizPivo="";
            for (i=0;i<proporcao;i++){
                for (j=0;j<=proporcao;j++){
                    imprimeMatrizPivo+=matriz[i][j];
                    imprimeMatrizPivo+="    ";
                }
                imprimeMatrizPivo+="\n";
            } 
        JOptionPane.showMessageDialog(null, "MATRIZ PIVÔ:\n" +imprimeMatrizPivo);    

        //Metodo de eliminação
        /*double res;
        for (i=0;i<proporcao-1;i++){                     
            for (k=i;k<proporcao;k++){
                if(matriz[k][i]!=0){
                    if(k!=i){
                        for(int z=i+1;z<proporcao;z++){
                            res=matriz[z][i]/matriz[i][i]; //A divisão pelo coeficiente permite encontrarmos os valores finais dos termos independentes;
                                for (int w=j;w<=proporcao;w++){
                                    matriz[z][w]-=res*matriz[i][w];
                                } //A partir daqui, todos os elementos abaixo dos pivôs são eliminados. Ou seja, ficam iguais a zero.
                        }
                    }
                }
            }
        }*/
        
        //Escalonamento
        double aux;
        for (i=0;i<proporcao-1;i++)                     //loop para realizar a eliminacao de gauss
        for (k=i+1;k<proporcao;k++){
            aux=matriz[k][i]/matriz[i][i];           //encontrando valor das vari�veis x's, ao dividir pelo seu coeficiente;
                for (j=0;j<=proporcao;j++)
                    matriz[k][j]=matriz[k][j]-aux*matriz[i][j];  //torna os elementos abaixo dos pivos iguais a zero ou elimina as vari�veis
        }

        //Imprimindo Matriz Final
        String imprimeMatrizFinal="";
            for (k=0;k<proporcao;k++){
                for (int q=0;q<=proporcao;q++){
                    imprimeMatrizFinal+=matriz[k][q];
                    imprimeMatrizFinal+="    ";
                }
                imprimeMatrizFinal+="\n";
            } 
        JOptionPane.showMessageDialog(null, "MATRIZ FINAL:\n" +imprimeMatrizFinal);
        
        //Etapa final da resolução do sistema linear
        double[] X = new double[matriz.length]; //X vai servir como um vetor auxiliar para armazenar o resultado.
        double vetorResultado[]= new double[proporcao]; //Vetor resultado
        for (i=matriz.length - 1; i>=0; i--) {              //o for faz com que os termos do lado direito da matriz
            X[i] = matriz[i][proporcao];                         //ou seja, os resultados, sejam calculados: a11 + a12 = x1
            for (j = i + 1; j<matriz.length; j++) {
                X[i] = X[i] - X[j] * matriz[i][j];
            }
            X[i] = X[i]/matriz[i][i];
            vetorResultado[i]=X[i];
        }

        //Imprimindo os valores de x1, x2, ... , xn.
        String imprimeResultadoFinal="";
        for(i=0;i<proporcao;i++) {
            imprimeResultadoFinal+="x" + (i+1) + "= ";
            imprimeResultadoFinal+=vetorResultado[i];
            imprimeResultadoFinal+="\n";
        }
        JOptionPane.showMessageDialog(null,"RESULTADO FINAL:\n" + imprimeResultadoFinal);                      
    }
}


