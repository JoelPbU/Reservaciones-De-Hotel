import java.util.Scanner;

public class Hotel {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Variables principales
        int roomNum = 1; // Número de habitación solicitada
        String userName; // Nombre del cliente
        int nightNum;    // Número de noches
        float price;     // Precio por noche

        // Matriz que guarda las habitaciones y su estado
        // {número de habitación, estado} → 1 = disponible, 0 = ocupada
        int habitaciones[][] = {{101,1},{102,1},{103,1},{104,1},{105,1}};

        int reserva, bandera, index; // Variables auxiliares

        // Ciclo principal: permite hasta 5 reservas
        for (int i = 0; i < 5; i++) {

            // 1. Pedir nombre del cliente
            System.out.println("Ingrese el nombre del cliente:");
            userName = scanner.nextLine();
            
            // 2. Pedir número de habitación con validación
            System.out.println("Ingrese el número de habitación:");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido de habitación:");
                scanner.next(); // descarta la entrada inválida
            }
            roomNum = scanner.nextInt();
            
            // Buscar índice de la habitación en la matriz
            index = -1;
            for (int j = 0; j < habitaciones.length; j++) {
                if (habitaciones[j][0] == roomNum) {
                    index = j;
                    break;
                }
            }

            // Validar si la habitación ya está ocupada
            if (index != -1 && habitaciones[index][1] == 0) {
                System.out.println("La habitación ya está ocupada, elija otra.");
                System.out.println("Ingrese el número de habitación:");
                while (!scanner.hasNextInt()) {
                    System.out.println("Por favor, ingrese un número válido de habitación:");
                    scanner.next(); // descarta la entrada inválida
                }
                roomNum = scanner.nextInt();
            }

            // Validar que el número de habitación esté entre 101 y 105
            while (roomNum < 101 || roomNum > 105) {
                System.out.println("Habitación no disponible");
                System.out.println("Ingrese el número de habitación:");
                while (!scanner.hasNextInt()) {
                    System.out.println("Por favor, ingrese un número válido de habitación:");
                    scanner.next(); // descarta la entrada inválida
                }
                roomNum = scanner.nextInt();

                // Repetir la validación de ocupación
                index = -1;
                for (int j = 0; j < habitaciones.length; j++) {
                    if (habitaciones[j][0] == roomNum) {
                        index = j;
                        break;
                    }
                }
                if (index != -1 && habitaciones[index][1] == 0) {
                    System.out.println("La habitación ya está ocupada, elija otra.");
                    System.out.println("Ingrese el número de habitación:");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Por favor, ingrese un número válido de habitación:");
                        scanner.next();
                    }
                    roomNum = scanner.nextInt();
                }
            }
            
            // 3. Pedir número de noches
            System.out.println("Ingrese el número de noches:");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido de noches:");
                scanner.next(); // descarta la entrada inválida
            }
            nightNum = scanner.nextInt();

            // 4. Pedir precio por noche
            System.out.println("Ingrese el precio por noche:");
            while (!scanner.hasNextFloat()) {
                System.out.println("Por favor, ingrese un número válido de precio por noche:");
                scanner.next(); // descarta la entrada inválida
            }
            price = scanner.nextFloat();

            // Calcular precio total
            float TotalPrice = nightNum * price;
            scanner.nextLine(); // Limpiar el buffer

            // Mostrar reporte final
            System.out.println("Reporte final:");
            System.out.println("Cliente: " + userName + " - Habitación: " + roomNum + " - Total a pagar: " + TotalPrice);

            // Marcar habitación como ocupada (0)
            switch (roomNum) {
                case 101: habitaciones[0][1] = 0; break;
                case 102: habitaciones[1][1] = 0; break;
                case 103: habitaciones[2][1] = 0; break;
                case 104: habitaciones[3][1] = 0; break;
                case 105: habitaciones[4][1] = 0; break;
                default: System.out.println("Habitación no disponible");
            }

            // Mostrar habitaciones disponibles
            System.out.print("Habitaciones disponibles: ");
            for (int j = 0; j < habitaciones.length; j++) {
                if (habitaciones[j][1] == 1) {
                    System.out.print(habitaciones[j][0]);
                    if (habitaciones[i] == habitaciones[4]) {
                        System.out.print(" ");
                    } else {
                        System.out.print(", ");
                    }
                }
            }
            System.out.println(" ");

            // Mostrar habitaciones ocupadas
            System.out.print("Habitaciones ocupadas: ");
            for (int j = 0; j < habitaciones.length; j++) {
                if (habitaciones[j][1] == 0) {
                    System.out.print(habitaciones[j][0]);
                    if (habitaciones[i] == habitaciones[4]) {
                        System.out.print(" ");
                    } else {
                        System.out.print(", ");
                    }
                }
            }
            System.out.println(" ");

            // Opción de cancelar una reserva
            System.out.println("¿Quiere cancelar una reserva? Si : 1 - No: 0");
            bandera = scanner.nextInt();
            scanner.nextLine();

            switch (bandera) {
                case 0: // No cancelar
                    break;
                case 1: // Cancelar
                    System.out.println("Ingrese la habitación de la reserva que quiere cancelar: ");
                    reserva = scanner.nextInt();
                    scanner.nextLine();

                    switch (reserva) {
                        case 101: habitaciones[0][1] = 1; System.out.println("Reservación Cancelada"); i = i - 1; break;
                        case 102: habitaciones[1][1] = 1; System.out.println("Reservación Cancelada"); i = i - 1; break;
                        case 103: habitaciones[2][1] = 1; System.out.println("Reservación Cancelada"); i = i - 1; break;
                        case 104: habitaciones[3][1] = 1; System.out.println("Reservación Cancelada"); i = i - 1; break;
                        case 105: habitaciones[4][1] = 1; System.out.println("Reservación Cancelada"); i = i - 1; break;
                        default: System.out.println("Habitación no disponible");
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
