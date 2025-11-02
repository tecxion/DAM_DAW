# Enunciado Tarea 1.

1.- Indica por qué  los siguientes ejemplos XML son incorrectos.

Ejercicio 1a)
```xml
<elemento>Elemento 1</elemento>
<elemento>Elemento 2</elemento>
```

Ejercicio 1b)
```xml
<elemento>Coche</ELEMENTO>
```

Ejercicio 1c)
```xml
<negrita><italica>Texto XML</negrita></italica>
```

Ejercicio 1d)
```xml
<rango>1 < 5 & 11 > 7</rango>
```

Ejercicio 1e)
```xml
<XMLfichero>Marcas.xml</XMLfichero> 
```

Ejercicio 1f)
```xml
<![CDATA[ <[[aa]]>]]>
```

Ejercicio 1g)
```xml
<user@uo>Pedro@Empleados</user@guo>
```
Ejercicio 1h)
```xml
<texto>El titular de hoy se basa en esta <subrayado>noticia<subrayado></texto>
```

La valoración de este ejercicio será de un total de 2 puntos.

Tiempo de resolución aproximado: 15'.


### Ejercicio 2

2.- Diseñar un documento bien formado en XML que permita estructurar la información de una agenda de teléfonos, suponer que la información que podemos tener de una persona es su nombre y apellidos (por separado), su dirección (incluyendo por separado el código postal, población y provincia) y sus teléfonos, que pueden ser el teléfono de casa, el móvil y el teléfono del trabajo.

 

La valoración de este ejercicio será de un total de 3 puntos.

Tiempo de resolución aproximado: 2 h.


### Ejercicio 3

3.- Diseñar un documento bien formado en XML que permita estructurar la información de las recetas de cocina de un restaurante y aplicarlo a la siguiente receta de cocina. Hay que hacerlo de modo que un sistema informático pueda realizar búsquedas por ingredientes, cantidad de comensales o nombre de la receta.

Sopa de cebolla (4 personas)
Ingredientes:

- 1 Kg. de cebollas.
- 2 l. de caldo de carne.
- 100 gr. mantequilla.
- 1 cucharada de harina.
- 100 gr. de queso emmental suizo o gruyére rallado.
- Pan tostado en rebanadas.
- Tomillo.
- 1 hoja de laurel.
- Pimienta.

Proceso:

1.- Pelar y partir las cebollas en rodajas finas.
2.- Rehogarlas con la mantequilla, sal y pimienta a fuego lento hasta que estén transparentes sin dorarse.
3.- Añadir la harina sin dejar de remover.
4.- Ponerlo en una cazuela con el caldo, el tomillo y el laurel.
5.- Dejar cocer a fuego lento durante unos 15 minutos.
6.- Poner las rebanadas de pan encima, espolvorear el queso y gratinar al horno.

La valoración de este ejercicio será de un total de 5 puntos.

Tiempo de resolución aproximado: 2,5 h.

Nota aclaratoria: A efectos de realizar búsquedas por ingredientes: "1 cucharada de harina" no es un ingrediente. En este caso el ingrediente es "harina", el dato "1 cucharada" se puede poner como un subelemento o un atributo.