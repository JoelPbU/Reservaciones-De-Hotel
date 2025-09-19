import java.util.Scanner;

public class Hotel {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int roomNum = 1;
        String userName;
        int nightNum;
        float price;
        int PreviousRoom = 0;
        int habitaciones[][] = {{101,1},{102,1},{103,1},{104,1},{105,1}};
        int reserva, bandera ;
        
        for (int i = 0; i<2; i++)
        {
            System.out.println("Ingrese el nombre del cliente:");
            userName =  scanner.nextLine();
            
            System.out.println("Ingrese el número de habitación:");
            roomNum = scanner.nextInt();
            while (roomNum == PreviousRoom) 
            {
                System.out.println("No puede reservar la misma habitacion que el cliente anterior");
                System.out.println("Ingrese el número de habitación:");
                roomNum = scanner.nextInt();
                
            }
            PreviousRoom = roomNum;
            while (roomNum<101 || roomNum>105) 
            {
                System.out.println("Habitacion no disponible");
                System.out.println("Ingrese el número de habitación:");
                roomNum = scanner.nextInt();
                PreviousRoom = roomNum;
            }
            
            System.out.println("Ingrese el número de noches:");
            nightNum = scanner.nextInt();

            System.out.println("Ingrese el precio por noche:");
            price = scanner.nextFloat();

            float TotalPrice = nightNum * price;
            scanner.nextLine(); // Limpiar el buffer
            System.out.println("Reporte final:");
            System.out.println("Cliente: "+ userName + " - Habitacion: " + roomNum + " - Total a pagar: " + TotalPrice );

           switch (roomNum) {
            case 101:
                habitaciones[0][1]=0;                 
                break;
            case 102:
                habitaciones[1][1]=0;                 
                break;
            case 103:
                habitaciones[2][1]=0;                 
                break;
            case 104:
                habitaciones[3][1]=0;                 
                break;
            case 105:
                habitaciones[4][1]=0;                 
                break;
                default:
                System.out.println("Habitacion no disponible");
           }
           System.out.print("Habitaciones disponibles:");
           for (int j = 0; j<habitaciones.length; j++)
           {
                if(habitaciones[j][1] == 1)
                {
                    System.out.print(habitaciones[j][0]);
                    if (habitaciones[i] == habitaciones[4])
                        {
                            System.out.print(" ");
                        }
                        else
                        {
                            System.out.print(", ");
                        }
                }
            }
            System.out.println(" ");

            System.out.print("Habitaciones ocupadas: ");
            for (int j = 0; j<habitaciones.length; j++)
                {
                    if(habitaciones[j][1] == 0)
                    {
                        System.out.print(habitaciones[j][0]);
                        if (habitaciones[i] == habitaciones[4])
                        {
                            System.out.print(" ");
                        }
                        else
                        {
                            System.out.print(", ");
                        }
                    }
                }
                System.out.println(" ");
                System.out.println("¿Quiere cancelar una reserva? Si : 1 - No: 0");
                bandera = scanner.nextInt();
                scanner.nextLine();
                switch (bandera) {
                    case 0:
                        break;
                    case 1:
                        System.out.println("Ingrese la habitacion de la reserva que quiere cancelar: ");
                        reserva = scanner.nextInt();
                        scanner.nextLine();
                            switch (reserva) {
                                case 101:
                                    habitaciones[0][1]=1;
                                    i = i-1;                 
                                    break;
                                case 102:
                                    habitaciones[1][1]=1;
                                    i = i-1;          
                                    break;
                                case 103:
                                    habitaciones[2][1]=1;
                                    i = i-1;                 
                                    break;
                                case 104:
                                    habitaciones[3][1]=1;
                                    i = i-1;                 
                                    break;
                                case 105:
                                    habitaciones[4][1]=1;
                                    i = i-1;                 
                                    break;
                                    default:
                                    System.out.println("Habitacion no disponible");
                                    }
                        break;
                    default:
                        break;
                }

    }
} 
} 

