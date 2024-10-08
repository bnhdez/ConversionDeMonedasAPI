import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaApi consulta = new ConsultaApi();
        String origenMoneda = "";
        String destinoMoneda = "";
        double monto;
        int opcion = 1;

        while (opcion != 9){
            System.out.println("""
                    \n******************************************************
                    Sea Bienvenido/a al conversor de monedas =)
                    
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> Real brasileño
                    4) Real brasileño =>> Dólar
                    5) Dólar =>> Soles
                    6) Soles =>> Dólar
                    7) Dólar =>> Peso colombiano
                    8) Peso colombiano =>> Dólar
                    9) Salir
                    ******************************************************
                    
                    Elija una opción válida: """);

            opcion = lectura.nextInt();

            switch (opcion){
                case 1:
                    origenMoneda = "USD";
                    destinoMoneda = "ARS";
                    break;
                case 2:
                    origenMoneda = "ARS";
                    destinoMoneda = "USD";
                    break;
                case 3:
                    origenMoneda = "USD";
                    destinoMoneda = "BRL";
                    break;
                case 4:
                    origenMoneda = "BRL";
                    destinoMoneda = "USD";
                    break;
                case 5:
                    origenMoneda = "USD";
                    destinoMoneda = "PEN";
                    break;
                case 6:
                    origenMoneda = "PEN";
                    destinoMoneda = "USD";
                    break;
                case 7:
                    origenMoneda = "USD";
                    destinoMoneda = "COP";
                    break;
                case 8:
                    origenMoneda = "COP";
                    destinoMoneda = "USD";
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida");
                    break;
            }

            if (opcion >= 1 && opcion <= 8) {
                System.out.println("Ingrese el monto que desea convertir: ");
                monto = lectura.nextDouble();

                if (monto > 0){
                    try {
                        Moneda consultaConversion = consulta.buscaMoneda(origenMoneda, destinoMoneda, monto);
                        System.out.println("El valor de " + monto +
                                " [" + origenMoneda + "] equivale a " + consultaConversion.conversion_result() +
                                " [" + destinoMoneda + "]");

                        GeneradorJson generador = new GeneradorJson();
                        generador.guardarArchivo(consultaConversion, origenMoneda, destinoMoneda);
                    }catch (NumberFormatException e){
                        System.out.println("Error, número no encontrado: " + e.getMessage());
                    } catch (IOException e) {
                        System.out.println("Error al grabar datos a JSON " + e.getMessage());
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("Por favor, ingrese un monto mayor a 0");
                }
            }
        }
        System.out.println("Finalizó la ejecución del programa");
    }
}
