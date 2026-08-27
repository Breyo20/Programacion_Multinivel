from flask import Flask, jsonify, request

from models.personaje import Personaje
from models.repository import (
    obtener_todos,
    guardar
)

app = Flask(__name__)


@app.route('/personajes', methods=['GET'])
def     obtener_todos_ruta():

    personajes_lista =     obtener_todos()

    datos = [
        personaje.convertir_dict()
        for personaje in personajes_lista
    ]

    return jsonify(datos)


@app.route('/personajes', methods=['POST'])
def crear_personaje():

    datos = request.get_json()

    personaje = Personaje(
        datos["nombre"],
        datos["clase"],
        datos["nivel"],
        datos["vida"]
    )

    guardar(personaje)

    return jsonify({
        "mensaje": "Personaje creado correctamente"
    }), 201


if __name__ == '__main__':
    app.run(port=5000, debug=True)