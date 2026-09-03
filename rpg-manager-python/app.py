from flask import Flask, jsonify, request, render_template, redirect, url_for

from models.personaje import Personaje
from models.repository import (
    obtener_todos,
    guardar
)

app = Flask(__name__)


@app.route('/personajes', methods=['GET'])
def obtener_todos_ruta():

    personajes = obtener_todos()

    return render_template(
        'personajes.html',
        personajes=personajes
    )


@app.route('/personajes', methods=['POST'])
def crear_personaje():

    nombre = request.form["nombre"]
    clase = request.form["clase"]
    nivel = request.form["nivel"]
    vida = request.form["vida"]

    personaje = Personaje(
        nombre,
        clase,
        nivel,
        vida
    )

    guardar(personaje)

    return redirect(url_for('obtener_todos_ruta'))


if __name__ == '__main__':
    app.run(port=5000, debug=True)