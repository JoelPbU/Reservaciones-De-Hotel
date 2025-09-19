import java.util.Scanner;
public class pruebas 
{
    
    public static void main(String[] args) throws Exception{
    Scanner scanner = new Scanner(System.in);
    int habitaciones[] = {1,2,3,4,5};

    for(int i = 0 ; i<habitaciones.length; i++){
        System.out.print(habitaciones[i]);
        if (habitaciones[i] == habitaciones[4]){
            
            System.out.print(" ");
        
        }
        else
        {
            System.out.print(", ");
        }
        

    }

    }
}
