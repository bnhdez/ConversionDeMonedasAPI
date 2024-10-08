# Conversor de Monedas

## Descripción

La aplicación **Conversor de Monedas** es un programa de consola en Java que permite convertir montos entre diferentes monedas utilizando la API de **ExchangeRate-API**. El usuario puede seleccionar una opción del menú para convertir una cantidad en dólares (USD) a otras monedas, o viceversa, y obtener el valor correspondiente. Además, el resultado de la conversión se guarda en un archivo JSON utilizando la librería **Gson**.

## Funcionalidades

- Convertir montos en dólares (USD) a otras monedas:
    - Peso argentino (ARS)
    - Real brasileño (BRL)
    - Soles peruanos (PEN)
    - Peso colombiano (COP)

- Convertir de estas monedas de vuelta a dólares (USD).

- Guardar el resultado de la conversión en un archivo JSON con un formato estructurado y legible.

## Estructura del Proyecto

El proyecto está compuesto por las siguientes clases:

1. **Principal**: Controla el flujo principal de la aplicación y el menú de interacción con el usuario. Permite seleccionar la conversión deseada y maneja los errores que puedan ocurrir durante la conversión o la escritura del archivo JSON.
2. **ConsultaApi**: Se encarga de hacer la consulta a la API de **ExchangeRate-API** para obtener la tasa de cambio entre las monedas especificadas.
3. **GeneradorJson**: Genera un archivo JSON que almacena la información de la conversión utilizando la librería **Gson**.
4. **Moneda**: Clase `record` que representa el objeto devuelto por la API con los detalles de la conversión (moneda base, moneda destino, tasa de conversión, y resultado).

## Menú Principal
Cuando inicies la aplicación, verás un menú con las opciones de conversión:

******************************************************
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

- Selecciona la opción correspondiente a la conversión que deseas realizar.
- Ingresa el monto que deseas convertir (debe ser mayor a 0).
- El programa mostrará el resultado y creará un archivo JSON con el nombre `origenDestino.json` (por ejemplo, `USD-ARS.json`) que contiene los detalles de la conversión.

### Ejemplo de Archivo JSON

El archivo JSON generado tendrá el siguiente formato:

```json
{
  "base_code": "USD",
  "target_code": "ARS",
  "conversion_rate": 95.3,
  "conversion_result": 9530.0
}
```
## Autor
Boris Nicholas Hernández Núñez

Este programa fue desarrollado como parte de un proyecto personal para aprender a trabajar con APIs en Java.