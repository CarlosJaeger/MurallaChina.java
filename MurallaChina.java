
//Alumno : Carlos Jara|Rut : 21 200 766-8
import java.io.*;

class Solution {
    //Se revisa cuantos numeros son mayores a si mismo si son mayores se sigue con el siguiente en el array
    //y se van sumando ,si no este se detiene 
    public static String CalculoDeTorres(int[] ArrI_AlturaDeTorres,int NumeroDeTorres ) {
        
        int[] ArrI_CalculoFinal = new int[NumeroDeTorres];
        int PosicionVar = 0;
        for (int PosicionFija=0; PosicionFija<NumeroDeTorres; PosicionFija++)
        {
            int GuardiasVistos = 0;
            PosicionVar=PosicionFija;
            while(PosicionVar>=0)
            {
                if (ArrI_AlturaDeTorres[PosicionFija]>=ArrI_AlturaDeTorres[PosicionVar])
                {
                    GuardiasVistos++;
                    PosicionVar--;
                }
                else{break;}
            }
            ArrI_CalculoFinal[PosicionFija]=GuardiasVistos;
        }
        //Union de Array de Ints a un solo String
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ArrI_CalculoFinal.length; i++) 
        {
            stringBuilder.append(ArrI_CalculoFinal[i]);
        }
        String joinedString = stringBuilder.toString();
        String StringFinal = joinedString.replace("", " ").trim();
        
        
        return StringFinal;
    }
};

public class MurallaChina {

    public static void main(String[] args) throws IOException{
        //Nombrar Clase De Lectura Y Escritura BR y BW
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));

        // T = Cuantas veces quieres correr la funcion
        int T = Integer.parseInt(BR.readLine().trim());
        
        
        while(T<=40 && T>=1)
        {
            
            int NumeroDeTorres = Integer.parseInt(BR.readLine().trim());
            //String S_AlturaDeTorres Ej: 3 4 1 2 3
            String S_AlturaDeTorres = BR.readLine();
            //Array split ( String regex, int limit) para separar el string en un array de ints
            String[] ArrS_AlturaDeTorres = S_AlturaDeTorres.split(" ",NumeroDeTorres);

            int[] ArrI_AlturaDeTorres = new int[NumeroDeTorres];
            
            //Iteracion de Array de Strings a Array de Ints
            for (int i=0; i<NumeroDeTorres; i++)
            {
                ArrI_AlturaDeTorres[i] = Integer.parseInt(ArrS_AlturaDeTorres[i]);
            }
            
            String Final = Solution.CalculoDeTorres(ArrI_AlturaDeTorres,NumeroDeTorres);
            BW.write(Final);
            T--;
        }

        BR.close();
        BW.close();
    }
}