# 🏆 Hackatón — 14 de Marzo 2026

> Colección de problemas de programación competitiva. Tiempo límite y memoria indicados en cada problema.

---

## Problema A: Nombres para Bebés

| | |
|---|---|
| ⏱ Tiempo límite | 4 segundos |
| 💾 Memoria | 256 MB |

Desde hace mucho tiempo, existe un bar extraño. Personas de diferentes programas y facultades convivían allí. Pero, como eran diferentes, también sus nombres lo eran. Por eso, en clases y prácticas, era bastante difícil llamar a alguien por su nombre, porque algunos nombres eran demasiado difíciles de pronunciar para personas de otros programas.

Entonces, un profesor ideó un plan para facilitar la vida de los futuros estudiantes y docentes. Tomó una cadena **S** y dos enteros **p** y **q**, y estableció una regla: los nombres de los bebés de las parejas formadas en el bar debían ser una subcadena de **S**, y su longitud debía estar entre **p** y **q** (ambos inclusive).

Ahora, dado **S**, **p** y **q**, debes encontrar el número de nombres distintos que pueden formarse.

### Entrada

- La entrada comienza con un entero `T (≤ 100)`, que indica el número de casos de prueba.
- Cada caso comienza con una línea que contiene la cadena `S`. La longitud de `S` estará entre **2 y 10000** (inclusive), y `S` contiene únicamente letras minúsculas en inglés.
- La siguiente línea contiene dos enteros `p` y `q` `(1 ≤ p ≤ q ≤ length(S))`.

### Salida

Para cada caso, imprime el número de caso y el número de nombres distintos que pueden formarse.

### Casos de prueba de muestra

**Input:**
```
1
abcdef
2 5
```

**Output:**
```
Case 1: 14
```

---

## Problema B: ¡Secreto Oculto!

| | |
|---|---|
| ⏱ Tiempo límite | 1 segundo |
| 💾 Memoria | 256 MB |

En este problema, se te dan **dos nombres** y debes determinar si **uno está oculto dentro del otro**. Las restricciones son:

1. Puedes cambiar letras mayúsculas a minúsculas y viceversa.
2. Puedes agregar o eliminar espacios libremente.
3. Puedes **permutar** (reordenar) las letras.

Si después de aplicar estas reglas **ambos nombres coinciden exactamente**, entonces se puede decir que un nombre está oculto dentro del otro.

### Entrada

- La entrada comienza con un entero `T (≤ 100)` que indica el número de casos de prueba.
- Cada caso contiene dos líneas. Cada línea tiene un nombre compuesto por letras inglesas (mayúsculas y minúsculas) y espacios.
- Puedes asumir que la longitud de cualquier nombre está entre **1 y 100** (inclusive).

### Salida

Para cada caso, imprime el número de caso y `Yes` si un nombre está oculto en el otro. En caso contrario, imprime `No`.

### Casos de prueba de muestra

**Input:**
```
3
Tom Marvolo Riddle
I am Lord Voldemort
I am not Harry Potter
Hi Pretty Roar to man
Harry and Voldemort
Tom and Jerry and Harry
```

**Output:**
```
Case 1: Yes
Case 2: Yes
Case 3: No
```

---

## Problema C: Envío de Paquetes

| | |
|---|---|
| ⏱ Tiempo límite | 2 segundos |
| 💾 Memoria | 256 MB |

Germán y Freddy están tratando de comunicarse a través de Internet. Supón que hay **N enrutadores** en Internet, numerados del **0 al N−1**. Germán está conectado directamente al enrutador **0** y Freddy al enrutador **N−1**. Germán inicia la conexión y quiere enviar **S KB** de datos a Freddy. Los datos pueden llegar al enrutador N−1 desde el 0 ya sea **directamente** o mediante algunos enrutadores intermedios. Existen algunos **enlaces bidireccionales** entre los enrutadores.

### Probabilidades de éxito

Para cada enlace existe una probabilidad `pᵢ`. Si **u** y **v** son dos enrutadores unidos por un enlace con probabilidad `pᵢ`, significa que la probabilidad de que el dato llegue exitosamente de `u` a `v` es `pᵢ`, y viceversa. Si se usan múltiples enlaces, la probabilidad total de éxito es el **producto** de las probabilidades individuales de los enlaces utilizados.

### Tiempo de envío y recepción

- Un paquete tarda **exactamente K segundos** en llegar del enrutador de Germán al de Freddy **si tiene éxito** (independiente del número de enlaces del camino).
- Cuando Freddy recibe el paquete, **inmediatamente envía un acuse** (ACK) hacia Germán.
- El ACK **siempre** llega exactamente en **K segundos** (nunca falla).

### Algoritmo usado por el enrutador de Germán

1. En el tiempo **0**, se elige el primer KB de datos para enviar.
2. Se establece una ruta (esto toma **0 segundos**) y se envían los datos por ella.
3. Germán **espera exactamente 2K segundos**.
4. Si recibe el ACK del dato enviado dentro de ese intervalo:
   - a. Si ya se enviaron los **S KB**, se avanza al paso 6.
   - b. Si no, toma el siguiente 1 KB y vuelve al paso 2.
5. Si no recibe el ACK, **reenvía el mismo KB** y vuelve al paso 2.
6. Cuando todos los datos han sido enviados, **informa a Germán**.

Las probabilidades de los enlaces son **estáticas e independientes**. Debes elegir rutas tal que el **tiempo esperado total** para enviar todos los datos sea **mínimo**.

### Entrada

- La entrada comienza con un entero `T (≤ 100)`, el número de casos de prueba.
- Cada caso contiene:
  - `N (2 ≤ N ≤ 100)`: número de enrutadores
  - `M (1 ≤ M)`: número de enlaces bidireccionales
  - `S (1 ≤ S ≤ 10⁹)`: cantidad de datos en KB
  - `K (1 ≤ K ≤ 20)`: tiempo de ida/vuelta
- Luego vienen **M líneas**, cada una con: `ui vi pi` — hay un enlace entre `uᵢ` y `vᵢ` con probabilidad de éxito de `pᵢ%` `(0 < pᵢ ≤ 100)`.

> Siempre habrá al menos una ruta válida entre Germán y Freddy. El resultado será menor que **10¹³**.

### Salida

Para cada caso, imprimir: `Case X: result`

Donde `result` es el tiempo esperado mínimo para enviar todos los datos. Errores menores a **10⁻³** serán ignorados.

### Casos de prueba de muestra

**Input:**
```
2
5 5 1 10
0 1 70
0 2 40
2 3 100
1 3 50
4 3 80
2 1 30 2
0 1 80
```

**Output:**
```
Case 1: 62.5000000000
Case 2: 150.0000000000
```

---

## Problema D: Colmenas

| | |
|---|---|
| ⏱ Tiempo límite | 4 segundos |
| 💾 Memoria | 256 MB |

Las abejas son uno de los insectos más industriosos. Para mejorar la navegación, numeraron los **n árboles** del **0 al n−1** y utilizan un **mapa predefinido** con algunos caminos.

Ahora desean construir colmenas de tal manera que, **si uno de los caminos en su nuevo mapa deja de estar disponible**, todavía sea posible ir de cualquier colmena a otra usando los otros caminos del mapa. Las abejas **no quieren elegir menos de dos árboles** y también desean construir el **mínimo número posible de colmenas**.

### Entrada

- La entrada comienza con un entero `T (≤ 50)`, que indica el número de casos de prueba.
- Cada caso inicia con una línea en blanco.
- La siguiente línea contiene dos enteros:
  - `n (2 ≤ n ≤ 500)`: número de árboles
  - `m (0 ≤ m ≤ 20000)`: número de caminos
- Cada una de las siguientes `m` líneas contiene: `u v (0 ≤ u, v < n, u ≠ v)` — existe un camino entre el árbol `u` y el árbol `v`.

> Se garantiza que como máximo habrá un camino entre cualquier par de árboles.

> ⚠️ El conjunto de datos es muy grande, usa métodos de entrada/salida más rápidos.

### Salida

Para cada caso, imprime el número de caso y:
- El **número mínimo de colmenas** en la colonia propuesta, **o**
- La palabra **`impossible`**, si no es posible encontrar una colonia que cumpla las condiciones.

### Casos de prueba de muestra

**Input:**
```
3

3 3
0 1
1 2
2 0

2 1
0 1

5 6
0 1
1 2
1 3
2 3
0 4
3 4
```

**Output:**
```
Case 1: 3
Case 2: impossible
Case 3: 3
```

> **Nota:** Para el caso 3, las abejas construirán 3 colmenas en los nodos `{1, 2, 3}` y solo mantendrán tres caminos en la colonia: `{(1,2), (1,3), (2,3)}`.

---

## Problema E: Amistad Corrompida

| | |
|---|---|
| ⏱ Tiempo límite | 1 segundo |
| 💾 Memoria | 256 MB |

Muchos de nosotros conocemos a un amigo descarrilado. Él es muy corrupto y perezoso. Para corromper a más personas perezosas, invita a sus amigos a una fiesta de forma recursiva. La idea es la siguiente:

- Si **X** tiene algunas tarjetas, se queda con **una tarjeta** e invita a uno de sus amigos **Y**, quien aún no haya recibido tarjeta de invitación.
- **X** entrega todas las tarjetas restantes a **Y**. Entonces decimos que **Y** fue invitado por **X**.
- Ahora **Y** tiene la responsabilidad de distribuir tantas tarjetas como pueda: se queda con **una tarjeta** y continúa el mismo procedimiento que hizo X.

Cuando Y no puede encontrar más amigos a quienes entregar tarjetas, devuelve las tarjetas restantes a X. Luego X revisa si tiene otros amigos que todavía no hayan recibido tarjeta. Si encuentra alguno, continúa con el mismo proceso. De lo contrario, si X fue invitado por Z, entonces devuelve a Z las tarjetas sobrantes. Si no existe tal persona (es decir, si X es el amigo descarrilado), entonces X se queda con las tarjetas.

Inicialmente, el amigo descarrilado tiene **N tarjetas** y comienza el proceso. Hay **N personas** numeradas del **1 al N**. El amigo descarrilado es la **persona número 1**. Lo interesante es que, después del proceso, **cada persona recibe exactamente 1 tarjeta**. Dada la información de quién invitó a quién, el amigo descarrilado quiere que determines:

1. El **número total de invitaciones** realizadas.
2. El **número de pares distintos de personas que con certeza no son amigos**.

### Entrada

- La entrada comienza con un entero `T (≤ 30)`, que indica el número de casos de prueba.
- Cada caso inicia con un entero `N (1 ≤ N ≤ 100000)`.
- Luego siguen `N−1` líneas; cada una contiene dos enteros `X Y (1 ≤ X, Y ≤ N, X ≠ Y)`, indicando que la persona Y recibió su tarjeta de invitación de X.

> ⚠️ El conjunto de datos es muy grande, usa métodos de entrada/salida más rápidos.

### Salida

Para cada caso, imprime el número del caso, el total de invitaciones realizadas, y el número de pares distintos de personas que seguramente no son amigos.

### Casos de prueba de muestra

**Input:**
```
2
2
1 2
3
1 2
1 3
```

**Output:**
```
Case 1: 1 0
Case 2: 2 1
```

---

## Problema F: Área de un Paralelogramo

| | |
|---|---|
| ⏱ Tiempo límite | 1 segundo |
| 💾 Memoria | 256 MB |

Un paralelogramo es un cuadrilátero con dos pares de lados paralelos. Ahora se te dan las coordenadas de **A**, **B** y **C**. Debes encontrar las coordenadas del punto **D** y el **área del paralelogramo**. La orientación de **ABCD** debe ser la misma que en la figura (recorrido secuencial).

```
D (Dx, Dy)    C (Cx, Cy)
  ┌──────────────┐
  │              │
  └──────────────┘
A (Ax, Ay)    B (Bx, By)
```

### Entrada

- La entrada empieza con un entero `T (≤ 1000)` que indica el número de casos de prueba.
- Cada caso contiene una línea con seis enteros: `Ax Ay Bx By Cx Cy`
  - `(Ax, Ay)` son las coordenadas de A
  - `(Bx, By)` son las coordenadas de B
  - `(Cx, Cy)` son las coordenadas de C
- Cada coordenada está en el rango `[−1000, 1000]`.
- Puedes asumir que **A**, **B** y **C** no son colineales.

### Salida

Para cada caso, imprime el número del caso, dos enteros correspondientes a las **coordenadas de D**, y un entero adicional correspondiente al **área del paralelogramo**.

### Casos de prueba de muestra

**Input:**
```
3
0 0 10 0 10 10
0 0 10 0 10 -20
-12 -10 21 21 1 40
```

**Output:**
```
Case 1: 0 10 100
Case 2: 0 -20 200
Case 3: -32 9 1247
```

---

## Problema G: Huevos Hervidos

| | |
|---|---|
| ⏱ Tiempo límite | 1 segundo |
| 💾 Memoria | 256 MB |

Tres estudiantes de ingeniería viajaron a Medellín y descubrieron que la estufa no estaba conectada al cilindro de gas. Por suerte, el **microondas sí funcionaba**. Así que intentaron hervir todos los huevos en el microondas.

Ahora tienen **n huevos** y un **tazón**. Colocan algunos huevos en el tazón con agua y luego lo ponen en el microondas.

- Es arriesgado poner **más de P huevos** en el tazón.
- El tazón puede cargar **como máximo Q gramos** de huevos.
- Hervir un tazón de huevos toma **12 minutos**.

Los estudiantes tienen exactamente **12 minutos disponibles**. Debes determinar el **número máximo de huevos que pueden hervir sin correr ningún riesgo**.

### Entrada

- La entrada comienza con un entero `T (≤ 100)` indicando el número de casos de prueba.
- Cada caso contiene tres enteros:
  - `n (1 ≤ n ≤ 30)`
  - `P (1 ≤ P ≤ 30)`
  - `Q (1 ≤ Q ≤ 30)`
- La siguiente línea contiene `n` enteros positivos (no mayores que 10), en **orden no decreciente**, representando el peso de los huevos en gramos.

### Salida

Para cada caso, imprime el número del caso y el máximo número de huevos que pueden hervir sin riesgo.

### Casos de prueba de muestra

**Input:**
```
2
3 2 10
1 2 3
4 5 5
4 4 5 5
```

**Output:**
```
Case 1: 2
Case 2: 1
```

---

## Problema H: Verificación de IP

| | |
|---|---|
| ⏱ Tiempo límite | 1 segundo |
| 💾 Memoria | 256 MB |

Una dirección IP es una dirección de **32 bits**, con el formato `a.b.c.d` donde `a, b, c, d` son enteros en el rango de **0 a 255**.

Ahora se te dan dos direcciones IP: la primera en **forma decimal** y la segunda en **forma binaria**. Tu tarea es determinar si **representan la misma dirección** o no.

### Entrada

- La entrada comienza con un entero `T (≤ 100)`, que indica el número de casos de prueba.
- Cada caso contiene dos líneas:
  1. La primera línea contiene una dirección IP en **forma decimal**.
  2. La segunda línea contiene una dirección IP en **forma binaria**, donde **cada una de las cuatro partes tiene exactamente 8 dígitos**.
- Puedes asumir que todas las direcciones proporcionadas son válidas.

### Salida

Para cada caso, imprime el número del caso, y `Yes` si ambas direcciones son iguales, de lo contrario imprime `No`.

### Casos de prueba de muestra

**Input:**
```
2
192.168.0.100
11000000.10101000.00000000.11001000
65.254.63.122
01000001.11111110.00111111.01111010
```

**Output:**
```
Case 1: No
Case 2: Yes
```

---

## Problema I: El Ladrón de Chocolate

| | |
|---|---|
| ⏱ Tiempo límite | 1 segundo |
| 💾 Memoria | 256 MB |

Le di algunos chocolates a varios estudiantes por sus actuaciones extraordinarias. Un chocolate es un objeto con **forma de cubo**, que tiene **largo, ancho y alto**. Todos los estudiantes recibieron la misma cantidad de chocolate — sus dimensiones pueden ser diferentes, pero los **volúmenes son iguales**. Ahora algunos estudiantes afirman que hay un **ladrón de chocolate** entre ellos.

Se te dan los nombres de los estudiantes y las dimensiones de sus chocolates. Debes encontrar el nombre del ladrón. Puedes asumir que **como máximo hay un solo ladrón** y, si lo hay, tomó parte del chocolate de **exactamente otro estudiante** (no de varios).

### Entrada

- La entrada empieza con un entero `T (≤ 100)`, el número de casos de prueba.
- Cada caso comienza con un entero `n (2 ≤ n ≤ 100)`, el número de estudiantes.
- Cada una de las siguientes `n` líneas contiene:
  - Un **nombre** (cadena alfanumérica de longitud entre 1 y 20)
  - Tres enteros: **largo, ancho y alto** de la porción de chocolate actual del estudiante.
- Cada dimensión está en el rango `[1, 100]`.

### Salida

Para cada caso, imprime primero el número del caso. Luego:
- Si no se encuentra ningún ladrón: `no thief`
- De lo contrario: `x took chocolate from y`

donde `x` es el nombre del ladrón e `y` es el nombre del estudiante del cual se tomó el chocolate.

### Casos de prueba de muestra

**Input:**
```
2
11
atq 3 4 3
mun 10 4 1
sam1 6 6 1
sam2 18 2 1
mub 1 36 1
tan 1 4 9
sha 4 3 3
di 3 12 1
nab 2 2 9
all 8 4 1
fah 3 2 6
2
...
```

**Output:**
```
Case 1: mun took chocolate from all
Case 2: no thief
```

---

## Problema J: Paridad

| | |
|---|---|
| ⏱ Tiempo límite | 1 segundo |
| 💾 Memoria | 256 MB |

Dado un entero **n**, primero lo representamos en **binario**. Luego contamos la cantidad de unos (1) en esa representación.

- Decimos que **n tiene paridad impar** si la cantidad de unos es **impar**.
- De lo contrario, decimos que **n tiene paridad par**.

**Por ejemplo:**
- `21 = (10101)₂` tiene paridad impar porque contiene **3 unos**.
- `6 = (110)₂` tiene paridad par.

### Entrada

- La entrada comienza con un entero `T (≤ 1000)` que indica el número de casos de prueba.
- Cada caso contiene un entero `n`, con `1 ≤ n < 2³¹`.

### Salida

Para cada caso, imprime el número del caso, y `odd` si `n` tiene paridad impar, de lo contrario imprime `even`.

### Casos de prueba de muestra

**Input:**
```
2
21
6
```

**Output:**
```
Case 1: odd
Case 2: even
```

---

## Problema K: Círculo en un Cuadrado

| | |
|---|---|
| ⏱ Tiempo límite | 1 segundo |
| 💾 Memoria | 256 MB |

Un círculo está colocado **perfectamente dentro de un cuadrado**. El término *perfectamente colocado* significa que cada lado del cuadrado es tocado por el círculo, pero el círculo **no se sobrepone** ni se sale del cuadrado.

Ahora se te da el radio del círculo. Debes encontrar el **área de la región sombreada** (las esquinas del cuadrado no cubiertas por el círculo).

Asume que: `π = 2 × acos(0.0)` (donde `acos` significa coseno inverso).

### Entrada

- La entrada comienza con un entero `T (≤ 1000)` que indica el número de casos de prueba.
- Cada caso contiene un número de punto flotante `r (0 < r ≤ 1000)`, que representa el radio del círculo.
- Puedes asumir que `r` tiene como máximo **cuatro dígitos** después del punto decimal.

### Salida

Para cada caso, imprime el número del caso, y el área sombreada, **redondeada a dos cifras decimales**.

> ⚠️ **Nota de precisión:** Este problema no tiene un juez especial. Es mejor agregar un valor pequeño a tu resultado para evitar problemas de precisión. Por ejemplo, agrega **10⁻⁹** a tu resultado.

### Casos de prueba de muestra

**Input:**
```
3
20
30.091
87.0921
```

**Output:**
```
Case 1: 343.36
Case 2: 777.26
Case 3: 6511.05
```

---

## Problema L: Pimp My Ride (Enchúlame la Máquina)

| | |
|---|---|
| ⏱ Tiempo límite | 1 segundo |
| 💾 Memoria | 256 MB |

Hay bastantes vehículos en las calles que necesitan una buena renovación. Tú has aceptado este trabajo. Quieres que diversos trabajos (pintura, decoración interior, etc.) sean realizados por diferentes talleres. Como los recargos dependen de **qué trabajo se hace** y de **cuáles trabajos ya han sido hechos antes**, estás tratando de ahorrar dinero encontrando un **orden óptimo** para realizar los trabajos.

Los trabajos individuales están numerados del **1 al n**. Dado:
- El **precio base** `p` para cada trabajo.
- Un **recargo** `s` para cada par de trabajos `(i, j)`, lo que significa que debes pagar un recargo `s` adicional por el trabajo `i` **si y solo si** el trabajo `j` fue completado antes.

Tu tarea es calcular el **costo total mínimo** necesario para completar todos los trabajos.

### Entrada

- La entrada comienza con un entero `T (≤ 100)`, que indica el número de casos de prueba.
- Cada caso comienza con un entero `n (1 ≤ n ≤ 14)`: el número de trabajos.
- Luego siguen `n` líneas, cada una conteniendo exactamente `n` enteros:
  - En la línea `i`, el **i-ésimo entero** es el precio base del trabajo `i`.
  - El **j-ésimo entero** (donde `i ≠ j`) es el recargo para el trabajo `i` que aplica si el trabajo `j` ya se hizo antes.
- Los valores son enteros **no negativos** y **menores o iguales a 100000**.

### Salida

Para cada caso, imprime el número del caso y el **costo total mínimo**.

### Casos de prueba de muestra

**Input:**
```
2
2
10 10
9000 10
3
14 23 0
0 14 0
0 14 0
```

**Output:**
```
Case 1: 30
Case 2: 42
```

---

## Problema M: Sé Eficiente

| | |
|---|---|
| ⏱ Tiempo límite | 1 segundo |
| 💾 Memoria | 256 MB |

Se te da un arreglo con **N enteros**, y otro entero **M**. Debes encontrar el **número de subsecuencias consecutivas** (subarreglos) cuya **suma sea divisible por M**.

**Por ejemplo**, con `N = 4`, arreglo `{2, 1, 4, 3}` y `M = 4`, de las 10 subsecuencias consecutivas posibles, solo **dos** tienen suma múltiplo de 4: `{1, 4, 3}` y `{4}`.

### Entrada

- La entrada comienza con un entero `T (≤ 10)` que indica el número de casos de prueba.
- Cada caso contiene dos enteros:
  - `N (1 ≤ N ≤ 10⁵)`
  - `M (1 ≤ M ≤ 10⁵)`
- La siguiente línea contiene `N` enteros separados por espacios que forman el arreglo. Cada entero está en el rango `[1, 10⁵]`.

### Salida

Para cada caso, imprime el número del caso, y el número total de subsecuencias consecutivas cuya suma sea divisible por M.

### Casos de prueba de muestra

**Input:**
```
2
4 4
2 1 4 3
6 3
1 2 3 4 5 6
```

**Output:**
```
Case 1: 2
Case 2: 11
```

---

## Problema N: Simulación Binaria

| | |
|---|---|
| ⏱ Tiempo límite | 2 segundos |
| 💾 Memoria | 256 MB |

Dado un número binario, debemos realizar algunas operaciones sobre él. Existen dos tipos de operaciones:

1. **`I i j`** — invierte todos los bits desde `i` hasta `j` (ambos inclusive).
2. **`Q i`** — consulta si el bit i-ésimo es `0` o `1`.

El **MSB** (*most significant bit*) es el **primer bit** (es decir, `i = 1`). El número binario puede contener **ceros a la izquierda**.

### Entrada

- La entrada comienza con un entero `T (≤ 10)`, indicando el número de casos de prueba.
- Cada caso inicia con una línea que contiene un número binario de longitud `n (1 ≤ n ≤ 10⁵)`.
- La siguiente línea contiene un entero `q (1 ≤ q ≤ 50000)` que indica el número de consultas.
- Cada consulta tendrá uno de los siguientes formatos:
  - `I i j`, donde `1 ≤ i ≤ j ≤ n`
  - `Q i`, donde `1 ≤ i ≤ n`

> ⚠️ El conjunto de datos es muy grande, usa métodos de entrada/salida más rápidos.

### Salida

Para cada caso, imprime el número del caso en una sola línea. Luego, por cada consulta `Q i`, imprime `1` o `0`, dependiendo del valor del bit i-ésimo.

### Casos de prueba de muestra

**Input:**
```
2
0011001100
6
I 1 10
I 2 7
Q 2
Q 1
Q 7
Q 5
1011110111
6
I 1 10
I 2 7
Q 2
Q 1
Q 7
Q 5
```

**Output:**
```
Case 1:
0
1
1
0
Case 2:
0
0
1
0
```

---

*Hackatón — 14 de Marzo de 2026*
