# Final-Prog-Av
Proyecto Final de la materia Programación Avanzada

# Proyecto de Cajero Automático

Este proyecto representa la implementación de un cajero automático en Java.

## Clases Principales

### ATM (Cajero Automático)
La clase principal que representa el cajero automático. Contiene métodos para ejecutar operaciones como consulta de saldo, retiro y depósito.

[Ver código](src/Banco/ATM/ATM.java)

### Dispenser (Dispensador de Billetes)
Clase que gestiona la dispensación de billetes en el cajero automático.

[Ver código](src/Banco/ATM/Dispenser.java)

### Operacion (Operación Bancaria)
Clase abstracta que define la estructura básica para las operaciones bancarias.

[Ver código](src/Banco/operaciones/Operacion.java)

### Deposito (Operación de Depósito)
Clase que representa la operación de depósito en una cuenta bancaria.

[Ver código](src/Banco/operaciones/Deposito.java)

### Extraccion (Operación de Extracción)
Clase que representa la operación de extracción de dinero en una cuenta bancaria.

[Ver código](src/Banco/operaciones/Extraccion.java)

### CambiarPIN (Operación de Cambiar NIP)
Clase que representa la operación de cambiar el NIP de una cuenta bancaria.

[Ver código](src/Banco/operaciones/CambiarPIN.java)

## Interfaces y Utilidades

### Teclado (Interfaz de Entrada)
Interfaz que define métodos para la entrada de datos, implementada mediante un teclado.

[Ver código](src/Banco/interfaces/Teclado.java)

### Pantalla (Interfaz de Salida)
Interfaz que define métodos para la salida de datos, implementada mediante una pantalla.

[Ver código](src/Banco/interfaces/Pantalla.java)

## Instrucciones de Ejecución

1. Clona el repositorio: `git clone https://github.com/JuaniPardo/Final-Prog-Av.git`
2. Navega al directorio del proyecto: `cd Final-Prog-Av`
3. Compila el código: `javac -d bin src/**/*.java`
4. Ejecuta la aplicación: `java -cp bin Banco.ATM.ATM`

## Contribuciones

Si encuentras algún problema o tienes sugerencias de mejora, no dudes en crear un [issue](https://github.com/JuaniPardo/Final-Prog-Av.git/issues) o enviar un [pull request](https://github.com/JuaniPardo/Final-Prog-Av.git/pulls).

## Autores

- Lucas Caraballo
- Juan Ignacio Pardo