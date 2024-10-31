**Parcial 2 Arep**
* Arquitectura

**Descripcion General**

- En esta aplicacion web se muestran los algoritmos de busqueda lineal y busqueda binaria mediante un servicio de microservicios desplegados en AWS. Laarquitectura incluye tres maquinas EC" en AWS, dos de ellas ejecutan servicios de busqueda y una tercera actua como proxy encargada de recibir las solicitudes del cliente web y distribuirlas entre las instancias de busqueda usando un balanco de carga round-robin.

- ![image](https://github.com/user-attachments/assets/fa3df009-779d-428f-a524-3592bbde8c34)

**Componentes de la aplicacion**

- Busqueda lineal: Recorre una lista de elementos de manera secuencial para encontrar la primera coincidencia del valor buscado. Devuelve el indice de la primera aparicion o -1 sino encuentra el valor

- Busqueda binaria: Requiere una lista ordenada y emplea un enfoque dividir repetidamente el conjunto de datos por la mitad hasta encontrar el valor buscado o hasta que no queden mas elementos por dividir, es mas eficiente en listas ordenadas grandes.


**Pruebas de funcionamiento local**
![image](https://github.com/user-attachments/assets/205a6ec2-f4a6-4886-b924-dc4112a38df1)

- De los requisitos que se pidieron en el parcial a las 3.55 pm se llego al funcionamiento local de los algoritmos de busqueda y el despliegue de la aplicacion en 2 maquinas virtuales EC2 en AWS.

![image](https://github.com/user-attachments/assets/0db2e677-96f1-4087-bbe1-2865196d7e9b)

![image](https://github.com/user-attachments/assets/702bc531-9268-461d-958d-5cf9236e65b7)

