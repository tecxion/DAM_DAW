- Si una aplicación de escritorio requiere el uso exclusivo de arrastrar y soltar (drag-and-drop) con el ratón para reordenar elementos en una lista, ¿qué principio de accesibilidad está fallando principalmente, asumiendo que no hay alternativa de teclado?
    - Operabilidad, debido a la violación de la 'Accesibilidad por Teclado' (2.1.1).
        - Perceptibilidad, ya que la operación no es visible para el lector de pantalla.
        - Robustez, porque el drag-and-drop no es un protocolo estándar de accesibilidad.
        - Comprensibilidad, ya que la interacción es demasiado compleja.

---

- Un campo de texto utiliza un widget personalizado que se parece a un campo de texto normal, pero que, para el lector de pantalla, solo anuncia 'Objeto genérico, editable'. ¿Qué elemento de NRVS está fallando principalmente, afectando a la Robustez?
    - El Rol.
        - El Nombre.
        - El Valor.
        - El Estado.

---

- Un componente de pestaña (tab) solo se puede activar haciendo clic con el ratón, sin atajos de teclado o funcionalidad 'Enter'/'Espacio'. ¿Qué principio WCAG se viola en este escenario?
    - Operabilidad, específicamente 'Accesibilidad por Teclado'.
        - Robustez, porque el componente no expone su Rol a la AT.
        - Comprensibilidad, porque el usuario no sabe cómo activar la pestaña.
        - Perceptibilidad, porque la pestaña no es visible sin el puntero del ratón.

---

- ¿Por qué es tan importante la realimentación en el diseño de interfaces usables?
    - Para que el usuario esté permanentemente informado del estado de sus acciones.
        - Para aumentar el contraste visual de los elementos de la aplicación.
        - Para asegurarnos un futuro mantenimiento.
        - Para que el usuario realice sus acciones en menor tiempo.

---

- Una muestra de 1-2 usuarios es, en la mayoría de los casos, suficiente para detectar muchos problemas de usabilidad.
    - Verdadero.

---

- Un texto de marcador de posición (placeholder) dentro de un campo de entrada vacío tiene un contraste de 4.0:1 con el fondo. ¿Es esto aceptable en Nivel AA?
    - No, se considera Texto Normal y debe cumplir 4.5:1.
        - Sí, solo si la fuente es de 18pt o más.
        - Sí, porque el texto de marcador de posición está exento ya que no es contenido esencial.
        - No, el contraste de 3:1 para Objetos Gráficos es el único aplicable aquí.

---

- En los cuadros de diálogo, los mensajes al usuario deben ser lo más técnicos posibles para que la aplicación sea de calidad.
    - Falso.

---

- ¿Cuál es la principal razón de accesibilidad para evitar el uso de textos largos escritos totalmente en mayúsculas (ALL CAPS)?
    - Elimina las 'siluetas' distintivas de las palabras, dificultando la lectura rápida y fluida para usuarios con dislexia o baja visión.
        - Los lectores de pantalla anuncian las palabras en mayúsculas letra por letra, lo que es un fallo de Robustez.
        - Viola el requisito de contraste 4.5:1 en la mayoría de las fuentes.
        - Es una falla de Operabilidad porque requiere más esfuerzo cognitivo.

---

- En cuanto al diseño de una interfaz, como característica de su usabilidad, podemos afirmar que:
    - No se debe sobrecargar la interfaz con elementos innecesarios.
        - La combinación de colores estridentes aumentan la atención del usuario.
        - Se debe poner el máximo de elementos visuales para facilitar la comprensión de los contenidos.
        - Un diseño complejo de interfaz es sinónimo de calidad del software.

---

- ¿En qué regla de diseño de presentación de datos en la interfaz se organiza el espacio por áreas según su función?
    - Enrejado.
        - Equilibrado.
        - Balanceado.

---

- En las interfaces usables, es conveniente definir _____ en las acciones más frecuentes.
    - Atajos de teclado.
        - Ventanas.
        - Colores llamativos.
        - Listas desplegables.

---

- Relaciona cada tipo de prueba de usuarios con su característica:
    - Evaluación escrita donde se evalúan los aspectos más complejos de la interfaz.
        - Encuesta.
    - Evaluación consistente en definir el orden las acciones que se llevan a cabo para la realización de una tarea.    
        - Diseño de escenarios.
    - Contactos personalizados con los usuarios.    
        - Entrevista.
    - Encuentros donde se aconseja que exista un moderador.
        - Reunión.

---

- ¿Qué se utiliza para indicar el significado de un icono cuando el ratón pasa por encima en una interfaz de usuario?
    - Tooltip o indicador de función.
        - Guía de ayuda rápida.
        - Cursor dinámico.
        - Menú contextual.

---

- Un desarrollador utiliza un atajo de teclado personalizado que, una vez activado, impide al usuario salir del área actual (un widget incrustado) con la tecla 'Tab' o 'Esc'. ¿Cuál es el término técnico para esta violación de Operabilidad?
    - Trampa de Teclado ('Keyboard Trap').
        - Fallo de Foco Lógico.
        - Redundancia de Entrada.
        - Violación de NRVS.

---

- Según el documento, ¿qué principio de diseño sugiere que los controles usados frecuentemente deben ser visibles y fácilmente accesibles?
    - El principio de visibilidad y utilidad
        - El principio de consistencia inteligente.
        - El principio de economía del diseño.
        - El principio del color como suplemento.

---

- ¿Qué entendemos por usabilidad de una interfaz?
    - Forma de diseñar interfaces más intuitivas, cómodas y sencillas.
        - Característica de todas las interfaces que combinan texto y elementos visuales.
        - Forma de diseño de interfaz basada en la superposición de colores.
        - Proceso de hacerla accesible a personas ciegas.

---

- Un ejemplo de métrica de usabilidad relacionado con: _____es evaluar el porcentaje de tareas completadas en el primer intento.
    - Efectividad de la interfaz.
        - La satisfacción del usuario.
        - El rendimiento de la interfaz.
        - Los requisitos no funcionales.

---

- La norma ISO que trata sobre la usabilidad entendida como “El grado en que un producto puede ser usado por usuarios específicos para lograr un objetivo con eficacia, eficiencia y satisfacción" es:
    - ISO 9241.
        - ISO 14915.
        - ISO 9126.
        - ISO 15504.

---

- De entre las variables que se suelen medir para evaluar la eficiencia de una interfaz se encuentran:
    - Porcentaje de usuarios que recomendarían el producto a un amigo.
        - Tiempo necesario en completar una tarea.
        - Tiempo de recuperación de errores.
        - Porcentaje de errores cometidos.

---

- La norma ISO 9241 se refiere a la usabilidad centrada en los requerimientos del producto.
    - Falso.

---

- Un botón de 'Guardar' tiene texto en blanco (4.5:1 de contraste) sobre un fondo verde. El borde del botón tiene un contraste de 3.2:1 con el fondo. ¿Cuál es el requisito de contraste más bajo que el borde debe cumplir para ser conforme con Nivel AA?
    - El borde, como objeto gráfico esencial, requiere un mínimo de 3:1.
        - El borde, como parte del texto, requiere 4.5:1.
        - El borde está exento porque el texto ya cumple 4.5:1.
        - El borde requiere 7:1 para Nivel AA.

---


- Una consistencia adecuada de la interfaz contribuye a:
    - Rápido aprendizaje.
        - Recuperación de información, en caso de error.
        - Economizar en el desarrollo de la aplicación.
        - Fácil mantenimiento.

---

- Los principios básicos en el diseño de interfaces usables son:
    - Economizar.
    - Comunicar.
    - Organizar.
        - Maximizar multimedia.

---

- ¿Qué componentes de las interfaces muestran mensajes al usuario en respuesta a sus acciones?
    - Cuadros de diálogo.
        - Atajos de teclado.
        - Menús desplegables.

---

- El uso inadecuado de color en el diseño de interfaces tiene como consecuencias:
    - Molestias visuales.
    - Incorrecta percepción del mensaje.
        - Incomprensión del lenguaje.

---

- Según el documento, ¿cuál es el número mágico de Miller que sugiere el número máximo de elementos que una persona puede retener en la memoria de corto plazo?
    - 7 +/- 2.
        - 5 +/- 2.
        - 9 +/- 2.
        - 10 +/- 2.

---

- En el tratamiento del texto en interfaces usables debemos tratar de lograr:
    - Lenguaje conciso.
    - Brevedad.
    - Frases positivas.
        - Extensión.

---

- ¿Cuál es la principal razón de distribuir convenientemente los elementos de una interfaz usable?
    - Aumentar la interacción con el usuario.
        - Alargar el tiempo de vida de la aplicación.
        - Encontrar mayor número de errores.
        - Sacar el producto al mercado antes que nuestros competidores.

---

- Relaciona cada prueba de usabilidad con el tipo de usuario que la realiza:
    - Diseño de escenarios.
        - Usuarios.
    - Entrevistas.    
        - Usuarios.
    - Caminata cognitiva.    
        - Expertos.
    - Cuestionario.
        - Expertos.

---

- ¿Qué tipo de datos se recoge en encuestas y preguntas abiertas para evaluar la usabilidad?
    - Datos cualitativos.
        - Datos cuantitativos.
        - Datos binarios.
        - Datos abstractos.

---

- Para determinar la usabilidad de una aplicación se suele recurrir a los cuestionarios y entrevistas a los usuarios.
    - Verdadero.

---

- En el contexto de la Robustez, ¿qué significa el término 'Compatibilidad hacia Adelante' ('Forward Compatibility')?
    - Que la aplicación debe ser capaz de seguir funcionando cuando surjan nuevas Tecnologías Asistivas (AT) o agentes de usuario.
        - Que el código debe ser compatible con todos los navegadores web principales.
        - Que la aplicación debe ser compatible con versiones anteriores del sistema operativo (SO).
        - Que los usuarios deben poder cargar sus datos de versiones anteriores de la aplicación.

---

- Relaciona cada elemento de la interfaz con su característica:
    - Aumento de interés en el contenido.    
        - Color.
    - Introducción de un dato de confirmación en el sistema.    
        - Botón de comando.
    - Combinación de cuadro de texto y menú desplegable.    
        - Lista desplegable.
    - Identificación de elementos.
        - Etiqueta.

---

- ¿Cuál de las siguientes NO es una dimensión de la usabilidad según el documento?
    - Intuitividad.
        - Eficacia / efectividad.
        - Satisfacción.
        - Eficiencia.

---

- ¿Qué principio sugiere que los mensajes a los usuarios deben ser positivos y activos sin parecer insultantes o graciosos?
    - Reglas no escritas de diseño de interfaces.
        - Principio de ayuda y documentación.
        - Principio de prevención de errores.
        - Principio de control del usuario.

---

- Una aplicación permite aumentar el tamaño del texto al 200%, pero el contenido se desborda y requiere que el usuario haga scroll horizontal para leer oraciones completas. ¿Qué requisito se incumple?
    - No debe haber scroll horizontal forzado en el contenido que se lee en una sola dirección.
        - Solo se permite el aumento de tamaño hasta el 150%.
        - Falla el requisito de Operabilidad al introducir una trampa de teclado.
        - Falla el principio de Comprensibilidad debido al desorden visual.

---

- En una aplicación de escritorio, la secuencia de tabulación (Tab Order) salta los elementos inactivos y los campos de sólo lectura. ¿Es esto conforme a la accesibilidad del teclado?
    - Sí, el orden de tabulación solo debe incluir elementos interactivos que el usuario pueda activar o editar.
        - No, se deben incluir todos los elementos para que el lector de pantalla pueda anunciarlos, independientemente de si son interactivos o no.
        - Solo si la aplicación no requiere un mouse en absoluto.
        - No, se viola el principio de Comprensibilidad porque el usuario pierde contexto.

---

- Para medir la usabilidad, los grupos de variables de interfaz que nos interesan evaluar son:
    - Variables de satisfacción.
    - Variables de efectividad.
        - Variables de portabilidad.
        - Variables de sistema.

---

- Si una fuente tiene un tamaño de 20px y un interlineado de 30px (1.5x), ¿cuántos px de 'leading' (espaciado entre líneas) se están agregando al texto?
    - 10px.
        - 5px.
        - 20px.
        - 15px.

---

- Un botón de cierre utiliza un icono de 'X' (12px de tamaño) que tiene un ratio de contraste de 3.5:1 con respecto al fondo. El botón no contiene texto. ¿Es este contraste aceptable para Nivel AA?
    - Sí, porque el icono de 'X' es un componente de interfaz, y el requisito mínimo es 3:1.
        - No, si no tiene texto, debe considerarse Texto Normal y cumplir 4.5:1.
        - Sí, porque es un elemento puramente decorativo y está exento.
        - No, todos los componentes interactivos deben tener un contraste de 7:1.