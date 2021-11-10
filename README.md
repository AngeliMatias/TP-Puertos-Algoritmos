#Algoritmos

##Trabajo Práctico

El trabajo práctico consiste en realizar una aplicación para el manejo de puertos y viajes de los
distintos buques.
Puertos
La información de los puertos estará dada en un archivo de texto puertos.txt que deberá leerse
al iniciar la aplicación. En cada línea del archivo estará la información de un puerto. La
información a contemplar debe obtenerse de:
https://www.joc.com/port-news/international-ports
Debe identificarse cada puerto por un código. Se debe mostrar un menú en el cual se pueda:
- consultar por un puerto en particular
- dar de alta/baja un puerto
- mostrar todos los puertos (ordenados por código)
  Viajes
  A partir de la lectura de un archivo de texto viajes.txt, que deberá hacerse inmediatamente
  después de leer el archivo puertos.txt, se generará un grafo pesado dirigido.
  En cada línea estará la información de cada viaje, separada por espacios:
  Se debe contemplar una variable costo del viaje.
  Adicionalmente se debe tener en cuenta las horas de viaje.
  La aplicación debe pedir al usuario el ingreso de los códigos de puertos de partida y de destino,
  y debe buscar la combinación de viajes más económica o de menor tiempo. El usuario debe
  poder elegir si el camino mínimo está representado por el costo del viaje o por la duración.
  Se debe imprimir el detalle del viaje, el costo de cada tramo y el total del viaje. Si hubiera más
  de una combinación óptima, deberá listarlas todas. Puede suceder que no haya ninguna
  combinación, en ese caso se informa que no hay conexiones posibles.
  
Consideraciones
- Los archivos están bien formados.
- Las implementaciones puede ser recursivas o iterativas.
  A tener en cuenta
- Diseño de algoritmos
- Funcionalidad completa
- Interfaz con el usuario
- Modularización /nombres
- Buenas prácticas de programación
- Diseño UML / Informe
- POO
- Código fuente de propia autoría

  
  Entrega
  
  Semanalmente cada equipo deberá realizar una exposición del avance del proyecto.
  La entrega final y defensa (individual) se realizará el día 17 de noviembre 2021.