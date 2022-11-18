import javax.swing.*;
import java.math.*;

public class MetodoGauss {
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

    
        //"Matriz Pivô"
        for (i=0;i<proporcao;i++){  
            for (k=i+1;k<proporcao;k++){
                for (j=0;j<=proporcao;j++){
                    double troca=matriz[i][j];
                    matriz[i][j]=matriz[k][j];
                    matriz[k][j]=troca; //realiza a troca entre as linhas da matriz
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

        
        //Escalonamento
        double aux;
        for (i=0;i<proporcao-1;i++)             
        for (k=i+1;k<proporcao;k++){
            aux=matriz[k][i]/matriz[i][i]; //os termos são divididos pelos coeficientes para encontrarmos os valores dos termos completos
                for (j=0;j<=proporcao;j++)
                    matriz[k][j]=matriz[k][j]-aux*matriz[i][j]; 
                    //a partir daqui, os valores abaixo dos termos Pivô estarão zerados
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

