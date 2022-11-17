import javax.swing.*;

public class GaussElimination {
    public static void main(String[] args) {
        int prop;
        int k;
        int i;
        int j;
        

        prop= Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a proporção da matriz: "));
        double matriz[][]= new double[prop][prop+1];
        double matrizResultado[][]= new double[prop][prop+1];
        JOptionPane.showMessageDialog(null, "Matriz(" + prop +"x" + prop+")"); 
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                if (prop + 1 != coluna+1) {
                    matriz[linha][coluna]= Double.parseDouble(JOptionPane.showInputDialog("Insira o termo da linha " + (linha + 1) + " e coluna " + (coluna + 1) + ": "));
                }
                else {
                    matriz[linha][coluna]= Double.parseDouble(JOptionPane.showInputDialog("Insira o resultado da equação da linha " + (linha + 1) + ": "));
                    matrizResultado[linha][coluna]=matriz[linha][coluna];
                }

            }
        }

        //Matriz Inicial
        String imprimeMatriz="";
        for (i=0;i<prop;i++){
            for (j=0;j<=prop;j++){
                imprimeMatriz+=matriz[i][j];
                imprimeMatriz+="    ";
            }
            imprimeMatriz+="\n";
        }
        JOptionPane.showMessageDialog(null, "MATRIZ INICIAL\n" +imprimeMatriz);

        
       //Equacao inicial
       /*String resultado2="";
       for(i = 0; i < prop; i++) { 
        for(j = 0; j < prop + 1; j++) {
            if(j < prop){
                if (i >= 0 && j > 0){
                        if ( j > 0){
                            if (matriz[i][j] > 0)
                            System.out.print("+ " + matriz[i][j] + " x" + (j+1) +  " ");
                            else
                            System.out.print(matriz[i][j] + " x" + (j+1) +  " ");
                        }
                            else{
                                if (matriz[i][j] < 0)
                                System.out.print(" - " + matriz[i][j] + " x" +(j+1) + " ");
                                else
                                System.out.print(matriz[i][j] + " x" + (j+1)+  " ");
                            }
                    }
                    else
                    System.out.print(matriz[i][j] + " x" + (j+1) + " ");
            }
            else
            System.out.println(" = " + matriz[i][j] +"\n");
        }
      }*/


    }
}
