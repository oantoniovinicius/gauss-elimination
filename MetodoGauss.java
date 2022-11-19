import javax.swing.*;

public class MetodoGauss {
    public static void main(String[] args) {
        int proporcao;
        int k=0;
        int i;
        int j=0;

        proporcao= Integer.parseInt(JOptionPane.showInputDialog(null, "ÁLGEBRA LINEAR\n" +
                                 "Método de Gauss\n\nInforme a proporção da matriz: "));
        double matriz[][]= new double[proporcao][proporcao+1]; //Matriz que será utilizada no programa
        //[Proporção+1] pois essa matriz deve ser uma matriz aumentada, já que a ultima coluna será a coluna de resultados.


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
        String imprimeMatriz=""; //um método basico para imprimir a matriz percorrendo suas linhas e colunas
        for (i=0;i<proporcao;i++){
            for (j=0;j<=proporcao;j++){
                imprimeMatriz+=matriz[i][j]; //o string recebe os valores armazenados na matriz separados
                imprimeMatriz+="          ";
            }
            imprimeMatriz+="\n";
        }
        JOptionPane.showMessageDialog(null, "MATRIZ INICIAL:\n" +imprimeMatriz);

    
        //"Matriz Pivô"-> aqui é realizada a troca da linha 1 com a linha 2.
        for (i=0;i<proporcao;i++){  
            for (k=i+1;k<proporcao;k++){
                for (j=0;j<=proporcao;j++){
                    double troca=matriz[i][j]; //uma variavel troca é usada como auxiliar
                    matriz[i][j]=matriz[k][j];
                    matriz[k][j]=troca; //realiza a troca entre as linhas da matriz 
                }
            }  
        }    
        
        //Escalonamento
        double aux; //aqui será armazenado o valor da operação de divisão entre os termos e os coeficientes diagonais
        for (i=0;i<proporcao-1;i++)             
            for (k=i+1;k<proporcao;k++){
                aux=matriz[k][i]/matriz[i][i]; //os termos são divididos pelos coeficientes diagonais
                                               // para encontrarmos os valores dos termos completos
                    for (j=0;j<=proporcao;j++)
                        matriz[k][j]-=aux*matriz[i][j]; //operações elementares serão realizadas aqui
                        //a partir daqui, os valores abaixo dos termos Pivô estarão zerados
            }
        

        //Imprimindo Matriz Final
        String imprimeMatrizFinal=""; //um método basico para imprimir a matriz percorrendo suas linhas e colunas
            for (k=0;k<proporcao;k++){
                for (int q=0;q<=proporcao;q++){
                    imprimeMatrizFinal+=(String.format("%.2f", matriz[k][q])); //stringformat para garantir maior precisão no resultado
                    imprimeMatrizFinal+="          ";
                }
                imprimeMatrizFinal+="\n";
            } 
        JOptionPane.showMessageDialog(null, "MATRIZ FINAL:\n" +imprimeMatrizFinal);
        
        //Etapa final da resolução do sistema linear
        double[] vetorAuxiliar = new double[proporcao]; //esse vetor auxiliar vai armazenar o resultado.
        double[] vetorResultado= new double[proporcao]; //Vetor resultado
        for (i=matriz.length - 1; i>=0; i--) {              //o for faz com que os termos do lado direito da matriz
            vetorAuxiliar[i] = matriz[i][proporcao];        //ou seja, os resultados, sejam calculados: a11 + a12 = x1
            for (j = i + 1; j<matriz.length; j++) {
                vetorAuxiliar[i] = vetorAuxiliar[i] - vetorAuxiliar[j] * matriz[i][j]; 
            } //acima foi realizado a etapa fundamental para encontrarmos o resultado dos coeficientes X's.
            vetorAuxiliar[i]= vetorAuxiliar[i]/matriz[i][i]; 
            vetorResultado[i]= vetorAuxiliar[i];
        }

        //Imprimindo os valores de x1, x2, ... , xn.
        String imprimeResultadoFinal="";
        for(i=0;i<proporcao;i++) {
            imprimeResultadoFinal+="x" + (i+1) + "= ";
            imprimeResultadoFinal+=(String.format("%.2f", vetorResultado[i])); //StringFormat para maior precisão no resultado.
            imprimeResultadoFinal+="\n";
        }
        JOptionPane.showMessageDialog(null,"RESULTADO FINAL:\n" + imprimeResultadoFinal);                      
    }
}

