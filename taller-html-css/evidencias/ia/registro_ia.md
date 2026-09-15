# Documentación del uso de inteligencia artificial

## ChatGPT

### Palabras clave de HTML

#### Estructura básica

* `<!DOCTYPE html>` → Indica que el documento utiliza HTML5.
* `<html>` → Contiene toda la página web.
* `<head>` → Contiene información de configuración de la página.
* `<body>` → Contiene el contenido visible de la página.
* `<meta>` → Define información adicional sobre la página.
* `<title>` → Define el título que aparece en la pestaña del navegador.
* `<link>` → Permite conectar archivos externos, como una hoja de estilos CSS.

#### Estructura semántica

* `<header>` → Representa el encabezado de la página.
* `<nav>` → Contiene los enlaces de navegación.
* `<main>` → Contiene el contenido principal de la página.
* `<section>` → Permite dividir el contenido en diferentes secciones.
* `<article>` → Representa contenido independiente dentro de una página.
* `<footer>` → Representa el pie de página.

#### Texto

* `<h1>` → Representa el título principal.
* `<h2>` → Representa un título de segundo nivel.
* `<h3>` → Representa un título de tercer nivel.
* `<p>` → Permite crear párrafos de texto.

#### Enlaces e imágenes

* `<a>` → Crea enlaces dentro de la página o hacia otras páginas.
* `<img>` → Permite mostrar una imagen.

#### Formularios

* `<form>` → Define un formulario.
* `<label>` → Describe o identifica un campo del formulario.
* `<input>` → Permite introducir diferentes tipos de datos.
* `<textarea>` → Permite introducir textos más extensos.
* `<button>` → Crea un botón.

#### Atributos

* `id` → Identifica de manera única un elemento.
* `class` → Permite agrupar elementos para aplicarles estilos.
* `href` → Indica la dirección de un enlace.
* `src` → Indica la ubicación de un recurso, como una imagen.
* `alt` → Proporciona una descripción alternativa de una imagen.
* `type` → Define el tipo de un elemento.
* `name` → Define el nombre de un campo de formulario.
* `required` → Hace obligatorio completar un campo.

### Configuración inicial del CSS

Le pedí a ChatGPT que realizara una configuración inicial para los elementos generales del HTML.

```css
* {
    box-sizing: border-box;
}

html {
    scroll-behavior: smooth;
}

body {
    margin: 0;
    background-color: var(--color-bg);
    color: var(--color-text);
    font-family: Arial, sans-serif;
    line-height: 1.6;
}
```

## Claude

### Mejora de la pantalla principal

Le pedí a Claude que revisara qué detalles podían mejorar en la pantalla principal.

#### Sugerencia

Claude indicó que el enlace **"Ver nuestro menú"** no se veía como un botón, a pesar de que en el CSS ya existía una clase `.button`.

La sugerencia fue agregar la clase al enlace:

```html
<a href="#menu" class="button">Ver nuestro menú</a>
```

#### Decisión

**Acepté la sugerencia**, ya que el enlace adquirió una apariencia más adecuada de botón y mejoró visualmente la pantalla principal.

### Organización de las tarjetas del menú

También le pedí a Claude que revisara la organización de las tarjetas del menú.

#### Sugerencia

Sugirió reemplazar el uso de `inline-block` por `flexbox`:

```css
#menu {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: var(--space);
}

#menu > article {
    flex: 1 1 280px;
    max-width: 320px;
}
```

#### Decisión

**Rechacé la sugerencia**, debido a que al realizar el cambio el diseño se veía más desorganizado y no se adaptaba de la manera esperada al diseño responsive que ya tenía la página.

Por esta razón, se mantuvo la estructura original utilizando `inline-block` y porcentajes.

## Gemini

### Mejora del formulario

Le pedí a Gemini que me ayudara a mejorar la organización del checkbox del formulario.

#### Sugerencia

Se propuso agrupar el checkbox y su etiqueta dentro de un contenedor:

```html
<div class="checkbox-group">
    <input type="checkbox" id="aceptacion" name="aceptacion" required>
    <label for="aceptacion">
        Acepto el uso de mis datos...
    </label>
</div>
```

También se propuso utilizar `flexbox` para organizar correctamente ambos elementos.

#### Decisión

**Acepté la sugerencia, pero realicé algunas modificaciones**, ya que después de aplicar inicialmente los cambios el checkbox todavía se veía desorganizado.

Finalmente, se utilizó la siguiente configuración:

```css
.checkbox-group {
    display: flex;
    flex-direction: row;
    align-items: center;
    gap: 0.5rem;
    margin-top: var(--space);
    width: 100%;
}

.checkbox-group input[type="checkbox"] {
    order: 1;
    margin: 0;
    flex-shrink: 0;
    width: auto;
}

.checkbox-group label {
    order: 2;
    margin: 0;
    font-weight: normal;
    width: auto;
    max-width: none;
    white-space: normal;
}
```

