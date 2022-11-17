import javax.swing.*;

public class GaussElimination {
    public static void main(String[] args) {
        int prop;
        int k=0;
        int i;
        int j=0;
        

        prop= Integer.parseInt(JOptionPane.showInputDialog(null, "ÁLGEBRA LINEAR\n" +
                                 "Método de Gauss\n\nInforme a proporção da matriz: "));
        double matriz[][]= new double[prop][prop+1]; //Matriz que será utilizada no programa
        double vetorResultado[]= new double[prop]; //Vetor resultado

        //Processo de obtenção dos dados da matriz
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                if (coluna==prop) {
                    matriz[linha][coluna]= Double.parseDouble(JOptionPane.showInputDialog("MATRIZ(" + prop +"x" + prop+")"+
                    "\n\nInsira o resultado da equação da linha " + (linha + 1) + ": "));
                }
                else {
                    matriz[linha][coluna]= Double.parseDouble(JOptionPane.showInputDialog("MATRIZ(" + prop +"x" + prop+")"+ 
                    "\n\nInsira o termo da linha " + (linha + 1) + " e coluna " + (coluna + 1) + ": "));
                }

            }
        }

        //Imprimindo Matriz Inicial
        String imprimeMatriz="";
        for (i=0;i<prop;i++){
            for (j=0;j<=prop;j++){
                imprimeMatriz+=matriz[i][j];
                imprimeMatriz+="    ";
            }
            imprimeMatriz+="\n";
        }
        JOptionPane.showMessageDialog(null, "MATRIZ INICIAL:\n" +imprimeMatriz);

    
        //Transformando matriz inicial em matriz pivô
        for (i=0;i<prop;i++){               
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
        }
        
        //Imprimindo Matriz Pivô
        String imprimeMatrizPivo="";
            for (k=0;k<prop;k++){
                for (int q=0;q<=prop;q++){
                    imprimeMatrizPivo+=matriz[k][q];
                    imprimeMatrizPivo+="    ";
                }
                imprimeMatrizPivo+="\n";
            } 
        JOptionPane.showMessageDialog(null, "MATRIZ PIVÔ:\n" +imprimeMatrizPivo);    

        //Metodo de eliminação
        double res;
        for (i=0;i<prop-1;i++)                     
            for (k=1;k<prop;k++){
                res=matriz[k][i]/matriz[i][i]; //A divisão pelo coeficiente permite encontrarmos os valores finais dos termos independentes;
                    for (j=0;j<=prop;j++){
                        matriz[k][j]=matriz[k][j]-res*matriz[i][j];
                    } //A partir daqui, todos os elementos abaixo dos pivôs são eliminados. Ou seja, ficam iguais a zero.
        }

        //Imprimindo Matriz Final
        String imprimeMatrizFinal="";
            for (k=0;k<prop;k++){
                for (int q=0;q<=prop;q++){
                    imprimeMatrizFinal+=matriz[k][q];
                    imprimeMatrizFinal+="    ";
                }
                imprimeMatrizFinal+="\n";
            } 
        JOptionPane.showMessageDialog(null, "MATRIZ FINAL:\n" +imprimeMatrizFinal);
        
        //Etapa final da resolução do sistema linear
        double[] X = new double[matriz.length]; //X vai servir como um vetor auxiliar para armazenar o resultado.
        for (i=matriz.length - 1; i>=0; i--) {              //o for faz com que os termos do lado direito da matriz
            X[i] = matriz[i][prop];                         //ou seja, os resultados, sejam calculados: a11 + a12 = x1
            for (j = i + 1; j < matriz.length; j++) {
                X[i] = X[i] - X[j] * matriz[i][j];
            }
            X[i] = X[i] / matriz[i][i];
            vetorResultado[i]=X[i];
        }

        //Imprimindo os valores de x1, x2, ... , xn.
        String imprimeResultadoFinal="";
        for(i=0;i<prop;i++) {
            imprimeResultadoFinal+="x" + (i+1) + "= ";
            imprimeResultadoFinal+=vetorResultado[i];
            imprimeResultadoFinal+="\n";
        }
        JOptionPane.showMessageDialog(null,"RESULTADO FINAL:\n" + imprimeResultadoFinal);                      
    }
}


